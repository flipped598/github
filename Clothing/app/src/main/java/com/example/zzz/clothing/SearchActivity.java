package com.example.zzz.clothing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zzz.clothing.utils.XmlParser;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {

    private EditText search_et;
    private ImageView city_search_iv;
    private Map<String, String> cityMap = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Log.d("MainActivity", "gaafggg");
        initData();
        search_et = (EditText)findViewById(R.id.search_et);
        city_search_iv = (ImageView) findViewById(R.id.city_search_iv);
        MyClickListener listener = new MyClickListener();
        city_search_iv.setOnClickListener(listener);
    }

    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String cityName = search_et.getText().toString();
            if (TextUtils.isEmpty(cityName)){
                finish();
            }else {
                String cityCode = cityMap.get(cityName);
                if (TextUtils.isEmpty(cityCode)){
                    Toast.makeText(getApplicationContext(),"城市输入不合法，请重新输入",Toast.LENGTH_SHORT).show();
                }else{
                    int code = Integer.parseInt(cityCode);
                    Intent intent = new Intent();
                    intent.putExtra("CODE",code);
                    setResult(200,intent);
                    finish();
                }
            }
        }
    }
    private void initData() {
        try {
            InputStream is = getAssets().open("city_code.xml");
            cityMap = XmlParser.parseCity(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
