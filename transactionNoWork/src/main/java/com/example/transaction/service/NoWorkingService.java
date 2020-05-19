package com.example.transaction.service;

import com.example.transaction.dao.IUserDao;
import com.example.transaction.domin.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class NoWorkingService implements INoWorkingService {

    @Resource
    private IUserDao userDao;

    @Override
    public void noWorkModel1() {
        noWorkModel1_1();
    }

    @Transactional
    public void noWorkModel1_1(){
        User user = new User();
        user.setName("noWorkModel1_1");
        user.setAge(777);
        userDao.save(user);
        int q = 1/0;
    }


    @Transactional
    @Override
    public void noWorkModel2() {
        noWorkModel2_2();

    }

    @Transactional
    void noWorkModel2_2() {
        User user = new User();
        user.setName("noWorkModel2_2");
        user.setAge(777);
        userDao.save(user);
        int q = 1/0;
    }


    @Transactional
    @Override
    public void noWorkModel3() {
        User user = new User();
        user.setName("noWorkModel3");
        user.setAge(777);
        userDao.save(user);
        try {
            int q = 1/0;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void noWorkModel4_1() {
        noWorkModel4_2();
        int q = 1/0;
    }

    @Override
    @Transactional
    public void noWorkModel4_2() {
        User user = new User();
        user.setName("noWorkModel4_2");
        user.setAge(777);
        userDao.save(user);
    }
}
