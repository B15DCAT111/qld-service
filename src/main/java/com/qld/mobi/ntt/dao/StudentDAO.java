package com.qld.mobi.ntt.dao;

import com.qld.mobi.ntt.common.BaseDAO;
import com.qld.mobi.ntt.common.CustomQueryDAO;
import com.qld.mobi.ntt.dto.StudentDTO;
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
public class StudentDAO extends BaseDAO implements CustomQueryDAO<StudentDTO> {
    @Override
    public String select() {
        return " select " +
                "  std.student_info_id as studentId , " +
                "  std.student_code as studentCode , " +
                "  std.student_name as studentName , " +
                "  std.class_code as classCode , " +
                "  std.student_adress as studentAdress , " +
                "  std.student_birth_day as studentBirhDay , " +
                "  std.student_email as studentEmail  ";
    }

    @Override
    public String from() {
        return " from student std ";
    }

    @Override
    public String where(StudentDTO obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where 1=1  ");
        if (!StringUtils.isEmpty(obj.getStudentName())) {
            stringBuilder.append(" and std.student_name like :studentName ");
        }
        if (!StringUtils.isEmpty(obj.getStudentAdress())) {
            stringBuilder.append(" and std.student_adress like :studentAdress ");
        }
        if (!StringUtils.isEmpty(obj.getStudentBirhDay())) {
            stringBuilder.append(" and std.student_birth_day like :studentBirhDay ");
        }
        return stringBuilder.toString();
    }

    @Override
    public String group() {
        return " group by " +
                "  std.student_info_id , " +
                "  std.student_code , " +
                "  std.student_name , " +
                "  std.class_code , " +
                "  std.student_adress , " +
                "  std.student_birth_day , " +
                "  std.student_email ";
    }

    @Override
    public void setParam(SQLQuery sqlQuery, StudentDTO obj) {
        if (!StringUtils.isEmpty(obj.getStudentName())) {
            sqlQuery.setParameter("studentName", "%" + obj.getStudentName() + "%");
        }
        if (!StringUtils.isEmpty(obj.getStudentAdress())) {
            sqlQuery.setParameter("studentAdress", "%" + obj.getStudentAdress() + "%");
        }
        if (!StringUtils.isEmpty(obj.getStudentBirhDay())) {
            sqlQuery.setParameter("studentBirhDay", "%" + obj.getStudentBirhDay() + "%");
        }
    }

    @Override
    public void addScalar(SQLQuery sqlQuery) {
        sqlQuery.addScalar("studentId", LongType.INSTANCE);
        sqlQuery.addScalar("studentCode", StringType.INSTANCE);
        sqlQuery.addScalar("studentName", StringType.INSTANCE);
        sqlQuery.addScalar("classCode", StringType.INSTANCE);
        sqlQuery.addScalar("studentAdress", StringType.INSTANCE);
        sqlQuery.addScalar("studentBirhDay", StringType.INSTANCE);
        sqlQuery.addScalar("studentEmail", StringType.INSTANCE);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(StudentDTO.class));
    }

    public List doSearch(StudentDTO obj) {
        String sql = select() + from() + where(obj) + group();
        SQLQuery query = getSession().createSQLQuery(sql);
        setParam(query, obj);
        addScalar(query);
        return query.list();
    }
}
