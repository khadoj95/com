package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button bt;
    private TextView n,g,t;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        bt.setOnClickListener(this);
        dataconfig();
    }
    public void initViews(){
        bt=findViewById(R.id.bt);
        n=findViewById(R.id.n);
        g=findViewById(R.id.g);
        t=findViewById(R.id.t);

    }
    public void  dataconfig(){
        t.setText(getIntent().getStringExtra("T"));
        n.setText(getIntent().getStringExtra("N"));

        g.setText(getIntent().getStringExtra("G"));
    }

    @Override
    public void onClick(View v){
        if ((v.getId()==R.id.bt)){

            Intent in =new Intent (MainActivity.this,Secondeactivite.class);
            in.putExtra("n",n.getText().toString());
            in.putExtra("g",g.getText().toString());
            in.putExtra("t",t.getText().toString());
            startActivity(in);


        }

    }

}