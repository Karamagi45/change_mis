package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ApprovalStages;
import com.internship2025.changemanagementsystem.Repostory.ApprovalStagesRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ApprovalStagesService  implements Constant {

    private final ApprovalStagesRepo approvalStagesRepo;

    public ApprovalStagesService(ApprovalStagesRepo approvalStagesRepo) {
        this.approvalStagesRepo = approvalStagesRepo;
    }

    public ApiResponse<?> addApprovalStage(ApprovalStages approvalStages){
        try {
            boolean addResponse = approvalStagesRepo.createApprovalStage(approvalStages);
            if(addResponse){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
                log.error(e.getMessage());
                return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> updateApprovalStage(ApprovalStages approvalStages){
        try {
            boolean updateResponse = approvalStagesRepo.updateApprovalStage(approvalStages);
            if(updateResponse){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


    public ApiResponse<?> deleteApprovalStage(ApprovalStages approvalStages){
        try {
            boolean deleteResponse = approvalStagesRepo.deleteApprovalStage(approvalStages);
            if(deleteResponse){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


    public ApiResponse<?> getApprovalStage(ApprovalStages approvalStages){
        try {
            List<ApprovalStages> getResponse = approvalStagesRepo.getAllApprovalStages();
            if(getResponse !=null &&   getResponse.size()>0){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(getResponse).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

}
