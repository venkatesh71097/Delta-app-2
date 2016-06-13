package com.example.god.speechapp;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView resulttext;
    ImageView img_animation;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resulttext = (TextView) findViewById(R.id.TVresult);
        img_animation = (ImageView) findViewById(R.id.draw);
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.shape) {
    promptSpeechInput();
}
}

    private void promptSpeechInput() {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");
        startActivityForResult(i,100);
    }

    public void onActivityResult(int request_code, int result_code, Intent i)
    {

        super.onActivityResult(request_code, result_code, i);

                if (request_code == 100 && result_code == RESULT_OK )
                {
                    ArrayList<String> result = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    resulttext.setText(result.get(0));
                    str=result.get(0);
                    if(str=="left") {
                        TranslateAnimation animation = new TranslateAnimation(0, -10,
                                0,0);//  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                        animation.setDuration(5000);// animation duration
                        animation.setRepeatCount(1);// animation repeat count
                        animation.setRepeatMode(2); // repeat animation (left to right, right to left )
                        animation.setFillAfter(true);
                        img_animation.startAnimation(animation);// start animation
                    }
                    if(str=="top") {
                        TranslateAnimation animation = new TranslateAnimation(0,0,0,-10);//  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                        animation.setDuration(5000);// animation duration
                        animation.setRepeatCount(1);// animation repeat count
                        animation.setRepeatMode(2); // repeat animation (left to right, right to left )
                        animation.setFillAfter(true);
                        img_animation.startAnimation(animation);// start animation
                    }
                    if(str=="right") {

                        TranslateAnimation animation = new TranslateAnimation(0, 10,
                                0,0);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                        animation.setDuration(5000);  // animation duration
                        animation.setRepeatCount(1);  // animation repeat count
                        animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
                        animation.setFillAfter(true);

                        img_animation.startAnimation(animation);  // start animation
                    }

                    if(str=="bottom") {
                        TranslateAnimation animation = new TranslateAnimation(0,0,
                                0,10);//  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                        animation.setDuration(5000); // animation duration
                        animation.setRepeatCount(1);// animation repeat count
                        animation.setRepeatMode(2); // repeat animation (left to right, right to left )
                        animation.setFillAfter(true);
                        img_animation.startAnimation(animation);// start animation
                    }

                }
    }
}
