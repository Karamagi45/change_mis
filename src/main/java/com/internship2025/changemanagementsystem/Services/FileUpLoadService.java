package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.FileUploadModal;
import com.internship2025.changemanagementsystem.Repostory.FileUploadRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class FileUpLoadService implements Constant {

    private final FileUploadRepo fileUploadRepo;

    public FileUpLoadService(FileUploadRepo fileUploadRepo) {
        this.fileUploadRepo = fileUploadRepo;
    }

    public ApiResponse<?> uploadFile(FileUploadModal fileUploadModal) {
        try {

            MultipartFile file = fileUploadModal.getData();
            if(file==null || file.isEmpty()){
                return ApiResponse.builder().code(FAILED_CODE).message("NO FILE FOUND").build();
            }

            String fileName = file.getOriginalFilename();
            String contentType = file.getContentType();
            byte[] fileBytes = file.getBytes();
            boolean result = fileUploadRepo.uploadBytes(fileName, contentType, fileBytes);
            if (result) {
                System.out.println("file upload successful");
                return ApiResponse.builder().code(SUCCESS_CODE).message("FILE SAVED").build();
            } else
                System.out.println("file upload failed");
            return ApiResponse.builder().code(FAILED_CODE).message("NO FILE SAVED").build();

        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

}
