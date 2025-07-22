package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.FileUploadModal;
import com.internship2025.changemanagementsystem.Services.FileUpLoadService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fileUploads")
public class FileUploadController {

    private final FileUpLoadService fileUpLoadService;

    public FileUploadController(FileUpLoadService fileUpLoadService) {
        this.fileUpLoadService = fileUpLoadService;
    }


    @PostMapping("uploadFile")
    public ApiResponse<?> uploadFile(@ModelAttribute FileUploadModal fileUploadModal) {
        return fileUpLoadService.uploadFile(fileUploadModal);
    }


}
