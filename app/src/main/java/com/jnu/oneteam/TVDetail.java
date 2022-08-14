package com.jnu.oneteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TVDetail extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvdetail);
        ViewPager2 viewPagerFragment=findViewById(R.id.view_page);//获取view_page与tabLayout结合实现滑动页面显示与连接
        viewPagerFragment.setAdapter(new MyFragmentAdapter(this));
        TabLayout tabLayout=findViewById(R.id.table_layout);
        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayout, viewPagerFragment, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {//设置滑动页面滑动标题
                switch (position){
                    case 0:
                        tab.setText("视频");break;
                    case 1:
                        tab.setText("详情");break;
                }
            }
        });
        tabLayoutMediator.attach();
    }
    int star=0;//判断想看点击是奇数次还是偶数次
    @Override
    public void onClick(View view) {//响应页面倒退回榜单页面

        switch (view.getId()){
            case R.id.detail_return:
                Intent intent=new Intent();
                intent.setClass(this,TVSeriresList.class);
                startActivity(intent);
                break;
            case R.id.star:
                ImageView imageView=findViewById(R.id.star);
                if(star%2==0){
                    imageView.setImageResource(R.drawable.xingxing2);
                }
                else
                    imageView.setImageResource(R.drawable.xingxing);;
                star++;
                break;
        }
    }

    private class MyFragmentAdapter extends FragmentStateAdapter {//设置触发器连接切换的页面，并实现滑动切换页面
        public MyFragmentAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {//绑定两个fragment
            switch (position){
                case 0:
                    return TVVedioFragment.newInstance();
                default:
                    return TVDetailFragment.newInstance();
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }

    }
}