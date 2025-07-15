package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.LoginUser;
import com.internship2025.changemanagementsystem.Modal.UsersModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepo {

    private final JdbcTemplate  jdbcTemplate;

    public UsersRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean save(UsersModel user) {

        String sql = "insert into  users(full_name, email, password, confirm_password, role,phone) values (?,?,?,?,?,?)";

       return jdbcTemplate.update(sql, user.getFullName(), user.getEmail(), user.getPassword(),
                user.getConfirmPassword(), user.getRole(),user.getPhone())  > 0;

    }

    public UsersModel getAllUsers(String email) {
        String sql = "select * from users where email = ?";

        return  jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(UsersModel.class),email);

    }
    public List<LoginUser> login (String email,String password) {
        String sql = "select * from users  where email = ? and password = ?";
       List<LoginUser> cred = jdbcTemplate.query(sql,
                new  BeanPropertyRowMapper<>(LoginUser.class),email,password);
       if(!cred.isEmpty()){
           return cred;
       }else
           return null;
    }

    public List<UsersModel> findAllUsers() {
        String  sql = "select * from users";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(UsersModel.class));
    }

    public UsersModel findUserByEmail(String email) {
        String sql = "select * from users where email = ?";
        List<UsersModel> resp = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UsersModel.class),
                email);

        if(!resp.isEmpty())
            return resp.get(0);
        else
            return null;
    }

}
