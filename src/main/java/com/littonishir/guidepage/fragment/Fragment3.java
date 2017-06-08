package com.littonishir.guidepage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.littonishir.guidepage.R;


public class Fragment3 extends Fragment {
    private View view;
    private ImageView imageview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view = getView();
        initView();
    }

    private void initView() {
        imageview = (ImageView) view.findViewById(R.id.im_fragment);
        imageview.setImageResource(R.mipmap.guide3);
    }
}
