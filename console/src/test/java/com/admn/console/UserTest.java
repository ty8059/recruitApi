package com.admn.console;

import com.admn.console.service.LoginService;
import com.admn.console.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class  UserTest {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

}
