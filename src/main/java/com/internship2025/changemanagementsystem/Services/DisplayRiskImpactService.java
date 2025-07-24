package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.DisplayRiskImpact;
import com.internship2025.changemanagementsystem.Repostory.DisplayRiskImpactRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DisplayRiskImpactService implements Constant {
    private final DisplayRiskImpactRepo displayRiskImpactRepo;

    public DisplayRiskImpactService(DisplayRiskImpactRepo displayRiskImpactRepo) {
        this.displayRiskImpactRepo = displayRiskImpactRepo;
    }

    public ApiResponse<?> getDisplayRiskImpact(){
        try {
            List<DisplayRiskImpact>  displayRiskImpacts = displayRiskImpactRepo.findAll();
            if(!displayRiskImpacts.isEmpty()){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(displayRiskImpacts).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }
}
