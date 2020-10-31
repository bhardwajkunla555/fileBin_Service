package com.fileBin.spring.api.controller;

import com.fileBin.spring.api.entity.UploadFeedback;
import com.fileBin.spring.api.services.DownloadFile;
import com.fileBin.spring.api.services.UploadFile;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@CrossOrigin
public class fileController {

    private static final Logger logger = LogManager.getLogger(fileController.class);

    @Autowired
    private UploadFile uploadFile;

    @Autowired
    private DownloadFile downloadFile;


    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public UploadFeedback uploadFile(@RequestParam(value = "file", required = true)
                                     MultipartFile file) throws IOException {
            logger.info("Controller Method : save File to Directory");
        return uploadFile.request(file);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error")
    public String erroredOut()   {
        logger.info("Controller Method : save File to Directory");
        return "error";
    }


    @RequestMapping(value="/download/{name}",produces = "application/zip")
    @ResponseBody
    public Resource getFileFromFileSystem(@PathVariable("name") String key, HttpServletResponse response)  {
        logger.info("Controller Method : getFileFromFileSystem");
        return downloadFile.save(key,response);
    }



}
