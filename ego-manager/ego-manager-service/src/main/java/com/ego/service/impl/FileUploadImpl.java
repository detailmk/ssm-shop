package com.ego.service.impl;

import com.ego.result.FileResult;
import com.ego.service.FileUploadServiceI;
import com.ego.util.DateUtil;
import com.ego.util.FTPUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDateTime;


/**
 * 文件上传service
 */
@Service
public class FileUploadImpl implements FileUploadServiceI {

    @Value("${ftp.host}")
    private String ftpHost;
    @Value("${ftp.port}")
    private int ftpPort;
    @Value("${ftp.username}")
    private String ftpUsername;
    @Value("${ftp.password}")
    private String ftpPassword;
    @Value("${ftp.path}")
    private String ftpPath;

    /**
     * 文件上传
     * @param fileName
     * @param is
     * @return
     */
    @Override
    public FileResult fileUpload(String fileName, InputStream is) {
        FileResult result=null;
        //得到日期格式
        String dataPath= DateUtil.getDateStr(LocalDateTime.now(), DateUtil.pattern_date);
        //得到文件上传服务器名称
        String remoteName= FTPUtil.fileUpload(ftpHost,ftpPort,ftpUsername,ftpPassword,ftpPath+dataPath,fileName,is);
        if (null!=remoteName&&remoteName.length()>0){
            result=new FileResult();
            //拼接上传到文件服务器的路径
            String imageUrl = "http://" + ftpHost + "/" + dataPath + "/" + remoteName;
            result.setSuccess("success");
            result.setMessage("文件上传成功");
            result.setFileUrl(imageUrl);
        }else{
            result=new FileResult();
            result.setError("error");
            result.setMessage("文件上传失败");
        }
        return result;
    }
}
