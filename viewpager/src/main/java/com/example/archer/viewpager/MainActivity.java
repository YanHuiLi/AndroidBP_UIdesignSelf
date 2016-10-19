package com.example.archer.viewpager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.tv_desc)
    private TextView tv_desc;
    @ViewInject(R.id.viewPager)
    private ViewPager viewPager;
    @ViewInject(R.id.ll_point_container)
    private LinearLayout ll_container;
    private int[] imageResIds;
    private ArrayList<ImageView> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //遵照mvc模式
        initView();
        initAdapter();
        initData();
    }

    private void initData() {


    }

    private void initAdapter() {
        viewPager.setAdapter(new MyAdapter());
        viewPager.setOffscreenPageLimit(2);//允许存在的可复用的view，默认是1个，就是三个。2个就是5个
    }

    private void initView() {
        ViewUtils.inject(this);
        //图片的本质上是以int类型保存在计算机中的
        imageResIds = new int[ ]{R.drawable.a,R.drawable.b,
                R.drawable.c,R.drawable.d,R.drawable.e};
        ImageView imageView;
        imageList = new ArrayList<>();

        for (int imageResId : imageResIds) {
            imageView = new ImageView(this);//初始化imageview
            imageView.setBackgroundResource(imageResId);//设置图片作为背景
            imageList.add(imageView);

        }


    }


    private class MyAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return imageList.size();
        }

        //创建要显示的内容

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            //container就是Viewpager，当前要显示条目的位置
            System.out.println("初始化++++"+position);
//a.把imageView对象添加到container里面
            ImageView imageView = imageList.get(position);
            container.addView(imageView);

            return imageView;
        }



        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }



        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            System.out.println("销毁了++++"+position);
            container.removeView((View) object);

        }
    }


}
