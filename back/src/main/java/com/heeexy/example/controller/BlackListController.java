package com.heeexy.example.controller;


import com.heeexy.example.entity.BlackListEntity;
import com.heeexy.example.query.QueryViewVo;
import com.heeexy.example.service.BlackHessionListService;
import com.heeexy.example.util.PageUtils;
import com.heeexy.example.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





/**
 * 证件审核表
 *
 * @author caochaofeng
 * @email caochaofeng@dacanginfo.com
 * @date 2019-09-10 06:33:49
 */
@RestController
@RequestMapping("blacklist")
@Slf4j
public class BlackListController {
    @Autowired
    private BlackHessionListService blackListService;

    /**
         * 列表
         */
    @RequestMapping("/list")
   // @RequiresPermissions("bussiness:blacklist:list")
    public R list(QueryViewVo<BlackListEntity> queryViewVo) {
        PageUtils page = blackListService.queryPage(queryViewVo);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("bussiness:blacklist:info")
    public R info(@PathVariable("id") Long id){
		BlackListEntity blackList = blackListService.selectById(id);
        return R.ok().put("data", blackList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("bussiness:blacklist:save")
    public R save(@RequestBody BlackListEntity blackList){
//        SysUserEntity sysUserEntity = getUser();
//        blackList.setCrtBy(sysUserEntity.getUsername());
//        blackList.setUpdBy(sysUserEntity.getUsername());
        blackListService.insert(blackList);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("bussiness:blacklist:update")
    public R update(@RequestBody BlackListEntity blackList){
		blackListService.updateById(blackList);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("bussiness:blacklist:delete")
    public R delete(@RequestBody Long id){
//		blackListService.deleteBatchIds(Arrays.asList(ids));
        BlackListEntity blackListEntity = blackListService.selectById(id);
        blackListEntity.setEditFlag("1100.80");
        blackListService.updateById(blackListEntity);
        return R.ok();
    }


}
