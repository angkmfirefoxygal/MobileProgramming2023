package com.example.team2app_1116;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private storyboard_todolist fragmentSearch = new storyboard_todolist();
    private chatbot_board fragmentChart = new chatbot_board();
    private HomeMain fragmentHome = new HomeMain();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentChart).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new MainActivity.ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();



            if(menuItem.getItemId()==R.id.storyboard){
                transaction.replace(R.id.menu_frame_layout, fragmentSearch).commitAllowingStateLoss();
            } else if (menuItem.getItemId()==R.id.chat_bot) {
                transaction.replace(R.id.menu_frame_layout,fragmentChart).commitAllowingStateLoss();
            }else if(menuItem.getItemId()==R.id.home){
                transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();
            }


            return true;
        }

    }
}
