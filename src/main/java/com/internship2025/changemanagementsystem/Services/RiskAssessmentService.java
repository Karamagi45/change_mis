package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.RiskAssessment;
import com.internship2025.changemanagementsystem.Repostory.RiskAssessmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RiskAssessmentService implements Constant {

    private final RiskAssessmentRepo riskAssessmentRepo;

    public RiskAssessmentService(RiskAssessmentRepo riskAssessmentRepo) {
        this.riskAssessmentRepo = riskAssessmentRepo;
    }

    public ApiResponse<?> saveRisks(RiskAssessment assessments) {
        try {
            boolean results = riskAssessmentRepo.saveRisks(assessments);
            if (results) {
                log.info("RiskAssessment save successful");
                return  ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else  {
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            }
        }catch (Exception e){
            log.info(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }

    }


    public ApiResponse<?> showLastKeyNumber(){
        try {
            int lastKeyNumber = riskAssessmentRepo.showLastKeyNumber();
            if(lastKeyNumber>0){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(lastKeyNumber).build();
            }else {
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }




    public ApiResponse<?> findAllRiskAssessment(){
        try {

          List<RiskAssessment> riskAssessment = riskAssessmentRepo.findAll();
          if(!riskAssessment.isEmpty()){
              return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                      .data(riskAssessment).build();
          }else
              return ApiResponse.builder().code(NO_DATA_FOUND_CODE).message(NO_DATA_FOUND_MESSAGE).build();

        }catch(Exception e){
            System.out.println(e.getMessage());
            return  ApiResponse.builder().message(EXCEPTION_MESSAGE).build();
        }
    }

}
