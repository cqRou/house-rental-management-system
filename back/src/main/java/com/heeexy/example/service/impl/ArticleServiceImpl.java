package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.heeexy.example.entity.ArticleEntity;
import com.heeexy.example.dao.ArticleDao;
import com.heeexy.example.query.QueryViewVo;
import com.heeexy.example.service.ArticleService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.PageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {

//	@Autowired
//	private ArticleDao articleDao;

	/**
	 * 新增文章
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public JSONObject addArticle(JSONObject jsonObject) {
		baseMapper.addArticle(jsonObject);
		return CommonUtil.successJson();
	}

	@Override
	public PageUtils queryPage(QueryViewVo<ArticleEntity> queryViewVo) {
		Page<ArticleEntity> page = this.selectPage(queryViewVo.getPageUtil(), queryViewVo.getWrapper());
		return new PageUtils(page);
	}

	/**
	 * 文章列表
	 */
	@Override
	public JSONObject listArticle(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = baseMapper.countArticle(jsonObject);
//		List<ArticleEntity> articleEntityList= baseMapper.selectList(null);
		List<JSONObject> list = baseMapper.listArticle(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	/**
	 * 更新文章
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public JSONObject updateArticle(JSONObject jsonObject) {
		baseMapper.updateArticle(jsonObject);
		return CommonUtil.successJson();
	}
}
