package com.epam.esm.dao;

import com.epam.esm.entity.Tag;
import com.epam.esm.exception.TagNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
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
        String INSERT_MESSAGE_SQL = "INSERT INTO tag(name) VALUES(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(INSERT_MESSAGE_SQL);
            ps.setString(1, tag.getName());
            return ps;
        }, keyHolder);
    }

    public Tag getTag(String name){
        return jdbcTemplate.query("SELECT * FROM tag WHERE name = ?",new Object[]{name}, new TagMapper()).stream()
                .findAny().orElse(null);
                        //orElseThrow(() -> new TagNotFoundException("Tag with name " + name + " is not found"));
    }

    public Tag getTag(int id){
        return jdbcTemplate.query("SELECT * FROM tag WHERE id = ?",new Object[]{id}, new TagMapper()).stream()
                .findAny().orElseThrow(() -> new TagNotFoundException("Tag with id " + id + " is not found"));

    }

    public boolean delete(int id){
        return jdbcTemplate.update("DELETE FROM tag WHERE id = ?", id) != 0;

    }

    public boolean delete(String name){
        return jdbcTemplate.update("DELETE FROM tag WHERE name = ?", name) != 0;
    }
}
