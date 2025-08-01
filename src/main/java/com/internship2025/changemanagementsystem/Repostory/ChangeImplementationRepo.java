package com.internship2025.changemanagementsystem.Repostory;


import com.internship2025.changemanagementsystem.Modal.ChangeImplementation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChangeImplementationRepo {

    private final JdbcTemplate jdbcTemplate;

    public ChangeImplementationRepo(JdbcTemplate jdbcTemplate) {
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

    public boolean createChangeImpl(ChangeImplementation implementation) {
        String sql = """
                insert into 
                         change_implementation(
                         change_implemented, 
                date_time_implementation,
                comments, 
                implemented_by, 
                signature,
                change_request_id )
                         values (?,?,?,?,?,?)""";

        return jdbcTemplate.update(sql,
                implementation.getChangeImplemented(),
                implementation.getDateTimeImplementation(),
                implementation.getComments(),
                implementation.getImplementedBy(),
                implementation.getSignature(),
                showLastKeyNumber()
        ) > 0;
    }

    public boolean updateChangeImpl(ChangeImplementation implementation) {
        String sql = "UPDATE change_implementation SET change_implemented = ?, date_time_implementation = ?, comments = ?," +
                " implemented_by = ?, signature = ? WHERE change_implementation_id = ?";

        return jdbcTemplate.update(
                sql,
                implementation.getChangeImplemented(),
                implementation.getDateTimeImplementation(),
                implementation.getComments(),
                implementation.getImplementedBy(),
                implementation.getSignature(),
                implementation.getChangeImplementationId()) > 0;
    }


    public List<?> fetchAllChangeImpl() {
        String sql = "select * from change_implementation";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ChangeImplementation.class));
    }

}
