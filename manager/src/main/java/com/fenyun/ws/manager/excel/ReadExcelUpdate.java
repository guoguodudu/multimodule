package com.fenyun.ws.manager.excel;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import com.fenyun.ws.manager.util.ExcelUtils;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.io.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ReadExcelUpdate {



    /*
    * PD档对应 BO_PD
    * SUB档 BO_PD_SUB
    *  RC_PD
    * */

    private static final String TABLENAME = "EXPIRE_MANAGE";

    //分割符
    private static final Integer FENGE = 2;

    //判断字符串大小是否添加双引号
    private static final Integer FENGESIZE = 10;


    private static final Integer COL = 10;

    public static void main(String[] args) throws Exception {
        ReadExcelUpdate obj = new ReadExcelUpdate();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("D:/excel/45.xlsx");

        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));

        List excelList= ExcelUtils.importExcel(multipartFile,Object.class);


        System.out.println(excelList);
        System.out.println("list中的数据打印出来");
        for (int i = 1; i < excelList.size(); i++) {

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("UPDATE ").append(TABLENAME).append(" SET ");

            List list = (List) excelList.get(i);
            for (int j = FENGE ; j < list.size(); j++) {
                stringBuffer.append(((List) excelList.get(0)).get(j));
                stringBuffer.append(" = ");
                //stringBuffer.append(list.get(j));
                //System.out.println(list.get(j));
                String string = list.get(j).toString();
                Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
                if (!pattern.matcher(string).matches() && !"NULL".equals(string)) {
                    stringBuffer.append("'");
                    stringBuffer.append(string);
                    stringBuffer.append("'");
                } else if (string.length() >= FENGESIZE) {
                    stringBuffer.append("'");
                    stringBuffer.append(string);
                    stringBuffer.append("'");
                } else {
                    stringBuffer.append(string);
                }
                stringBuffer.append(", ");
            }
            stringBuffer.delete(stringBuffer.length() - 2,stringBuffer.length());
            stringBuffer.append(" WHERE ");
            for (int j = 0; j < FENGE; j++) {
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
                        //System.out.println(cellinfo);
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