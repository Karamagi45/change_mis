package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.Change_impact_evaluation;
import com.internship2025.changemanagementsystem.Repostory.ChangeDetailRepo;
import com.internship2025.changemanagementsystem.Repostory.ChangeEvaluationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeEvaluationService  implements Constant {

    private  final ChangeEvaluationRepo  evaluationRepo;

    public ChangeEvaluationService(ChangeEvaluationRepo evaluationRepo) {
        this.evaluationRepo = evaluationRepo;

    }

    public ApiResponse<?> addChangeEvaluation(Change_impact_evaluation  evaluation){
        try {
            boolean evaluateResponse = evaluationRepo.createChangeEvaluation(evaluation);
            if(evaluateResponse){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else
                return  ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();

        }catch (Exception e){
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> fetchChangeEvaluation(){
        try {
            List<?> fetchResponse = evaluationRepo.getAllChangeEvaluation();
            if(fetchResponse != null && fetchResponse.size() > 0){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(fetchResponse).build();
            }else
                return  ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }


}
