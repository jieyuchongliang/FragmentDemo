package com.fujisoft.fragmentdemo.factory;

import android.app.Fragment;

import com.fujisoft.fragmentdemo.mainfragment.FragmentDetail;
import com.fujisoft.fragmentdemo.mainfragment.FragmentHome;
import com.fujisoft.fragmentdemo.mainfragment.FragmentMe;
import com.fujisoft.fragmentdemo.mainfragment.FragmentVideio;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 860617010 on 2018/1/12.
 */

public class MainFragmentFactory {
    private static Map<String, Fragment> fragmentMap = new HashMap();
    private static final String TAG = "MainFragmentFactory";
    public static final String HOME = "home";
    public static final String DETAIL = "detail";
    public static final String VIDEIO = "video";
    public static final String ME = "me";
    private static MainFragmentFactory instance;

    public static MainFragmentFactory getInstance() {
        if (instance == null) {
            instance = new MainFragmentFactory();
        }
        return instance;
    }
    private MainFragmentFactory() {
    }

    public  Fragment getFragment(String tag) {
        Fragment fragment = null;
        if (fragmentMap.get(tag) != null){
            return fragmentMap.get(tag);
        }else {
            switch (tag) {
                case HOME:
                    fragment = new FragmentHome();
                    fragmentMap.put(HOME,fragment);
                    break;
                case DETAIL:
                    fragment = new FragmentDetail();
                    fragmentMap.put(DETAIL,fragment);
                    break;
                case VIDEIO:
                    fragment = new FragmentVideio();
                    fragmentMap.put(VIDEIO,fragment);
                    break;
                case ME:
                    fragment = new FragmentMe();
                    fragmentMap.put(ME,fragment);
                    break;
            }
            return fragment;
        }
    }
}
