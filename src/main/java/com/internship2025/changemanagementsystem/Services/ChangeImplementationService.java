package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ChangeImplementation;
import com.internship2025.changemanagementsystem.Repostory.ChangeImplementationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class ChangeImplementationService implements Constant {

    private final ChangeImplementationRepo changeImplementationRepo;

    public ChangeImplementationService(ChangeImplementationRepo changeImplementationRepo) {
        this.changeImplementationRepo = changeImplementationRepo;
    }

    public ApiResponse<?> addChangeImpl(ChangeImplementation changeImpl) {
        try {
            changeImpl.setDateTimeImplementation(LocalDateTime.now());
            boolean changeResponse = changeImplementationRepo.createChangeImpl(changeImpl);
            if (changeResponse) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            } else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        } catch (Exception e) {
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> updateChangeImpl(ChangeImplementation changeImpl) {
        try {
            if (changeImpl.getChangeImplementationId() == null)
                return ApiResponse.builder().code(FAILED_CODE).message("Change Implementation Id  required").build();

            changeImpl.setDateTimeImplementation(LocalDateTime.now());
            boolean changeResponse = changeImplementationRepo.updateChangeImpl(changeImpl);
            if (changeResponse) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            } else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


    public ApiResponse<?> findChangeImpl() {
        try {
            List<?> findResponse = changeImplementationRepo.fetchAllChangeImpl();
            if (findResponse != null || findResponse.size() > 0) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(findResponse).build();
            } else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        } catch (Exception e) {
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


}
