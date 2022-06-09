package com.jksurajpuriya.flashlignt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;

import com.jksurajpuriya.flashlignt.databinding.ActivityPermissionBinding;

public class PermissionActivity extends AppCompatActivity {



    ActivityPermissionBinding binding;
    public static final int CAMERA_REQUEST=123;
    public static final int REQUEST_PERMISSION_SETTING=1234;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPermissionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        binding.allowAccessBtn.setOnClickListener(v -> {
            permission();
        });







    }
    private void permission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
            startActivity(new Intent(PermissionActivity.this, SplashActivity.class));
            finish();
        }else {
            ActivityCompat.requestPermissions(PermissionActivity.this,
                    new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_REQUEST){
            for (int i = 0; i < permissions.length; i++){
                String per = permissions[i];
                if (grantResults[i] == PackageManager.PERMISSION_DENIED){

                    boolean showRationale = shouldShowRequestPermissionRationale(per);
                    if (!showRationale){
                        // user clicked on never ask again
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("App Permission")
                                .setMessage("For Flash Light App, You must allow this app to access Flash Light on your device"
                                        +"\n\n"+"Now follow the below steps"+"\n\n"+
                                        "Open Setting from below button"+"\n"
                                        +"Click on Permissions"+"\n"+"Allow access for Camera")
                                .setPositiveButton("Open Settings", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent =new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package",getPackageName(),null);
                                        intent.setData(uri);
                                        startActivityForResult(intent,REQUEST_PERMISSION_SETTING);
                                    }
                                }).create().show();
                    }else {

                        ActivityCompat.requestPermissions(PermissionActivity.this,
                                new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);

                    }
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            startActivity(new Intent(PermissionActivity.this,SplashActivity.class));
            finish();
        }
    }

}
