package com.example.a7_page23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    LinearLayout baseLayout;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기(컨텍스트 메뉴)");
        baseLayout = (LinearLayout)findViewById(R.id.baseLayout);
        button1 = (Button)findViewById(R.id.button1);
        registerForContextMenu(button1);
        button2 = (Button)findViewById(R.id.button2);
        registerForContextMenu(button2); //컨텍스트 메뉴가 연결되어야 하는 View를 등록합니다. 이를 위해서는 registerForContextMenu()를 호출하고 여기에 View를 전달하면 됩니다.
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();

        if(v == button1){
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.menu1, menu);
        }
        if(v == button2){
            menu.setHeaderTitle("버튼 변경");
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subRotate:
                button2.setRotation(45);
                return true;
            case R.id.subSize:
                button2.setScaleX(2);
                return true;
        }
        return false;
    }
}