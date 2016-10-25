package com.example.rac.toasapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FoamFlowChart extends AppCompatActivity implements View.OnClickListener {
    /*the aim of this class is to populate a list based on the assets we have.
    Use a local database to load this information
    An array will do fine for now.
    Can support up to 8 options per question
    */
    //layout that will link to xml layout to add buttons
    LinearLayout buttonHolder;
    int currentOptionNum = 4;
    int currentIndex = 0;
    Question[] masterChart;
    final int weightOfButtons = 70;//used to make buttons fit nicer.
                                   //image, textview, and one space take up 30.
    float weightPerButton;//assigned during button creation


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

        Question tempQ = new Question(); //for index
//------------------------------------------------------------ Setup index 0
        tempQ.setQuestionText("Is there excess foam?");

        //set the 4 possible options, they link to an index on the chart.
        //set images by id
        tempQ.setOp1(1);//pumice-like
        //add button image.
        tempQ.setOp1bImage(R.drawable.pmcbtn);
        tempQ.setButton1Text("pumice-like");
        tempQ.setOp2(2);//grey, thick slimmy
        tempQ.setOp2bImage(R.drawable.slmybtn);
        tempQ.setButton2Text("thick, slimmy");
        tempQ.setOp3(3);//Dark brown, thick and scummt
        tempQ.setButton3Text("Dark brown, thick and scummy");
        tempQ.setOp3bImage(R.drawable.dkbrnthkbtn);
        tempQ.setOp4(4);//bilowy, white
        tempQ.setButton4Text("bilowy, white");
        tempQ.setOp4bImage(R.drawable.whtblybtn);
        tempQ.setOptionNums(4);

        tempQ.image = new ImageView(this);
        tempQ.image.setImageResource(R.drawable.logo);//put a picture

        tempQ.setPrevious(-1);//at the start

        masterChart[0] = tempQ;//add it to index 0 of the chart

//--------------------------------------------------------------Setup index 1

        tempQ.setQuestionText("Solids return from sludge processing. Try to reduce the solid return by improving the solids capture in sludge processing.");

        tempQ = new Question();
        tempQ.setOp1(-2);
        tempQ.setButton1Text("");
        tempQ.setOp2(-2);
        tempQ.setOp2bImage(R.drawable.logo);
        tempQ.setButton2Text("");
        tempQ.setOp3(-2);
        tempQ.setButton3Text("");
        tempQ.setOp4(-2);
        tempQ.setButton4Text("");
        tempQ.setOptionNums(4);
        tempQ.setPrevious(0);//at the start

        tempQ.image = new ImageView(this);
        tempQ.image.setImageResource(R.drawable.logo);//put a picture

        masterChart[1] = tempQ;//add it to index 0 of the chart

//-------------------------------------------------------------Setup index 2


        //add the question as index 0 of the temp flowchart, then when all are done, set the flowchart
        //as the flowchart for the asset.
        //TODO: create flowcharts, with indices, to translate into the array.
    }

    //this function will draw buttons to the screen depending on the number of options of the current question,
    //but for now it is going to draw the first question.
    //this function gets called after each option click
    //automated button creation by creating button 1 to i
    private void drawButtons()
    {
        String key = "op";
        currentOptionNum = masterChart[currentIndex].getOptionNums();
        //-----------------------layout stuff----------------------
        weightPerButton = weightOfButtons/ currentOptionNum;
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0);
        //----------------------end layout stuff----------------------



        //assigns the buttons an equal weight, cumulative to 60.
        for( int i = 1; i <= currentOptionNum; i++)//for all available options, start at op1
        {
            boolean enabledButton = true;//used for enable/disable button based on -2 index
            ImageButton test = new ImageButton(this);
            test.setAdjustViewBounds(true);//fixes the image scale bug
            String tempName = key + i;

            //assigns an id to the button depending on which button is created
            //and assigns the text to the appropiate button text
            /*
                each question contains an image for op1 -opn buttons. They are loaded below, based
                on which butotn it is. An id is assigned, 1 to n, for each button. Buttons are
                destroyed after each click and reloaded, so the ids can be resused.
            */

            switch (tempName)
            {
                case "op1":
                    //test = masterChart[currentIndex].getOp1b();
                    test.setImageResource(masterChart[currentIndex].getOp1Image());
                    test.setId(1);
                    //test.setText(masterChart[currentIndex].getButton1Text());
                    if(masterChart[currentIndex].getOp1() == -2)
                        enabledButton = false;
                    break;
                case "op2":
                    test.setImageResource(masterChart[currentIndex].getOp2bImage());
                    test.setId(2);
                    //test.setText(masterChart[currentIndex].getButton2Text());
                    break;
                case "op3":
                    test.setImageResource(masterChart[currentIndex].getOp3bImage());
                    test.setId(3);
                    //test.setText(masterChart[currentIndex].getButton3Text());
                    break;
                case "op4":
                    test.setImageResource(masterChart[currentIndex].getOp4bImage());
                    test.setId(4);
                   // test.setText(masterChart[currentIndex].getButton4Text());
                    break;
                case "op5":
                    test.setId(5);
                    //test.setText(masterChart[currentIndex].getButton5Text());
                    break;
                case "op6":
                    test.setId(6);
                    //test.setText(masterChart[currentIndex].getButton6Text());
                    break;
                case "op7":
                    test.setId(7);
                    //test.setText(masterChart[currentIndex].getButton7Text());
                    break;
                case "op8":
                    test.setId(8);
                    //test.setText(masterChart[currentIndex].getButton8Text());
                    break;
            }

            test.setOnClickListener(this);
            //all the neccessary layout-adding stuff. It adds the button to the layout.
            p.weight = weightPerButton;
            test.setScaleType(ImageView.ScaleType.FIT_XY);
            test.setLayoutParams(p);
            test.setEnabled(enabledButton);
            buttonHolder.addView(test);
        }
    }

    @Override
    public void onClick(View v) {


        switch(v.getId())
        {
            //case x:
            //      update to option x of the next index
            //      remove the buttons from view
            //      update current number of options for button creation purposes
            //      recalculate weight per button based on new number of options
            //      draw the new buttons, one for each option

            case 1://load the index of the current's option 1 value
                currentIndex = masterChart[currentIndex].getOp1();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                weightPerButton = weightOfButtons/currentOptionNum;
                drawButtons();//reloads the screen
                break;

            case 2:
                currentIndex = masterChart[currentIndex].getOp2();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                weightPerButton = weightOfButtons/currentOptionNum;
                drawButtons();//reloads the screen
                break;

            case 3:
                currentIndex = masterChart[currentIndex].getOp3();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                weightPerButton = weightOfButtons/currentOptionNum;
                drawButtons();//reloads the screen
                break;
            case 4:
                currentIndex = masterChart[currentIndex].getOp4();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                weightPerButton = weightOfButtons/currentOptionNum;
                drawButtons();//reloads the screen
                break;

            case 5:
                currentIndex = masterChart[currentIndex].getOp5();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                weightPerButton = weightOfButtons/currentOptionNum;
                drawButtons();//reloads the screen
                break;

            case 6:
                currentIndex = masterChart[currentIndex].getOp6();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                weightPerButton = weightOfButtons/currentOptionNum;
                drawButtons();//reloads the screen
                break;

            case 7:
                currentIndex = masterChart[currentIndex].getOp7();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                weightPerButton = weightOfButtons/currentOptionNum;
                drawButtons();//reloads the screen
                break;

            case 8:
                currentIndex = masterChart[currentIndex].getOp8();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                weightPerButton = weightOfButtons/currentOptionNum;
                drawButtons();//reloads the screen
                break;
        }
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
