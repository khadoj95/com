package com.example.sujet5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.security.identity.ResultData;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity  implements  NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    private DrawerLayout drawer;
    private Button button;
    public   int status = 0;
    TextView text2;
    Handler handler = new Handler();
    ProgressDialog progressDialog;

    private FragmentManager getSupportFragmentManager;

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
                System.exit(1);
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace (R.id.fragment_container,new AboutFragment()).commit();
                break;
            case R.id.nav_history:

                getSupportFragmentManager().beginTransaction().replace (R.id.fragment_container,new History()).commit();
                break;
            case R.id.nav_newgame:
onClick(findViewById(R.id.nav_newgame));
               break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

  public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.french) {
            Toast.makeText(getApplicationContext(), "translating in french...",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.english) {
            Toast.makeText(getApplicationContext(), "translating in english...",
                    Toast.LENGTH_SHORT).show();
        }
        return true;

}

    @Override
    public void onClick(View v){
        progressDialog =new ProgressDialog(MainActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progressd);
        text2=progressDialog.findViewById(R.id.T1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (status < 100) {
                    status += 1;
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            text2.setText(String.valueOf(status));
                            if (status == 100) {
                                progressDialog.cancel();
                                status=0;
                                boolean runningThread =false;
                                getSupportFragmentManager().beginTransaction().replace (R.id.fragment_container,new NewGameFragment()).commit();
                            }
                        }
                    });
                }
            }
        }).start();

    }
}
