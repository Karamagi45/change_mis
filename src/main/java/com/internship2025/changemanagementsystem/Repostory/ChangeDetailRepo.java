package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.Change_detail;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChangeDetailRepo {

    private final  JdbcTemplate jdbcTemplate;

    public ChangeDetailRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean createChangeDetail(Change_detail change_detail) {
        String changeSql = "insert into change_detail(source_of_change, type_of_change, request_by, client_name, cost_implementation, change_description_objection) values (?,?,?,?,?,?)";

        return jdbcTemplate.update(changeSql,change_detail.getSource_of_change(),change_detail.getType_of_change(),change_detail.getRequest_by(),
                change_detail.getClient_name(),change_detail.getCost_implementation(),change_detail.getChange_description_objection()) > 0;

    }

    public List<?> findAllChangeDetail() {
        String sql = "select * from change_detail";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Change_detail.class));
    }

}
