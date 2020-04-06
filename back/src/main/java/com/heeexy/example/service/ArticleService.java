package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.entity.ArticleEntity;
import com.baomidou.mybatisplus.service.IService;
import com.heeexy.example.query.QueryViewVo;
import com.heeexy.example.util.PageUtils;

/**
 * @author: hxy
 * @date: 2017/10/24 16:06
 */
public interface ArticleService extends IService<ArticleEntity>{
	/**
	 * 新增文章
	 */
	JSONObject addArticle(JSONObject jsonObject);

	/**
	 * 文章列表
	 */
	JSONObject listArticle(JSONObject jsonObject);

	/**
	 * 更新文章
	 */
	JSONObject updateArticle(JSONObject jsonObject);

	PageUtils queryPage(QueryViewVo<ArticleEntity> queryViewVo);
}
