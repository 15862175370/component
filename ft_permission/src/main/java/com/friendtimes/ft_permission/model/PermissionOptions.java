package com.friendtimes.ft_permission.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Created by liwei002 on 2017/5/31.
 */

public class PermissionOptions implements Parcelable {

	//应用所需要的权限
	private String[] permissions;

	/**
	 * 无参构造方法
	 */
	public PermissionOptions() {

	}

	/**
	 * 有参构造方法
	 *
	 * @param permissions 应用所需要的权限
	 */
	public PermissionOptions(String[] permissions) {
		this.permissions = permissions;
	}

	/**
	 * 获得应用所需的权限
	 *
	 * @return
	 */
	public String[] getPermissions() {
		return permissions;
	}

	/**
	 * 设置应用所需要的权限
	 *
	 * @param permissions
	 */
	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "PermissionOptions{" +
				"permissions=" + Arrays.toString(permissions) +
				'}';
	}

	/******************************************** Parcelable接口所需实现的方法  ************************************************************/
	protected PermissionOptions(Parcel in) {
		this.permissions = in.createStringArray();
	}

	public static final Creator<PermissionOptions> CREATOR = new Creator<PermissionOptions>() {
		@Override
		public PermissionOptions createFromParcel(Parcel in) {
			return new PermissionOptions(in);
		}

		@Override
		public PermissionOptions[] newArray(int size) {
			return new PermissionOptions[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringArray(this.permissions);
	}
}
