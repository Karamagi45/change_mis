package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.Change_detail;
import com.internship2025.changemanagementsystem.Modal.Change_impact_evaluation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChangeEvaluationRepo {

    private final JdbcTemplate jdbcTemplate;

    public ChangeEvaluationRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public boolean createChangeEvaluation(Change_impact_evaluation evaluation) {
        String changeSql = "insert into change_impact_evaluation(change_type, change_priority, change_impact, summary_result, conducted_by, impacted) values (?,?,?,?,?,?)";

        return jdbcTemplate.update(changeSql,evaluation.getChangeType(),evaluation.getChangePriority(),evaluation.getChangeImpact(),
                evaluation.getSummaryResult(),evaluation.getConductedBy(),evaluation.getImpacted()) > 0;
    }

    public List<?> getAllChangeEvaluation() {
        String sql = "select * from change_impact_evaluation";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Change_impact_evaluation.class));
    }

}



