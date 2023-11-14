package smu.ai.final_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;
    TextView tv;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = findViewById(R.id.calendarView);
        tv = findViewById(R.id.textView);
        cb = findViewById(R.id.checkBox1);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = Integer.toString(year) + Integer.toString(month) + Integer.toString(dayOfMonth);
                tv.setText(date);
                cb.setVisibility(View.VISIBLE);
            }
        });
    }
