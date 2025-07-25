package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.ProfileModal;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileRepo {

    private final JdbcTemplate jdbcTemplate;

    public ProfileRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProfileModal > profileByEmail(String email, String password) {
        String query = "select * from users where email = ? and password = ?";
        List<ProfileModal > cred = jdbcTemplate.query(query,
                new BeanPropertyRowMapper<>(ProfileModal.class),email,password);
        if(!cred.isEmpty()){
            return cred;
        }else
            return null;
    }

    public List<ProfileModal > fetchProfileByEmail(String email) {
        String query = "select full_name, role ,email, password from users where email = ?";

        List<ProfileModal > cred =jdbcTemplate.query(query,
                new BeanPropertyRowMapper<>(ProfileModal.class), email);
        if(!cred.isEmpty()){
            return cred;
        }else
            return null;
    }


}
