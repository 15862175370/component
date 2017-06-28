package com.friendtimes.ft_module;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.friendtimes.ft_permission.CheckSelfPermissionSDK;
import com.friendtimes.ft_permission.listener.IPermissionCallback;

public class MainActivity extends Activity implements View.OnClickListener, IPermissionCallback {
    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.READ_PHONE_STATE};
    private static final int REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_main01).setOnClickListener(this);
        findViewById(R.id.btn_main02).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_main01:
              /*  // 缺少权限时, 进入权限配置页面
                if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
                    PermissioActivity.startActivityForResult(MainActivity.this, REQUEST_CODE, PERMISSIONS);
                    Toast.makeText(MainActivity.this,"权限没有通过",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"权限通过",Toast.LENGTH_SHORT).show();
                }*/
                new CheckSelfPermissionSDK.Builder()
                        .permissions(new String[]{Manifest.permission.READ_PHONE_STATE,Manifest.permission.CAMERA})
                        .build()
                        .start(this, this);
                break;
            case R.id.btn_main02:
               /* new CheckSelfPermissionSDK.Builder()
                        .permissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO
                                , Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_PHONE_STATE})
                        .build()
                        .start(this, this);*/
                break;
        }
    }

    @Override
    public void permissionSuccess(String[] permissionStr) {
        Toast.makeText(MainActivity.this, "所有权限都已通过", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void permissionDeny(String[] permissionStr) {
        //Toast.makeText(MainActivity.this, "无法获取所有权限", Toast.LENGTH_SHORT).show();
        for (String permission : permissionStr)
        {
            Log.e("ss", "被拒绝的权限:" + permission);
        }
    }
}
