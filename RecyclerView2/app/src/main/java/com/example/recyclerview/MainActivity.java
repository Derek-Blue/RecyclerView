package com.example.recyclerview;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //RecyclerView清單主業
    private RecyclerView recyclerView;
    public RecyclerAdapter adapter = null;
    public ArrayList<Movie_ctt> moviego = null;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.movielist_m);

        moviego=new ArrayList<Movie_ctt>();

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        moviego.add(new Movie_ctt(R.mipmap.bee,"神鬼認證：傑森包恩","2016-07-25","麥特戴蒙強勢回歸他最具代表性的主角傑森包恩..."));
        moviego.add(new Movie_ctt(R.mipmap.bookshop,"名偵探柯南：純黑的惡夢","2016-07-26","★20週年大作，製作成本創新高★原作者青山剛昌親自參與劇本製作工作"));
        moviego.add(new Movie_ctt(R.mipmap.champion,"最酷的一天","2016-07-27","以莫札特作為人生目標，卻苦無成名契機的古怪鋼琴家小安（馬提亞斯史維克福 飾..."));
        moviego.add(new Movie_ctt(R.mipmap.hades,"夏日情事","2016-07-25","莎夏在柏林意外離世，讓男友勞倫斯與柔伊兩人頓失了一位情人和一位姊姊..."));
        moviego.add(new Movie_ctt(R.mipmap.summer,"變裝皇后萬萬歲","2016-07-25","★2016台北電影節 ★2016美國奧斯卡獎最佳外語片提名決選.."));
        moviego.add(new Movie_ctt(R.mipmap.superman,"超人特攻隊2","2018-06-27","《超人特攻隊》導演與角色將全數回歸，再次為觀眾帶來充滿冒險又笑料十足的《超人特攻隊2》..."));
        adapter = new RecyclerAdapter(this,moviego);
        recyclerView.setAdapter(adapter);
    }
}
