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
                insert into roles_table(role_name,roles_status) values(?,?)
                """;
        return jdbcTemplate.update(sql, usersRolesDto.getRoleName(),
                usersRolesDto.getRolesStatus()) > 0;
    }

    public boolean updateUserRoles(UsersRolesDto usersRolesDto) {
        String sql = """
                        update roles_table set role_name=?,roles_status=? where roles_id=?
                """;
        return jdbcTemplate.update(sql, usersRolesDto.getRoleName(),
                usersRolesDto.getRolesStatus(), usersRolesDto.getRolesId()) > 0;
    }

    public boolean deleteUserRoles(UsersRolesDto usersRolesDto) {
        String sql = """
                        delete from roles_table where roles_id=?
                """;
        return jdbcTemplate.update(sql, usersRolesDto.getRolesId()) > 0;
    }


    public List<UsersRolesDto> getAllUserRoles() {
        String sql = """ 
                select  * from roles_table;
                """;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UsersRolesDto.class));
    }

}
