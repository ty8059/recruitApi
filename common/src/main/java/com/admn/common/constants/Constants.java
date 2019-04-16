package com.admn.common.constants;

public interface Constants {

    interface SysCodeStatus {
        /**
         * 启用
         */
        String ENABLE = "SYS_CODE_STATUS:ENABLE";
        /**
         * 停用
         */
        String STOP = "SYS_CODE_STATUS:STOP";
    }

    interface UserStatus {
        /**
         * 正常
         */
        String NORMAL = "USER_STATUS:NORMAL";
        /**
         * 冻结
         */
        String ABNORMAL = "USER_STATUS:ABNORMAL";
    }

    interface UserType {
        /**
         * 普通用户
         */
        String NORMAL_USER = "USER_TYPE:NORMAL_USER";
        /**
         * VIP用户
         */
        String VIP_USER = "USER_TYPE:VIP_USER";
    }

    interface UserMarriage {
        /**
         * 未婚
         */
        String FALSE = "USER_MARRIAGE:FALSE";
        /**
         * 已婚
         */
        String TRUE = "USER_MARRIAGE:TRUE";
    }

    interface PositionAppStatus {
        /**
         * 未通过
         */
        String FAIL = "POSITION_APP_STATUS:FAIL";
        /**
         * 通过
         */
        String PASS = "POSITION_APP_STATUS:PASS";
        /**
         * 待审核
         */
        String PENDING = "POSITION_APP_STATUS:PENDING";
    }

}
