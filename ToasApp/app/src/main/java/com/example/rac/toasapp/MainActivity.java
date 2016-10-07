package com.example.rac.toasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        //Assign the listeners to each button
        troubleShootbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Button pressedButton = (Button)v;
        switch(pressedButton.getText().toString()){

            case "Troubleshoot":
                //Open the next window - start new intent
                Intent assetSelectionWindow = new Intent(MainActivity.this, FoamFlowChart.class);
                startActivity(assetSelectionWindow);
                break;

        }
    }
}
