package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.Risk_assessment;
import com.internship2025.changemanagementsystem.Repostory.RiskAssessmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAssessmentService implements Constant {

    private final RiskAssessmentRepo riskAssessmentRepo;

    public RiskAssessmentService(RiskAssessmentRepo riskAssessmentRepo) {
        this.riskAssessmentRepo = riskAssessmentRepo;
    }

    public ApiResponse<?> saveRisks(Risk_assessment assessments) {
        try {
            boolean results = riskAssessmentRepo.saveRisks(assessments);
            if (results) {

                return  ApiResponse.builder().message(SUCCESS_MESSAGE).build();
            }else  {

                return ApiResponse.builder().message(FAILED_MESSAGE).build();
            }

        }catch (Exception e){

            return ApiResponse.builder().message(EXCEPTION_MESSAGE).build();
        }
    }




    public ApiResponse<?> findAllRiskAssessment(){
        try {

          List<Risk_assessment> riskAssessment = riskAssessmentRepo.findAll();

          if(!riskAssessment.isEmpty()){

              return ApiResponse.builder().message(SUCCESS_MESSAGE)
                      .data(riskAssessment).build();
          }else return ApiResponse.builder().message(NO_DATA_FOUND_MESSAGE).build();


        }catch(Exception e){
            System.out.println(e.getMessage());
            return  ApiResponse.builder().message(EXCEPTION_MESSAGE).build();
        }
    }

}
