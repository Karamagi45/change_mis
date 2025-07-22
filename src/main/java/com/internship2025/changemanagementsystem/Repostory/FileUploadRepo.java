package com.internship2025.changemanagementsystem.Repostory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FileUploadRepo {

    private final JdbcTemplate jdbcTemplate;

    public FileUploadRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean uploadBytes(String name, String type, byte[] data) {
        String sql="insert into file_upload (name,type,data) values (?,?,?)";
        return jdbcTemplate.update(sql,name,type,data) > 0;
    }

}
