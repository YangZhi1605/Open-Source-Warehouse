package com.test.demo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_three extends Fragment {

    public static Fragment_three newInstance(){
        return new Fragment_three();
    }

    private TextView tv_name;
    public static SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three,container,false);
        sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        view.findViewById(R.id.btn_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),LoginActivity.class));
                getActivity().finish();
            }
        });
        tv_name = view.findViewById(R.id.tv_name);
        tv_name.setText("用户名："+sp.getString("account",""));
        return view;
    }
}
