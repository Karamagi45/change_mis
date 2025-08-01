package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.ApprovalProcess;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApprovalProcessRepo {

    private final JdbcTemplate jdbcTemplate;

    public ApprovalProcessRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createApprovalProcess(ApprovalProcess approvalProcess) {
        String sql = """
                insert into approval_process(description,
                created_by, created_date, process_status)
                values(?,?,?,?)
                """;
        return jdbcTemplate.update(sql,approvalProcess.getDescription(),
                approvalProcess.getCreated_by(),
                approvalProcess.getCreated_date(),
                approvalProcess.getProcess_status())>0;
    }

    public boolean updateApprovalProcess(ApprovalProcess approvalProcess) {
        String sql = """
                update approval_process set
                description=?,
                created_by=?,
                created_date=?,
                process_status=? where process_id=?
        """;
        return jdbcTemplate.update(sql,approvalProcess.getDescription(),
                approvalProcess.getCreated_by(),approvalProcess.getCreated_date(),
                approvalProcess.getProcess_status())>0;
    }

    public boolean deleteApprovalProcess(ApprovalProcess approvalProcess) {
        String sql = """
                delete from approval_process where process_id=?
        """;
        return jdbcTemplate.update(sql,approvalProcess.getProcessId())>0;
    }

    public List<ApprovalProcess> findAllApprovalProcess(){
        String sql = "select * from approval_process";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(ApprovalProcess.class));
    }


}
