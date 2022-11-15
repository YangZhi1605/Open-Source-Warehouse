package com.test.demo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class RegistActivity extends Activity {

    private EditText et_pwd,et_account;
    public static SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        et_account = findViewById(R.id.et_account);
        et_pwd = findViewById(R.id.et_password);
        findViewById(R.id.btnRegist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_account.getText().toString().trim().equals("")){
                    Toast.makeText(RegistActivity.this,"用户名不能为空",0).show();
                    return;
                }
                if(et_pwd.getText().toString().trim().equals("")){
                    Toast.makeText(RegistActivity.this,"密码不能为空",0).show();
                    return;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("account",et_account.getText().toString().trim());
                editor.putString("pwd",et_pwd.getText().toString().trim());
                editor.apply();
                finish();
            }
        });
    }
}
