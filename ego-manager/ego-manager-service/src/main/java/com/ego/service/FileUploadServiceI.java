package com.ego.service;

import com.ego.result.FileResult;

import java.io.InputStream;

public interface FileUploadServiceI {
    //文件上传
   public FileResult fileUpload(String fileName, InputStream is);
}
