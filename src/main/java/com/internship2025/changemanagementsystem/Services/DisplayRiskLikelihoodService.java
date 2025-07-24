package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.DisplayRiskImpact;
import com.internship2025.changemanagementsystem.Modal.DisplayRiskLikelihood;
import com.internship2025.changemanagementsystem.Repostory.DisplayRiskLikelihoodRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DisplayRiskLikelihoodService implements Constant {

    private final DisplayRiskLikelihoodRepo displayRiskLikelihoodRepo;


    public DisplayRiskLikelihoodService(DisplayRiskLikelihoodRepo displayRiskLikelihoodRepo) {
        this.displayRiskLikelihoodRepo = displayRiskLikelihoodRepo;
    }

    public ApiResponse<?> getDisplayRiskLikelihood() {
        try {
            List<DisplayRiskLikelihood> response = displayRiskLikelihoodRepo.findAllRiskLikelihood();
            if (response == null) {
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            } else
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(response).build();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

}
