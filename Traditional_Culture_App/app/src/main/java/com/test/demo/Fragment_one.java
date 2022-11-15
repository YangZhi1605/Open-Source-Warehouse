package com.test.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_one extends Fragment {

    public static Fragment_one newInstance(){
        return new Fragment_one();
    }

    private VideoView videoview;
    private MediaController mediaController;
    private String videoPath;
    private RecyclerView rcy_msg;
    private RcyAdapter rcyAdapter;
    private List<Msg> msgList;
    public String[] message = {"李大钊是中国共产主义运动的先驱，伟大的马克思主义者，杰出的无产阶级革命家，中国共产党的主要创始人之一。" +
            "李大钊少年立志报国，为寻求中华民族的解放不懈努力，他顺应时代的需要，率先在中国大地上高举起马克思列宁主义的旗帜。",
            "字润之。中国人民的领袖，马克思主义者，伟大的无产阶级革命家、战略家和理论。" +
                    "中国共产党、中国人民解放军和中华人民共和国的主要缔造者和领导人，诗人，书法家。",
            "又名遐延。革命烈士。陈独秀长子。中共早期领导人之一，为中国解放革命事业做出过巨大贡献 。" +
                    "与赵世炎、周恩来一起创建旅欧共产主义组织——中国少年共产党，并担任宣传部长。",
            "1917年考入北京大学中文系，在北京大学学习期间，曾发起组织北京大学平民教育讲演团，1919年参加五四运动，任北京学生联合会总务干事" +
                    "1920年3月，在李大钊领导下，邓中夏、高君宇等人发起组织北京大学马克思学说研究会。" +
                    "同年10月，以马克思学说研究会的成员为骨干，发起组织了北京的共产党早期组织，李大钊被选为书记，邓中夏从此成为中国共产党最早的党员之一。" +
                    ""};
    public String[] name = {"李大钊","毛泽东","陈延年","邓中夏"};
    private int[] imgs = {R.mipmap.abc,R.mipmap.bcd,R.mipmap.cde,R.mipmap.def};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        videoview = view.findViewById(R.id.videoview);
//        videoPath = "android.resource://"+getActivity().getPackageName()+"/"+R.raw.video;
        mediaController = new MediaController(getActivity());
        mediaController.setMediaPlayer(videoview);
        mediaController.setVisibility(View.INVISIBLE);
        videoview.setMediaController(mediaController);
        videoview.requestFocus();
        videoview.setVideoPath(videoPath);
        videoview.start();
        rcy_msg = view.findViewById(R.id.rcy_msg);
        msgList = new ArrayList<>();
        for(int i=0;i<message.length;i++){
            Msg msg = new Msg();
            msg.msg = message[i];
            msg.name = name[i];
            msg.img = imgs[i];
            msgList.add(msg);
        }
        rcyAdapter = new RcyAdapter(getActivity(),msgList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcy_msg.setLayoutManager(linearLayoutManager);
        rcy_msg.setAdapter(rcyAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
