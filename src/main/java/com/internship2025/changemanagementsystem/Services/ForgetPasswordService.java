package com.internship2025.changemanagementsystem.Services;


import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.OtpModel;
import com.internship2025.changemanagementsystem.Modal.UsersModel;
import com.internship2025.changemanagementsystem.Repostory.ForgetPasswordRepo;
import com.internship2025.changemanagementsystem.Repostory.UsersRepo;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Slf4j
@Service
public class ForgetPasswordService implements Constant {

    private final ForgetPasswordRepo forgetPasswordRepo;
    private final UsersRepo usersRepo;

    public ForgetPasswordService(ForgetPasswordRepo forgetPasswordRepo, UsersRepo usersRepo) {
        this.forgetPasswordRepo = forgetPasswordRepo;
        this.usersRepo = usersRepo;
    }


    public ApiResponse<?> validateOtpByEmail(OtpModel otpModel) {
        try {
            List<OtpModel> otpResponse = forgetPasswordRepo
                    .selectOtpByEmail(otpModel.getOtpCode(), otpModel.getEmail());
            if (otpResponse == null || otpResponse.isEmpty()) {
                return ApiResponse.builder().code(FAILED_CODE)
                        .message("otp is not valid").build();
            } else {
                if (otpResponse.get(0).getStatus().equals("Expired")) {
                    return ApiResponse.builder().code(FAILED_CODE).message("otp is expired").build();
                } else {
                    boolean expired = forgetPasswordRepo.expiredOtpByStatus(otpModel);
                    if(expired){
                        return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
                    } else
                        return ApiResponse.builder().code(FAILED_CODE).message("Failed to update OTP Status").build();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE + e.getMessage()).build();
        }

    }

//    public String otpExist(OtpModel otpModel) {
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        ;
//        if (currentDateTime.plusMinutes(5).isBefore(now)) {
//
//            otpModel.setStatus("Expired");
//            //  return "Expired";
//        } else {
//            otpModel.setStatus("Pending");
//            //return "Pending";
//        }
//        forgetPasswordRepo.updateOtpBystatus(otpModel);
//        return "Success";
//    }


    public ApiResponse<?> forgetPassword(String email) {
        try {

            if (email == null || email.trim().isEmpty()) {
                return ApiResponse.builder().code(FAILED_CODE)
                        .message("email is incorrect").build();
            }

            UsersModel usersModel = usersRepo.findUserByEmail(email.trim());
            if (usersModel == null) {
                return ApiResponse.builder().code(FAILED_CODE)
                        .message("Email doesn't exist").build();
            } else {
                Integer generatedOTP = OTPNumber();

                OtpModel otpModel = new OtpModel();
                otpModel.setEmail(email);
                otpModel.setOtpCode(generatedOTP);
                otpModel.setStatus("Pending");
                otpModel.setCreatedDate(LocalDateTime.now());

                return saveOtpRecord(otpModel);
            }

        } catch (Exception e) {
            return ApiResponse.builder().code(EXCEPTION_CODE)
                    .message(e.getMessage()).build();
        }

    }

    public Integer OTPNumber() {
        return 100000 + (int) (Math.random() * 900000); // Generates a number between 100000 and 999999
    }

//    public void sendMail(String email, Integer otpCode) {
//        try {
//            System.out.println("Sending Email to {} "+ email);
//
//            String messageBody = "Hello, Your OTP Code is "+ otpCode;
//
//            MimeMessage message = mailSender.createMimeMessage();
//            message.setFrom(new InternetAddress(fromMail));
//            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(messageBody));
//            message.setSubject("OTP CODE");
//
//            MimeMultipart multipart = new MimeMultipart("related");
//            MimeBodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setContent(messageBody, "text/html; charset=UTF-8");
//            multipart.addBodyPart(messageBodyPart);
//
//            message.setContent(multipart);
//
//            mailSender.send(message);
//
//            System.out.println("Sent email to {} "+ email);
//
//        }
//
//        catch (Exception e) {
//            System.out.println("ERROR SEND MAILS : " + e);
//        }
//    }



//    public Integer OTPNumber(Integer otpnumber) {
//
//        for (int i = 0; i < 6; i++) {
//            otpnumber += (int) (Math.random() * 10);
//        }
//        return otpnumber;
//    }


    public ApiResponse<?> saveOtpRecord(OtpModel otpModel) {
        try {
            boolean results = forgetPasswordRepo.saveOtp(otpModel);
            if (results) {
                //  System.out.println("Am clear!!");
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            } else {
                //System.out.println("Am not fine!!");
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            }

        } catch (Exception e) {
            //System.out.println("something is wrong!!" + e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public String dateUsers() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    public Object generateOTP() {
//        String otp = "";
//        for (int i = 0; i < 6; i++) {
//            otp += (int) (Math.random() * 10);
//        }
        int otp = 100000 + (int) (Math.random() * 900000); // Ensures a 6-digit number
        System.out.println("otp generated: " + otp);
        return otp;
    }

}
