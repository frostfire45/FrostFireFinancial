package com.frostfirecompx.financial.services;

import com.frostfirecompx.financial.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements UploadService{
    @Value("${upload.path}")
    public String uploadDir;

    @Override
    public void uploadFile(MultipartFile file) {
        try {
            Path copyLocation = Paths.get(
                    uploadDir + File.separator + StringUtils.cleanPath(
                            file.getOriginalFilename()));
            Files.copy(file.getInputStream(),copyLocation, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename()
            + ". Please try again!");
        }
    }

    @Override
    public void deleteFile() {

    }

    @Override
    public boolean fileExsists() {
        return false;
    }
}
