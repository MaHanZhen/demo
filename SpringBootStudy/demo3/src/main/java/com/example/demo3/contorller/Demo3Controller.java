package com.example.demo3.contorller;


import com.example.demo3.domin.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@RestController
public class Demo3Controller {

    //@Valid 注解 启用参数校验
    @RequestMapping("/testValid")
    public String testValid(@Valid Student student){
        System.out.println(student);
        return "success";
    }


    //需要使用包装类，对当个属性值无效
    @RequestMapping("/testValid2")
    public String testValid(@Valid @NotBlank(message = "传入姓名为空字符串") String name){
        System.out.println(name);
        return "success";
    }
}
