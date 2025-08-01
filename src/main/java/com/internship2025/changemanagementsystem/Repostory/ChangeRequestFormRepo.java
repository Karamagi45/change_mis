package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.ChangeFormData;
import com.internship2025.changemanagementsystem.Modal.ChangeFormData2;
import com.internship2025.changemanagementsystem.Modal.ChangeFormDataList;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ChangeRequestFormRepo {

    private final JdbcTemplate jdbcTemplate;

    public ChangeRequestFormRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int showLastKeyNumber() {
        String sql = """
                select 
                     change_request_id
                from change_detail
                                order by  change_request_id DESC 
                                LIMIT 1""";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<ChangeFormData> fetchFormData() {
        int lastKeyNumber = showLastKeyNumber();
        String sql = """
                    SELECT 
                        cd.source_of_change,
                        cd.type_of_change,
                        cd.request_by,
                        cd.cost_implementation,
                        cd.change_description_objection,
                        ra.risk_type,
                        ra.risk_impact,
                        cie.change_type,
                        cie.change_priority,
                        cie.change_impact,
                        cie.summary_result,
                        cie.conducted_by,
                        cie.impacted,
                        cie.change_request_id
                    FROM change_detail cd
                    JOIN risk_assessment ra ON cd.change_request_id = ra.change_request_id
                    JOIN change_impact_evaluation cie ON cd.change_request_id = cie.change_request_id
                    where  cd.change_request_id = ?
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ChangeFormData.class), lastKeyNumber);
    }


    public List<ChangeFormData2> fetchFormData2() {
        int lastKeyNumber = showLastKeyNumber();
        String sql = """
                SELECT
                    cd.source_of_change,
                    cd.type_of_change,
                    cd.request_by,
                    cd.cost_implementation,
                    cd.change_description_objection,
                    car.change_request_status,
                    car.comments,
                    car.change_control_committee,
                    car.lead_software_engineer,
                    car.project_manager,
                    car.lead_infrastructure_database,
                    car.head_consult_support_department,
                    ci.change_implemented,
                    ci.date_time_implementation,
                    ci.comments,
                    ci.implemented_by,
                    ci.signature,
                    ci.change_request_id
                 FROM change_detail AS cd 
                join  change_approval_rejection AS car 
                    ON cd.change_request_id = car.change_request_id
                join change_implementation AS ci 
                    on cd.change_request_id = ci.change_request_id
                  where  cd.change_request_id = ?
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ChangeFormData2.class), lastKeyNumber);
    }


    public List<ChangeFormDataList> fetchFormDataList() {
        int lastKeyNumber = showLastKeyNumber();
        String sql = """
                        SELECT
                            cd.source_of_change,
                            cd.type_of_change,
                            cd.request_by,
                            cd.cost_implementation,
                            cd.change_description_objection,
                             ra.risk_type,
                             ra.risk_impact,
                            cie.change_type,
                             cie.change_priority,
                            cie.change_impact,
                            cie.summary_result,
                             cie.conducted_by,
                            cie.impacted,
                             cie.change_request_id,
                            car.change_request_status,
                            car.comments,
                            car.change_control_committee,
                            car.lead_software_engineer,
                            car.project_manager,
                            car.lead_infrastructure_database,
                            car.head_consult_support_department,
                            ci.change_implemented,
                            ci.date_time_implementation,
                            ci.comments,
                            ci.implemented_by,
                            ci.signature,
                            ci.change_request_id
                         FROM change_detail AS cd 
                             JOIN risk_assessment AS ra ON cd.change_request_id = ra.change_request_id
                            JOIN change_impact_evaluation AS cie ON cd.change_request_id = cie.change_request_id
                        join  change_approval_rejection AS car 
                            ON cd.change_request_id = car.change_request_id
                        join change_implementation AS ci 
                            on cd.change_request_id = ci.change_request_id
                          where  cd.change_request_id = ?
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ChangeFormDataList.class), lastKeyNumber);
    }


}
