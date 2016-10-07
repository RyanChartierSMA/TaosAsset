package com.example.rac.toasapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FoamFlowChart extends AppCompatActivity implements View.OnClickListener {
    /*the aim of this class is to populate a list based on the assets we have.
    Use a local database to load this information
    An array will do fine for now.
    */
    //layout that will link to xml layout to add buttons
    LinearLayout buttonHolder;
    int currentOptionNum = 4;
    int currentIndex = 0;
    Question[] masterChart;

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

        populateChart();
        drawButtons();//called after each button click, but here to force an initial draw


    }

    private void populateChart()
    //This function creates the flowchart for all assets
    //create each step in the flowchart and add it to the foam chart array
    {
        masterChart = new Question[100];//chart one to populate
        //set the questions to each index

        Question tempQ = new Question(); //for index 0

        tempQ.setQuestionText("Is there excess foam?");

        //set the 4 possible options, they link to an index on the chart.
        tempQ.setOp1(1);//pumice-like
        tempQ.setButton1Text("pumice-like");
        tempQ.setOp2(2);//grey, thick slimmy
        tempQ.setButton2Text("thick, slimmy");
        tempQ.setOp3(3);//Dark brown, thick and scummt
        tempQ.setButton3Text("Dark brown, thick and scummy");
        tempQ.setOp4(4);//bilowy, white
        tempQ.setButton4Text("bilowy, white");
        tempQ.setOptionNums(4);

        tempQ.image = new ImageView(this);
        tempQ.image.setImageResource(R.drawable.logo);//put a picture

        tempQ.setPrevious(-1);//at the start


        masterChart[0] = tempQ;//add it to index 0 of the chart

        tempQ.setQuestionText("This is the result of clicking option 1");

        tempQ = new Question();
        //set the 4 possible options, they link to an index on the chart.
        tempQ.setOp1(0);//pumice-like
        tempQ.setButton1Text("go back");
        tempQ.setOp2(0);//grey, thick slimmy
        tempQ.setButton2Text("go back");
        tempQ.setOp3(0);//Dark brown, thick and scummt
        tempQ.setButton3Text("go back");
        tempQ.setOp4(0);//bilowy, white
        tempQ.setButton4Text("go back");
        tempQ.setOptionNums(8);

        tempQ.image = new ImageView(this);
        tempQ.image.setImageResource(R.drawable.logo);//put a picture

        tempQ.setPrevious(0);//at the start

        masterChart[1] = tempQ;//add it to index 0 of the chart

        //add the question as index 0 of the temp flowchart, then when all are done, set the flowchart
        //as the flowchart for the asset.
        //TODO: create flowcharts, with indices, to translate into the array.
    }

    //this function will draw buttons to the screen depending on the number of options of the current question,
    //but for now it is going to draw the first question.
    //this function gets called after each option click
    private void drawButtons()
    {
        //update the current index













        String key = "op";
        for( int i = 1; i <= currentOptionNum; i++)//for all available options, start at op1
        {
            Button test = new Button(this);
            test.setAllCaps(false);
            String tempName = key + i;

            //assigns an id to the button depending on which button is created
            //and assigns the text to the appropiate button text
            switch (tempName)
            {
                case "op1":
                    test.setId(1);
                    test.setText(masterChart[currentIndex].getButton1Text());
                    break;
                case "op2":
                    test.setId(2);
                    test.setText(masterChart[currentIndex].getButton2Text());
                    break;
                case "op3":
                    test.setId(3);
                    test.setText(masterChart[currentIndex].getButton3Text());
                    break;
                case "op4":
                    test.setId(4);
                    test.setText(masterChart[currentIndex].getButton4Text());
                    break;
                case "op5":
                    test.setId(5);
                    test.setText(masterChart[currentIndex].getButton5Text());
                    break;
                case "op6":
                    test.setId(6);
                    test.setText(masterChart[currentIndex].getButton6Text());
                    break;
                case "op7":
                    test.setId(7);
                    test.setText(masterChart[currentIndex].getButton7Text());
                    break;
                case "op8":
                    test.setId(8);
                    test.setText(masterChart[currentIndex].getButton8Text());
                    break;
            }

            test.setOnClickListener(this);
            //all the neccessary layout-adding stuff. It adds the button to the layout.
            test.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT ));
            buttonHolder.addView(test);
        }

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case 1://load the index of the current's option 1 value
                currentIndex = masterChart[currentIndex].getOp1();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                drawButtons();//reloads the screen
                break;
        }
    }

    //loads in the index specified
    private void loadIndex(int index)
    {

    }

    //this function will update the screen to the current index's items
    private void removeButtons()
    {
        for( int i = 1; i <= currentOptionNum; i++)//for all available options, start at op1, destroy buttons
        {
            buttonHolder.removeView(findViewById(i));

        }
    }
}
