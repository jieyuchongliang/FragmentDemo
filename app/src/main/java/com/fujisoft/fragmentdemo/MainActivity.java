package com.fujisoft.fragmentdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.fujisoft.fragmentdemo.factory.MainFragmentFactory;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener, OnTabReselectListener {
    private BottomBar bottomBar;
    private String hideTag = null;//隐藏的上一个显示的fragment标记
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(this);
        bottomBar.setOnTabReselectListener(this);
    }

    @Override
    public void onTabSelected(int i) {
        switch (i) {
            case R.id.tab_home:
                ftCommit(MainFragmentFactory.HOME);
                Toast.makeText(this,"首页", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_detail:
                ftCommit(MainFragmentFactory.DETAIL);
                Toast.makeText(this,"详情", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_video:
                ftCommit(MainFragmentFactory.VIDEIO);
                Toast.makeText(this,"视频", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_me:
                ftCommit(MainFragmentFactory.ME);
                Toast.makeText(this,"我的", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void ftCommit(String tag) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //判断有没有需要隐藏的fragment，如果有，先行隐藏。
        if (!TextUtils.isEmpty(hideTag)){
            Fragment fragmentHide = fm.findFragmentByTag(hideTag);
            if (fragmentHide != null) {
                ft.hide(fragmentHide);
            }
        }
        Fragment fragmentShow = fm.findFragmentByTag(tag);
        if (fragmentShow != null) {
            ft.show(fragmentShow);
        }else {
            fragmentShow = MainFragmentFactory.getInstance().getFragment(tag);
            ft.show(fragmentShow);
            ft.add(R.id.content,fragmentShow,tag);
        }
        ft.commit();
        //fragment显示之后，将标记赋值给hideTag，用于隐藏。
        hideTag = tag;
    }

    @Override
    public void onTabReSelected(int i) {
        switch (i) {
            case R.id.tab_home:
                Toast.makeText(this,"re首页", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_detail:
                Toast.makeText(this,"re详情", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_video:
                Toast.makeText(this,"re视频", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_me:
                Toast.makeText(this,"re我的", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
