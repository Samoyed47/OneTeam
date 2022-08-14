package com.jnu.oneteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        switch (view.getId()){//响应主页面的三个按钮，实现显示三个榜单
            case R.id.TV://显示电视剧榜单
                Intent intent=new Intent();
                intent.setClass(this,TVSeriresList.class);
                startActivity(intent);
                break;
            case R.id.variety://显示综艺榜单
                Intent intent2=new Intent();
                intent2.setClass(getBaseContext(),VarietySerires.class);
                startActivity(intent2);
                break;
            case R.id.movie://显示电影榜单
                Intent intent3=new Intent();
                intent3.setClass(getBaseContext(),movieSerires.class);
                startActivity(intent3);
                break;
        }
    }
}