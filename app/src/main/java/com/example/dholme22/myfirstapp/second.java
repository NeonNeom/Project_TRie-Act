package com.example.dholme22.myfirstapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class second extends AppCompatActivity {
    int loop = 0;
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
        Random r = new Random();
        int rand = r.nextInt(15 - 5) + 5;
        rand = rand * 1000;
        new CountDownTimer(rand, 1000) {

            public void onTick(long millisUntilFinished) {
                txtV1.setText("Wait");
                txtV2.setText("Tap screen when you see 'Attack!");
            }

            public void onFinish() {
                txtV1.setText("Attack!");
                txtV2.setText("");
            }
        }.start();
    }


}
