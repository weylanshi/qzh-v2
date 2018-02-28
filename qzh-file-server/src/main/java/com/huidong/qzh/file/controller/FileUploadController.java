package com.huidong.qzh.file.controller;

import com.huidong.qzh.util.common.util.QzhResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Value("${file_base_path}")
    private String FILE_BASE_PATH;

    @Value("${file_view_url}")
    private String FILE_VIEW_URL;

    /**
     * 单文件上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/uploadFile")
    public @ResponseBody
    QzhResult handFileUpload(@RequestParam(value = "file") MultipartFile file, String path) throws IOException {
        try {
            File filePath = new File(FILE_BASE_PATH + path);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            String fileName = file.getOriginalFilename();
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();//文件类型
            String ToSaveFileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + extension;
            File fileToSave = new File(FILE_BASE_PATH + path, ToSaveFileName);
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(fileToSave));
            String[] paths = fileToSave.getPath().replaceAll("\\\\", "/").split(FILE_BASE_PATH);
            return QzhResult.ok(FILE_VIEW_URL + paths[1]);
        } catch (IOException e) {
            e.printStackTrace();
            return QzhResult.error(e.getMessage());
        }
    }

    /**
     * 多文件上传
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/uploadFiles")
    public @ResponseBody
    QzhResult handFileUpload(HttpServletRequest request, String path) throws IOException {

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        ArrayList<String> pathList = new ArrayList<>();
        files.forEach(file -> {
            try {
                File filePath = new File(FILE_BASE_PATH + path);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                String fileName = file.getOriginalFilename();
                String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();//文件类型
                String ToSaveFileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + extension;
                File fileToSave = new File(FILE_BASE_PATH + path, ToSaveFileName);
                FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(fileToSave));
                String[] paths = fileToSave.getPath().replaceAll("\\\\", "/").split(FILE_BASE_PATH);
                pathList.add(FILE_VIEW_URL + paths[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return QzhResult.ok(pathList);
    }

}
