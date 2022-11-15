package com.test.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {

    private EditText et_account,et_password;
    public static SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        et_account = findViewById(R.id.et_account);
        et_password = findViewById(R.id.et_password);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et_account.getText().toString().trim().equals(sp.getString("account",""))){
                    Toast.makeText(LoginActivity.this,"账号或密码错误",0).show();
                    return;
                }
                if(!et_password.getText().toString().trim().equals(sp.getString("pwd",""))){
                    Toast.makeText(LoginActivity.this,"账号或密码错误",0).show();
                    return;
                }
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        findViewById(R.id.btnRegist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegistActivity.class));
            }
        });
    }
}
