package com.heeexy.example.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_permission")
public class SysPermisssionEntity extends BaseEntity implements Serializable {

    @TableId
    private Long id;
    /**
     * 归属菜单
     */
    private String menu_code;
    /**
     * 菜单的中文释义
     */
    private String menu_name;
    /**
     * 权限的代码
     */
    private String permission_code;
    /**
     * 本权限的中文释义
     */
    private String permission_name;
    /**
     * 是否本菜单必选权限
     */
    private Integer required_permission;
}
