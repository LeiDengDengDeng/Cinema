package com.example.cinema.controller;

import com.example.cinema.vo.ResponseVO;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fjj
 * @date 2019/3/12 5:11 PM
 */
@RestController
public class FileController {
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public ResponseVO upLoadFile(@RequestParam MultipartFile myFile, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String realFileName = "";
        if(myFile.isEmpty()) {
            return ResponseVO.buildFailure("图片未上传");
        }
        else {
            String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload")+File.separator;
            System.out.println(realPath);
            realFileName =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + myFile.getOriginalFilename();
            String realFileAddress = realPath + realFileName;
            System.out.println(realFileAddress);
            FileUtils.copyInputStreamToFile(myFile.getInputStream(), new File(realFileAddress));
        }
        return ResponseVO.buildSuccess("/uploads/" + realFileName);
    }
}
