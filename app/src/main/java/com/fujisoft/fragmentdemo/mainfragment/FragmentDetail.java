package com.fujisoft.fragmentdemo.mainfragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fujisoft.fragmentdemo.R;

/**
 * Created by 860617010 on 2018/1/12.
 */

public class FragmentDetail extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home,null);
        TextView textView = new TextView(getActivity());
        textView.setText(getClass().getSimpleName());
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        return view;
    }
}
