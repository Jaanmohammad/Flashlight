package com.jksurajpuriya.flashlignt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.jksurajpuriya.flashlignt.databinding.ActivityMainBinding;

import eu.dkaratzas.android.inapp.update.Constants;
import eu.dkaratzas.android.inapp.update.InAppUpdateManager;
import eu.dkaratzas.android.inapp.update.InAppUpdateStatus;

public class MainActivity extends AppCompatActivity implements InAppUpdateManager.InAppUpdateHandler{



    ActivityMainBinding binding;
    private Handler handler, handler1;
    private Runnable runnable, runnable1;
    private int time=100;
    private boolean handlerRun, torchOnRun;
    private long backPressedTime;

    InAppUpdateManager inAppUpdateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.zero.setOnClickListener(v -> {
            zeroColor();
            if (handlerRun==true){
                handler.removeMessages(0);
                handler1.removeMessages(0);
                TorchON();
            }
            binding.powerOn.setVisibility(View.INVISIBLE);
            binding.powerOff.setVisibility(View.VISIBLE);
            TorchON();

        });

        binding.one.setOnClickListener(v -> {
            if (handlerRun==true){
                oneColor();
                time=100;
                handler.removeMessages(0);
                handler1.removeMessages(0);
                HandlerON();


            }else {
                oneColor();
                time=100;
                HandlerON();
                binding.powerOn.setVisibility(View.INVISIBLE);
                binding.powerOff.setVisibility(View.VISIBLE);
                handlerRun=false;
            }

        });

        binding.two.setOnClickListener(v -> {

            if (handlerRun==true){
                twoColor();
                time=200;
                handler.removeMessages(0);
                handler1.removeMessages(0);
                HandlerON();


            }else {
                twoColor();
                time=200;
                HandlerON();
                binding.powerOn.setVisibility(View.INVISIBLE);
                binding.powerOff.setVisibility(View.VISIBLE);
                handlerRun=false;
            }

        });

        binding.three.setOnClickListener(v -> {

            if (handlerRun==true){
                time=400;
                threeColor();
                handler.removeMessages(0);
                handler1.removeMessages(0);
                HandlerON();


            }else {
                time=400;
                threeColor();
                HandlerON();
                binding.powerOn.setVisibility(View.INVISIBLE);
                binding.powerOff.setVisibility(View.VISIBLE);
                handlerRun=false;
            }

        });

        binding.four.setOnClickListener(v -> {

            if (handlerRun==true){
                fourColor();
                time=700;
                handler.removeMessages(0);
                handler1.removeMessages(0);
                HandlerON();


            }else {
                fourColor();
                time=700;
                HandlerON();
                binding.powerOn.setVisibility(View.INVISIBLE);
                binding.powerOff.setVisibility(View.VISIBLE);
                handlerRun=false;
            }

        });

        binding.five.setOnClickListener(v -> {

            if (handlerRun==true){
                fiveColor();
                time=900;
                handler.removeMessages(0);
                handler1.removeMessages(0);
                HandlerON();


            }else {
                fiveColor();
                time=900;
                HandlerON();
                binding.powerOn.setVisibility(View.INVISIBLE);
                binding.powerOff.setVisibility(View.VISIBLE);
                handlerRun=false;
            }

        });

        binding.six.setOnClickListener(v -> {

            if (handlerRun==true){
                time=1200;
                sixColor();
                handler.removeMessages(0);
                handler1.removeMessages(0);
                HandlerON();


            }else {
                sixColor();
                time=1200;
                HandlerON();
                binding.powerOn.setVisibility(View.INVISIBLE);
                binding.powerOff.setVisibility(View.VISIBLE);
                handlerRun=false;
            }

        });

        binding.seven.setOnClickListener(v -> {

            if (handlerRun==true){
                time=1500;
                sevenColor();
                handler.removeMessages(0);
                handler1.removeMessages(0);
                HandlerON();


            }else {
                sevenColor();
                time=1500;
                HandlerON();
                binding.powerOn.setVisibility(View.INVISIBLE);
                binding.powerOff.setVisibility(View.VISIBLE);
                handlerRun=false;
            }

        });

        binding.eight.setOnClickListener(v -> {

            if (handlerRun==true){
                time=2000;
                eightColor();
                handler.removeMessages(0);
                handler1.removeMessages(0);
                HandlerON();


            }else {
                time=2000;
                eightColor();
                HandlerON();
                binding.powerOn.setVisibility(View.INVISIBLE);
                binding.powerOff.setVisibility(View.VISIBLE);
                handlerRun=false;
            }

        });

        binding.nine.setOnClickListener(v -> {

            if (handlerRun==true){
                nineColor();
                time=2500;
                handler.removeMessages(0);
                handler1.removeMessages(0);
                HandlerON();



            }else {
                nineColor();
                time=2500;
                HandlerON();
                binding.powerOn.setVisibility(View.INVISIBLE);
                binding.powerOff.setVisibility(View.VISIBLE);
                handlerRun=false;
            }

        });


        binding.powerOn.setOnClickListener(v -> {
            zeroColor();
            binding.powerOn.setVisibility(View.INVISIBLE);
            binding.powerOff.setVisibility(View.VISIBLE);
            TorchON();
        });

        binding.powerOff.setOnClickListener(v -> {
            if (handlerRun==true){
                allColor();
                handler.removeMessages(0);
                handler1.removeMessages(0);
                TorchOFF();
                binding.powerOff.setVisibility(View.INVISIBLE);
                binding.powerOn.setVisibility(View.VISIBLE);
                handlerRun=false;
            }else {
                allColor();
                binding.powerOff.setVisibility(View.INVISIBLE);
                binding.powerOn.setVisibility(View.VISIBLE);
                TorchOFF();
                torchOnRun = false;
            }
        });







        ImmediateUpdate();

    }


    private void zeroColor() {
        binding.zero.setTextColor(Color.WHITE);
        binding.zero.setBackgroundColor(Color.GREEN);

        binding.one.setBackgroundColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.WHITE);

        binding.one.setTextColor(Color.BLACK);
        binding.two.setTextColor(Color.BLACK);
        binding.three.setTextColor(Color.BLACK);
        binding.four.setTextColor(Color.BLACK);
        binding.five.setTextColor(Color.BLACK);
        binding.six.setTextColor(Color.BLACK);
        binding.seven.setTextColor(Color.BLACK);
        binding.eight.setTextColor(Color.BLACK);
        binding.nine.setTextColor(Color.BLACK);
    }

    private void oneColor() {
        binding.one.setTextColor(Color.WHITE);
        binding.one.setBackgroundColor(Color.GREEN);

        binding.zero.setBackgroundColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.WHITE);


        binding.zero.setTextColor(Color.BLACK);
        binding.two.setTextColor(Color.BLACK);
        binding.three.setTextColor(Color.BLACK);
        binding.four.setTextColor(Color.BLACK);
        binding.five.setTextColor(Color.BLACK);
        binding.six.setTextColor(Color.BLACK);
        binding.seven.setTextColor(Color.BLACK);
        binding.eight.setTextColor(Color.BLACK);
        binding.nine.setTextColor(Color.BLACK);
    }

    private void twoColor() {
        binding.two.setTextColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.GREEN);

        binding.zero.setBackgroundColor(Color.WHITE);
        binding.one.setBackgroundColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.WHITE);

        binding.zero.setTextColor(Color.BLACK);
        binding.one.setTextColor(Color.BLACK);
        binding.three.setTextColor(Color.BLACK);
        binding.four.setTextColor(Color.BLACK);
        binding.five.setTextColor(Color.BLACK);
        binding.six.setTextColor(Color.BLACK);
        binding.seven.setTextColor(Color.BLACK);
        binding.eight.setTextColor(Color.BLACK);
        binding.nine.setTextColor(Color.BLACK);
    }

    private void threeColor() {
        binding.three.setTextColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.GREEN);

        binding.zero.setBackgroundColor(Color.WHITE);
        binding.one.setBackgroundColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.WHITE);

        binding.zero.setTextColor(Color.BLACK);
        binding.one.setTextColor(Color.BLACK);
        binding.two.setTextColor(Color.BLACK);
        binding.four.setTextColor(Color.BLACK);
        binding.five.setTextColor(Color.BLACK);
        binding.six.setTextColor(Color.BLACK);
        binding.seven.setTextColor(Color.BLACK);
        binding.eight.setTextColor(Color.BLACK);
        binding.nine.setTextColor(Color.BLACK);
    }

    private void fourColor() {
        binding.four.setTextColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.GREEN);

        binding.zero.setBackgroundColor(Color.WHITE);
        binding.one.setBackgroundColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.WHITE);

        binding.zero.setTextColor(Color.BLACK);
        binding.one.setTextColor(Color.BLACK);
        binding.two.setTextColor(Color.BLACK);
        binding.three.setTextColor(Color.BLACK);
        binding.five.setTextColor(Color.BLACK);
        binding.six.setTextColor(Color.BLACK);
        binding.seven.setTextColor(Color.BLACK);
        binding.eight.setTextColor(Color.BLACK);
        binding.nine.setTextColor(Color.BLACK);
    }

    private void fiveColor() {
        binding.five.setTextColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.GREEN);

        binding.zero.setBackgroundColor(Color.WHITE);
        binding.one.setBackgroundColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.WHITE);

        binding.zero.setTextColor(Color.BLACK);
        binding.one.setTextColor(Color.BLACK);
        binding.two.setTextColor(Color.BLACK);
        binding.three.setTextColor(Color.BLACK);
        binding.four.setTextColor(Color.BLACK);
        binding.six.setTextColor(Color.BLACK);
        binding.seven.setTextColor(Color.BLACK);
        binding.eight.setTextColor(Color.BLACK);
        binding.nine.setTextColor(Color.BLACK);
    }

    private void sixColor() {
        binding.six.setTextColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.GREEN);

        binding.zero.setBackgroundColor(Color.WHITE);
        binding.one.setBackgroundColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.WHITE);

        binding.zero.setTextColor(Color.BLACK);
        binding.one.setTextColor(Color.BLACK);
        binding.two.setTextColor(Color.BLACK);
        binding.three.setTextColor(Color.BLACK);
        binding.four.setTextColor(Color.BLACK);
        binding.five.setTextColor(Color.BLACK);
        binding.seven.setTextColor(Color.BLACK);
        binding.eight.setTextColor(Color.BLACK);
    }

    private void sevenColor() {
        binding.seven.setTextColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.GREEN);

        binding.zero.setBackgroundColor(Color.WHITE);
        binding.one.setBackgroundColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.WHITE);

        binding.zero.setTextColor(Color.BLACK);
        binding.one.setTextColor(Color.BLACK);
        binding.two.setTextColor(Color.BLACK);
        binding.three.setTextColor(Color.BLACK);
        binding.four.setTextColor(Color.BLACK);
        binding.five.setTextColor(Color.BLACK);
        binding.six.setTextColor(Color.BLACK);
        binding.eight.setTextColor(Color.BLACK);
        binding.nine.setTextColor(Color.BLACK);
    }

    private void eightColor() {
        binding.eight.setTextColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.GREEN);

        binding.zero.setBackgroundColor(Color.WHITE);
        binding.one.setBackgroundColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.WHITE);

        binding.zero.setTextColor(Color.BLACK);
        binding.one.setTextColor(Color.BLACK);
        binding.two.setTextColor(Color.BLACK);
        binding.three.setTextColor(Color.BLACK);
        binding.four.setTextColor(Color.BLACK);
        binding.five.setTextColor(Color.BLACK);
        binding.six.setTextColor(Color.BLACK);
        binding.seven.setTextColor(Color.BLACK);
        binding.nine.setTextColor(Color.BLACK);
    }

    private void nineColor() {
        binding.nine.setTextColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.GREEN);

        binding.zero.setBackgroundColor(Color.WHITE);
        binding.one.setBackgroundColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.WHITE);

        binding.zero.setTextColor(Color.BLACK);
        binding.one.setTextColor(Color.BLACK);
        binding.two.setTextColor(Color.BLACK);
        binding.three.setTextColor(Color.BLACK);
        binding.four.setTextColor(Color.BLACK);
        binding.five.setTextColor(Color.BLACK);
        binding.six.setTextColor(Color.BLACK);
        binding.seven.setTextColor(Color.BLACK);
        binding.eight.setTextColor(Color.BLACK);
    }

    private void allColor() {

        binding.zero.setBackgroundColor(Color.WHITE);
        binding.one.setBackgroundColor(Color.WHITE);
        binding.two.setBackgroundColor(Color.WHITE);
        binding.three.setBackgroundColor(Color.WHITE);
        binding.four.setBackgroundColor(Color.WHITE);
        binding.five.setBackgroundColor(Color.WHITE);
        binding.six.setBackgroundColor(Color.WHITE);
        binding.seven.setBackgroundColor(Color.WHITE);
        binding.eight.setBackgroundColor(Color.WHITE);
        binding.nine.setBackgroundColor(Color.WHITE);

        binding.zero.setTextColor(Color.BLACK);
        binding.one.setTextColor(Color.BLACK);
        binding.two.setTextColor(Color.BLACK);
        binding.three.setTextColor(Color.BLACK);
        binding.four.setTextColor(Color.BLACK);
        binding.five.setTextColor(Color.BLACK);
        binding.six.setTextColor(Color.BLACK);
        binding.seven.setTextColor(Color.BLACK);
        binding.eight.setTextColor(Color.BLACK);
        binding.nine.setTextColor(Color.BLACK);
    }


    private void HandlerON() {
        handler =new Handler();
        runnable =new Runnable() {
            @Override
            public void run() {
                handlerRun=true;
                TorchON();
                HandlerOFF();


            }
        };
        handler.postDelayed(runnable,time);
    }

    private void HandlerOFF() {
        handler1 =new Handler();
        runnable1 =new Runnable() {
            @Override
            public void run() {
                handlerRun=true;
                TorchOFF();
                HandlerON();
            }
        };
        handler1.postDelayed(runnable1,time);
    }

    private void TorchON() {
        torchOnRun=true;
        CameraManager cameraManager=(CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String  cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId,true);
            binding.bulbOff.setVisibility(View.INVISIBLE);
            binding.bulbOn.setVisibility(View.VISIBLE);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void TorchOFF() {
        CameraManager cameraManager=(CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String  cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId,false);
            binding.bulbOn.setVisibility(View.INVISIBLE);
            binding.bulbOff.setVisibility(View.VISIBLE);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime +2000 > System.currentTimeMillis()){
            super.onBackPressed();
            if (handlerRun==true){
                allColor();
                handler.removeMessages(0);
                handler1.removeMessages(0);
                TorchOFF();
                binding.powerOff.setVisibility(View.INVISIBLE);
                binding.powerOn.setVisibility(View.VISIBLE);
                handlerRun=false;
            }else {
                allColor();
                binding.powerOff.setVisibility(View.INVISIBLE);
                binding.powerOn.setVisibility(View.VISIBLE);
                TorchOFF();
                torchOnRun = false;
            }
            return;
        }
        backPressedTime=System.currentTimeMillis();
    }

    private void ImmediateUpdate() {
        inAppUpdateManager = InAppUpdateManager.Builder(this,101)
                .resumeUpdates(true)
                .mode(Constants.UpdateMode.IMMEDIATE)
                .snackBarAction("An update has just been download.")
                .snackBarAction("RESTART")
                .handler(this);
        inAppUpdateManager.checkForAppUpdate();
    }

    @Override
    public void onInAppUpdateError(int code, Throwable error) {


    }

    @Override
    public void onInAppUpdateStatus(InAppUpdateStatus status) {
        if (status.isDownloaded()){
            View view = getWindow().getDecorView().findViewById(android.R.id.content);
            Snackbar snackbar = Snackbar.make(view,"An update has just been download.",
                    Snackbar.LENGTH_INDEFINITE);

            snackbar.setAction("", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    inAppUpdateManager.completeUpdate();
                }
            });
            snackbar.show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Share App");
                    String shareMessage = "https://play.google.com/store/apps/details?id=com.jksurajpuriya.flashlignt";
                    intent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                    startActivity(Intent.createChooser(intent,"Share by"));
                }catch (Exception e){
                    Toast.makeText(this, "Send to Unable App", Toast.LENGTH_SHORT).show();
                }
        }
        return super.onOptionsItemSelected(item);
    }
}