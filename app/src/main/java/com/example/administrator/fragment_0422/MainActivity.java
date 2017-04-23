package com.example.administrator.fragment_0422;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import fragment.LeftFragment;
import fragment.RightFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        //第三个参数：一个tag值，唯一指示添加进去的fragment
        beginTransaction.replace(R.id.fleft, new LeftFragment(), "left");
        //添加右边的fragment
        beginTransaction.replace(R.id.fright, new RightFragment(), "right");
        //提交
        beginTransaction.commit();

    }
}
