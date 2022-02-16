package com.epam.esm.service;

import com.epam.esm.dao.TagDAO;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.TagAlreadyExistException;
import com.epam.esm.exception.TagNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TagService {

    private final TagDAO tagDao;

    @Autowired
    public TagService(TagDAO tagDao) {
        this.tagDao = tagDao;
    }

    public void save(Tag tag) {
        if(tagDao.getTag(tag.getName()) == null) {
            tagDao.save(tag);
        }
        else
            throw new TagAlreadyExistException("Tag with name " + tag.getName() + " already exist");
    }

    public Tag get(String name){
        return tagDao.getTag(name);
    }

    public Tag get(int id){
        return tagDao.getTag(id);
    }

    public List<Tag> getAll() {
        return tagDao.getTags();
    }

    public void delete(int id){
        if(!tagDao.delete(id))
            throw new TagNotFoundException("Tag with id = " + id + " not found");
    }

    public void delete(String name){
        if(!tagDao.delete(name))
            throw new TagNotFoundException("Tag with name = " + name + " not found");
    }
}
