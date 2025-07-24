package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.TypeOfChange;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisplayChangeOfTypeRepo {

    private  final JdbcTemplate jdbcTemplate;


    public DisplayChangeOfTypeRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TypeOfChange> getAllChange() {
        String sql = "select description from type_of_change_display";
        return  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(TypeOfChange.class));
    }

}
