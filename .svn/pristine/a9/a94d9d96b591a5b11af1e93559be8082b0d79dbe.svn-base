package com.huidong.qzh.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/video")
public class VideoController {

    @RequestMapping("")
    public void playVideo(String name, HttpServletResponse response) {

        File file = new File("D:\\opt\\data\\video\\" + name);

        InputStream in = null;
        ServletOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = response.getOutputStream();
            byte[] buffer = new byte[4 * 1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件读取失败,文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件流输出异常");
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println("文件流关闭异常");
                e.printStackTrace();
            }
        }
    }
}
