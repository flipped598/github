package com.example.zzz.clothing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.zzz.clothing.data.Weather;
import com.example.zzz.clothing.fragment.FourFragment;
import com.example.zzz.clothing.fragment.OneFragment;
import com.example.zzz.clothing.fragment.ThreeFragment;
import com.example.zzz.clothing.fragment.TwoFragment;
import com.hjm.bottomtabbar.BottomTabBar;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_POSITION = 0;
    private static final int REQUEST_PHOTO = 1;

    private Button mPositionButton;
    private Button mClimateButton;
    private Button mPhotoButton;
    private String mPos;
    private BottomTabBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_main);
        mBottomBar = (BottomTabBar) findViewById(R.id.bottom_bar);

        mBottomBar.init(getSupportFragmentManager())
                .setImgSize(90, 90)
                .setFontSize(12)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.GREEN, Color.RED)
                .addTabItem("第一项", R.mipmap.erweima,  OneFragment.class)
                .addTabItem("第二项", R.mipmap.erweima,  TwoFragment.class)
                .addTabItem("第三项", R.mipmap.ic_launcher, ThreeFragment.class)
                .addTabItem("第四项", R.mipmap.ic_launcher, FourFragment.class)
                .setTabBarBackgroundColor(Color.BLUE)
                .isShowDivider(false);


        mPositionButton = (Button) findViewById(R.id.position_button);
        mPositionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i =new Intent(MainActivity.this, PositionActivity.class);
                startActivityForResult(i, REQUEST_POSITION);
            }
        });

        mClimateButton = (Button) findViewById(R.id.climate_button);
        mClimateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i1 = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(i1);
            }
        });
        mPhotoButton = (Button) findViewById(R.id.photo_button);
        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PhotoActivity.class);
                startActivityForResult(i, REQUEST_PHOTO);
            }
        });
    }

    protected void onAcitivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode != Activity.RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_POSITION){
            if(data ==null){
                return ;
            }
            mPos = PositionActivity.getposition(data);
        }
    }


}
