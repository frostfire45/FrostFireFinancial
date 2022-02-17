package com.frostfirecompx.financial.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    void uploadFile(MultipartFile file);
    void deleteFile();
    boolean fileExsists();
}
