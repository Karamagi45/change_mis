package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ChangeDetail;
import com.internship2025.changemanagementsystem.Repostory.ChangeDetailRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ChangeDetailService implements Constant {

    private final ChangeDetailRepo changeDetailRepo;

    public ChangeDetailService(ChangeDetailRepo changeDetailRepo) {
        this.changeDetailRepo = changeDetailRepo;
    }


    public ApiResponse<?> newChangeDetail(ChangeDetail change_detail) {
        try {

            boolean detailResponse = changeDetailRepo.createChangeDetail(change_detail);
            if (detailResponse) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            } else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


    public  ApiResponse<?> getChangeDetailById(Integer changeRequestId) {
        try {
            if(changeRequestId == null){
                return ApiResponse.builder().code(FAILED_CODE).message("change_request_id required").build();
            }

            ChangeDetail dd = changeDetailRepo.findChangeDetailById(changeRequestId);
            if (dd != null) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(dd).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


    public ApiResponse<?> updateChangeDetail(ChangeDetail detail) {
        try {
            if(detail.getChangeRequestId()==null)
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();

            boolean detailResponse = changeDetailRepo.updateChangeDetail(detail);
            if (detailResponse) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            } else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();

        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> findChangeDetails() {
        try {
            List<?> findResponse = changeDetailRepo.findAllChangeDetail();
            if (findResponse != null && findResponse.size() > 0) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(findResponse).build();

            } else
                System.out.println("Data not fetched");
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

}
