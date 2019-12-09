package com.example.recyclerview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class OderListActivity extends AppCompatActivity  {

    //詳細資料頁面
    TextView msg;
    Bundle getbag;
    ImageView img;
    Button back;
    Intent intent;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_list);

        msg=findViewById(R.id.odtext);
        img=findViewById(R.id.imgt);
        back=findViewById(R.id.back);

        getbag=getIntent().getExtras();

        int p1=getbag.getInt("PIC");

        String m1=getbag.getString("NAME");
        String m2=getbag.getString("DATE");
        String m3=getbag.getString("STORY");
        msg.setText("電影名稱: "+m1+"\n"+"\n"+"上映日期: "+m2+"\n"+"\n"+"故事大綱: "+m3);

        img.setImageResource(p1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent();
                intent.setClass(OderListActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
