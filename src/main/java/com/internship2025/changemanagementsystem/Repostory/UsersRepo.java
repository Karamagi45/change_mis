package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.LoginUser;
import com.internship2025.changemanagementsystem.Modal.UsersModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepo {

    private final JdbcTemplate jdbcTemplate;

    public UsersRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean save(UsersModel user) {

        String sql = """
                 insert into  
                 users(full_name, 
                 email, password, 
                phone, roles_id) values (?,?,?,?,?)""";

        return jdbcTemplate.update(sql, user.getFullName(), user.getEmail(), user.getPassword(),
                user.getPhone(), user.getRolesId()) > 0;

    }


    public boolean updateUser(UsersModel user) {
        String sql = """
                Update users set full_name = ?,
                 email = ?, password = ? , phone = ?, 
                 roles_id = ? where users_id = ?
                """;
        return jdbcTemplate.update(sql, user.getFullName(),
                user.getEmail(), user.getPassword(),
                user.getPhone(), user.getRolesId(),
                user.getUsersId()) > 0;
    }


    public List<LoginUser> login(String email, String password) {
        String sql = "select * from users  where email = ? and password = ?";
        List<LoginUser> cred = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(LoginUser.class), email, password);
        if (!cred.isEmpty()) {
            return cred;
        } else
            return null;
    }

    public List<UsersModel> findAllUsers() {
        String sql = """
                select uu.full_name,uu.email,uu.phone,uu.users_id,
                       rt.role_name,uu.roles_id
                from users uu
                         join roles rt
                              on uu.roles_id = rt.roles_id;
                """;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UsersModel.class));
    }

    public List<?> searchUser(UsersModel user) {
        String sql = "select * from users where  lower(full_name)   like (?) ";
        String searchCard = "%" + user.getFullName() + "%";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UsersModel.class), searchCard);
    }

    public UsersModel findUserByEmail(String email) {
        String sql = "select * from users where email = ?";
        List<UsersModel> resp = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UsersModel.class),
                email);

        if (!resp.isEmpty())
            return resp.get(0);
        else
            return null;
    }


}
