package com.friendtimes.ft_permission.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

/**
 * Created by liwei002 on 2017/5/31.
 */

public class Util {

	public Util() {

	}
	/**
	 * 获取App名称
	 */
	public static String getAppName(Context context) {
		try {
			PackageManager pm = context.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
			return pi == null ? null : pi.applicationInfo.loadLabel(pm).toString();
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
			return context.getPackageName();
		}
	}

	/**
	 * 跳转到App设置详情界面
	 */
	public static void goToSettingDetail(Context context) {
		Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
		intent.setData(Uri.parse("package:" + context.getPackageName()));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}
}
