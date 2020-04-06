package com.heeexy.example.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.heeexy.example.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RouteDao extends BaseMapper<SysUserEntity> {

}
