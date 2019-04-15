package com.admn.web.service.impl;

import com.admn.web.dao.TblPositionAppMapper;
import com.admn.web.model.TblPositionApp;
import com.admn.web.service.PositionAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionAppServiceImpl implements PositionAppService {

   @Autowired
   private TblPositionAppMapper positionAppMapper;

   @Override
   public List<TblPositionApp> getAppByAppTimeAndStatus(String startTime, String endTime, String status) {
       return positionAppMapper.findAppByAppTimeAndStatus(startTime, endTime, status);
   }

}
