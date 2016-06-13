package com.example.god.spiderwebdev2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayAdapter<String> stringArrayAdapter;
    Spinner spinner;
    Intent nextpg;
    private Button submit;
    EditText name;
    EditText rollNo;
    CheckBox tronix,ad,wd,al;
    int count=0;
    Switch confirm;
    String trans;
    RelativeLayout bg;
//created necessary variables for name,rollno,branch,profileselection,mentorship and a submit button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] dept={"ARCHI", "CS", "ECE","MECH","EEE","ICE","CHEM","CIVIL","PROD","META"};
        stringArrayAdapter=
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        dept);
        bg=(RelativeLayout)findViewById(R.id.bg);
        name=(EditText)findViewById(R.id.name);
        rollNo=(EditText)findViewById(R.id.rollNo);
        submit=(Button)findViewById(R.id.button);
        spinner = (Spinner)  findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);
        tronix=(CheckBox)findViewById(R.id.tronix);
        ad=(CheckBox)findViewById(R.id.ad);
        wd=(CheckBox)findViewById(R.id.wd);
        al=(CheckBox)findViewById(R.id.al);
        confirm=(Switch)findViewById(R.id.confirm);
        bg.setBackgroundColor(Color.GREEN);
        submit.setOnClickListener(this);

    }
//all variables set for action
    @Override
    //when submit is clicked, validation occurs
    public void onClick(View v) {
        if((tronix.isChecked()))
            count++;
        else if(ad.isChecked())
            count++;
        else if(wd.isChecked())
            count++;
        else if(al.isChecked())
            count++;
        if(name.getText().toString().equals(""))
            Toast.makeText(this, "Please enter you name", Toast.LENGTH_LONG).show();
            else if(rollNo.getText().toString().equals(""))
            Toast.makeText(this, "Please enter you rollno", Toast.LENGTH_LONG).show();
        else if(count==0)
            Toast.makeText(this, "Please check any of the profiles", Toast.LENGTH_LONG).show();
        else if(!confirm.isChecked())
            Toast.makeText(this, "Please accept the mentorship", Toast.LENGTH_LONG).show();
        else {
            nextpg = new Intent(this, finishpg.class);
            trans=name.getText().toString();
            nextpg.putExtra("transfer",trans);
            startActivity(nextpg);
        }
    }
}
