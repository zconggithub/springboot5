package com.CircleOfFridend.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CircleOfFridend.entity.Friend;
import com.CircleOfFridend.entity.SearchCondition;
import com.CircleOfFridend.service.FriendService;
import com.CircleOfFridend.util.ExcelExportUtil;


@RestController
public class FriendExportExcelController {

	@Autowired
	private FriendService friendService;
	
    /**
     * 导出Excel
     * 
     * @author zhang_cq
     */
    @RequestMapping("/export")
    public String export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置导出的编码格式，此处统一为UTF-8
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        // 设置导出文件的名称
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String("数据导出Excel测试.xls".getBytes(), "utf-8"));
        // 模拟表格需要导出的数据
    	SearchCondition condition=new SearchCondition();
		condition.setStartAge(18);
		condition.setEndAge(30);
		condition.setStarAnnualBonus(2000);;
		 List<Friend>  friendList= friendService.searchByCondition(condition);

       
 
        // 实际应用中这个地方会判断获取的数据，如果没有对应的数据则不导出，如果超过2000条，则只导出2000条
        if (friendList.size() == 0) {
            PrintWriter print = response.getWriter();
            print.write("没有需要导出的数据！");
            return null;
        }
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
        	ExcelExportUtil dataExportUtil = new ExcelExportUtil();
            bis = new BufferedInputStream(dataExportUtil.getExcelStream(friendList));
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            bos.flush();
        } catch (final IOException e) {
            System.out.println("数据导出列表导出异常！");
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
        return "export";
    }
}