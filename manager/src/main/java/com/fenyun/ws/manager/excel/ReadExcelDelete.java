package com.fenyun.ws.manager.excel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ReadExcelDelete {


    /*
     * PD档对应 BO_PD
     * SUB档 BO_PD_SUB
     *  RC_PD_SUB
     * */

    //表明
    private static final String TABLENAME = "RC_PD_SUB";

    //分割符
  //  private static final Integer FENGE = 11;

    //判断字符串大小是否添加双引号
    private static final Integer FENGESIZE = 6;


    private static final Integer COL = 10;

    public static void main(String[] args) {
        ReadExcelUpdate obj = new ReadExcelUpdate();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("D:/delete.xls");
        List excelList = obj.readExcel(file);
        System.out.println("list中的数据打印出来");


        for (int i = 1; i < excelList.size(); i++) {

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("DELETE FROM ").append(TABLENAME).append("");

            List list = (List) excelList.get(i);

           // stringBuffer.delete(stringBuffer.length() - 2,stringBuffer.length());
            stringBuffer.append(" WHERE ");
            for (int j = 0; j < list.size(); j++) {
                stringBuffer.append(((List) excelList.get(0)).get(j));
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

    }

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
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
