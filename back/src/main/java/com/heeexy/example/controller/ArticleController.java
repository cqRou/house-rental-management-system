package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.entity.ArticleEntity;
import com.heeexy.example.query.QueryViewVo;
import com.heeexy.example.service.ArticleService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.heeexy.example.util.R;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hxy
 * @description: 文章相关Controller
 * @date: 2017/10/24 16:04
 */
@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	/**
	 * 查询文章列表
	 */
	@RequiresPermissions("article:list")
	@GetMapping("/listArticle")
	public JSONObject listArticle(HttpServletRequest request) {
		return articleService.listArticle(CommonUtil.request2Json(request));
	}

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("article:list")
	public R list(String name) {
		QueryViewVo<ArticleEntity> queryViewVo = new QueryViewVo<ArticleEntity>();
		PageUtils page = articleService.queryPage(queryViewVo);
		return R.ok().put("page", page);
	}

	/**
	 * 新增文章
	 */
	@RequiresPermissions("article:add")
	@PostMapping("/addArticle")
	public JSONObject addArticle(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "content");
		return articleService.addArticle(requestJson);
	}

	/**
	 * 修改文章
	 */
	@RequiresPermissions("article:update")
	@PostMapping("/updateArticle")
	public JSONObject updateArticle(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "id,content");
		return articleService.updateArticle(requestJson);
	}
}
