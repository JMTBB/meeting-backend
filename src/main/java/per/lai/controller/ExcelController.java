package per.lai.controller;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import per.lai.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ExcelController {
    private UserService userService;

    @Autowired
    @Qualifier("userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/userExcel")
    public @ResponseBody
    void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.reset();
//        Map<String,Object> map=new HashMap<String,Object>();
//        // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
//        // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
//        response.setHeader("Content-Disposition", "attachment;filename=" + "表单测试" + ".xlsx");
//        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
//        response.setHeader("Pragma", "no-cache");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expires", 0);
//        XSSFWorkbook workbook=null;
//        //导出Excel对象
//        workbook = userService.exportExcelInfo();
//        OutputStream output;
//        try {
//            output = response.getOutputStream();
//            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
//            bufferedOutPut.flush();
//            workbook.write(bufferedOutPut);
//            bufferedOutPut.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + "表单测试" + ".xlsx");
        XSSFWorkbook workbook = userService.exportExcelInfo();
        try {
            bos = new BufferedOutputStream(response.getOutputStream());
            bos.flush();
            workbook.write(bos);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
