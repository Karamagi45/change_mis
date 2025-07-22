package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadModal {
    private  String name;
    private  String type;
    private MultipartFile data;
    private  String userId;


}
