package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.DisplayChangeType;
import com.internship2025.changemanagementsystem.Modal.TypeOfChange;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisplayChangeTypeRepo {

    private final JdbcTemplate jdbcTemplate;

    public DisplayChangeTypeRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<String> getAllType() {
        String sql = "select display from change_type_display";
        return jdbcTemplate.queryForList(sql, String.class);
    }


}
