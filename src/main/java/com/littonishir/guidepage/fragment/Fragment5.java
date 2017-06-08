package com.littonishir.guidepage.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.littonishir.guidepage.MainActivity;
import com.littonishir.guidepage.R;
import com.littonishir.guidepage.SharedPreferencesUtils;

public class Fragment5 extends Fragment {
    private View view;
    private ImageView imageview;
    private TextView mTextView;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view = getView();
        context = view.getContext();
        initView();
    }

    private void initView() {
        imageview = (ImageView) view.findViewById(R.id.im_fragment);
        imageview.setImageResource(R.mipmap.guide5);
        mTextView = (TextView) view.findViewById(R.id.tv_fragment);
        mTextView.setVisibility(View.VISIBLE);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtils.setParam(context, "flag", "1");

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    //回调requestCode==1销毁该Activity
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 1) {
                getActivity().setResult(1);
                getActivity().finish();
            }
        }
    }
}
