package com.heeexy.example.service;

import com.baomidou.mybatisplus.service.IService;
import com.heeexy.example.entity.BlackListEntity;
import com.heeexy.example.query.QueryViewVo;
import com.heeexy.example.util.PageUtils;

/**
 * 证件审核表
 *
 * @author caochaofeng
 * @email caochaofeng@dacanginfo.com
 * @date 2019-09-10 06:33:49
 */
public interface BlackHessionListService extends IService<BlackListEntity> {

    PageUtils queryPage(QueryViewVo<BlackListEntity> queryViewVo);


}

