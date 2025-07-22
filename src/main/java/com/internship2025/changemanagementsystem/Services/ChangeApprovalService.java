package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.Change_approval_rejection;
import com.internship2025.changemanagementsystem.Repostory.ChangeApprovalRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeApprovalService  implements Constant {

    private  final ChangeApprovalRepo changeApprovalRepo;

    public ChangeApprovalService(ChangeApprovalRepo changeApprovalRepo) {
        this.changeApprovalRepo = changeApprovalRepo;
    }

    public ApiResponse<?> addChangeApproval(Change_approval_rejection rejection){
        try {
            boolean approval = changeApprovalRepo.createChangeApproval(rejection);
            if(approval){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


    public ApiResponse<?> fetchChangeApproval(){
        try {
            List<?> fetchResponse = changeApprovalRepo.getChangeApprovalRejections();
            if(fetchResponse != null && fetchResponse.size()>0){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(fetchResponse).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

}
