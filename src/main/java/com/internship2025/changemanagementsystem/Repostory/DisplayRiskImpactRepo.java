package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.DisplayRiskImpact;
import lombok.Data;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisplayRiskImpactRepo {
   private  final JdbcTemplate jdbcTemplate;

    public DisplayRiskImpactRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DisplayRiskImpact> findAll(){
        String sql = "select display from risk_impact_display";
        return  jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(DisplayRiskImpact.class));
    }

}
