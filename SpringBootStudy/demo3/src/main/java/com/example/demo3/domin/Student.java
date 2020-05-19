package com.example.demo3.domin;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Student {

    @NotNull(message = "传入姓名为null")
    @NotEmpty(message = "传入姓名为空字符串")
    private String name;

    @NotNull(message = "传入成绩为null")
    @Min(value = 0,message ="成绩应大于0")
    @Max(value = 0,message ="成绩应小于100")
    private Integer score;

    @NotNull(message = "传入电话为null")
    @NotEmpty(message = "传入电话为空字符串")
    @Length(min = 11,max =11,message ="电话号码长度有误")
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
