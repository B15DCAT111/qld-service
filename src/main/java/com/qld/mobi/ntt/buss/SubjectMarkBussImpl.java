package com.qld.mobi.ntt.buss;

import com.qld.mobi.ntt.bo.SubjectMarkBO;
import com.qld.mobi.ntt.dao.SubjectMarkDAO;
import com.qld.mobi.ntt.dto.SubjectMarkDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectMarkBussImpl implements SubjectMarkBuss {
    private final SubjectMarkDAO subjectMarkDAO;

    public SubjectMarkBussImpl(SubjectMarkDAO subjectMarkDAO) {
        this.subjectMarkDAO = subjectMarkDAO;
    }

    @Override
    public void save(SubjectMarkBO obj) {
        subjectMarkDAO.save(obj);
    }

    @Override
    public void update(SubjectMarkBO obj) {
        subjectMarkDAO.upadte(obj);
    }

    @Override
    public void saveOrUpdate(SubjectMarkBO obj) {
        subjectMarkDAO.saveOrUpdate(obj);
    }

    @Override
    public void remove(SubjectMarkBO obj) {
        subjectMarkDAO.remove(obj);
    }

    @Override
    public List doSearch(SubjectMarkDTO obj) {

        List<SubjectMarkDTO> list = subjectMarkDAO.doSearch(obj);
        list.forEach(ob->{
            ob.setPhanLoai("A+");
        });
        return list;
    }

}
