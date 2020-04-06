package com.heeexy.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId
    private Long roleId;

    /**
     * 角色名称
     */
    @NotEmpty(message = "角色名称不能为空")
    private String roleName;
}
