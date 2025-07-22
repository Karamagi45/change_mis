package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.Change_approval_rejection;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChangeApprovalRepo {

    private  final JdbcTemplate jdbcTemplate;

    public ChangeApprovalRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    public boolean createChangeApproval(Change_approval_rejection rejection) {
        String changeSql = "insert into change_approval_rejection(change_request_status, comments, change_control_committee, lead_software_engineer, project_manager, lead_infrastructure_database, head_consult_support_department) values (?,?,?,?,?,?,?)";

        return  jdbcTemplate.update(changeSql,rejection.getChangeRequestStatus(),rejection.getComments(),rejection.getChangeControlCommittee(),
                rejection.getLeadSoftwareEngineer(),rejection.getProjectManager(),rejection.getLeadInfrastructureDatabase(),
                rejection.getHeadConsultSupportDepartment()) > 0;

    }


    public List<Change_approval_rejection> getChangeApprovalRejections() {
        String sql = "select * from change_approval_rejection";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Change_approval_rejection.class));
    }



}
