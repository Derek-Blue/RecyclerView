package com.example.recyclerview;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Viewhoder> {

    //RecyclerView適配器
    private ArrayList<Movie_ctt> movie_data;
    Intent intent;
    Context context;
    String idMovie = "Ll";
    final Bundle bag=new Bundle();

    public RecyclerAdapter(Context context,ArrayList<Movie_ctt> movie_data) {
        this.movie_data = movie_data;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapterCard, parent, false);
        RecyclerAdapter.Viewhoder vh=new RecyclerAdapter.Viewhoder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.Viewhoder holder, int position) {

        holder.t_pic.setImageResource(movie_data.get(position).pic);
        holder.t_name.setText(movie_data.get(position).getName());
        holder.t_date.setText(movie_data.get(position).date);
        holder.t_story.setText(movie_data.get(position).getStory());
    }

    @Override
    public int getItemCount() {
        return movie_data.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder  {

        private ImageView t_pic;
        private TextView t_name;
        private TextView t_date;
        private TextView t_story;
        private Button t_bon;

        public Viewhoder(@NonNull final View itemView) {
            super(itemView);
            t_pic=itemView.findViewById(R.id.pic);
            t_name=itemView.findViewById(R.id.name);
            t_date=itemView.findViewById(R.id.date);
            t_story=itemView.findViewById(R.id.story);
            t_bon=itemView.findViewById(R.id.bon);

            //按下選擇的itemview連結至詳細資訊
            itemView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi
                @Override
                public void onClick (View v) {

                    intent=new Intent();
                    intent.setClass(v.getContext(),OderListActivity.class);
                    int img=movie_data.get(getAdapterPosition()).getPic();
                    String n=t_name.getText().toString();
                    String d=t_date.getText().toString();
                    String s=t_story.getText().toString();

                    bag.putString("NAME",n);
                    bag.putString("DATE",d);
                    bag.putString("STORY",s);
                    bag.putInt("PIC",img);

                    intent.putExtras(bag);

                    context.startActivity(intent);
                    ((Activity)context).finish();

                }
            });

            //按下送出建立一個Notification通知
            t_bon.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onClick(View v) {
                    NotificationManager notificationManager = (NotificationManager) v.getContext().getSystemService(Context.NOTIFICATION_SERVICE);

                    //通知設定
                    NotificationChannel channelMovie = new NotificationChannel(idMovie, "Channel Movie", NotificationManager.IMPORTANCE_HIGH);
                    channelMovie.setDescription("已預訂電影");
                    channelMovie.enableLights(true);
                    channelMovie.enableVibration(true);

                    //依設定建立通知
                    notificationManager.createNotificationChannel(channelMovie);

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(v.getContext(), idMovie)
                            .setSmallIcon(R.mipmap.love)
                            .setContentTitle("MovieAPP")
                            .setContentText("周年慶特賣開始")
                            .setAutoCancel(true);

                    //啟動通知
                    notificationManager.notify(0,builder.build());

                }
            });
        }


    }
}
