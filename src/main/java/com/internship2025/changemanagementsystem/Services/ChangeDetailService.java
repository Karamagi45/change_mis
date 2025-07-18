package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.Change_detail;
import com.internship2025.changemanagementsystem.Modal.UsersModel;
import com.internship2025.changemanagementsystem.Repostory.ChangeDetailRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeDetailService implements Constant {

    private final ChangeDetailRepo changeDetailRepo;

    public ChangeDetailService(ChangeDetailRepo changeDetailRepo) {
        this.changeDetailRepo = changeDetailRepo;
    }


    public ApiResponse<?> newChangeDetail(Change_detail change_detail) {
        try {

            boolean detailResponse = changeDetailRepo.createChangeDetail(change_detail);
            if (detailResponse) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            } else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();

        } catch (Exception e) {
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> findChangeDetails() {
        try {
            List<?> findResponse = changeDetailRepo.findAllChangeDetail();
            if (findResponse != null && findResponse.size() > 0) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(findResponse).build();

            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

}
