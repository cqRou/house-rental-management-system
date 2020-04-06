package com.heeexy.example.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("payment")
public class PaymentEntity extends BaseEntity implements Serializable {
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
     * 总金额
     */
    private  Double money;
    /**
     * 是否支付
     */
    private  Integer isPay;

    /**
     * 押金
     */
    private  Double deposit;
}
