package com.example.demo4.controller;

import com.example.demo4.cont.NeoProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProController {

    @Resource
    NeoProperties neoProperties;

    @GetMapping("/getPro")
    public NeoProperties getPro() {
        return neoProperties;
    }

}
