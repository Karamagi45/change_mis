package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.DisplayChangePriority;
import com.internship2025.changemanagementsystem.Repostory.DisplayChangePriorityRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class DisplayChangePriorityService implements Constant {

    private final DisplayChangePriorityRepo displayChangePriorityRepo;

    public DisplayChangePriorityService(DisplayChangePriorityRepo displayChangePriorityRepo) {
        this.displayChangePriorityRepo = displayChangePriorityRepo;
    }

    public ApiResponse<?> getDisplayChangePriority() {
        try {
            List<DisplayChangePriority> response = displayChangePriorityRepo.getAllType();
            if (response == null) {
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            } else
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(response).build();

        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

}
