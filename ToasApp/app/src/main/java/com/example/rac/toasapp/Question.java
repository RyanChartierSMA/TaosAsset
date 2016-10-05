package com.example.rac.toasapp;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by Rac on 9/26/2016.
 */

public class Question
//This class will serve as a question per index of the flowchart.
{

    private ImageView image;

    private int op1;
    private int op2;
    private int op3;
    private int op4;
    private int op5;
    private int op6;
    private int previous;

    public int getOp1() {
        return op1;
    }

    public void setOp1(int op1) {
        this.op1 = op1;
    }

    public int getOp2() {
        return op2;
    }

    public void setOp2(int op2) {
        this.op2 = op2;
    }

    public int getOp3() {
        return op3;
    }

    public void setOp3(int op3) {
        this.op3 = op3;
    }

    public int getOp4() {
        return op4;
    }

    public void setOp4(int op4) {
        this.op4 = op4;
    }

    public int getOp5() {
        return op5;
    }

    public void setOp5(int op5) {
        this.op5 = op5;
    }


    public int getOp6() {
        return op6;
    }

    public void setOp6(int op6) {
        this.op6 = op6;
    }


    private String questionText;

    public void setImage(int picture) {
        image.setImageResource(picture);
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ImageView getImage() {
        return image;
    }

    public int getPrevious() {
        return previous;
    }

    public String getQuestionText() {
        return questionText;
    }

}
