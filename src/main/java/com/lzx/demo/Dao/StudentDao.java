package com.lzx.demo.Dao;

import com.lzx.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * 描述: 学生类dao接口
 *
 * @Auther: lzx
 * @Date: 2019/7/11 15:52
 */
@RepositoryRestResource(path = "student")
public interface StudentDao extends Repository<Student,String>,JpaSpecificationExecutor<Student> {
}
