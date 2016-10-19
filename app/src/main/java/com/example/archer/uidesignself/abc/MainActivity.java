package com.example.archer.uidesignself.abc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.archer.uidesignself.R;
import com.example.archer.uidesignself.abc.Utils.RotateAnimationUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @ViewInject(R.id.rl_level1)
    private RelativeLayout ll_level1;
    @ViewInject(R.id.rl_level2)
    private RelativeLayout ll_level2;
    @ViewInject(R.id.rl_level3)
    private RelativeLayout ll_level3;

    @ViewInject(R.id.ib_home)
    private ImageButton ib_home;
    @ViewInject(R.id.ib_menu)
    private ImageButton ib_menu;

    /**
     * 三个菜单默认是显示的
     */
    private boolean isLevel3Display=true;
    private boolean isLevel2Display=true;
    private boolean isLevel1Display=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);

        initUI();



    }

    private void initUI() {
           ib_menu.setOnClickListener(this);
        ib_home.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ib_menu:
                if (RotateAnimationUtils.RunningCount>0){
                    return;
                }
                if (isLevel3Display){
                    //如果第三个菜单是展示的状态，那么转出去（隐藏起来）
                    RotateAnimationUtils.rotateAnimationOUT(ll_level3,0);
//isLevel3Display=false;

                }else {
                    RotateAnimationUtils.rotateAnimationIn(ll_level3);
//isLevel3Display=true;
                }
                isLevel3Display=!isLevel3Display;

                break;

            case R.id.ib_home:
                if (RotateAnimationUtils.RunningCount>0){
                    return;
                }
                if (isLevel2Display){
                    long delay =0;
                    if (isLevel3Display){
                        RotateAnimationUtils.rotateAnimationOUT(ll_level3,0);
                        isLevel3Display=false;
                        delay+=200;
                    }

                    //如果第2个菜单是展示的状态，那么转出去（隐藏起来）
                    RotateAnimationUtils.rotateAnimationOUT(ll_level2,delay);


                }else {
                    RotateAnimationUtils.rotateAnimationIn(ll_level2);

                }

                isLevel2Display=!isLevel2Display;

                break;

            default:
                break;
        }
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }


}
