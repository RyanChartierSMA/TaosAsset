package com.example.rac.toasapp;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static com.example.rac.toasapp.R.drawable.logo;

public class AssetSelection extends AppCompatActivity {
    /*the aim of this class is to populate a list based on the assets we have.
    Use a local database to load this information
    An array will do fine for now.
    */
    //layout that will link to xml layout to add buttons
    LinearLayout buttonHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        buttonHolder = (LinearLayout)findViewById(R.id.buttonLayout);
        Button test = new Button(this);
        test.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT ));
        test.setText("Poke");
        buttonHolder.addView(test);
        //maps it so i can add buttons to it dynamically

        //this allows for adding buttons dynamically
        */

        populateLayout();

    }

    private void populateLayout()
    //make an asset, then create an assetflowchart, create questions and assing them, then assigned flowchart to asset
    {
        Asset tank = new Asset();
        tank.setAge(6);// years
        tank.setCost(5000); //cost per year
        tank.setExpectedLife(5);// years
        tank.setAssetDesc("A tank that holds stuff. In this case, sludge");

        //The tank is created, now create the sludge problem it may have.

        AssetFlowChart temp = new AssetFlowChart();//temp one to populate
        //set the questions to each index

        Question tempQ = new Question(); //for index 0
        tempQ.setQuestionText("Is there excess foam?");
        //set the 4 possible options
        tempQ.setOp1(1);//pumice-like
        tempQ.setOp2(2);//grey, thick slimmy
        tempQ.setOp3(3);//Dark brown, thick and scummt
        tempQ.setOp4(4);//bilowy, white


        tempQ.image = new ImageView(this);
        tempQ.image.setImageResource(R.drawable.logo);

        tempQ.setPrevious(-1);//at the start

        temp.assignIndex(0, tempQ);*/

        //add the question as index 0 of the temp flowchart, then when all are done, set the flowchart
        //as the flowchart for the asset.
        //TODO: create flowcharts, with indices, to translate into the array.
    }
}
