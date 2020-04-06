package com.heeexy.example.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.heeexy.example.entity.BlackListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 证件审核表
 * 
 * @author caochaofeng
 * @email caochaofeng@dacanginfo.com
 * @date 2019-09-10 06:33:49
 */
@Mapper
@Repository
public interface BlackListDao extends BaseMapper<BlackListEntity> {
	
}
