package com.example.demo4.cont;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component  //注册这是一个组件
public class NeoProperties  {

    @Value("${com.example.demo4.cont.title}")  //获取 properties文件中的值
    public String title;

    @Value("${com.example.demo4.cont.description}")
    public  String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
