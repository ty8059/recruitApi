package com.admn.console;

import com.admn.common.constants.Constants;
import com.admn.console.service.SysCodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysCodeTest {

    @Autowired
    private SysCodeService sysCodeService;

    @Test
    public void sysCodeTest() {
        String value = sysCodeService.findByTypeCode(Constants.UserType.NORMAL_USER).getDisplay1();
        System.out.println(value);

    }
}
