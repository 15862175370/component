package com.friendtimes.ft_permission;

import android.app.Activity;

import com.friendtimes.ft_permission.listener.IPermissionCallback;
import com.friendtimes.ft_permission.model.PermissionOptions;
import com.friendtimes.ft_permission.ui.PermissionActivity;

/**
 * Created by liwei002 on 2017/5/31.
 */

public class CheckSelfPermissionSDK {


	private PermissionOptions mOptions;

	private CheckSelfPermissionSDK(PermissionOptions options) {
		this.mOptions = options;
	}

	/**
	 * 启动权限界面
	 *
	 * @param activity 上下文
	 * @param listener 权限请求结果回调接口
	 */
	public void start(Activity activity, IPermissionCallback listener) {
		PermissionActivity.setOnGrandResultListener(listener);
		PermissionActivity.start(activity, mOptions);
	}

	public static class Builder {
		private PermissionOptions mOptions;

		public Builder() {
			mOptions = new PermissionOptions();
		}

		public Builder permissions(String[] permissions) {
			mOptions.setPermissions(permissions);
			return this;
		}

		public CheckSelfPermissionSDK build() {
			return new CheckSelfPermissionSDK(mOptions);
		}
	}



}
