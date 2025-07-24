package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.ChangeDetail;
import com.internship2025.changemanagementsystem.Modal.ChangeImpactEvaluation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ChangeImpactEvaluationRepo {

    private final JdbcTemplate jdbcTemplate;

    public ChangeImpactEvaluationRepo(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createChangeEvaluation(ChangeImpactEvaluation evaluation) {
        String changeSql = "insert into change_impact_evaluation( change_priority, " +
                "change_impact, summary_result, conducted_by, impacted,change_type) values (?,?,?,?,?,?)";

        return jdbcTemplate.execute((Connection conn) -> {
            try (PreparedStatement ps = conn.prepareStatement(changeSql)) {
                ps.setString(1, evaluation.getChangePriority());
                ps.setString(2, evaluation.getChangeImpact());
                ps.setString(3, evaluation.getSummaryResult());
                ps.setString(4, evaluation.getConductedBy());
                ps.setString(5, evaluation.getImpacted());

                Array typeArray = conn.createArrayOf("text", evaluation.getChangeType().toArray());
                ps.setArray(6, typeArray);

                return ps.executeUpdate() > 0;
            }
        });

    }


    public List<?> getAllChangeEvaluation() {
        String sql = "select change_priority, change_impact, summary_result, " +
                "conducted_by, impacted,impacted_change_id,change_type from change_impact_evaluation";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ChangeImpactEvaluation dto = new ChangeImpactEvaluation();

            dto.setChangePriority(rs.getString("change_priority"));
            dto.setChangeImpact(rs.getString("change_impact"));
            dto.setSummaryResult(rs.getString("summary_result"));
            dto.setConductedBy(rs.getString("conducted_by"));
            dto.setImpacted(rs.getString("impacted"));
            dto.setImpactedChangeId(rs.getInt("impacted_change_id"));


            Array array = rs.getArray("change_type");
            if (array == null) {
                System.out.println("change_type is NULL for row " + rs.getLong("impacted_change_id"));
                dto.setChangeType(Collections.emptyList());
            } else {
               String[] typeArray = (String[]) array.getArray();
               dto.setChangeType(Arrays.asList(typeArray));
           }

            return dto;
        });
    }

}
