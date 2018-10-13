package com.qiji.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.UploadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qiji.common.ModelJson;
import com.qiji.common.utils.ConfigUtils;

@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private ConfigUtils configUtils;
    /**
     * 单文件上传
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public ModelJson upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
    	ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            String savePath = request.getParameter("save_path");
            String tmpSavePath = "";
            if(StringUtils.isBlank(savePath)){
            	tmpSavePath= "upload/";
            	savePath = configUtils.getUploadPath();
            	
            }else{
            	tmpSavePath= "upload/" + savePath;
            	savePath = configUtils.getUploadPath() + savePath;
            	
            }
            saveFileName = UUID.randomUUID().toString().replace("-", "") + saveFileName;
            File saveFile = new File(savePath + "/" +  saveFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            BufferedOutputStream out = null;
            try {
                out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                modelJson.setSucc(true);
        		modelJson.setOperSucc(true);
        		modelJson.setObj(tmpSavePath + "/" + saveFileName);
                modelJson.setMessage("文件上传成功！");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                modelJson.setMessage("文件上传失败，失败原因：系统异常！");
            } catch (IOException e) {
                e.printStackTrace();
                modelJson.setMessage("文件上传失败，失败原因：系统异常！");
            }finally{
            	if(null != out){
            		try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
						 modelJson.setMessage("文件上传失败，失败原因：系统异常！");
					}
            	}
            }
        } else {
            modelJson.setMessage("文件上传失败，失败原因：上传文件列表为空！");
        }
        return modelJson;
    }
 
    /**
     * 多文件上传
     *
     * @param request
     * @return
     */
    @PostMapping("/uploadFiles")
    public ModelJson uploadFiles(HttpServletRequest request) throws IOException {
    	ModelJson modelJson = new ModelJson();
		modelJson.setSucc(false);
		modelJson.setOperSucc(false);
		modelJson.setObj(null);
		String savePathStr = request.getParameter("save_path");
        String tmpSavePath = "";
		if (StringUtils.isBlank(savePathStr)) {
			tmpSavePath = "upload/";
			savePathStr = configUtils.getUploadPath();
			
		} else {
			tmpSavePath = "upload/" + savePathStr + "/";
			savePathStr = configUtils.getUploadPath()+ savePathStr + "/";;
			
		}
		
        System.out.println(savePathStr);
        File savePath = new File(savePathStr);
        if (!savePath.exists()) {
            savePath.mkdirs();
        }
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        List<String> fileNames = new ArrayList<String>();
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String fileName = UUID.randomUUID().toString().replace("-", "") + "-"
            				+ file.getOriginalFilename();
                    File saveFile = new File(savePath, fileName);
                    fileNames.add(tmpSavePath + fileName);
                    stream = new BufferedOutputStream(new FileOutputStream(saveFile));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    if (stream != null) {
                        stream.close();
                        stream = null;
                    }
                    modelJson.setMessage("文件上传失败，失败原因：第 " + i + " 个文件上传有错误");
                    return modelJson;
                }
            } else {
            	modelJson.setMessage("文件上传失败，失败原因：第 " + i + " 个文件为空");
            	return modelJson;
            }
        }
        modelJson.setMessage("所有文件上传成功");
        modelJson.setObj(fileNames);
        modelJson.setOperSucc(true);
        modelJson.setSucc(true);
        return modelJson;
    }
}

