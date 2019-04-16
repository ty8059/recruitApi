package com.admn.web.service.impl;

import com.admn.common.ResultEntity;
import com.admn.common.constants.Constants;
import com.admn.common.utils.DateUtil;
import com.admn.web.dao.TblPositionAppMapper;
import com.admn.web.dao.TblPositionMapper;
import com.admn.web.model.TblPosition;
import com.admn.web.model.TblPositionApp;
import com.admn.web.model.TblResume;
import com.admn.web.model.TblUser;
import com.admn.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionAppServiceImpl implements PositionAppService {

   @Autowired
   private TblPositionAppMapper positionAppMapper;
   @Autowired
   private PositionService positionService;
   @Autowired
   private UserService userService;
   @Autowired
   private ResumeService resumeService;
   @Autowired
   private SysCodeService sysCodeService;

   @Override
   public List<TblPositionApp> getAppByAppTimeAndStatus(String startTime, String endTime, String status) {
       return positionAppMapper.findAppByAppTimeAndStatus(startTime, endTime, status);
   }

   @Override
   public ResultEntity applyPosition(Integer positionId, Integer userId) {
      TblPosition position = positionService.getPositionById(positionId);
      if (position == null) {
         return new ResultEntity(false, "该职位不存在");
      }
      TblUser user = userService.findUserById(userId);
      if (user == null) {
         return new ResultEntity(false, "该用户不存在");
      }
      List<TblResume> resumeList = resumeService.findResumeByUserId(userId);
      if (resumeList.size() == 0) {
         return new ResultEntity(false, "请先上传简历");
      }
      TblResume resume = resumeList.get(0);
      TblPositionApp positionApp = new TblPositionApp();

      // 检测是否已申请
      TblPositionApp existApp = positionAppMapper.findAppByPositionIdAndUserIdAndResumeId(positionId, userId, resume.getResumeId());
      if (existApp != null) {
         return new ResultEntity(false, "您已用简历申请过，请勿重复投递");
      }

      // 设置字段
      positionApp.setUserId(userId);
      positionApp.setPositionId(positionId);
      positionApp.setResumeId(resume.getResumeId());
      positionApp.setAppTime(DateUtil.getNowTime());
      String pending = sysCodeService.findByTypeCode(Constants.PositionAppStatus.PENDING).getDisplay1();
      positionApp.setStatus(pending);
      int result = positionAppMapper.insertSelective(positionApp);
      if (result > 0) {
         return new ResultEntity(true, "申请简历成功");
      } else {
         return new ResultEntity(false, "申请简历失败");
      }
   }
}
