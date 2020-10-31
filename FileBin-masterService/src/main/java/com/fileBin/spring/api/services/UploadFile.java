package com.fileBin.spring.api.services;

import com.fileBin.spring.api.entity.UploadFeedback;
import com.fileBin.spring.api.model.UniqueKey;
import com.fileBin.spring.api.repository.UniqueRepositiory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

@Service
public class UploadFile {

    @Value("${fileBin.uploadDir}")
    private String uploadDir;
    @Value("${fileBin.downloadDir}")
    private String downloadDir;

    @Autowired
    private UniqueRepositiory uniqueRepositiory;

    private static final Logger logger = LogManager.getLogger(DownloadFile.class);


    public UploadFeedback request(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String filePath =uploadDir;
            String fileName="";
            //Check If File exist and If exist generateFileName
            if (Files.exists(Paths.get(filePath+file.getOriginalFilename()))){
                fileName=generateFileName(file.getOriginalFilename());
                filePath = filePath  + fileName;
            }else{
                fileName = file.getOriginalFilename().replaceAll("\\s", "");
                filePath = filePath  + fileName;
            }
            //generate Random key for db
            String uniquekey=generateRandomKey();
            UniqueKey row=createrow(fileName.replaceAll("\\s", ""),uniquekey);
            //save obj in db
            logger.info("UploadFile Service: Save Row To Database");
            uniqueRepositiory.save(row);
            //save file in directory
            logger.info("UploadFile Service: Save File To Directory");
            Files.copy(file.getInputStream(), Paths.get(filePath));
            UploadFeedback obj=new UploadFeedback("Success","localhost:9190/download/"+uniquekey);
            return obj;
        }else{
            UploadFeedback obj=new UploadFeedback("Failed",null);
            return obj;

        }
    }

    private UniqueKey createrow(String fileName, String uniquekey) {
        UniqueKey row =new UniqueKey();
        row.setFile_name(fileName);
        row.setUnique_key(uniquekey);
        return row;
    }

    private String generateRandomKey() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
    private String generateFileName(String fileName) {
        String alphabet = "123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 3;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString()+fileName.replaceAll("\\s", "");
    }
}
