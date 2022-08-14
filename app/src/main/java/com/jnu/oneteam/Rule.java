package com.jnu.oneteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Rule extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);
    }

    public void setText(){
        TextView rule=findViewById(R.id.rule_content);//获取页面中的文本组件，用来显示之后获取到的榜单规则具体内容
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){//响应返回榜单界面
            case R.id.rule_return:
                Intent intent=new Intent();
                intent.setClass(this,TVSeriresList.class);
                startActivity(intent);
                break;
        }
    }
}