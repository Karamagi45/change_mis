package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.ChangeDetail;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ChangeDetailRepo {

    private final JdbcTemplate jdbcTemplate;

    public ChangeDetailRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean createChangeDetail(ChangeDetail change_detail) {
        String changeSql = "insert into change_detail(source_of_change, request_by, client_name, " +
                "cost_implementation, change_description_objection,type_of_change) values (?,?,?,?,?,?)";

        return jdbcTemplate.execute((Connection conn) -> {
            try (PreparedStatement ps = conn.prepareStatement(changeSql)) {
                ps.setString(1, change_detail.getSourceOfChange());
                ps.setString(2, change_detail.getRequestBy());
                ps.setString(3, change_detail.getClientName());
                ps.setString(4, change_detail.getCostImplementation());
                ps.setString(5, change_detail.getChangeDescriptionObjection());

                // Convert Java array to PostgreSQL array
                Array typeArray = conn.createArrayOf("text", change_detail.getTypeOfChange().toArray());
                ps.setArray(6, typeArray);

                return ps.executeUpdate() > 0;
            }
        });

    }

    public List<ChangeDetail> findAllChangeDetail() {
        String sql = "SELECT source_of_change, request_by, client_name, " +
                "cost_implementation, change_description_objection," +
                " type_of_change, change_request_id FROM change_detail";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ChangeDetail dto = new ChangeDetail();
            dto.setSourceOfChange(rs.getString("source_of_change"));
            dto.setRequestBy(rs.getString("request_by"));
            dto.setClientName(rs.getString("client_name"));
            dto.setCostImplementation(rs.getString("cost_implementation"));
            dto.setChangeDescriptionObjection(rs.getString("change_description_objection"));
            dto.setChangeRequestId(rs.getInt("change_request_id"));

            Array array = rs.getArray("type_of_change");
            if (array == null) {
                System.out.println("type_of_change is NULL for row " + rs.getLong("change_request_id"));
                dto.setTypeOfChange(Collections.emptyList());
            } else {
                String[] typeArray = (String[]) array.getArray();
                dto.setTypeOfChange(Arrays.asList(typeArray));
            }

            return dto;
        });

    }

    public ChangeDetail findChangeDetailById(Integer changeRequestId) {
        String sql = """
                select *
                from change_detail where change_request_id = ?
                """;
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(ChangeDetail.class),
                changeRequestId).stream().findFirst().orElse(null);

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


}
