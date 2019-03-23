package com.example.cinema.bl;

import com.example.cinema.po.UserForm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huwen
 * @date 2019/3/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

    @Autowired
    private AccountServiceImpl accountService;
//    @Test
//    public void testCreateNewAccount(){
//        UserForm user=new UserForm();
//        user.setUsername("testname");
//        user.setPassword("123456");
//        accountService.registerAccount(user);
//    }

    @Test
    public void testGetAccountByName1(){
        UserForm user=new UserForm();
        user.setUsername("testname");
        user.setPassword("123456");
        Boolean result=accountService.login(user);
        Assert.assertEquals(true,result);
    }

    @Test
    public void testGetAccountByName2(){
        UserForm user=new UserForm();
        user.setUsername("testname");
        user.setPassword("123456dsfdsfds");
        Boolean result=accountService.login(user);
        Assert.assertEquals(false,result);
    }

    @Test
    public void testGetAccountByName3(){
        UserForm user=new UserForm();
        user.setUsername("tesdsastnsdamsdse");
        user.setPassword("123456dsfdsfds");
        Boolean result=accountService.login(user);
        Assert.assertEquals(false,result);
    }
}
