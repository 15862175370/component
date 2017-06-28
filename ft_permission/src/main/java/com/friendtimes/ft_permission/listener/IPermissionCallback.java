package com.friendtimes.ft_permission.listener;

public interface IPermissionCallback {
	/**
	 * 权限请求成功接口回调
	 * @param permissionStr 允许的权限
	 */
	void permissionSuccess(String[] permissionStr);

	/**
	 * 权限请求失败接口回调
	 * @param permissionStr 拒绝的权限
	 */
	void permissionDeny(String[] permissionStr);
}
