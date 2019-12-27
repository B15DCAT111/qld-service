package com.qld.mobi.ntt.buss;

import com.qld.mobi.ntt.bo.SubjectBO;
import com.qld.mobi.ntt.dao.SubjectDAO;
import com.qld.mobi.ntt.dto.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectBussImpl implements SubjectBuss {
    private final SubjectDAO subjectDAO;

    public SubjectBussImpl(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    @Override
    public void save(SubjectBO obj) {
        subjectDAO.save(obj);
    }

    @Override
    public void update(SubjectBO obj) {
        subjectDAO.upadte(obj);
    }

    @Override
    public void saveOrUpdate(SubjectBO obj) {
        subjectDAO.saveOrUpdate(obj);
    }

    @Override
    public void remove(SubjectBO obj) {
        subjectDAO.remove(obj);
    }

    @Override
    public List doSearch(SubjectDTO obj) {
        return subjectDAO.doSearch(obj);
    }
}
