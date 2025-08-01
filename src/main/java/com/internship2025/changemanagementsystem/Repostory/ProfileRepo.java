package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.ChangePassword;
import com.internship2025.changemanagementsystem.Modal.ProfileModal;
import com.internship2025.changemanagementsystem.Modal.UsersModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class ProfileRepo {

    private final JdbcTemplate jdbcTemplate;

    public ProfileRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProfileModal> profileByEmail(String email, String password) {
        String query = "select * from users where email = ? and password = ?";
        List<ProfileModal> cred = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<>(ProfileModal.class), email, password);
        if (!cred.isEmpty()) {
            return cred;
        } else
            return null;
    }


    public List<ProfileModal> fetchProfileByEmail(String email) {
        String query = "select full_name, role ,email, password from users where email = ?";

        List<ProfileModal> cred = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<>(ProfileModal.class), email);
        if (!cred.isEmpty()) {
            return cred;
        } else
            return null;
    }


    public List<ChangePassword> checkOldPassword(String password) {
        String query = "select password from users where password = ?";
        return jdbcTemplate.query(query,
                new BeanPropertyRowMapper<>(ChangePassword.class), password);
    }

    public boolean changePassword(String newPassword, String oldPassword) {
        String query = "update users set password = ? where password = ?";
        return jdbcTemplate.update(query, newPassword, oldPassword) > 0;
    }


}
