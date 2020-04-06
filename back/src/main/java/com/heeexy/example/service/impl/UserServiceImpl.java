package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.heeexy.example.entity.SysUserEntity;
import com.heeexy.example.dao.UserDao;
import com.heeexy.example.service.UserService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.ErrorEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, SysUserEntity> implements UserService {

	/**
	 * 用户列表
	 */
	@Override
	public JSONObject listUser(JSONObject jsonObject) {
		CommonUtil.fillPageParam(jsonObject);
		int count = baseMapper.countUser(jsonObject);
		List<JSONObject> list = baseMapper.listUser(jsonObject);
		return CommonUtil.successPage(jsonObject, list, count);
	}

	/**
	 * 添加用户
	 */
	@Override
	public JSONObject addUser(JSONObject jsonObject) {
		int exist = baseMapper.queryExistUsername(jsonObject);
		if (exist > 0) {
			return CommonUtil.errorJson(ErrorEnum.E_10009);
		}
		baseMapper.addUser(jsonObject);
		return CommonUtil.successJson();
	}

	/**
	 * 查询所有的角色
	 * 在添加/修改用户的时候要使用此方法
	 */
	@Override
	public JSONObject getAllRoles() {
		List<JSONObject> roles = baseMapper.getAllRoles();
		return CommonUtil.successPage(roles);
	}

	/**
	 * 修改用户
	 */
	@Override
	public JSONObject updateUser(JSONObject jsonObject) {
		baseMapper.updateUser(jsonObject);
		return CommonUtil.successJson();
	}

	/**
	 * 角色列表
	 */
	@Override
	public JSONObject listRole() {
		List<JSONObject> roles = baseMapper.listRole();
		return CommonUtil.successPage(roles);
	}

	/**
	 * 查询所有权限, 给角色分配权限时调用
	 */
	@Override
	public JSONObject listAllPermission() {
		List<JSONObject> permissions = baseMapper.listAllPermission();
		return CommonUtil.successPage(permissions);
	}

	/**
	 * 添加角色
	 */
	@Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject addRole(JSONObject jsonObject) {
		baseMapper.insertRole(jsonObject);
		baseMapper.insertRolePermission(jsonObject.getString("roleId"), (List<Integer>) jsonObject.get("permissions"));
		return CommonUtil.successJson();
	}

	/**
	 * 修改角色
	 */
	@Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject updateRole(JSONObject jsonObject) {
		String roleId = jsonObject.getString("roleId");
		List<Integer> newPerms = (List<Integer>) jsonObject.get("permissions");
		JSONObject roleInfo = baseMapper.getRoleAllInfo(jsonObject);
		Set<Integer> oldPerms = (Set<Integer>) roleInfo.get("permissionIds");
		//修改角色名称
		dealRoleName(jsonObject, roleInfo);
		//添加新权限
		saveNewPermission(roleId, newPerms, oldPerms);
		//移除旧的不再拥有的权限
		removeOldPermission(roleId, newPerms, oldPerms);
		return CommonUtil.successJson();
	}

	/**
	 * 修改角色名称
	 */
	private void dealRoleName(JSONObject paramJson, JSONObject roleInfo) {
		String roleName = paramJson.getString("roleName");
		if (!roleName.equals(roleInfo.getString("roleName"))) {
			baseMapper.updateRoleName(paramJson);
		}
	}

	/**
	 * 为角色添加新权限
	 */
	private void saveNewPermission(String roleId, Collection<Integer> newPerms, Collection<Integer> oldPerms) {
		List<Integer> waitInsert = new ArrayList<>();
		for (Integer newPerm : newPerms) {
			if (!oldPerms.contains(newPerm)) {
				waitInsert.add(newPerm);
			}
		}
		if (waitInsert.size() > 0) {
			baseMapper.insertRolePermission(roleId, waitInsert);
		}
	}

	/**
	 * 删除角色 旧的 不再拥有的权限
	 */
	private void removeOldPermission(String roleId, Collection<Integer> newPerms, Collection<Integer> oldPerms) {
		List<Integer> waitRemove = new ArrayList<>();
		for (Integer oldPerm : oldPerms) {
			if (!newPerms.contains(oldPerm)) {
				waitRemove.add(oldPerm);
			}
		}
		if (waitRemove.size() > 0) {
			baseMapper.removeOldPermission(roleId, waitRemove);
		}
	}

	/**
	 * 删除角色
	 */
	@Transactional(rollbackFor = Exception.class)
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject deleteRole(JSONObject jsonObject) {
		JSONObject roleInfo = baseMapper.getRoleAllInfo(jsonObject);
		List<JSONObject> users = (List<JSONObject>) roleInfo.get("users");
		if (users != null && users.size() > 0) {
			return CommonUtil.errorJson(ErrorEnum.E_10008);
		}
		baseMapper.removeRole(jsonObject);
		baseMapper.removeRoleAllPermission(jsonObject);
		return CommonUtil.successJson();
	}
}
