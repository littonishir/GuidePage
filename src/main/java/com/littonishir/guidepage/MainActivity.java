package com.littonishir.guidepage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by littonishir on 2017/6/7.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setResult(1);
    }

    public void clear(View view) {
        SharedPreferencesUtils.setParam(this, "flag", "2");
        String flag = (String) SharedPreferencesUtils.getParam(this, "flag", "0");
        if (flag.equals("2")) {
            Toast.makeText(this, "清除SP数据成功", Toast.LENGTH_SHORT).show();
        }
    }
}
