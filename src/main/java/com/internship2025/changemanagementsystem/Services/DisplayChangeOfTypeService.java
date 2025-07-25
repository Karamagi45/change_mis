package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.TypeOfChange;
import com.internship2025.changemanagementsystem.Repostory.DisplayChangeOfTypeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DisplayChangeOfTypeService implements Constant {

    private final DisplayChangeOfTypeRepo displayChangeOfTypeRepo;

    public DisplayChangeOfTypeService(DisplayChangeOfTypeRepo displayChangeOfTypeRepo) {
        this.displayChangeOfTypeRepo = displayChangeOfTypeRepo;
    }


    public ApiResponse<?> getTypeOfChange() {
        try {
            List<String> typeOfChange = displayChangeOfTypeRepo.getAllChange();
            if(typeOfChange != null   || typeOfChange.size()>0){
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(typeOfChange).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

}
