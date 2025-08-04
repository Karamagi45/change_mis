package com.internship2025.changemanagementsystem.Repostory;

import com.internship2025.changemanagementsystem.Modal.UsersRolesDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRolesRepo {

    private final JdbcTemplate jdbcTemplate;

    public UserRolesRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean createUserRoles(UsersRolesDto usersRolesDto) {
        String sql = """
                insert into roles(role_name) values(?)
                """;
        return jdbcTemplate.update(sql, usersRolesDto.getRoleName()) > 0;
    }


    public boolean deleteUserRoles(UsersRolesDto usersRolesDto) {
        String sql = """
                        delete from roles_table where roles_id=?
                """;
        return jdbcTemplate.update(sql, usersRolesDto.getRolesId()) > 0;
    }

    public  UsersRolesDto findUserRolesById(Integer rolesId) {
        String sql = """
                        select * from roles where roles_id=?
        """;
        return  jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(UsersRolesDto.class),
                rolesId).stream().findFirst().orElse(null);
    }

    public List<UsersRolesDto> getAllUserRoles() {
        String sql = """ 
                select  * from roles;
                """;
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(UsersRolesDto.class));
    }

}
