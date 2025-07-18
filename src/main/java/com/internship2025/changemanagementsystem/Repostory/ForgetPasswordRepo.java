package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.OtpModel;
import com.internship2025.changemanagementsystem.Modal.UsersModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ForgetPasswordRepo {

    private final JdbcTemplate jdbcTemplate;

    public ForgetPasswordRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean saveOtp(OtpModel otpModel) {

        String sql = "insert into otp (otp_code ,email,status,create_date) values (?,?,?,?)";
        return jdbcTemplate.update(sql, otpModel.getOtpCode(), otpModel.getEmail(),
                otpModel.getStatus(), otpModel.getCreatedDate()) > 0;
    }


    public List<OtpModel> selectOtpByEmail(Integer otpCode, String email) {
        String sql = "select * from otp where  otp_code = ? AND email = ?";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(OtpModel.class), otpCode, email);

    }

    public boolean updateOtpStatus(OtpModel otpModel) {
        String sql = "update otp set status = ? where  otp_code =? and  email=? and status= ?";
        return jdbcTemplate.update(sql, "Expired", otpModel.getOtpCode(),otpModel.getEmail(), "Pending") > 0;

    }


    public boolean updatePassword(UsersModel  usersModel) {
        String sql = "update users set password = ? where email = ?";
        return  jdbcTemplate.update(sql,usersModel.getPassword(),usersModel.getEmail()) > 0;
    }



    public List<OtpModel> searchUser() {

        return null;
    }

}
