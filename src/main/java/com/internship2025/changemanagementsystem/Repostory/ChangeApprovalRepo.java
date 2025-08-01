package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.ChangeApprovalRejection;
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

    public int showLastKeyNumber(){
        String sql = "select change_request_id from change_detail\n" +
                "order by  change_request_id DESC\n" +
                "LIMIT 1";
        return  jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public boolean createChangeApproval(ChangeApprovalRejection rejection) {
        String changeSql = """
        insert into
            change_approval_rejection(
                                      change_request_status,
                                      comments, change_control_committee, 
                                      lead_software_engineer, project_manager, 
                                      lead_infrastructure_database,
                                      head_consult_support_department,
                                      change_request_id)
        values (?,?,?,?,?,?,?,?)""";

        return  jdbcTemplate.update(changeSql,rejection.getChangeRequestStatus(),
                rejection.getComments(),rejection.getChangeControlCommittee(),
                rejection.getLeadSoftwareEngineer(),rejection.getProjectManager(),
                rejection.getLeadInfrastructureDatabase(),
                rejection.getHeadConsultSupportDepartment(),
                showLastKeyNumber()) > 0;

    }


    public List<ChangeApprovalRejection> getChangeApprovalRejections() {
        String sql = "select * from change_approval_rejection";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ChangeApprovalRejection.class));
    }



}
