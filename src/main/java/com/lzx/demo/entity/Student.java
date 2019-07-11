package com.lzx.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 描述: 学生类
 *
 * @Auther: lzx
 * @Date: 2019/7/11 15:39
 */
@Entity(name = "STUDENT")
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "ID",length = 32)
    private String id;

    /**
     * 名称
     */
    @Column(name = "NAME",length = 100)
    private String name;

    /**
     * 性别
     */
    @Column(name = "GENDER",length = 8)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Getter
    @AllArgsConstructor
    public enum Gender{
        WOMAN("女"),
        MAN("男");
        private String code;
    }

    /**
     * 分数
     */
    @Column(name = "SCORE",precision = 10,scale = 5)
    private BigDecimal score;
}
