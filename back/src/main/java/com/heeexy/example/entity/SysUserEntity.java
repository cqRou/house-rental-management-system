package com.heeexy.example.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_user")
public class SysUserEntity extends BaseEntity implements Serializable {
    @TableId
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 虚拟名
     */
    private String nickname;
    /**
     * 地址
     */
    private String address;

    private Long roleId;
    /**
     * 邮箱
     */
    private String email;

}
