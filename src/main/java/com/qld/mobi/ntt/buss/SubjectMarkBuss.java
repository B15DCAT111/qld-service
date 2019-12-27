package com.qld.mobi.ntt.buss;

import com.qld.mobi.ntt.bo.SubjectMarkBO;
import com.qld.mobi.ntt.dto.SubjectMarkDTO;

import java.util.List;

public interface SubjectMarkBuss {
    void save(SubjectMarkBO obj);

    void update(SubjectMarkBO obj);

    void saveOrUpdate(SubjectMarkBO obj);

    void remove(SubjectMarkBO obj);

    List doSearch(SubjectMarkDTO obj);
}
