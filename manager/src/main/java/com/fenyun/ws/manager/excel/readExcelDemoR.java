package com.fenyun.ws.manager.excel;

import com.google.common.collect.Lists;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.collections.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class readExcelDemoR {


    //判断字符串大小是否添加双引号
    private static final Integer FENGESIZE = 7;

    public static void main(String[] args) {

        ReadExcelUpdate obj = new ReadExcelUpdate();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("D:/update.xls");
        List excelList = obj.readExcel(file);
        System.out.println("list中的数据打印出来");

        List listTable= Lists.newArrayList();
        String tableName="";
        String operate="";
        Integer size=0;

        for (int i=0;i<excelList.size();i++){
            List listTemp = (List) excelList.get(i);

            if(CollectionUtils.isEmpty(listTemp)) continue;
            if (Objects.equals("tableName",listTemp.get(0).toString())){
                if(Objects.equals("update",listTemp.get(3).toString())){
                    tableName=listTemp.get(1).toString();
                    System.out.println();
                    System.out.println();
                    System.out.println("-- 表名 "+tableName+"--执行更新操作");
                    System.out.println();

                    size= Integer.parseInt(listTemp.get(5).toString());
                    operate="update";
                }else if(Objects.equals("delete",listTemp.get(3).toString())){
                    System.out.println();
                    System.out.println();
                    tableName=listTemp.get(1).toString();
                    System.out.println("-- 表名 "+tableName+"--执行删除操作");
                    System.out.println();

                  //  size= Integer.parseInt(listTemp.get(5).toString());
                    operate="delete";
                }
                i++;
                listTable=(List) excelList.get(i);
                continue;
            }
            if(Objects.equals("update",operate)){
                update(listTable,listTemp,tableName,size);
            }else if(Objects.equals("delete",operate)) {
                delete(listTable,listTemp,tableName);
            }

            //System.out.println(excelList.get(i));
        }
       // System.out.println(excelList);
    }
    private static void delete(List listTable,List lists,String tableName) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DELETE FROM ").append(tableName).append("");

        List list = lists;

        // stringBuffer.delete(stringBuffer.length() - 2,stringBuffer.length());
        stringBuffer.append(" WHERE ");
        for (int j = 0; j < list.size(); j++) {
            stringBuffer.append(listTable.get(j));
            stringBuffer.append(" = ");
            //stringBuffer.append(list.get(j));
            String string = list.get(j).toString();
            Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
            if (!pattern.matcher(string).matches() && !"NULL".equals(string)) {
                stringBuffer.append("'");
                stringBuffer.append(list.get(j));
                stringBuffer.append("'");
            } else if (string.length() >= FENGESIZE) {
                stringBuffer.append("'");
                stringBuffer.append(list.get(j));
                stringBuffer.append("'");
            } else {
                stringBuffer.append(list.get(j));
            }
            stringBuffer.append(" AND ");
        }

        stringBuffer.delete(stringBuffer.length() - 5,stringBuffer.length());
        stringBuffer.append(";");
        System.out.println(stringBuffer);
    }

    private static void update(List listTable,List lists,String tableName,Integer size){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UPDATE ").append(tableName).append(" SET ");

        List list = lists;
        for (int j = size ; j < list.size(); j++) {
            stringBuffer.append(listTable.get(j));
            stringBuffer.append(" = ");
            //stringBuffer.append(list.get(j));
            String string = list.get(j).toString();
            Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
            if (!pattern.matcher(string).matches() && !"NULL".equals(string)) {
                stringBuffer.append("'");
                stringBuffer.append(string);
                stringBuffer.append("'");
            }  else {
                stringBuffer.append(string);
            }
            stringBuffer.append(", ");
        }
        stringBuffer.delete(stringBuffer.length() - 2,stringBuffer.length());
        stringBuffer.append(" WHERE ");
        for (int j = 0; j < size; j++) {
            stringBuffer.append(listTable.get(j));
            stringBuffer.append(" = ");
            //stringBuffer.append(list.get(j));
            String string = list.get(j).toString();
            Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
            if (!pattern.matcher(string).matches() && !"NULL".equals(string)) {
                stringBuffer.append("'");
                stringBuffer.append(list.get(j));
                stringBuffer.append("'");
            } else if (string.length() >= FENGESIZE) {
                stringBuffer.append("'");
                stringBuffer.append(list.get(j));
                stringBuffer.append("'");
            } else {
                stringBuffer.append(list.get(j));
            }
            stringBuffer.append(" AND ");
        }

        stringBuffer.delete(stringBuffer.length() - 5,stringBuffer.length());
        stringBuffer.append(";");
        System.out.println(stringBuffer);
    }


    public List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList = new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);

                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList = new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if (cellinfo.isEmpty()) {
                            continue;
                        }
                        innerList.add(cellinfo);
                    }
                    outerList.add(i, innerList);
                }
                return outerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
