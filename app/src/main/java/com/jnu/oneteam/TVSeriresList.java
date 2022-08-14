package com.jnu.oneteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TVSeriresList extends AppCompatActivity implements View.OnClickListener {
    private List<TVItem> tvItems;       //List存储显示的榜单数据单元

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvserires_list);

        initData();// 给list加入数据
        RecyclerView myRecyclerView=findViewById(R.id.TVList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);//设置recycleView为线性布局



        myRecyclerView.setAdapter(new MYRecyclerViewAdapter(tvItems));//给recycleView设置触发器

    }

    public void initData(){// 给list加入数据，目前是写死的没有获取到数据
        tvItems =new ArrayList<TVItem>();
        tvItems.add(new TVItem(R.drawable.huomiao,"幸福生活","赵丽颖/刘威","40集","2022-3-06 播出","100000000000"));
        tvItems.add(new TVItem(R.drawable.huomiao,"幸福到万家","赵丽颖/刘威","40集","2022-6-22 播出","4044.03"));

        tvItems.add(new TVItem(R.drawable.huomiao,"幸福到万家","赵丽颖/刘威","40集","2022-6-22 播出","4044.03"));

        tvItems.add(new TVItem(R.drawable.huomiao,"幸福到万家","赵丽颖/刘威","40集","2022-6-22 播出","4044.03"));

        tvItems.add(new TVItem(R.drawable.huomiao,"幸福到万家","赵丽颖/刘威","40集","2022-6-22 播出","4044.03"));

        tvItems.add(new TVItem(R.drawable.huomiao,"幸福到万家","赵丽颖/刘威","40集","2022-6-22 播出","4044.03"));

    }

    @Override
    public void onClick(View view) {//点击响应处理
        switch (view.getId()){
            case R.id.imageView_left:       //响应返回上一页面
                Intent intent=new Intent();
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.imageView_right:      //响应分享
                break;
            case R.id.textView_right:           //榜单规则页面跳转
                Intent intent3=new Intent();
                intent3.setClass(this,Rule.class);
                startActivity(intent3);
                break;
            case R.id.textView_left:            //详情跳转

                break;
        }
    }

    private class MYRecyclerViewAdapter extends RecyclerView.Adapter {          //recycleView
        private List<TVItem> tvItems;

        public MYRecyclerViewAdapter(List<TVItem> tvItems) {
            this.tvItems=tvItems;

        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tv_item,parent,false);
            return new MyViewHolder(view);    //设置列表项样式，链接到对应的Layout
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder Holder, int position) {
            MyViewHolder holder=(MyViewHolder) Holder;          //给每一个列表项内容赋值

            holder.getImageView().setImageResource(tvItems.get(position).getTVImage());
            holder.getTextViewName().setText(tvItems.get(position).getTVName());
            holder.getTextViewStar().setText(tvItems.get(position).getTVStar());
            holder.getTextViewSum().setText(tvItems.get(position).getTVSum());
            holder.getTextViewBroadcast().setText(tvItems.get(position).getTVBroadcast());
            holder.getTextViewHeat().setText(tvItems.get(position).getTVHeat());

            //设置每一项的点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent4=new Intent();
                    intent4.setClass(getBaseContext(),TVDetail.class);
                    startActivity(intent4);
                }
            });
        }

        @Override
        public int getItemCount() {

            return tvItems.size();  //获取列表项总数
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            private  ImageView imageView;
            private  TextView textViewName;
            private  TextView textViewHeat;
            private  TextView textViewBroadcast;
            private  TextView textViewSum;
            private  TextView textViewStar;

            public MyViewHolder(View view) {            //将具体列表项与列表项布局连接
                super(view);

                this.imageView=view.findViewById(R.id.TVImage);
                this.textViewName=view.findViewById(R.id.TVName);
                this.textViewStar=view.findViewById(R.id.TVStar);
                this.textViewSum=view.findViewById(R.id.TVSum);
                this.textViewBroadcast=view.findViewById(R.id.TVBroadcast_time);
                this.textViewHeat=view.findViewById(R.id.TVHeat);

            }


            public ImageView getImageView() {
                return imageView;
            }

            public TextView getTextViewName() {
                return textViewName;
            }

            public TextView getTextViewHeat() {
                return textViewHeat;
            }

            public TextView getTextViewBroadcast() {
                return textViewBroadcast;
            }

            public TextView getTextViewSum() {
                return textViewSum;
            }

            public TextView getTextViewStar() {
                return textViewStar;
            }
        }
    }
}