package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApprovalProcess {

    private Integer processId;
    private  String description;
    private  String created_by;
    private LocalDateTime created_date;
    private  String process_status;


}
