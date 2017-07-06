package com.example.dholme22.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton settings = (ImageButton) findViewById(R.id.setBtn);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView txtView = (TextView)findViewById(R.id.txtView);
                //txtView.setText("The button was clicked!!");
                Intent toy = new Intent(MainActivity.this, second.class);
                startActivity(toy);
            }
        });


        ImageButton sound = (ImageButton) findViewById(R.id.sndBtn);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView txtView = (TextView)findViewById(R.id.txtView);
                //txtView.setText("The button was clicked!!");
                Intent toy = new Intent(MainActivity.this, second.class);
                startActivity(toy);
            }
        });


        ImageView text = (ImageView) findViewById(R.id.imageView);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView txtView = (TextView)findViewById(R.id.txtView);
                //txtView.setText("The button was clicked!!");
                Intent toy = new Intent(MainActivity.this, second.class);
                startActivity(toy);
            }
        });

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(400); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        text.startAnimation(anim);

        /*
        Button btn = (Button)findViewById(R.id.btn);
        setTitle("Main Activity");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView txtView = (TextView)findViewById(R.id.txtView);
                //txtView.setText("The button was clicked!!");
                Intent toy = new Intent(MainActivity.this, second.class);
                startActivity(toy);
            }
        });
*/

    }
}
