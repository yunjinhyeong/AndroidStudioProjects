public class MainActivity extends ActionBarActivity {
    final int DIALOG_MULTICHOICE = 4; // 다이얼로그용 ID
    TextView tv; // 결과값 출력용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView2);
        findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_MULTICHOICE);
            }
        });
    } // end of onCreate

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        switch(id) {
            case DIALOG_MULTICHOICE :
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(MainActivity.this);

                final String data []   = {"한국","북한","소련","영국"};
                final boolean checked[]= {true,  false, true,  false};

                builder    .setTitle("MuiltiChoice 다이얼로그 제목")
                        .setPositiveButton("선택완료",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String str = "선택된 값은 : ";
                                        for (int i = 0; i < checked.length; i++) {
                                            if (checked[i]) {
                                                str = str + data[i] +", ";
                                            }
                                        }
                                        tv.setText(str);
                                    }
                                })
                        .setNegativeButton("취소", null)
                        .setMultiChoiceItems
                                (data, // 체크박스 리스트 항목
                                        checked, // 초기값(선택여부) 배열
                                        new OnMultiChoiceClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which, boolean isChecked) {
                                                checked[which] = isChecked;
                                            }
                                        }); // 리스너
                return builder.create(); // 다이얼로그 생성해서 리턴
        }

        return super.onCreateDialog(id);
    }
} // end of class


출처: https://bitsoul.tistory.com/17 [Happy Programmer~]