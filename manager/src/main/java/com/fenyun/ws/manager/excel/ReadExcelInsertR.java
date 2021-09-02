package com.fenyun.ws.manager.excel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ReadExcelInsertR {


    /*
     * PD档对应 BO_PD
     * SUB档 BO_PD_SUB
     *  RC_PD_SUB
     * */

    //表明
    private static final String TABLENAME = "FILE_CONF";

    //分割符
  //  private static final Integer FENGE = 11;

    //判断字符串大小是否添加双引号
    private static final Integer FENGESIZE = 10;

      private static final String userName = "system";

      private static final LocalDateTime t=LocalDateTime.now();

    private static final Integer COL = 10;
    private static  DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
      //  ReadExcelUpdate obj = new ReadExcelUpdate();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("D:/demand/3333.xls");
        List excelList = readExcel(file);
        System.out.println("list中的数据打印出来"+excelList.size());


        for (int i = 1; i < excelList.size(); i++) {


            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("INSERT INTO  ").append(TABLENAME).append(" ( ");

            List list = (List) excelList.get(0);

            for (int j = 0; j < list.size(); j++) {
                stringBuffer.append(list.get(j)).append(", ");
            }
            stringBuffer.delete(stringBuffer.length() - 2,stringBuffer.length());
            stringBuffer.append(" ) VALUES (");

            List list2 = (List) excelList.get(i);
           // System.out.println(list2);
            for (int j = 0; j < list2.size(); j++) {

                String string = list2.get(j).toString();

                if(list.get(j).equals("FILE_DETAIL_NAME")) {

                    if(StringUtils.isNotBlank(string)) {
                        StringBuffer stringBuffer1 = new StringBuffer();
                        stringBuffer1.append("[");
                        String[] strings = string.split("\n");
                        for (String s : strings) {
                            stringBuffer1.append("{\"name\": \"").append(s)
                                    .append("\"},");

                        }
                        String stringBuffer2 = stringBuffer1.substring(0, stringBuffer1.length() - 1).toString();
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append(stringBuffer2);
                        stringBuffer3.append("]");
                        //System.out.println(stringBuffer3.toString());
                        //System.out.println();
                        stringBuffer.append("'").append(stringBuffer3).append("', ");
                        continue;
                    }{
                        stringBuffer.append("NULL,");
                        continue;
                    }


                }
             //   [{"name": "身份证正面\"}, {\"name\": \"身份证反面\"}]

                if(list.get(j).equals("CREATE_ID")){
                    stringBuffer.append("'").append(userName).append("', ");continue;
                }
                if(list.get(j).equals("CREATE_DATETIME")){
                    stringBuffer.append("'").append(LocalDateTime.now().format(dtf2).toString()).append("', ");continue;
                }
                if(string.isEmpty()){
                    stringBuffer.append("NULL,");continue;
                }
                Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
                if (!pattern.matcher(string).matches() && !"NULL".equals(string)) {
                    stringBuffer.append("'");
                    stringBuffer.append(list2.get(j));
                    stringBuffer.append("'");
                } else if (string.length() >= FENGESIZE) {
                    stringBuffer.append("'");
                    stringBuffer.append(list2.get(j));
                    stringBuffer.append("'");
                } else {
                    stringBuffer.append(list2.get(j));
                }
                stringBuffer.append(",");
            }
            stringBuffer.delete(stringBuffer.length() - 1,stringBuffer.length());
            stringBuffer.append(");");
            System.out.println(stringBuffer);
        }


    }

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public static List readExcel(File file) {
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
                            innerList.add("");continue;
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
