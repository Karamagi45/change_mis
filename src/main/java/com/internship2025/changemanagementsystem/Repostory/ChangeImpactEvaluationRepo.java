package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.ChangeImpactEvaluation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChangeImpactEvaluationRepo {

    private final JdbcTemplate jdbcTemplate;

    public ChangeImpactEvaluationRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public boolean createChangeEvaluation(ChangeImpactEvaluation evaluation) {
        String changeSql = "insert into change_impact_evaluation(change_type, change_priority, change_impact, summary_result, conducted_by, impacted) values (?,?,?,?,?,?)";

        return jdbcTemplate.update(changeSql,evaluation.getChangeType(),evaluation.getChangePriority(),evaluation.getChangeImpact(),
                evaluation.getSummaryResult(),evaluation.getConductedBy(),evaluation.getImpacted()) > 0;
    }

    public List<?> getAllChangeEvaluation() {
        String sql = "select * from change_impact_evaluation";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ChangeImpactEvaluation.class));
    }

}



