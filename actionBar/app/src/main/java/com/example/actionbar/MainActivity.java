package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabSong, tabArtist, tabAlbum;

    MyTabFragment []myFrags = new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);//View 대신 Fragment 사용 할 예정

        //1.액션바 만들기
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //1-1. 탭 만들어서 액션바에 꽂기
        tabSong = bar.newTab();
        tabSong.setText("음악별");
        //이벤트 처리 등록
        tabSong.setTabListener(this);
        bar.addTab(tabSong);

        tabArtist = bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
    {
        MyTabFragment myTabFrag = null;

        if(myFrags[tab.getPosition()] == null)
        {
            myTabFrag = new MyTabFragment();

            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());

            myTabFrag.setArguments(data);

            myFrags[tab.getPosition()] = myTabFrag;
        }
        else
        {
            myTabFrag = myFrags[tab.getPosition()];
        }

        ft.replace(android.R.id.content, myTabFrag);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}

    //2.프레그먼트 만들기 -> 내부(이너) 클래스로 만든다, 외부에 만들어도 된다
    public static class MyTabFragment extends Fragment
    {
        String tabName;
        //프레그먼트가 만들어 질 때, 액티비티(OS)와 통신이 필요할 시 설정값 세팅
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }
        //프레그먼트가 만들어지고 나서, 뷰를 생성할 때, 화면과 관련된 코드 작성
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
        {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);

            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            if(tabName == "음악별")
                baseLayout.setBackgroundColor(Color.RED);
            if(tabName == "가수별")
                baseLayout.setBackgroundColor(Color.GREEN);
            if(tabName == "앨범별")
                baseLayout.setBackgroundColor(Color.BLUE);

            return baseLayout;
        }
    }
}