package com.test.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends FragmentActivity implements View.OnClickListener {

    private RelativeLayout layoutOne,layoutTwo,layoutThree;
    private Fragment_one fragment_one;
    private Fragment_two fragment_two;
    private Fragment_three fragment_three;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        layoutOne = findViewById(R.id.layout_one);
        layoutTwo = findViewById(R.id.layout_two);
        layoutThree = findViewById(R.id.layout_three);
        layoutOne.setOnClickListener(this);
        layoutTwo.setOnClickListener(this);
        layoutThree.setOnClickListener(this);
        if (fragment_one == null) {
            fragment_one = Fragment_one.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.layout_frame, fragment_one)
                    .commitNow();
        } else {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if(fragment_two!=null){
                transaction.hide(fragment_two);
            }
            if(fragment_three!=null){
                transaction.hide(fragment_three);
            }
            transaction.show(fragment_one);
            transaction.commitNow();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layout_one:
                setOne();
                break;
            case R.id.layout_two:
                setTwo();
                break;
            case R.id.layout_three:
                setThree();
                break;
        }
    }

    private void setThree() {
        layoutOne.setEnabled(true);
        layoutTwo.setEnabled(true);
        layoutThree.setEnabled(false);
        if(fragment_three==null){
            fragment_three = Fragment_three.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.layout_frame,fragment_three).commitNow();
        }else{
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if(fragment_two!=null){
                transaction.hide(fragment_two);
            }
            if(fragment_one!=null){
                transaction.hide(fragment_one);
            }
            transaction.show(fragment_three);
            transaction.commitNow();
        }
    }

    private void setOne() {
        layoutOne.setEnabled(false);
        layoutTwo.setEnabled(true);
        layoutThree.setEnabled(true);
        if(fragment_one==null){
            fragment_one = Fragment_one.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.layout_frame,fragment_one).commitNow();
        }else{
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if(fragment_two!=null){
                transaction.hide(fragment_two);
            }
            if(fragment_three!=null){
                transaction.hide(fragment_three);
            }
            transaction.show(fragment_one);
            transaction.commitNow();
        }
    }

    private void setTwo(){
        layoutOne.setEnabled(true);
        layoutTwo.setEnabled(false);
        layoutThree.setEnabled(true);
        if(fragment_two==null){
            fragment_two = Fragment_two.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.layout_frame,fragment_two).commitNow();
        }else{
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if(fragment_one!=null){
                transaction.hide(fragment_one);
            }
            if(fragment_three!=null){
                transaction.hide(fragment_three);
            }
            transaction.show(fragment_two);
            transaction.commitNow();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
