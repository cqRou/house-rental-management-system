package com.heeexy.example.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@TableName("route")
public class RouteEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 路线ID
     */
    @TableId
    private Long id;

    /**
     * 开始地点
     */
    private String start;

    /**
     * 结束地点
     */
    private String end;

    /**
     * 途径点
     */
    private String lookPoints;

    /**
     * 交通方式（0：公交，1：开车，2：骑行）
     */
    private Integer lookType;

}
