package com.jeff.wqgframework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.jeff.baselibrary.ico.CheckNet;
import com.jeff.baselibrary.ico.OnClick;
import com.jeff.baselibrary.ico.ViewById;
import com.jeff.baselibrary.ico.ViewUtils;

public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.tv_hello)
    private TextView tvHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);

    }

    @OnClick(R.id.iv_icon)
    @CheckNet
    public void click(){
        Toast.makeText(this,"看看打开了吗",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tv_hello)
    public void tvClick(){
        Toast.makeText(this,"看看打开了吗-》tv_hello",Toast.LENGTH_SHORT).show();
    }



}