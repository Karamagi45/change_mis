package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ApprovalProcess;
import com.internship2025.changemanagementsystem.Repostory.ApprovalProcessRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ApprovalProcessService implements Constant {

    private final ApprovalProcessRepo approvalProcessRepo;

    public ApprovalProcessService(ApprovalProcessRepo approvalProcessRepo) {
        this.approvalProcessRepo = approvalProcessRepo;
    }

    public ApiResponse<?> addApprovalProcess(ApprovalProcess approvalProcess){
        try {
            approvalProcess.setCreated_date(LocalDateTime.now());
            boolean addResponse = approvalProcessRepo.createApprovalProcess(approvalProcess);
            if(addResponse){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            log.error("addApprovalProcess Exception:{}",e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> updateApprovalProcess(ApprovalProcess approvalProcess){
        try {
            approvalProcess.setCreated_date(LocalDateTime.now());
            boolean updateResponse = approvalProcessRepo.updateApprovalProcess(approvalProcess);
            if(updateResponse){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> deleteApprovalProcess(ApprovalProcess approvalProcess){
        try {
            boolean deleteResponse = approvalProcessRepo.deleteApprovalProcess(approvalProcess);
            if(deleteResponse){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> getApprovalProcess(ApprovalProcess approvalProcess){
        try {
            List<ApprovalProcess> getResponse = approvalProcessRepo.findAllApprovalProcess();
            if(getResponse != null &&  getResponse.size()>0){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(getResponse).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            log.error("getApprovalProcess Exception:{}",e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


}
