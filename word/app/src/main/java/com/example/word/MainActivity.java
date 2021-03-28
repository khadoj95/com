package com.example.word;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.content.ClipData;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity  implements  NavigationView.OnNavigationItemSelectedListener {
 private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       getToolBar();
     getNavigationBar();

    }
    public void getToolBar(){
       Toolbar toolbar = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar);
    }
    public void getNavigationBar(){
        drawer = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle( this, drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_Close);
        drawer.addDrawerListener(toogle);
        toogle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.nav_exit:
               android.os.Process.killProcess(android.os.Process.myPid());
               System.exit(1);
               break;
           case R.id.nav_about:

               getSupportFragmentManager().beginTransaction().replace (R.id.fragment_container,new AboutFragment()).commit();
               break;
           case R.id.nav_newgame:

               getSupportFragmentManager().beginTransaction().replace (R.id.fragment_container,new NewGameFragment()).commit();
               break;
       }
       drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
        super.onBackPressed();
    }
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.french) {
            Toast.makeText(getApplicationContext(), "you click translate in french",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.english) {
            Toast.makeText(getApplicationContext(), "you click translate in english",
                    Toast.LENGTH_SHORT).show();
        }
        return true;
    }


}
