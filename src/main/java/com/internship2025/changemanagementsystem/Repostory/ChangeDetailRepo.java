package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.ChangeDetail;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChangeDetailRepo {

    private final JdbcTemplate jdbcTemplate;

    public ChangeDetailRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean createChangeDetail(ChangeDetail change_detail) {
        String changeSql = "insert into change_detail(source_of_change, type_of_change, request_by, client_name, cost_implementation, change_description_objection) values (?,?,?,?,?,?)";

        return jdbcTemplate.update(changeSql, change_detail.getSourceOfChange(), change_detail.getTypeOfChange(), change_detail.getRequestBy(),
                change_detail.getClientName(), change_detail.getCostImplementation(), change_detail.getChangeDescriptionObjection()) > 0;

    }

    public boolean updateChangeDetail(ChangeDetail detail) {
        String sql = "UPDATE change_detail SET source_of_change = ?, type_of_change = ?, request_by = ?, client_name = ?, " +
                "cost_implementation = ?, change_description_objection = ? WHERE change_request_id = ?";

        return jdbcTemplate.update(sql,
                detail.getSourceOfChange(),
                detail.getTypeOfChange(),
                detail.getRequestBy(),
                detail.getClientName(),
                detail.getCostImplementation(),
                detail.getChangeDescriptionObjection(),
                detail.getChangeRequestId()) > 0;
    }

    public List<?> findAllChangeDetail() {
        String sql = "select * from change_detail";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ChangeDetail.class));
    }

}
