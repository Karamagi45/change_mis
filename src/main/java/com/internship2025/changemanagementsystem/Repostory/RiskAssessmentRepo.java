package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.Risk_assessment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RiskAssessmentRepo {

    private  final  JdbcTemplate jdbcTemplate;

    public RiskAssessmentRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean saveRisks(Risk_assessment assessments) {

        String sql = "insert into  risk_assessment( identified_risk, risk_occurance,impact_occur) values (?,?,?)";

        return jdbcTemplate.update(sql, assessments.getIdentifiedRisk(), assessments.getRiskOccur(),
                assessments.getImpactOccur()) > 0;

    }

    public List<Risk_assessment> findAll() {
        String sql = "select * from risk_assessment";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Risk_assessment.class));
    }


}
