package com.example.myproject2svetofor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout bulb1,bulb2,bulb3;
    private boolean start_stop = false;
    private Button buttonLight;
    private int counter = 0;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bulb1 = findViewById(R.id.bulb1);
        bulb2 = findViewById(R.id.bulb2);
        bulb3 = findViewById(R.id.bulb3);
        buttonLight = findViewById(R.id.buttonLight);

    }

    public void onClickStart(View view) {
        if (!start_stop) {
            buttonLight.setText("STOP");

            buttonLight.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
            start_stop = true;

            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (start_stop) {
                        counter++;
                        switch (counter){
                            case 1:
                                bulb1.setBackgroundColor(ContextCompat.getColor(context,R.color.green));
                                bulb2.setBackgroundColor(ContextCompat.getColor(context,R.color.grey));
                                bulb3.setBackgroundColor(ContextCompat.getColor(context,R.color.grey));

                                break;
                            case 2:
                                bulb1.setBackgroundColor(ContextCompat.getColor(context,R.color.grey));
                                bulb2.setBackgroundColor(ContextCompat.getColor(context,R.color.yellow));
                                bulb3.setBackgroundColor(ContextCompat.getColor(context,R.color.grey));
                                break;
                            case 3:
                                bulb1.setBackgroundColor(ContextCompat.getColor(context,R.color.grey));
                                bulb2.setBackgroundColor(ContextCompat.getColor(context,R.color.grey));
                                bulb3.setBackgroundColor(ContextCompat.getColor(context,R.color.red));
                                counter = 0;
                                break;
                        }



                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


        }
        else{
            start_stop = false;
            buttonLight.setText("START");
            buttonLight.setBackgroundColor(ContextCompat.getColor(context, R.color.green));

        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;

    }
}