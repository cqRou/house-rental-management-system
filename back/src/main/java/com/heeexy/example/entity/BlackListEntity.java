package com.heeexy.example.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 证件审核表
 * 
 * @author caochaofeng
 * @email caochaofeng@dacanginfo.com
 * @date 2019-09-10 06:33:49
 */
@Data
@TableName("dc_black_list")
public class BlackListEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 黑名单编码
	 */
	private String cd;
	/**
	 * 车牌
	 */
	private String vehicleNo;

	private String entpName;
	/**
	 * 车牌主键
	 */
	private Long vehiclePk;
	/**
	 * 有效期
	 */
	@JsonFormat( pattern = "yyyy-MM-dd")
	private Date expireTime;
	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 黑名单所属平台
	 */
	private String sysId;
	/**
	 * 操作用户主键
	 */
	private Long oprUserPk;
	/**
	 * 操作用户名称
	 */
	private String oprUserNm;
	/**
	 * 当前状态编码
	 */
	private String statCd;
	/**
	 * 当前状态中文名
	 */
	private String statNmCn;
	/**
	 * 当前状态英文名
	 */
	private String statNmEn;
	/**
	 * 分类编码，司机，企业，车辆
	 */
	private String catCd;
	/**
	 * 分类英文名
	 */
	private String catNmEn;


}
