package com.heeexy.example.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("house")
public class HouseEntity extends BaseEntity implements Serializable {
    @TableId
    private Long id;
    /**
     * 房屋名称
     */
    private String houseName;

    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 面积
     */
    private String area;
    /**
     * 房屋类型
     */
    private Integer houseType;
    /**
     * 朝向
     */
    private String orientation;
    /**
     * 租金
     */
    private Double payment;
    /**
     * 地铁
     */
    private String subway;
    /**
     * 租房类型（0整租，1合租）
     */
    private Integer rentType;
    /**
     * 是否出租
     */
    private  Integer isRent;

    /**
     * 房龄
     */
    private  Double houseAge;
}
