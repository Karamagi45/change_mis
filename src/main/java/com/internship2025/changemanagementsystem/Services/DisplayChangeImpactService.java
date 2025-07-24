package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.DisplayChangeImpact;
import com.internship2025.changemanagementsystem.Repostory.DisplayChangeImpactRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DisplayChangeImpactService implements Constant {

    private final DisplayChangeImpactRepo displayChangeImpactRepo;

    public DisplayChangeImpactService(DisplayChangeImpactRepo displayChangeImpactRepo) {
        this.displayChangeImpactRepo = displayChangeImpactRepo;
    }

    public ApiResponse<?> getDisplayChangeImpact() {
        try {
            List<DisplayChangeImpact> response = displayChangeImpactRepo.getAllType();
            if (response == null) {
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            }else
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(response).build();

        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

}
