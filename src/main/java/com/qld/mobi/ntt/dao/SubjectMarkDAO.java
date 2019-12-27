package com.qld.mobi.ntt.dao;

import com.qld.mobi.ntt.common.BaseDAO;
import com.qld.mobi.ntt.common.CustomQueryDAO;
import com.qld.mobi.ntt.dto.StudentDTO;
import com.qld.mobi.ntt.dto.SubjectMarkDTO;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class SubjectMarkDAO extends BaseDAO implements CustomQueryDAO<SubjectMarkDTO> {

    @Override
    public String select() {
        return " select " +
                "  sjm.subject_mark_id as subjectMarkid , " +
                "  sjm.student_code as studentCode , " +
                "  std.student_name as studentName , " +
                "  sjm.subject_code as subjectCode , " +
                "  sj.subject_name as subjectName , " +
                "  sjm.mark_cc as markCc , " +
                "  sjm.mark_btl as markBtl , " +
                "  sjm.mark_ck as markCk  ";
    }

    @Override
    public String from() {
        return " from " +
                " (  subject_mark sjm inner join subject sj on sjm.subject_code = sj.subject_code ) " +
                " inner join student std on sjm.student_code = std.student_code ";
    }

    @Override
    public String where(SubjectMarkDTO obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where 1=1  ");
        if (!StringUtils.isEmpty(obj.getStudentName())) {
            stringBuilder.append(" and std.student_name like :studentName ");
        }
        //diem cuoi ki =
        if (!StringUtils.isEmpty(obj.getMarkCk())) {
            stringBuilder.append(" and sjm.mark_ck = :markCk ");
        }
        //diem cuoi ki >=
        if (!StringUtils.isEmpty(obj.getSsLonHonHoacBang())) {
            stringBuilder.append(" and sjm.mark_ck >= :ssLonHonHoacBang ");
        }
        //diem cuoi ki <=
        if (!StringUtils.isEmpty(obj.getSsNhoHonHoacBang())) {
            stringBuilder.append(" and sjm.mark_ck <= :ssNhoHonHoacBang ");
        }
        return stringBuilder.toString();
    }

    @Override
    public String group() {
        return " group by " +
                "  sjm.subject_mark_id , " +
                "  sjm.student_code , " +
                "  std.student_name , " +
                "  sjm.subject_code ," +
                "  sj.subject_Name , " +
                "  sjm.mark_cc , " +
                "  sjm.mark_btl , " +
                "  sjm.mark_ck  "
                ;
    }

    @Override
    public void setParam(SQLQuery sqlQuery, SubjectMarkDTO obj) {
        if (!StringUtils.isEmpty(obj.getStudentName())) {
            sqlQuery.setParameter("studentName","%" + obj.getStudentName() + "%");
        }
        //diem cuoi ki =
        if (!StringUtils.isEmpty(obj.getMarkCk())) {
            sqlQuery.setParameter("markCk",obj.getMarkCk());
        }
        //diem cuoi ki >=
        if (!StringUtils.isEmpty(obj.getSsLonHonHoacBang())) {
            sqlQuery.setParameter("ssLonHonHoacBang",obj.getSsLonHonHoacBang());
        }
        //diem cuoi ki <=
        if (!StringUtils.isEmpty(obj.getSsNhoHonHoacBang())) {
            sqlQuery.setParameter("ssNhoHonHoacBang",obj.getSsNhoHonHoacBang());
        }
    }

    @Override
    public void addScalar(SQLQuery sqlQuery) {
        sqlQuery.addScalar("subjectMarkid", LongType.INSTANCE);
        sqlQuery.addScalar("studentCode", StringType.INSTANCE);
        sqlQuery.addScalar("studentName", StringType.INSTANCE);
        sqlQuery.addScalar("subjectCode", StringType.INSTANCE);
        sqlQuery.addScalar("subjectName", StringType.INSTANCE);
        sqlQuery.addScalar("markCc", StringType.INSTANCE);
        sqlQuery.addScalar("markBtl", StringType.INSTANCE);
        sqlQuery.addScalar("markCk", StringType.INSTANCE);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(SubjectMarkDTO.class));
    }

    public List doSearch(SubjectMarkDTO obj) {
        String sql = select() + from() + where(obj) + group();
        SQLQuery query = getSession().createSQLQuery(sql);
        setParam(query, obj);
        addScalar(query);
        return query.list();
    }
}
