package com.fileBin.spring.api.services;

import com.fileBin.spring.api.model.UniqueKey;
import com.fileBin.spring.api.repository.UniqueRepositiory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class DownloadFile {
    @Value("${fileBin.uploadDir}")
    private String uploadDir;
    @Value("${fileBin.downloadDir}")
    private String downloadDir;

    @Autowired
    private UniqueRepositiory uniqueRepositiory;

    private static final Logger logger = LogManager.getLogger(DownloadFile.class);



    public Resource save(String key, HttpServletResponse response)  {
        logger.info("DownloadFile Service: Get Row From Database");
        UniqueKey row=uniqueRepositiory.findById(key);
        Resource resource = null;
        File file = new File(uploadDir+row.getFile_name());
        if (Files.exists(Paths.get(uploadDir+row.getFile_name()))){
            String mimeType = "application/zip  ";
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            response.setHeader("filename", file.getName());
            resource = (Resource) new FileSystemResource(uploadDir+row.getFile_name());
            logger.info("DownloadFile Service: Delete File From Directory");
            file.delete();
            logger.info("DownloadFile Service: Delete Row From Database");
            uniqueRepositiory.delete(row);
            return resource;
        }else{

            return null;
        }
    }
}
