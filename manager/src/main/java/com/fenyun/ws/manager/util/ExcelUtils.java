package com.fenyun.ws.manager.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.excel.export.ExcelBatchExportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * excel导入导出工具类
 *
 * @author jason
 */
@Slf4j
public class ExcelUtils {

	/**
	 * 推荐使用
	 * excel 大数据导出 不带标题的
	 *
	 * @param list      数据
	 * @param pojoClass pojo类型
	 * @param fileName  文件名+sheet名
	 * @param response
	 */


	/**
	 * excel 导出 不带标题的
	 *
	 * @param list      数据
	 * @param pojoClass pojo类型
	 * @param fileName  文件名+sheet名
	 * @param response
	 */
	public static void downloadExcel(Collection<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response) {
		if (list == null || list.isEmpty()) {
			return;
		}
		ExportParams exportParams = new ExportParams();
		exportParams.setSheetName(fileName);
		exportParams.setType(ExcelType.XSSF);
		Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
		downLoadExcel(fileName, response, workbook);
	}

	/**
	 * excel 导入 不带标题的
	 *
	 * @param file      上传的文件
	 * @param pojoClass pojo类型
	 */
	public static <T> List<T> importExcel(MultipartFile file, Class<?> pojoClass) {
		if (null == file) {
			return null;
		}
		ImportParams params = new ImportParams();
		params.setTitleRows(0);// 标题
		params.setHeadRows(1);// 头
		params.setNeedSave(false); // 是否需要保存上传的Excel，默认为false
		params.setSaveUrl("/excel/");// 保存地址
		try {
			return ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * excel 导入 不带标题的 返回带校验结果
	 *
	 * @param inputStream 上传的文件流
	 * @param pojoClass   pojo类型
	 * @return
	 */
	public static <T> ExcelImportResult<T> importExcelMore(InputStream inputStream, Class<?> pojoClass) {
		ImportParams params = new ImportParams();
		params.setNeedVerify(true);
		params.setTitleRows(0);
		params.setHeadRows(1);
		try {
			return ExcelImportUtil.importExcelMore(inputStream, pojoClass, params);
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * excel 下载
	 *
	 * @param fileName 文件名称
	 * @param workbook excel数据
	 */
	private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
		try {
			String fileNameFull = fileName + ".xlsx";
			response.setCharacterEncoding("UTF-8");
			response.setHeader("content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileNameFull, "UTF-8"));
			workbook.write(response.getOutputStream());
		} catch (Exception e) {
		}
	}

	/**
	 * 大数据导出
	 *
	 * @param entity    表格标题属性
	 * @param pojoClass Excel对象Class
	 * @param dataSet   Excel对象数据List
	 */

	// Excel 导出 通过浏览器下载的形式
	public static void exportExcel(HttpServletResponse response, Workbook workbook, String fileName) throws IOException {
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes("UTF-8"), "iso8859-1"));
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		BufferedOutputStream bufferedOutPut = new BufferedOutputStream(response.getOutputStream());
		workbook.write(bufferedOutPut);
		bufferedOutPut.flush();
		bufferedOutPut.close();
	}

	public static void downloadTemp(HttpServletResponse response, String path, String name) {
		try {

			TemplateExportParams tempParams =
					new TemplateExportParams(path);

			Map<String, Object> map = new HashMap<>();
			Workbook workbook = ExcelExportUtil.exportExcel(tempParams, map);

			ExcelUtils.exportExcel(
					response,
					workbook,
					name + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx");

		} catch (Exception e) {
			log.error("系统异常", e);
		}
	}
}