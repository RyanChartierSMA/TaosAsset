package com.example.rac.toasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//Create the buttons for Activity_main.xml

    ImageButton troubleShootbtn, qrBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize buttons
        troubleShootbtn = (ImageButton)findViewById(R.id.trouble);
        qrBtn = (ImageButton)findViewById(R.id.qrbtn);

        //Assign the listeners to each button
        troubleShootbtn.setOnClickListener(this);
        qrBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        ImageButton pressedButton = (ImageButton)v;
        switch(pressedButton.getId()){

            case R.id.trouble:
                //Open the next window - start new intent
                Intent assetSelectionWindow = new Intent(MainActivity.this, FoamFlowChart.class);
                startActivity(assetSelectionWindow);
                break;
            case R.id.qrbtn:
                Toast toast = Toast.makeText(this, "Not yet implemented.", Toast.LENGTH_LONG);
                toast.show();
                break;

        }
    }
}
