package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.users;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class usersRepo {

    private final JdbcTemplate  jdbcTemplate;

    public usersRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean save(users user) {

        String sql = "insert into  users(full_name, email, password, confirm_password, role,phone) values (?,?,?,?,?,?)";

       return jdbcTemplate.update(sql, user.getFullName(), user.getEmail(), user.getPassword(),
                user.getConfirmPassword(), user.getRole(),user.getPhone())  > 0;

    }

    public List<users> login(users user){
        String sql = "select * from users  where password = ? and email = ?";
        return  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(users.class),
                user.getPassword(), user.getEmail());
    }

    public List<users> findAllUsers() {
        String  sql = "select * from users";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(users.class));
    }

}
