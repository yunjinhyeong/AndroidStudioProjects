package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity  extends AppCompatActivity {

    //영화진흥위원회 통합전산망에서 발급받은 인증키
    String apiKey="JAaHR4jP6NVMKkIyGRNtL0j2matDnwixM3X29zOr8rDOgDYGmkZp%2F96F8lkIQI9NMXAIerd9XrCZV6Vssl4k6g%3D%3D";

    ListView listView;
    ArrayAdapter adapter;

    ArrayList<String> items=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
        //원래 layout을 .xml을 만들어야 하지만 예제이므로 안드로이에서 제공하는 것(android.R.layout.simple_list_item_1)을 사용
        listView.setAdapter(adapter);
    }

    public void clickBtn(View view) {
        //네트워크를 통해서 xml문서를 읽어오기..
        new Thread(){
            @Override
            public void run() {
                //영화진흥위원회 open API를 통해
                //일일박스오피스 정보를 가진 xml문서를
                //읽어와서 분석하여 Listview에 보여주기
                items.clear();

                Date date=new Date();//현재 날짜와 시간을 가진 객체
                date.setTime(date.getTime()-(1000*60*60*24)); //현재 날짜의 1일을 뺀 날짜

                SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd"); //SimpleDateFormat 자동으로 편리하게 포맷을 넣을 수 있다.
                String dateStr=sdf.format(date);

                String adress = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=JAaHR4jP6NVMKkIyGRNtL0j2matDnwixM3X29zOr8rDOgDYGmkZp%2F96F8lkIQI9NMXAIerd9XrCZV6Vssl4k6g%3D%3D&pageNo=1&numOfRows=20&startCreateDt=20200410&endCreateDt=20200410";

//                String adress = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey="+apiKey
//                        +"&pageNo=1&numOfRows=20&startCreateDt="+dateStr+"&endCreateDt="+dateStr+"";

                try {
                    //URL객체생성
                    URL url= new URL(adress);

                    //Stream 열기                                     //is는 바이트 스트림이라 문자열로 받기위해 isr이 필요하고 isr을 pullparser에게 줘야하는데
                    InputStream is= url.openStream(); //바이트스트림
                    //문자스트림으로 변환
                    InputStreamReader isr=new InputStreamReader(is);

                    //읽어들인 XML문서를 분석(parse)해주는 객체 생성    //pullparser를 만들려면 Factory가 필요해서 팩토리 만들고 pullparser를 만들었다. 결론, 그리고 pullparser에게 isr연결
                    XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
                    XmlPullParser xpp=factory.newPullParser();
                    xpp.setInput(isr);

                    //xpp를 이용해서 xml문서를 분석

                    //xpp.next();   //XmlPullParser는 시작부터 문서의 시작점에 있으므로 next해주면 START_DOCUMENT를 못만난다.
                    int eventType= xpp.getEventType();

                    String tagName;
                    StringBuffer buffer=null;

                    while(eventType!=XmlPullParser.END_DOCUMENT){

                        switch (eventType){
                            case XmlPullParser.START_DOCUMENT:

                                runOnUiThread(new Runnable() {  //여기는 별도 스레드이므로 화면 구성을 하려면 runOnUiThread 필요
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this,"파싱을 시작했다.",Toast.LENGTH_SHORT).show();
                                    }
                                });

                                break;

                            case XmlPullParser.START_TAG:
                                tagName=xpp.getName();
                                if(tagName.equals("item")){
                                    buffer=new StringBuffer();

                                }else if(tagName.equals("gubun")){
                                    buffer.append("도시:");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");  //아래 두줄을 한줄로 줄일 수 있다.
//                                    String text = xpp.getText();
//                                    buffer.append(text+"\n");

                                }else if(tagName.equals("defCnt")){
                                    buffer.append("전체 확진자:");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else if(tagName.equals("isolIngCnt")){
                                    buffer.append("격리중인환자수:");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");

                                }else if(tagName.equals("isolClearCnt")){
                                    buffer.append("격리해제수:");
                                    xpp.next();
                                    buffer.append(xpp.getText()+"\n");
                                }
                                break;

                            case XmlPullParser.TEXT:
                                break;

                            case XmlPullParser.END_TAG:
                                tagName = xpp.getName();
                                if(tagName.equals("item")){

                                    items.add(buffer.toString());

                                    //리스트뷰 갱신
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            adapter.notifyDataSetChanged();
                                        }
                                    });
                                }
                                break;
                        }

                        eventType=xpp.next();
                        //                        xpp.next();   //두줄을 한줄로 쓸 수 있다.
                        //                        eventType=xpp.getEventType();
                    }//while ..

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "파싱종료!!",Toast.LENGTH_SHORT).show();
                        }
                    });


                } catch (MalformedURLException e) { e.printStackTrace();} catch (IOException e) {e.printStackTrace();} catch (XmlPullParserException e) {e.printStackTrace();}


            }// run() ..
        }.start();
    }
}