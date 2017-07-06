package com.example.dholme22.myfirstapp;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;

import java.util.Random;

public class second extends AppCompatActivity {
    int loop = 0;
    boolean clickedOnce = false;
    boolean clickedEarly = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second Activity");
        final TextView txtV2 = (TextView) findViewById(R.id.txtV2);

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                if (loop == 0) {
                    txtV2.setText("Loading   ");
                    loop++;
                }
                else if (loop == 1) {
                    txtV2.setText("Loading.  ");
                    loop++;
                }
                else if (loop == 2) {
                    txtV2.setText("Loading.. ");
                    loop++;
                }
                else if (loop == 3) {
                    txtV2.setText("Loading...");
                    loop = 0;
                }
            }

            public void onFinish() {
                tap();
            }
        }.start();

    }


    public void tap(){
        final TextView txtV1 = (TextView) findViewById(R.id.txtV1);
        final TextView txtV2 = (TextView) findViewById(R.id.txtV2);
        final TextView txtV3 = (TextView) findViewById(R.id.txtV3);
        final TextView txtV4 = (TextView) findViewById(R.id.txtV4);
        txtV1.setTextColor(Color.parseColor("#ffffff"));
        txtV2.setTextColor(Color.parseColor("#ffffff"));
        final RelativeLayout slay = (RelativeLayout) findViewById(R.id.layOut);
        Random r = new Random();
        int rand = r.nextInt(15 - 5) + 5;
        rand = rand * 1000;

        new CountDownTimer(rand, 1000) {

            public void onTick(long millisUntilFinished) {
                slay.setBackgroundColor(Color.parseColor("#cc0000"));

                txtV1.setText("");
                txtV4.setText("Wait");
                txtV2.setText("Tap screen when you see 'Attack!");

                slay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (clickedEarly == false) {
                            cancel();
                            slay.setBackgroundColor(Color.parseColor("#3385ff"));
                            txtV4.setText("Too soon!");
                            txtV2.setText("Tap screen to try again.");
                            clickedEarly = true;
                        }
                        else{
                            clickedEarly = false;
                            txtV4.setText("");
                            txtV2.setText("");
                            slay.setOnClickListener(null);
                            tap();

                        }
                    }
                });

            }

            public void onFinish() {
                slay.setBackgroundColor(Color.parseColor("#33cc33"));
                txtV4.setText("Attack!");
                final long startTime = SystemClock.uptimeMillis();
                txtV2.setText("");

                slay.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (clickedOnce == false) {
                            long endTime = SystemClock.uptimeMillis();
                            long reactTime = endTime - startTime;
                            slay.setBackgroundColor(Color.parseColor("#3385ff"));
                            txtV4.setText("");
                            txtV3.setText("Screen was tapped!\nReaction Time: " + reactTime + "ms\n\n");
                            txtV2.setText("Tap screen to try again.");
                            clickedOnce = true;
                        }
                        else{
                            clickedOnce = false;
                            txtV3.setText("");
                            txtV2.setText("");
                            slay.setOnClickListener(null);
                            tap();

                        }
                    }
                });


            }
        }.start();
    }

}
