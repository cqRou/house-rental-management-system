package com.heeexy.example.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class BaseEntity implements Serializable {private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    @TableField(value="crt_tm",fill = FieldFill.INSERT)
    private Date crtTm;
    /**
     * 创建者
     */
    @TableField(value="crt_by",fill = FieldFill.INSERT)
    private String crtBy;
    /**
     * 最后修改时间
     */
    @TableField(value="upd_tm",fill = FieldFill.INSERT_UPDATE)
    private Date updTm;
    /**
     * 修改人
     */
    @TableField(value="upd_by",fill = FieldFill.INSERT_UPDATE)
    private String updBy;
    /**
     * 修订状态：1100.10 新建 1100.80 已删除
     */
    @TableField(value = "edit_flag", fill = FieldFill.INSERT)
    @TableLogic
    @JsonIgnore
    private String editFlag;


}
