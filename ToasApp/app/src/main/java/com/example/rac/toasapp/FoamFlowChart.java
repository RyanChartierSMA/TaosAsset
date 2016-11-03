package com.example.rac.toasapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

public class FoamFlowChart extends AppCompatActivity implements View.OnClickListener {
    /*the aim of this class is to populate a list based on the assets we have.
    Use a local database to load this information
    An array will do fine for now.
    Can support up to 8 options per question
    */
    //layout that will link to xml layout to add buttons
    LinearLayout buttonHolder;
    TextView desc;
    int currentOptionNum = 4;
    int currentIndex = 0;
    Question[] masterChart;
    final int weightOfButtons = 75;//used to make buttons fit nicer.
                                   //image, textview, and one space take up 30.
    float weightPerButton;//assigned during button creation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_selection);

        buttonHolder = (LinearLayout)findViewById(R.id.buttonLayout);
        desc = (TextView)findViewById(R.id.description);
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
        tempQ.setQuestionText("Is there excess foam? If so, what does it look like?");

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

        tempQ = new Question();
        tempQ.setQuestionText("Solids return from sludge processing. Try to reduce the solid return by improving the solids capture in sludge processing.");

        tempQ.setOp1(-2);
        tempQ.setButton1Text("");

        tempQ.setOp2(-2);
        tempQ.setOp2bImage(R.drawable.logo);
        tempQ.setButton2Text("");
        tempQ.setOp3(-2);
        tempQ.setButton3Text("");
        tempQ.setOp4(-2);
        tempQ.setButton4Text("");
        tempQ.setOptionNums(0);
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
    private void drawButtons() {
        String key = "op";
        currentOptionNum = masterChart[currentIndex].getOptionNums();
        //-----------------------layout stuff----------------------
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
        //----------------------end layout stuff----------------------

        ImageButton test = new ImageButton(this);
        //checks for Div/0 error
        if(currentOptionNum == 0)
        {
            weightPerButton = 15;
        }
        else
        {
            weightPerButton = weightOfButtons/(currentOptionNum +1);//includes go back button
        }

        p.weight = weightPerButton;


        if (currentOptionNum != 0) {
            //assigns the buttons an equal weight, cumulative to 60.
            for (int i = 1; i <= currentOptionNum; i++)//for all available options, start at op1
            {
                boolean enabledButton = true;//used for enable/disable button based on -2 index
                test = new ImageButton(this);
                test.setAdjustViewBounds(true);//fixes the image scale bug
                String tempName = key + i;

                //assigns an id to the button depending on which button is created
                //and assigns the text to the appropiate button text
            /*
                each question contains an image for op1 -opn buttons. They are loaded below, based
                on which butotn it is. An id is assigned, 1 to n, for each button. Buttons are
                destroyed after each click and reloaded, so the ids can be resused.
            */

                switch (tempName) {
                    case "op1":
                        //test = masterChart[currentIndex].getOp1b();
                        test.setImageResource(masterChart[currentIndex].getOp1Image());
                        test.setId(1);
                        //test.setText(masterChart[currentIndex].getButton1Text());
                        if (masterChart[currentIndex].getOp1() == -2)
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
                        test.setImageResource(masterChart[currentIndex].getOp5bImage());
                        test.setId(5);
                        //test.setText(masterChart[currentIndex].getButton5Text());
                        break;
                    case "op6":
                        test.setImageResource(masterChart[currentIndex].getOp6bImage());
                        test.setId(6);
                        //test.setText(masterChart[currentIndex].getButton6Text());
                        break;
                    case "op7":
                        test.setImageResource(masterChart[currentIndex].getOp7bImage());
                        test.setId(7);
                        //test.setText(masterChart[currentIndex].getButton7Text());
                        break;
                    case "op8":
                        test.setId(8);
                        test.setImageResource(masterChart[currentIndex].getOp8bImage());
                        //test.setText(masterChart[currentIndex].getButton8Text());
                        break;

                }

                //all the neccessary layout-adding stuff. It adds the button to the layout.

               // p.weight = weightPerButton;
                test.setScaleType(ImageView.ScaleType.FIT_XY);
                test.setLayoutParams(p);
                test.setEnabled(enabledButton);
                test.setOnClickListener(this);
                buttonHolder.addView(test);
            }

        }
        else { //there are no buttons to draw, this is the end of the chart. Create a restart button.

            //create a space so it will force the buttons to be smaller and not oversized.
            Space sp = new Space(this);
            sp.setId(300);
            p.weight *= 2;//scale it up to force butons down
            sp.setLayoutParams(p);
            buttonHolder.addView(sp);

            test = new ImageButton(this);
            p.weight = 10;
            test.setId(100);//cannot be negative, so be high
            test.setAdjustViewBounds(true);//fixes the image scale bug
            test.setScaleType(ImageView.ScaleType.FIT_XY);
            test.setLayoutParams(p);
            test.setImageResource(R.drawable.restartbutton);
            test.setOnClickListener(this);
            buttonHolder.addView(test);
        }
        //insert a space here for formatting niceness, only if there are options.
        //inserting when back/prev are there will make it look awkard.
        if(currentOptionNum !=0 ) {
            Space sp = new Space(this);
            sp.setId(300);
            sp.setLayoutParams(p);
            buttonHolder.addView(sp);
        }

        //---- Regardless of options, create a back button.
        p.weight = weightPerButton;
        test = new ImageButton(this);//reset button data
        test.setId(200);//cannot be negative, so be high
        test.setAdjustViewBounds(true);//fixes the image scale bug
        test.setScaleType(ImageView.ScaleType.FIT_XY);
        test.setLayoutParams(p);
        test.setImageResource(R.drawable.backbtn);
        test.setOnClickListener(this);
        //if we are at the start already...
        if(masterChart[currentIndex].getPrevious() < 0)
        {
            test.setEnabled(false);
        }
        buttonHolder.addView(test);

        //----End back button creation
        updateDesc(currentIndex);
    }
    private void updateDesc(int index)
    {
        desc.setText(masterChart[index].getQuestionText());
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
                currentIndex = masterChart[currentIndex].getPrevious();
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


}
