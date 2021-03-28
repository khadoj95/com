package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button bt;
private String somme;
private EditText a,b,c;
@Override

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        bt.setOnClickListener(this);

        }
public void initViews(){
        bt=findViewById(R.id.bt);
        a=findViewById(R.id.a);
        b=findViewById(R.id.b);
        c=findViewById(R.id.c);

        }

@Override
public void onClick(View v){
        if ((v.getId()==R.id.bt)){

                Intent in =new Intent (MainActivity.this,SecondeActivite.class);
                in.putExtra("A",a.getText().toString());
                in.putExtra("B",b.getText().toString());
                in.putExtra("C",c.getText().toString());
                startActivity(in);


        }
        }

        }

