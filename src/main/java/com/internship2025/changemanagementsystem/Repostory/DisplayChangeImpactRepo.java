package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.DisplayChangeImpact;
import com.internship2025.changemanagementsystem.Modal.TypeOfChange;
import lombok.Data;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisplayChangeImpactRepo {
    private final JdbcTemplate jdbcTemplate;

    public DisplayChangeImpactRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getAllType() {
        String sql = "select display from change_impact_display";
        return  jdbcTemplate.queryForList(sql, String.class);
    }


}
