package com.littonishir.guidepage;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;


import com.littonishir.guidepage.fragment.Fragment1;
import com.littonishir.guidepage.fragment.Fragment2;
import com.littonishir.guidepage.fragment.Fragment3;
import com.littonishir.guidepage.fragment.Fragment4;
import com.littonishir.guidepage.fragment.Fragment5;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends FragmentActivity {

    private ViewPager viewPager;
    private List<View> listImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除状态栏全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //读取sp数据判断是否应该进入引导页
        String sp = (String) SharedPreferencesUtils.getParam(this, "flag", "2");
        if (sp.equals("1")) {
            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
            startActivityForResult(intent, 1);
        } else {
            setContentView(R.layout.activity_guide);

            //设置有几个底部指示小点
            initView(5);
        }


    }

    private void initView(int pointsize) {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), showView()));
        listImg = new ArrayList<View>();
        for (int i = 1; i <= pointsize; i++) {
            Resources res = getResources();
            int id = res.getIdentifier("p" + i, "id", getPackageName());
            listImg.add(findViewById(id));
        }

        viewPager.addOnPageChangeListener(showPageChange);
    }


    ViewPager.OnPageChangeListener showPageChange = new ViewPager.OnPageChangeListener() {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            for (int i = 0; i < listImg.size(); i++) {
                if (i == position) {
                    listImg.get(position).setBackgroundResource(R.drawable.point_red);
                } else {
                    listImg.get(i).setBackgroundResource(R.drawable.point_normal);
                }
            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 1) {
                finish();
            }
        }
    }


    private List<Fragment> showView() {
        List<Fragment> listView = new ArrayList<Fragment>();
        listView.add(new Fragment1());
        listView.add(new Fragment2());
        listView.add(new Fragment3());
        listView.add(new Fragment4());
        listView.add(new Fragment5());
        return listView;
    }
}
