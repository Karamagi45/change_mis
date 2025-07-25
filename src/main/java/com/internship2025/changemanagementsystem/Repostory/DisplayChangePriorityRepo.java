package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.DisplayChangePriority;
import com.internship2025.changemanagementsystem.Modal.TypeOfChange;
import lombok.Data;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisplayChangePriorityRepo {
    private final JdbcTemplate jdbcTemplate;

    public DisplayChangePriorityRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getAllType() {
        String sql = "select display from change_priority_display";
        return  jdbcTemplate.queryForList(sql, String.class);
    }
}
