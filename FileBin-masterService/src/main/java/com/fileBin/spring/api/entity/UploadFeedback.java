package com.fileBin.spring.api.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UploadFeedback {
    private static final Logger logger = LogManager.getLogger(UploadFeedback.class);
    private String status;
    private String link;

    public UploadFeedback(String status, String link) {
        this.status = status;
        this.link = link;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
