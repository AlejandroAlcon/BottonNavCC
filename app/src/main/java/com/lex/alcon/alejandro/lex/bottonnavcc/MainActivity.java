package com.lex.alcon.alejandro.lex.bottonnavcc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = findViewById(R.id.nav_view);
        BottonNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        selectedFragment = HomeActivity.newInstance();
                        break;
                    case R.id.navigation_dashboard:
                        selectedFragment = DashboardActivity.newInstance();
                        //selectedFragment.setArguments(bundle1);
                        break;
                    case R.id.navigation_notifications:
                        selectedFragment = NotificationsActivity.newInstance();
                        break;
                    case R.id.navigation_profile:
                        selectedFragment = ProfileActivity.newInstance();
                        break;


                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, selectedFragment);
                transaction.commit();
                return true;

            }
        });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, HomeActivity.newInstance());
        transaction.commit();




    }

}
