package com.heeexy.example.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("contract")
public class ContractEntity extends BaseEntity implements Serializable {
    @TableId
    private Long id;
    /**
     * 房屋id
     */
    private Long houseId;

    /**
     * 租赁人id
     */
    private Long rentId;

    /**
     * 出租者id
     */
    private Long houseOwnerId;

    /**
     * 租期
     */
    private  String rentTime;
    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 到期时间
     */
    private  Date endTime;
}
