package com.lzx.demo.controller;

import com.lzx.demo.base.controller.BaseController;
import com.lzx.demo.entity.Student;
import com.lzx.demo.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: 学生api
 *
 * @Auther: lzx
 * @Date: 2019/7/11 17:14
 */
@RestController
@RequestMapping("/student")
public class StudentController extends BaseController<Student> {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
         /*
            !!!!!!!!!!!!!!!!!!!!重点：
            这个时必须的   ·······~~~~~~~~注意哦
         */
        this.baseService = studentService;
        this.studentService = studentService;
    }
}
