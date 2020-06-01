package com.example.transaction;

import com.example.transaction.service.INoWorkingService;
import com.example.transaction.service.NoWorkingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@SpringBootTest
@EnableTransactionManagement
class TransactionApplicationTests {

    @Resource
    private INoWorkingService noWorkingService;


    @Test
    void contextLoads() {
    }

    @Test
    void noWorkModel1() {
        noWorkingService.noWorkModel1();
    }

    @Test
    void noWorkModel3() {
        noWorkingService.noWorkModel3();
    }

    @Test
    void noWorkModel4() {
        noWorkingService.noWorkModel4_1();
    }

}
