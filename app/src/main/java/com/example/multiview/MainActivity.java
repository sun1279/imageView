package com.example.multiview;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.os.Environment;
import android.graphics.BitmapFactory;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView IView = (ImageView)findViewById(R.id.image1);

        if (Build.VERSION.SDK_INT >= 23)
        { int REQUEST_CODE_CONTACT = 101;
        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        //验证是否许可权限
            for (String str : permissions)
            {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED)
                { //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT); return;
                }
            }
        }
        //requestWritePermission();
        //String s = Environment.getExternalStorageDirectory().getAbsolutePath() + "/sdcard/123.jpg";
        //String s = "/sdcard/DCIM/Camera/123.jpg";

        //private String[] galleryPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};


        String s = "/sdcard/123.jpg";
        Bitmap bitmap = BitmapFactory.decodeFile(s);
        IView.setImageBitmap(bitmap);

    }

}

