package com.example.rac.toasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//Create the buttons for Activity_main.xml

    Button troubleShootbtn;
    Button bt2;
    Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize buttons
        troubleShootbtn = (Button)findViewById(R.id.trouble);
        bt2 = (Button)findViewById(R.id.bt2);
        bt3 = (Button)findViewById(R.id.bt3);

    }

    @Override
    public void onClick(View v) {

        Button pressedButton = (Button)v;
        switch(pressedButton.getText().toString()){

            case "TroubleShoot":
                //Open the next window - start new intent
                break;

        }
    }
}
