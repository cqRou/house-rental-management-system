package com.heeexy.example.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.heeexy.example.entity.BlackListEntity;
import com.heeexy.example.dao.BlackListDao;
import com.heeexy.example.query.QueryViewVo;
import com.heeexy.example.service.BlackHessionListService;
import com.heeexy.example.util.PageUtils;
import org.springframework.stereotype.Service;



@Service("blackListService")

public class BlackListServiceImpl extends ServiceImpl<BlackListDao, BlackListEntity> implements BlackHessionListService {

    @Override
    public PageUtils queryPage(QueryViewVo<BlackListEntity> queryViewVo) {
        Page<BlackListEntity> page = this.selectPage(queryViewVo.getPageUtil(), queryViewVo.getWrapper());
        return new PageUtils(page);
    }
}
