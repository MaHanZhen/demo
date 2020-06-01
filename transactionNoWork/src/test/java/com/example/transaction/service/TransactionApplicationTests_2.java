package com.example.transaction.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@SpringBootTest
@EnableTransactionManagement
class TransactionApplicationTests_2 {


    @Resource
    private NoWorkingService noWorkingService_2;


    @Test
    void noWorkModel2() {
        noWorkingService_2.noWorkModel2_2();
    }

}
