package com.heeexy.example.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.heeexy.example.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleDao extends BaseMapper<SysRoleEntity> {

}
