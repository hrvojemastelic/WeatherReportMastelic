package com.example.weatherreport;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.weatherreport.models.MainModel;
import com.example.weatherreport.models.WeatherForcast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyView> {

    Context context;


    ArrayList <MainModel> mainModelArrayList= new ArrayList<>();


    public RecyclerViewAdapter(Context context, ArrayList<MainModel> mainModelArrayList) {
        this.context = context;
        this.mainModelArrayList=mainModelArrayList;

    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.weather_item_layout,parent,false);

        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        MainModel mainModel= mainModelArrayList.get(position);
        holder.cardView.setBackgroundResource(R.color.transGray);

        holder.date.setText(mainModel.getDate_time());
        holder.temoerature.setText(String.valueOf(mainModel.getTemp() + "°C"));
        holder.description.setText(String.valueOf(mainModel.getDescription()));

        if (mainModel.getImg().toString().matches("10n")||mainModel.getImg().toString().matches("10d")){
            holder.weather_image.setImageResource(R.drawable.cloudrainsun);
        }if (mainModel.getImg().toString().matches("04d")||mainModel.getImg().toString().matches("04n")){
            holder.weather_image.setImageResource(R.drawable.cloudblack);
        }
        if (mainModel.getImg().toString().matches("01n")||mainModel.getImg().toString().matches("01d")){
            holder.weather_image.setImageResource(R.drawable.sunclear);
        }
        if (mainModel.getImg().toString().matches("02d")||mainModel.getImg().toString().matches("02n")){
            holder.weather_image.setImageResource(R.drawable.cloudsun);
        }
        if (mainModel.getImg().toString().matches("03n")||mainModel.getImg().toString().matches("03d")){
            holder.weather_image.setImageResource(R.drawable.cloud);
        }
        if (mainModel.getImg().toString().matches("09d")||mainModel.getImg().toString().matches("09n")){
            holder.weather_image.setImageResource(R.drawable.cloudblackrain);
        }
        if (mainModel.getImg().toString().matches("11d")||mainModel.getImg().toString().matches("11n")){
            holder.weather_image.setImageResource(R.drawable.cloudblackrain);
        }
        if (mainModel.getImg().toString().matches("13d")||mainModel.getImg().toString().matches("13n")){
            holder.weather_image.setImageResource(R.drawable.cloudblackrain);
        }
        if (mainModel.getImg().toString().matches("50d")||mainModel.getImg().toString().matches("50n")){
            holder.weather_image.setImageResource(R.drawable.cloudblackrain);
        }





    }

    @Override
    public int getItemCount() {
        return mainModelArrayList.size();
    }

    public class MyView extends RecyclerView.ViewHolder {
        TextView date,temoerature,description;
        ImageView weather_image;
        CardView cardView;

        public MyView(@NonNull View itemView) {
            super(itemView);

            cardView=(CardView)itemView.findViewById(R.id.cardview_item);
            date=(TextView)itemView.findViewById(R.id.text_date);
            description=(TextView)itemView.findViewById(R.id.txt_description);
            temoerature=(TextView)itemView.findViewById(R.id.txt_temperature);
            weather_image=(ImageView)itemView.findViewById(R.id.img_waether);




        }
    }
}
