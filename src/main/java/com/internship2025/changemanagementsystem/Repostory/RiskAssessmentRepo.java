package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.RiskAssessment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RiskAssessmentRepo {

    private final JdbcTemplate jdbcTemplate;

    public RiskAssessmentRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean saveRisks(RiskAssessment assessments) {
        String sql = "insert into  risk_assessment( risk_type, risk_likelihood," +
                "risk_impact,change_request_id) values (?,?,?,?)";
        return jdbcTemplate.update(sql, assessments.getRiskType(), assessments.getRiskLikelihood(),
                assessments.getRiskImpact(),showLastKeyNumber()) > 0;

    }

    public int showLastKeyNumber(){
        String sql = "select change_request_id from change_detail\n" +
                "order by  change_request_id DESC\n" +
                "LIMIT 1";
        return  jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<RiskAssessment> findAll() {
        String sql = "select * from risk_assessment";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(RiskAssessment.class));
    }


}
