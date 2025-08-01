package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.ApprovalStages;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApprovalStagesRepo {

    private  final JdbcTemplate jdbcTemplate;

    public ApprovalStagesRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createApprovalStage(ApprovalStages approvalStages){
        String sql = """
                insert into approval_stages (
                stage_code,description)  values (?,?)
                """;
        return jdbcTemplate.update(sql,approvalStages.getStageCode(),
                approvalStages.getDescription())>0;
    }

    public boolean updateApprovalStage(ApprovalStages approvalStages){
        String sql = """
                update approval_stages set stage_code=?,description=? where stage_id=?
        """;
        return jdbcTemplate.update(sql,approvalStages.getStageCode(),
                approvalStages.getDescription(),approvalStages.getStageId())>0;
    }

    public boolean deleteApprovalStage(ApprovalStages approvalStages){
        String sql = """
                delete from approval_stages where stage_id=?
        """;
        return jdbcTemplate.update(sql,approvalStages.getStageId())>0;
    }

    public List<ApprovalStages> getAllApprovalStages(){
        String sql = "select * from approval_stages";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(ApprovalStages.class));
    }

}
