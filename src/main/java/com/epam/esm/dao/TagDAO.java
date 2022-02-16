package com.epam.esm.dao;

import com.epam.esm.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TagDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //get all Tags
    public List<Tag> getTags(){
        return jdbcTemplate.query("SELECT * FROM tag",new TagMapper());
    }

    public void save(Tag tag){
        jdbcTemplate.update("INSERT INTO tag VALUES(1,?)",tag.getName());
    }
}
