package com.example.archer.uidesignself.abc.Utils;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;



/**
 * Created by Archer on 2016/10/19.
 * <p>
 * 描述:
 * <p>
 * 作者
 */

//旋转出去的动画
public class RotateAnimationUtils  {

    public  static  int RunningCount =0;


    public static void rotateAnimationOUT(RelativeLayout layout,long delay) {
//禁用所有的孩子
        int childCount = layout.getChildCount();
        for (int i=0; i<childCount;i++){
            layout.getChildAt(i).setEnabled(false);
        }


        RotateAnimation ra = new RotateAnimation(
                0f,-180f, Animation.RELATIVE_TO_SELF
                ,0.5f,Animation.RELATIVE_TO_SELF,1.0f//相对旋转的坐标点
        );
//逆时针
        ra.setDuration(1000);//半秒内展示完动画效果
        ra.setFillAfter(true);//动画结束的时候保持结束状态

        ra.setStartOffset(delay);//动画延时
        layout.startAnimation(ra);//开始动画
        ra.setAnimationListener(new MyAnimationListener());

    }

    public static void rotateAnimationIn(RelativeLayout layout) {
//启用
        int childCount = layout.getChildCount();
        for (int i=0; i<childCount;i++){
            layout.getChildAt(i).setEnabled(true);
        }
        //顺时针
        RotateAnimation ra = new RotateAnimation(
                -180f,-360f, Animation.RELATIVE_TO_SELF
                ,0.5f,Animation.RELATIVE_TO_SELF,1.0f//相对旋转的坐标点
        );

        ra.setDuration(1000);
        ra.setFillAfter(true);
        ra.setAnimationListener(new MyAnimationListener());
        layout.startAnimation(ra);

    }

    private static class MyAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

            RunningCount++;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            RunningCount--;

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
