package com.example.acivitychange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar bottomAppBar;
    private int bottomAppBarState = 0;

    CalendarView calendar;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = Integer.toString(year) + " . " + Integer.toString(month) + " . " + Integer.toString(dayOfMonth);
            }
        });

        //imageButton 사용 위한 코드
        ImageButton plusbtn = findViewById(R.id.imageButton);
        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(getApplicationContext(),v);
                getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getItemId()==R.id.menu_todolist){
                            Intent intent = new Intent(MainActivity.this, SubActivity.class);

                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "to do list", Toast.LENGTH_SHORT).show();
                        }else if(menuItem.getItemId()==R.id.menu_diary){
                            Intent intent = new Intent(MainActivity.this, DiaryActivity.class);
                            Bundle extras = new Bundle();
                            extras.putString("date", date);
                            intent.putExtras(extras);
                            startActivity(intent);

                            Toast.makeText(MainActivity.this, "diary", Toast.LENGTH_SHORT).show();
                        } else if (menuItem.getItemId()==R.id.library) {
                            Intent intent = new Intent(MainActivity.this, Libarary.class);
                            Bundle extras = new Bundle();
                            extras.putString("date", date);
                            intent.putExtras(extras);
                            startActivity(intent);

                        } else{
                            Toast.makeText(MainActivity.this, "etc",Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
            popupMenu.show();
        //onClick();
            }

        });



        //Activity 이동 위한 버튼
        Button button1 = findViewById(R.id.button1); //xml에서 생성한 id 매치
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        //버튼에 클릭 이벤트 적용
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트 선언 및 정의
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                //액티비티 이동
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                startActivity(intent);

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);

                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_actions, menu) ;

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.back){
            // 전 액티비티 인텐트
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
}
