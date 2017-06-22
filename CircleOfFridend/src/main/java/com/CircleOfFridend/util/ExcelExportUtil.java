package com.CircleOfFridend.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.CircleOfFridend.entity.Friend;


//表格导出工具类
/**
 * 数据导出到Excel工具类
 * @author 周聪
 *
 */
public class ExcelExportUtil {
	
	 /**
     * 设置导出Excel的表名
     * 
     * @return
     */
    public String getSheetName() {
        return "测试导出数据";
    }
    /**
     * 设置导出Excel的列名
     * 
     * @return
     */
    public String getSheetTitleName() {
		
        return "fid,fname,tid,ftel,sex,age,monthSal,annualBonus";
    }
    /**
     * 创建 sheet 的第一行,标题行
     * 
     * @param sheet
     * @param strTitle
     */
    private void createSheetTitle(HSSFSheet sheet, String strTitle) {
        HSSFRow row = sheet.createRow(0); // 创建该表格(sheet)的第一行
        sheet.setDefaultColumnWidth(5);
        HSSFCell cell = null;
        String[] strArray = strTitle.split(",");
        for (int i = 0; i < strArray.length; i++) {
            cell = row.createCell(i); // 创建该行的第一列
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(new HSSFRichTextString(strArray[i]));
        }
    }
    /**
     * 
     * @param friendList		封装的数据内容
     * @return
     * @throws IOException
     */
    @SuppressWarnings("resource")
    public InputStream getExcelStream(List<Friend> friendList) throws IOException {
        // 创建一个 Excel 文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建一个表格 Sheet
        HSSFSheet sheet = wb.createSheet(this.getSheetName());
        // 创建 sheet 的第一行,标题行
        // 行号从0开始计算
        this.createSheetTitle(sheet, this.getSheetTitleName());
        // 设置 sheet 的主体内容
        this.createSheetBody(friendList, sheet);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        wb.write(output);
        byte[] ba = output.toByteArray();
        InputStream is = new ByteArrayInputStream(ba);
        return is;
    }
    private void createSheetBody(List<Friend> FriendList, HSSFSheet sheet) {
        if (FriendList == null || FriendList.size() < 1) {
            return;
        }
        // 表格(sheet) 的第二行, 第一行是标题, Excel中行号, 列号 是由 0 开始的
        int rowNum = 1;
        HSSFCell cell = null;
        HSSFRow row = null;
        for (Iterator<Friend> it = FriendList.iterator(); it.hasNext(); rowNum++) {
        	Friend friend = (Friend) it.next();
            if (friend == null)
            	friend = new Friend();
            row = sheet.createRow(rowNum);
            int i = 0;
            cell = row.createCell(i++);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(new HSSFRichTextString(rowNum + ""));
            cell = row.createCell(i++); // name
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(new HSSFRichTextString(friend.getFname()));
            
            cell=row.createCell(i++);//ftype
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(friend.getFtel());
            
            cell=row.createCell(i++);//ftel
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(friend.getFtel());
            
            cell = row.createCell(i++); // sex
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(new HSSFRichTextString(friend.getSex()));
            
            cell = row.createCell(i++);//Age
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(friend.getAge());
             
            cell = row.createCell(i++);//monthSal
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(friend.getMonthSal());
            
            cell = row.createCell(i++);//AnnualBonus
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(friend.getAnnualBonus());
            
        }
    }
}
	


