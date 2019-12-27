package com.qld.mobi.ntt.dao;

import com.qld.mobi.ntt.common.BaseDAO;
import com.qld.mobi.ntt.common.CustomQueryDAO;
import com.qld.mobi.ntt.dto.SubjectDTO;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class SubjectDAO extends BaseDAO implements CustomQueryDAO<SubjectDTO> {

    @Override
    public String select() {
        return " select " +
                "  sj.subject_id as subjectId , " +
                "  sj.subject_code as subjectCode , " +
                "  sj.subject_name as subjectName , " +
                "  sj.number_session as numberSession  ";
    }

    @Override
    public String from() {
        return " from subject sj ";
    }

    @Override
    public String where(SubjectDTO obj) {
        return " where 1=1  ";
    }

    @Override
    public String group() {
        return " group by " +
                "  sj.subject_id , " +
                "  sj.subject_code , " +
                "  sj.subject_name , " +
                "  sj.number_session ";
    }

    @Override
    public void setParam(SQLQuery sqlQuery, SubjectDTO obj) {

    }

    @Override
    public void addScalar(SQLQuery sqlQuery) {
        sqlQuery.addScalar("subjectId", LongType.INSTANCE);
        sqlQuery.addScalar("subjectCode", StringType.INSTANCE);
        sqlQuery.addScalar("subjectName", StringType.INSTANCE);
        sqlQuery.addScalar("numberSession", StringType.INSTANCE);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(SubjectDTO.class));
    }

    public List doSearch(SubjectDTO obj) {
        String sql = select() + from() + where(obj) + group();
        SQLQuery query = getSession().createSQLQuery(sql);
//        setParam(query, obj);
        addScalar(query);
        return query.list();
    }
}
