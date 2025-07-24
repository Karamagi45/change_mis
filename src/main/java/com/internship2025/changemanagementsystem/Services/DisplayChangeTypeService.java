package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.DisplayChangeType;
import com.internship2025.changemanagementsystem.Repostory.DisplayChangeTypeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class DisplayChangeTypeService implements Constant {

    private final DisplayChangeTypeRepo displayChangeTypeRepo;

    public DisplayChangeTypeService(DisplayChangeTypeRepo displayChangeTypeRepo) {
        this.displayChangeTypeRepo = displayChangeTypeRepo;
    }

    public ApiResponse<?> getDisplayChangeType() {
        try {
            List<DisplayChangeType> response = displayChangeTypeRepo.getAllType();
            if (response != null) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(response).build();
            } else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();

        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }
}
