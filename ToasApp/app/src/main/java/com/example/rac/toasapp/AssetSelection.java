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
    int currentOptionNum = 0;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_selection);



        buttonHolder = (LinearLayout)findViewById(R.id.buttonLayout);
        /*
        Button test = new Button(this);
        test.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT ));
        test.setText("Poke");
        buttonHolder.addView(test);
        //maps it so i can add buttons to it dynamically

        //this allows for adding buttons dynamically
        */

        populateLayout();
        drawButtons();


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
        tempQ.setOptionNums(4);

        tempQ.image = new ImageView(this);
        tempQ.image.setImageResource(R.drawable.logo);

        tempQ.setPrevious(-1);//at the start
        //first one, so assign it as first
        currentIndex = 0;
        currentOptionNum = tempQ.getOptionNums();

        temp.assignIndex(0, tempQ);//add it to index 0 of chart

        //add the question as index 0 of the temp flowchart, then when all are done, set the flowchart
        //as the flowchart for the asset.
        //TODO: create flowcharts, with indices, to translate into the array.
    }

    //this function will draw buttons to the screen depending on the number of options of the current question,
    //but for now it is going to draw the first question.
    private void drawButtons()
    {
        String key = "op";
        for( int i = 1; i <= currentOptionNum; i++)//for all available options, start at op1
        {
            Button test = new Button(this);
            String tempName = key + i;

            //assigns an id to the button depending on which button is created
            switch (tempName)
            {
                case "op1":
                    test.setId(1);
                    break;
                case "op2":
                    test.setId(2);
                    break;
                case "op3":
                    test.setId(3);
                    break;
                case "op4":
                    test.setId(4);
                    break;
                case "op5":
                    test.setId(5);
                    break;
                case "op6":
                    test.setId(6);
                    break;
            }

            test.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT ));
            test.setText(tempName);
            buttonHolder.addView(test);
        }

    }
}
