package com.example.god.spiderwebdev2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.Timestamp;

public class finishpg extends AppCompatActivity implements View.OnClickListener {

    TextView reply;
    Button back;
    Intent page1;
    String trans;
    Intent nextpg;
    TextView time;
RelativeLayout bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishpg);
        bg=(RelativeLayout)findViewById(R.id.bg);
        nextpg=getIntent();
        trans=nextpg.getStringExtra("transfer");
//value is passed from activity 1 to activity 2
        reply = (TextView) findViewById(R.id.reply);
        reply.setText("Thank you" +" " +trans+ " " + "for your reply");
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
//the name of user is stored in trans
        java.util.Date date= new java.util.Date();
        time=(TextView)findViewById(R.id.time);
        time.setText(""+(new Timestamp(date.getTime())));
        //sql is adopted to get the time
        bg.setBackgroundColor(Color.CYAN);

    }

    @Override
    public void onClick(View v) {
        page1 = new Intent(this, MainActivity.class);
        startActivity(page1);
        //a back button is placed to travel to first page
    }


}