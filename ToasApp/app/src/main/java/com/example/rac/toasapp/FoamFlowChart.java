package com.example.rac.toasapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.duration;

public class FoamFlowChart extends AppCompatActivity implements View.OnClickListener {
    /*the aim of this class is to populate a list based on the assets we have.
    Use a local database to load this information
    An array will do fine for now.
    Can support up to 8 options per question
    */
    //layout that will link to xml layout to add buttons
    LinearLayout buttonHolder;
    TextView desc;
    ImageView headerImage;
    int currentOptionNum = 4;
    int currentIndex = 0;
    Question[] masterChart;
    final int weightOfButtons = 66;//used to make buttons fit nicer.
                                   //image, textview, and one space take up 30.
    float weightPerButton;//assigned during button creation
//------DrawButton() variables
    LinearLayout.LayoutParams p;
    String key, tempName;//key matches, tempname gets appened to for each automated button id
    ImageButton test;//button that will be added n times
    boolean enabledButton = true;//enable a button or not
    Button b;
//------DrawButton() variables end
    Question tempQ; //used to populate array that holds info for chart data


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_selection);

        buttonHolder = (LinearLayout)findViewById(R.id.buttonLayout);
        desc = (TextView)findViewById(R.id.description);
        headerImage = (ImageView)findViewById(R.id.headerImage);
        headerImage.setScaleType(ImageView.ScaleType.FIT_XY);
        headerImage.setAdjustViewBounds(true);

        p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);

        populateChart();
        drawButtons();//called after each button click, but here to force an initial draw

    }


    //this function will draw buttons to the screen depending on the number of options of the current question,
    //but for now it is going to draw the first question.
    //this function gets called after each option click
    //automated button creation by creating button 1 to i
    private void drawButtons() {

        key = "op";
        currentOptionNum = masterChart[currentIndex].getOptionNums();
        test = new ImageButton(this);
        //checks for Div/0 error
        if(currentOptionNum == 0)
        {
            p.weight = 25;
        }
        else
        {
            p.weight = weightOfButtons/(currentOptionNum+2);//includes go back button/prev
            //weightPerButton = 19;
        }

        if (currentOptionNum != 0) {
            //assigns the buttons an equal weight, cumulative to 60.
            for (int i = 1; i <= currentOptionNum; i++)//for all available options, start at op1
            {
                enabledButton = true;//used for enable/disable button based on -2 index
                test = new ImageButton(this);
                //test.setLayoutParams();
                tempName = key + i;

                //assigns an id to the button depending on which button is created
                //and assigns the text to the appropiate button text
            /*
                each question contains an image for op1 -opn buttons. They are loaded below, based
                on which butotn it is. An id is assigned, 1 to n, for each button. Buttons are
                destroyed after each click and reloaded, so the ids can be resused.
            */

                switch (tempName) {
                    case "op1":
                        test.setImageResource(masterChart[currentIndex].getOp1Image());
                        test.setId(1);
                        if (masterChart[currentIndex].getOp1() == -2)
                            enabledButton = false;
                        break;
                    case "op2":
                        test.setImageResource(masterChart[currentIndex].getOp2bImage());
                        test.setId(2);
                        break;
                    case "op3":
                        test.setImageResource(masterChart[currentIndex].getOp3bImage());
                        test.setId(3);
                        break;
                    case "op4":
                        test.setImageResource(masterChart[currentIndex].getOp4bImage());
                        test.setId(4);
                        break;
                    case "op5":
                        test.setImageResource(masterChart[currentIndex].getOp5bImage());
                        test.setId(5);
                        break;
                    case "op6":
                        test.setImageResource(masterChart[currentIndex].getOp6bImage());
                        test.setId(6);
                        break;
                    case "op7":
                        test.setImageResource(masterChart[currentIndex].getOp7bImage());
                        test.setId(7);
                        break;
                    case "op8":
                        test.setId(8);
                        test.setImageResource(masterChart[currentIndex].getOp8bImage());
                        break;
                }

                //all the neccessary layout-adding stuff. It adds the button to the layout.
                test.setEnabled(enabledButton);
                test.setOnClickListener(this);
                test.setAdjustViewBounds(true);//fixes the image scale bug
                test.setScaleType(ImageButton.ScaleType.FIT_XY);
                //test.setBackgroundColor(Color.CYAN);

                test.setLayoutParams(p);
                buttonHolder.addView(test);
            }

        }
        else { //there are no buttons to draw, this is the end of the chart. Create a restart button.

            Button b = new Button(this);
            b.setId(300);

            b.setVisibility(View.INVISIBLE);
            buttonHolder.addView(b);

            test = new ImageButton(this);
            test.setId(100);//cannot be negative, so be high
            test.setAdjustViewBounds(true);//fixes the image scale bug
            test.setScaleType(ImageButton.ScaleType.FIT_XY);
            test.setImageResource(R.drawable.restartbutton);
            test.setOnClickListener(this);
            test.setLayoutParams(p);
            buttonHolder.addView(test);
        }
        //insert a space here for formatting niceness, only if there are options.
        //inserting when back/prev are there will make it look awkard.
        if(currentOptionNum !=0 ) {
            Button b = new Button(this);
            b.setId(300);
            b.setVisibility(View.INVISIBLE);
            b.setLayoutParams(p);
            buttonHolder.addView(b);
        }

        //---- Regardless of options, create a back button.
        test = new ImageButton(this);//reset button data
        test.setId(200);//cannot be negative, so be high
        test.setAdjustViewBounds(true);//fixes the image scale bug
        test.setScaleType(ImageButton.ScaleType.FIT_XY);
        test.setImageResource(R.drawable.backbtn);
        test.setOnClickListener(this);
        test.setLayoutParams(p);
        buttonHolder.addView(test);

        //----End back button creation
        updateDesc(currentIndex);
    }
    private void updateDesc(int index)
    {
        desc.setText(masterChart[index].getQuestionText());
        //headerImage.setImageResource(masterChart[index].getImage());

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
                drawButtons();//reloads the screen
                break;

            case 2:
                currentIndex = masterChart[currentIndex].getOp2();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                drawButtons();//reloads the screen
                break;

            case 3:
                currentIndex = masterChart[currentIndex].getOp3();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                drawButtons();//reloads the screen
                break;
            case 4:
                currentIndex = masterChart[currentIndex].getOp4();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                drawButtons();//reloads the screen
                break;

            case 5:
                currentIndex = masterChart[currentIndex].getOp5();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                drawButtons();//reloads the screen
                break;

            case 6:
                currentIndex = masterChart[currentIndex].getOp6();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                drawButtons();//reloads the screen
                break;

            case 7:
                currentIndex = masterChart[currentIndex].getOp7();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                drawButtons();//reloads the screen
                break;

            case 8:
                currentIndex = masterChart[currentIndex].getOp8();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                drawButtons();//reloads the screen
                break;
            case 200://back button
                if(currentIndex == 0)
                {
                    //go back to the mainactivity
                    Intent assetSelectionWindow = new Intent(FoamFlowChart.this, MainActivity.class);
                    startActivity(assetSelectionWindow);
                    break;
                }
                currentIndex = masterChart[currentIndex].getPrevious();
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                drawButtons();
                break;
            case 100://restart button
                currentIndex = 0;
                removeButtons();
                currentOptionNum = masterChart[currentIndex].getOptionNums();
                drawButtons();
                break;
        }
    }


    //this function will update the screen to the current index's items
    private void removeButtons()
    {
        //-----begin manual button removal----
        buttonHolder.removeView(findViewById(100));//previous button
        buttonHolder.removeView(findViewById(200));//back button
        buttonHolder.removeView(findViewById(300));//space between prev button and back button

        //----begin automated button removal for automated buttons
        for( int i = 1; i <= currentOptionNum; i++)//for all available options, start at op1, destroy buttons
        {
            buttonHolder.removeView(findViewById(i));

        }
    }

    private void populateChart()
    //This function creates the flowchart for all assets
    //create each step in the flowchart and add it to the foam chart array
    {
        masterChart = new Question[100];//chart one to populate
        //set the questions to each index

        tempQ = new Question(); //for index
//------------------------------------------------------------ Setup index 0
        tempQ.setQuestionText("Welcome to the Excess Foam Troubleshooting section. What does the foam look like?");

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

        tempQ.setPrevious(-1);//at the start

        masterChart[0] = tempQ;//add it to index 0 of the chart

//--------------------------------------------------------------Setup index 1

        tempQ = new Question();
        tempQ.setQuestionText("Solids return from sludge processing. Try to reduce the solid return by improving the solids capture in sludge processing.");

        tempQ.setOp1(-2);

        tempQ.setOp2(-2);
        tempQ.setOp3(-2);

        tempQ.setOp4(-2);

        tempQ.setOptionNums(0);
        tempQ.setPrevious(0);//at the start

        masterChart[1] = tempQ;//add it to index 1 of the chart

//-------------------------------------------------------------Setup index 2
        tempQ = new Question();
        tempQ.setQuestionText("There may be a nutrient deficiency in the tank. Try adding nutrients, such as: \n\n1)NH3 or NO3 if (NH3 + NO2 + NO3) < 1 mg/L \n" +
                "2) H3PO4 if PO4 < 0.5 mg/L");

        tempQ.setOp1(-2);


        tempQ.setOp2(-2);

        tempQ.setOp3(-2);

        tempQ.setOp4(-2);

        tempQ.setOptionNums(0);
        tempQ.setPrevious(0);//at the start

        masterChart[2] = tempQ;//add it to index 2 of the chart

//-------------------------------------------------------------Setup index 3

        tempQ = new Question();
        tempQ.setQuestionText("The sludge may be old. Using treatment pressure, try to decrease TSU by increasing the waste and then removing the foam from the system.");

        tempQ.setOp1(-2);

        tempQ.setOp2(-2);

        tempQ.setOp3(-2);

        tempQ.setOp4(-2);

        tempQ.setOptionNums(0);
        tempQ.setPrevious(0);//at the start

        masterChart[3] = tempQ;//add it to index 3 of the chart

//-------------------------------------------------------------Setup index 4
        tempQ = new Question();
        tempQ.setQuestionText("Try to gague the extent of the mixed liquor suspended solids (MLSS). Are they:");

        tempQ.setOp1(5);//low
        tempQ.setOp1bImage(R.drawable.lowmlss);
        tempQ.setOp2(6);//normal
        tempQ.setOp2bImage(R.drawable.normalmlss);
        tempQ.setOp3(-2);

        tempQ.setOp4(-2);

        tempQ.setOptionNums(2);
        tempQ.setPrevious(0);//at the start

        masterChart[4] = tempQ;//add it to index 4 of the chart


//-------------------------------------------------------------Setup index 5: low MLSS
        tempQ = new Question();
        tempQ.setQuestionText("If the sludge was found at startup, then it is likely young sludge. Using oxidative pressure, increase the TSU and decrease the waste.");

        tempQ.setOp1(-2);
        tempQ.setOp2(-2);
        tempQ.setOp3(-2);

        tempQ.setOp4(-2);

        tempQ.setOptionNums(0);
        tempQ.setPrevious(4);//at the start

        masterChart[5] = tempQ;//add it to index 5 of the chart

//-------------------------------------------------------------Setup index 5: normal MLSS
        tempQ = new Question();
        tempQ.setQuestionText("The cause may be high surfactant food. Using oxidative pressure, increase the TSU and SOTa by decreasing waste and return.");

        tempQ.setOp1(-2);
        tempQ.setOp2(-2);
        tempQ.setOp3(-2);

        tempQ.setOp4(-2);

        tempQ.setOptionNums(0);
        tempQ.setPrevious(4);//at the start

        masterChart[6] = tempQ;//add it to index 5 of the chart
    }


}
