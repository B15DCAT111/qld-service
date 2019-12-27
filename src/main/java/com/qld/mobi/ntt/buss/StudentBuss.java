package com.qld.mobi.ntt.buss;

import com.qld.mobi.ntt.bo.StudentBO;
import com.qld.mobi.ntt.dto.StudentDTO;

import java.util.List;

public interface StudentBuss {
    void save(StudentBO obj);

    void update(StudentBO obj);

    void saveOrUpdate(StudentBO obj);

    void remove(StudentBO obj);

    List doSearch(StudentDTO obj);
}
