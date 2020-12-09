package com.example.testxml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MainActivity";
    public String dataKey = MyConfig.da
    private String requestUrl;
    ArrayList<Item> list = null;
    Item bus = null;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

//        AsyncTask
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }

    public class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            requestUrl = "http://openapi.gbis.go.kr/ws/rest/busarrivalservice/station?serviceKey=" +dataKey+ "&stationId=200000078";
            try {
                boolean b_locationNo1 = false;
                boolean b_plateNo1 =false;
                boolean b_routeId = false;
                boolean b_stationId = false;

                URL url = new URL(requestUrl);
                InputStream is = url.openStream();
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();
                parser.setInput(new InputStreamReader(is, "UTF-8"));

                String tag;
                int eventType = parser.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    switch (eventType){
                        case XmlPullParser.START_DOCUMENT:
                            list = new ArrayList<Item>();
                            break;
                        case XmlPullParser.END_DOCUMENT:
                            break;
                        case XmlPullParser.END_TAG:
                            if(parser.getName().equals("busArrivalList") && bus != null) {
                                list.add(bus);
                            }
                            break;
                        case XmlPullParser.START_TAG:
                            if(parser.getName().equals("busArrivalList")){
                                bus = new Item();
                            }
                            if (parser.getName().equals("locationNo1")) b_locationNo1 = true;
                            if (parser.getName().equals("plateNo1")) b_plateNo1 = true;
                            if (parser.getName().equals("routeId")) b_routeId = true;
                            if (parser.getName().equals("stationId")) b_stationId = true;
                            break;
                        case XmlPullParser.TEXT:
                            if(b_locationNo1){
                                bus.setLocationNo1(parser.getText());
                                b_locationNo1 = false;
                            } else if(b_plateNo1) {
                                bus.setPlateNo1(parser.getText());
                                b_plateNo1 = false;
                            } else if (b_routeId) {
                                bus.setRouteId(parser.getText());
                                b_routeId = false;
                            } else if(b_stationId) {
                                bus.setStationId(parser.getText());
                                b_stationId = false;
                            }
                            break;
                    }
                    eventType = parser.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //어답터 연결
            MyAdapter adapter = new MyAdapter(getApplicationContext(), list);
            recyclerView.setAdapter(adapter);
        }
    }
}