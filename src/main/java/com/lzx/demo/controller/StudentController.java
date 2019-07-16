package com.lzx.demo.controller;

import com.lzx.demo.base.controller.BaseController;
import com.lzx.demo.dto.ReturnData;
import com.lzx.demo.entity.Student;
import com.lzx.demo.exception.SystemRunServiceException;
import com.lzx.demo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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


    /**
     * 异常处理测试
     * @param student
     * @return
     */
    @PostMapping("/exceptionTest")
    public ReturnData<String> exceptionTest(@RequestBody @Valid Student student){

        //int i = 1/0;
        throw new SystemRunServiceException("系统处理业务时出现了异常");

    }

 }
