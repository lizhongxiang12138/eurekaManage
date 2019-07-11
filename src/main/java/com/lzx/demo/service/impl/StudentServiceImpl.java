package com.lzx.demo.service.impl;

import com.lzx.demo.Dao.StudentDao;
import com.lzx.demo.base.service.impl.BaseServiceImpl;
import com.lzx.demo.entity.Student;
import com.lzx.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/7/11 17:09
 */
@Service
@Slf4j
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.dao = studentDao;
        this.studentDao = studentDao;
    }

    /**
     * 创建自己的查询条件
     * @return
     */
    @Override
    public List<Predicate> createPredicateList() {
        return super.createPredicateList();
    }
}
