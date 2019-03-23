package com.admn.console.service.impl;

import com.admn.common.ResultEntity;
import com.admn.common.constants.Constants;
import com.admn.console.model.TblUser;
import com.admn.console.service.RegisterService;
import com.admn.console.service.SysCodeService;
import com.admn.console.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserService userService;
    @Autowired
    private SysCodeService sysCodeService;

    @Override
    public ResultEntity register(TblUser user) {
        TblUser result = userService.findUserByUsername(user.getUsername());
        if (result != null) {
            return new ResultEntity(false, "注册失败, 该用户名已存在");
        } else {
            // 设置状态
            String userType = sysCodeService.findByTypeCode(Constants.UserType.NORMAL_USER).getDisplay1();
            String userStatus = sysCodeService.findByTypeCode(Constants.UserStatus.NORMAL).getDisplay1();
            user.setUserType(userType);
            user.setUserStatus(userStatus);
            ResultEntity resultEntity = userService.addUser(user);
            if (!resultEntity.isSuccess()) {
                return new ResultEntity(false, "注册失败");
            } else {
                return new ResultEntity(true, "注册成功");
            }
        }


    }

}
