package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.DisplayRiskLikelihood;
import lombok.Data;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisplayRiskLikelihoodRepo {

    private final JdbcTemplate jdbcTemplate;

    public DisplayRiskLikelihoodRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> findAllRiskLikelihood() {
        String query = "select display from risk_likelihood_display";

        return jdbcTemplate.queryForList(query, String.class);
    }
}
