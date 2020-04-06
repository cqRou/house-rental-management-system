package com.heeexy.example.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_role_permission")
public class SysRolePermissionEntity extends BaseEntity implements Serializable {
    @TableId
    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 权限id
     */
    private Long permissionId;


}
