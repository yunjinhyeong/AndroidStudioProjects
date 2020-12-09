package com.example.testxmlgo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    TextView text;
    XmlPullParser xpp;

    String key="JAaHR4jP6NVMKkIyGRNtL0j2matDnwixM3X29zOr8rDOgDYGmkZp%2F96F8lkIQI9NMXAIerd9XrCZV6Vssl4k6g%3D%3D";
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit= (EditText)findViewById(R.id.edit);
        text= (TextView)findViewById(R.id.result);

    }
    public void mOnClick(View v){
        switch (v.getId()){
            case R.id.button:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        data=getXmlData();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(data);
                            }
                        });
                    }
                }).start();
                break;
        }
    }
    String getXmlData(){
        StringBuffer buffer=new StringBuffer();
        String str= edit.getText().toString();//EditText에 작성된 Text얻어오기
//        String location = URLEncoder.encode(str);
//        String query="%EC%A0%84%EB%A0%A5%EB%A1%9C";

        String queryUrl="http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey="+key+"&pageNo=1&numOfRows=20&startCreateDt=20200410&endCreateDt="+str+"";
        try{
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();//xml파싱을 위한
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();
            while( eventType != XmlPullParser.END_DOCUMENT ){
                switch( eventType ){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//테그 이름 얻어오기

                        if(tag.equals("item")) ;// 첫번째 검색결과
                        else if(tag.equals("createDt")){
                            buffer.append("createDt : ");
                            xpp.next();
                            buffer.append(xpp.getText());//title 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("deathCnt")){
                            buffer.append("deathCnt : ");
                            xpp.next();
                            buffer.append(xpp.getText());//category 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");//줄바꿈 문자 추가
                        }
                        else if(tag.equals("defCnt")){
                            buffer.append("defCnt :");
                            xpp.next();
                            buffer.append(xpp.getText());//description 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");//줄바꿈 문자 추가
                        }
                        else if(tag.equals("gubun")){
                            buffer.append("gubun :");
                            xpp.next();
                            buffer.append(xpp.getText());//telephone 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");//줄바꿈 문자 추가
                        }
                        else if(tag.equals("incDec")){
                            buffer.append("incDec :");
                            xpp.next();
                            buffer.append(xpp.getText());//address 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");//줄바꿈 문자 추가
                        }
                        else if(tag.equals("isolClearCnt")){
                            buffer.append("isolClearCnt :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapx 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("  ,  "); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("isolIngCnt")){
                            buffer.append("isolIngCnt :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapy 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("localOccCnt")){
                            buffer.append("localOccCnt :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapy 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("overFlowCnt")){
                            buffer.append("overFlowCnt :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapy 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("qurRate")){
                            buffer.append("qurRate :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapy 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("seq")){
                            buffer.append("seq :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapy 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        else if(tag.equals("stdDay")){
                            buffer.append("stdDay :");
                            xpp.next();
                            buffer.append(xpp.getText());//mapy 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n"); //줄바꿈 문자 추가
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //테그 이름 얻어오기

                        if(tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈
                        break;
                }

                eventType= xpp.next();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        buffer.append("파싱 끝\n");
        return buffer.toString();//StringBuffer 문자열 객체 반환

    }//getXmlData method....
}