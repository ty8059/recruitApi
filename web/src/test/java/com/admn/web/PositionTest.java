package com.admn.web;

import com.admn.web.model.TblPosition;
import com.admn.web.service.PositionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionTest {

    @Autowired
    private PositionService positionService;

    @Test
    public void getListTest() {

    }

}
