package com.example.weatherreport;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.weatherreport.models.MainModel;
import com.example.weatherreport.models.ChildModels.MyList;
import com.example.weatherreport.models.ChildModels.ChildModelMylist.Weather;
import com.example.weatherreport.models.WeatherForcast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends  YouTubeBaseActivity {

    private static final  String TAG="MainActivity";

    YouTubePlayer.OnInitializedListener onInitializedListener;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer tubePlayer;

    ArrayList<MainModel> mainModelArrayList= new ArrayList<>();
    ArrayList<MyList> arrayList=new ArrayList<>();
    ArrayList<Weather> weathers=new ArrayList<>();

    SearchView searchView;

    String BASE_URL="https://openweathermap.org/data/2.5/";
    String currentweatherUrl="https://openweathermap.org/data/2.5/weather?q=";
    String CityName;
    String url;
    //CURRENT WEATHER API_KEY
    String apiKey="&units=metric&appid=b6907d289e10d714a6e88b30761fae22";
    //5 DAYS FORECAST API_KEY
    String fapiKey="&units=metric&appid=405ac9c55a116da2de60b9b9512961de";
    String forcast_Url="https://api.openweathermap.org/data/2.5/forecast?q=";

    RelativeLayout relativeLayout;
    CardView cardView;
    TextView temp_txt,name_city_txt,description_txt,fiveday_title;
    ImageView current_weather_image;

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    private  String date_time;
    private  String description;
    private  double temp;
    private  String img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CHECK FOR NETWORK CONNECTION
        final ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {

        current_weather_image = (ImageView) findViewById(R.id.image_view_current);

        cardView = (CardView) findViewById(R.id.cardview);
        searchView = (SearchView) findViewById(R.id.city_search);
        temp_txt = (TextView) findViewById(R.id.temp);
        description_txt = (TextView) findViewById(R.id.description);
        name_city_txt = (TextView) findViewById(R.id.name);
        fiveday_title = (TextView) findViewById(R.id.fiveday);
        relativeLayout = (RelativeLayout) findViewById(R.id.main_relativelayout);


        cardView.setVisibility(View.GONE);
        fiveday_title.setVisibility(View.GONE);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);

        recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new RecyclerViewAdapter(this, mainModelArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

        //YOUTUBEPLAYER LOADS VIDEO BASE ON TIME ICON

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                tubePlayer = youTubePlayer;
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubePlayerView.initialize(YoutubeConfig.getApiKey(), onInitializedListener);
        youTubePlayerView.setVisibility(View.GONE);

        //SEARCHVIEW BY CITY NAME

        searchView.setFocusable(true);
        searchView.setIconified(false);

        searchView.requestFocusFromTouch();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                CityName = String.valueOf(query);
                url = currentweatherUrl + CityName + apiKey;

                //VOLLEY MAKES REQUEST FOR CURRENT WEATHER

                JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject main_object = response.getJSONObject("main");
                            JSONArray json_arry = response.getJSONArray("weather");
                            JSONObject object = json_arry.getJSONObject(0);

                            String temmp = String.valueOf(main_object.getDouble("temp"));
                            String descriptionm = object.getString("description");
                            String city = response.getString("name");
                            String current_weather = object.getString("main");
                            String icon = object.getString("icon");

                            if (!icon.isEmpty() && icon.equals("02d") || icon.toString().equals("02n")) {
                                current_weather_image.setImageResource(R.drawable.cloudsun);
                                relativeLayout.setBackgroundResource(R.drawable.sun_background);
                                youTubePlayerView.setVisibility(View.VISIBLE);
                                tubePlayer.loadVideo("dgq6x6nijfk");
                            }
                            if (!icon.isEmpty() && icon.equals("01d") || icon.toString().equals("01n")) {
                                youTubePlayerView.setVisibility(View.VISIBLE);
                                current_weather_image.setImageResource(R.drawable.sunclear);
                                relativeLayout.setBackgroundResource(R.drawable.sun_background);
                                tubePlayer.loadVideo("dgq6x6nijfk");
                            }
                            if (!icon.isEmpty() && icon.equals("03d") || icon.toString().equals("03n")) {
                                current_weather_image.setImageResource(R.drawable.cloud);
                                relativeLayout.setBackgroundResource(R.drawable.lightningstrike);
                                youTubePlayerView.setVisibility(View.VISIBLE);
                                tubePlayer.loadVideo("Wimkqo8gDZ0");
                            }
                            if (!icon.isEmpty() && icon.equals("04d") || icon.toString().equals("04n")) {
                                current_weather_image.setImageResource(R.drawable.cloudblack);
                                relativeLayout.setBackgroundResource(R.drawable.lightningstrike);
                                youTubePlayerView.setVisibility(View.VISIBLE);
                                tubePlayer.loadVideo("5Xkpot8vch4");
                            }
                            if (!icon.isEmpty() && icon.equals("09d") || icon.toString().equals("09n")) {
                                current_weather_image.setImageResource(R.drawable.cloudblackrain);
                                relativeLayout.setBackgroundResource(R.drawable.rain_backkground);
                                youTubePlayerView.setVisibility(View.VISIBLE);
                                tubePlayer.loadVideo("gVKEM4K8J8A");
                            }
                            if (!icon.isEmpty() && icon.equals("10d") || icon.toString().equals("10n")) {
                                current_weather_image.setImageResource(R.drawable.cloudrainsun);
                                relativeLayout.setBackgroundResource(R.drawable.rain_backkground);
                                youTubePlayerView.setVisibility(View.VISIBLE);
                                tubePlayer.loadVideo("QZPQ_rGNds8");
                            }
                            if (!icon.isEmpty() && icon.equals("11d") || icon.toString().equals("11n")) {
                                current_weather_image.setImageResource(R.drawable.cloudlighting);
                                relativeLayout.setBackgroundResource(R.drawable.lightningstrike);
                                youTubePlayerView.setVisibility(View.VISIBLE);
                                tubePlayer.loadVideo("gVKEM4K8J8A");
                            }
                            if (!icon.isEmpty() && icon.equals("13d") || icon.toString().equals("13n")) {
                                current_weather_image.setImageResource(R.drawable.snoflake);
                                relativeLayout.setBackgroundResource(R.drawable.snow_background);
                                youTubePlayerView.setVisibility(View.VISIBLE);
                                tubePlayer.loadVideo("NmPVhv6_bGs");
                            }
                            if (!icon.isEmpty() && icon.equals("50d") || icon.toString().equals("50n")) {
                                current_weather_image.setImageResource(R.drawable.mist);
                                relativeLayout.setBackgroundResource(R.drawable.snow_background);
                                youTubePlayerView.setVisibility(View.VISIBLE);
                                tubePlayer.loadVideo("dzsNb-LWbDU");
                            }

                            //SET VIEW VALUES
                            name_city_txt.setText("City : " + city);
                            description_txt.setText(descriptionm);
                            temp_txt.setText(temmp + " °C ");
                            cardView.setVisibility(View.VISIBLE);

                            } catch (JSONException e) {
                            e.printStackTrace();
                            }
                           if (response != null) {

                            // retrofit request method
                            fivedayRequest();
                            } else {
                            Log.d(TAG, "onFailure : Something went weong");
                            fiveday_title.setVisibility(View.VISIBLE);
                            }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onFailure : Something went weong" + error.getMessage());
                    }
                });

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(objectRequest);

                return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                return false;
            }

                });
                }
                else{
                    //ALERT DIALOG FOR INTERNET CONECTIVITY
                     new AlertDialog.Builder(MainActivity.this)
                    .setTitle("GREŠKA")
                    .setMessage("Ups,došlo je do pogreške"+"\n"+ "Provjerite da li ste povezani na internet ")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //
                            dialog.dismiss();
                        }}).show();
                    }

    }

    //RETROFIT REQUEST FOR FIVE DAYS FORCAST / 3H PERIOD

        public void fivedayRequest(){
        mainModelArrayList.clear();
        arrayList.clear();
        weathers.clear();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherInterface weatherInterface = retrofit.create(WeatherInterface.class);

        Call<WeatherForcast> call = weatherInterface.getData(forcast_Url + CityName + fapiKey);
        call.enqueue(new Callback<WeatherForcast>() {
                    @Override public void onResponse(Call<WeatherForcast> call, retrofit2.Response<WeatherForcast> response) {
                    arrayList = response.body().getList();
                    for (int i = 0; i < arrayList.size(); i++) {
                    temp = arrayList.get(i).getMain().getTemp();
                    date_time = arrayList.get(i).getDt_txt();
                    weathers = (ArrayList<Weather>) arrayList.get(i).getWeather();
                    for (int j = 0; j < weathers.size(); j++) {
                        img = weathers.get(j).getIcon();
                        description = weathers.get(j).getDescription();
                    }
                    MainModel mainModel = new MainModel(date_time, temp, img, description);
                    mainModelArrayList.add(mainModel);
                    recyclerViewAdapter.notifyDataSetChanged();
                    fiveday_title.setVisibility(View.VISIBLE);
                    } }
                   @Override
                    public void onFailure (Call < WeatherForcast > call, Throwable t){
                    Log.d(TAG, "onFailure : Something went weong" + t.getMessage());
                   }

                   });
    }}
