package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ChangeFormData;
import com.internship2025.changemanagementsystem.Modal.ChangeFormData2;
import com.internship2025.changemanagementsystem.Modal.ChangeFormDataList;
import com.internship2025.changemanagementsystem.Repostory.ChangeRequestFormRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ChangeRequestFormService implements Constant {

    private final ChangeRequestFormRepo changeRequestFormRepo;

    public ChangeRequestFormService(ChangeRequestFormRepo changeRequestFormRepo) {
        this.changeRequestFormRepo = changeRequestFormRepo;
    }


    public ApiResponse<?> getChangeRequestForm2() {
        try {
            List<ChangeFormData2> formResponse = changeRequestFormRepo.fetchFormData2();
            if (formResponse != null || formResponse.size() > 0) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(formResponse).build();
            } else
                System.out.println("display failed");
            return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


    public ApiResponse<?> showLastKeyNumber() {
        try {
            int lastKeyNumber = changeRequestFormRepo.showLastKeyNumber();
            if (lastKeyNumber > 0) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(lastKeyNumber).build();
            } else {
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


    public ApiResponse<?> getChangeRequestForm() {
        try {
            List<ChangeFormData> formResponse = changeRequestFormRepo.fetchFormData();
            if (formResponse != null || formResponse.size() > 0) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(formResponse).build();
            } else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> getChangeRequestForm3() {
        try {
            List<ChangeFormDataList> formResponse = changeRequestFormRepo.fetchFormDataList();
            if (formResponse != null || formResponse.size() > 0) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(formResponse).build();
            } else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


}
