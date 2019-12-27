package com.qld.mobi.ntt.buss;

import com.qld.mobi.ntt.bo.SubjectBO;
import com.qld.mobi.ntt.dto.SubjectDTO;

import java.util.List;

public interface SubjectBuss {
    void save(SubjectBO obj);

    void update(SubjectBO obj);

    void saveOrUpdate(SubjectBO obj);

    void remove(SubjectBO obj);

    List doSearch(SubjectDTO obj);
}
