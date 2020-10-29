package com.example.a7_page40;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView viewName, viewEmail, toastText;
    Button btnClick;
    EditText etName, etEmail;
    View dialogView, toastView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        viewName = (TextView)findViewById(R.id.viewName);
        viewEmail = (TextView)findViewById(R.id.viewEmail);
        btnClick = (Button)findViewById(R.id.btnClick);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View)View.inflate(MainActivity.this,R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View)View.inflate(MainActivity.this,R.layout.toast,null);
                        toastText = (TextView)toastView.findViewById(R.id.toastText);
                        toastText.setText("취소했습니다.");
                        toast.setView(toastView);
                        toast.show();
                    }
                });

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etName = (EditText)dialogView.findViewById(R.id.etName);
                        etEmail = (EditText)dialogView.findViewById(R.id.etEmail);

                        viewName.setText(etName.getText().toString());
                        viewEmail.setText(etEmail.getText().toString());
                    }
                });
                dlg.show();
            }            
        });
        
        
    }
}