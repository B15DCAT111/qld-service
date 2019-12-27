package com.qld.mobi.ntt.buss;

import com.qld.mobi.ntt.bo.StudentBO;
import com.qld.mobi.ntt.dao.StudentDAO;
import com.qld.mobi.ntt.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentBussImpl implements StudentBuss {
    private final StudentDAO studentDAO;

    public StudentBussImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void save(StudentBO obj) {
        studentDAO.save(obj);
    }

    @Override
    public void update(StudentBO obj) {
        studentDAO.upadte(obj);
    }

    @Override
    public void saveOrUpdate(StudentBO obj) {
        studentDAO.saveOrUpdate(obj);
    }

    @Override
    public void remove(StudentBO obj) {
        studentDAO.remove(obj);
    }

    @Override
    public List doSearch(StudentDTO obj) {
        return studentDAO.doSearch(obj);
    }
}
