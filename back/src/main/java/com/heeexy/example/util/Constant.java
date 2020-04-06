package com.heeexy.example.util;

/**
 * 常量
 * 
 * @author zjdc
 * @email 631079326@qq.com
 * @date 2016年11月15日 下午1:23:52
 */
public class Constant {


    /** 超级管理员ID */
    public static final int SUPER_ADMIN = 1;
    public static final int SUPER_ADMIN_IP = 13;

    public static final String DEFAULT_AREA_CODE = "330211";

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_LOAD_UNLOAD_PROXY = "checkPoint_proxy_role";
    public static final String ROLE_GOV_CHECK = "gov_check_lic";
    public static final String ROLE_GOV_PREF= "gov_";
    public static final String ROLE_ENTP_PREF= "entp_";
    public static final String ROLE_CP_PREF= "checkPoint";
    public static final String ROLE_OPR_PREF= "yy_admin";
    public static final String ROLE_CP_PROXY_PREF= "checkPoint_proxy_role";
    public static final String SY_AREA_CODE = "330604";
    public static final String SY_AREA_CODE_OLD = "330682";
    public static final String ZH_AREA_CODE = "330211";
    public static final String XA_AREA_CODE = "330999";
    public static final String ZS_AREA_CODE = "330900";
    public static final Long ZH_CP_PROXY_ROLE_ID = 18L;
    public static final Long SY_CP_PROXY_ROLE_ID = 19L;
    public static final Long CP_PROXY_ROLE_ID = 18L;
    public static final Long YY_ROLE_ID = 24L;
    //运输企业
    public static final String ROLE_ENTP = "ROLE_ENTP";
    public static final String SYS_ENTP_NAME = "WHJK-ENTP";
    public static final String SY_AREA = "sy";
    public static final String ZH_AREA = "zh";
    public static final String BL_AREA = "bl";
    public static final String QZ_AREA = "qz";
    public static final String SYHGQ_AREA = "syhgq";
    public static final String MOBILE_REG = "^[1][3,4,5,6,7,8,9][0-9]{9}$";
    public static final String TRAICAR_REG = "^[\\u4e00-\\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{4}[A-Z0-9挂]{1}$";//挂车校验
    public static final String TRACCAR_REG = "^[\\u4e00-\\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$";//牵引车校验
    //充装单
    public static final String ID_REG = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";//身份证校验

    /**
     * 用户登录次数计数  redisKey 前缀
     */
    public static final String SHIRO_LOGIN_COUNT = "shiro:shiro_login_count_";

    /**
     * 用户登录是否被锁定    redisKey 前缀
     */
    public static final String SHIRO_IS_LOCK = "shiro:shiro_is_lock_";

    /**
     * Redis分布式并发锁  redisKey 前缀
     */
    public static final String ConcurrentLockPreFix = "ConcurrentLock:";

    /**
     * Redis分布式并发锁超时（秒）
     */
    public static final int ConcurrentLockTimeOut = 10;

    /**
     * 菜单类型
     *
     * @author zjdc
     * @email 631079326@qq.com
     * @date 2016年11月15日 下午1:24:29
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        private MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        private int value;

        private CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    /**
     * 定时任务状态
     *
     * @author chenshun
     * @email sunlightcs@gmail.com
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
