package com.example.rac.toasapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Rac on 9/26/2016.
 */

public class Question
//This class will serve as a question per index of the flowchart.
{

    private int optionNums = 0;
    private int op1;
    private int op2;
    private int op3;
    private int op4;
    private int op5;
    private int op6;
    private int op7;
    private int op8;


    //images for buttons
    private int op1Image;
    private int op2bImage;
    private int op3bImage;
    private int op4bImage;
    private int op5bImage;
    private int op6bImage;
    private int op7bImage;
    private int op8bImage;

    private int headerImage;



    private int previous;

    String button1Text;
    String button2Text;
    String button3Text;
    String button4Text;
    String button5Text;
    String button6Text;
    String button7Text;
    String button8Text;

    public int getOp1Image() {
        return op1Image;
    }

    public void setOp1bImage(int op1Image) {
        this.op1Image = op1Image;
    }

    public int getOp2bImage() {
        return op2bImage;
    }

    public void setOp2bImage(int op2bImage) {
        this.op2bImage = op2bImage;
    }

    public int getOp3bImage() {
        return op3bImage;
    }

    public void setOp3bImage(int op3bImage) {
        this.op3bImage = op3bImage;
    }

    public int getOp4bImage() {
        return op4bImage;
    }

    public void setOp4bImage(int op4bImage) {
        this.op4bImage = op4bImage;
    }

    public int getOp5bImage() {
        return op5bImage;
    }

    public void setOp5bImage(int op5bImage) {
        this.op5bImage = op5bImage;
    }

    public int getOp6bImage() {
        return op6bImage;
    }

    public void setOp6bImage(int op6bImage) {
        this.op6bImage = op6bImage;
    }

    public int getOp7bImage() {
        return op7bImage;
    }

    public void setOp7bImage(int op7bImage) {
        this.op7bImage = op7bImage;
    }

    public int getOp8bImage() {
        return op8bImage;
    }

    public void setOp8bImage(int op8bImage) {
        this.op8bImage = op8bImage;
    }


    public int getOp7() {
        return op7;
    }

    public void setOp7(int op7) {
        this.op7 = op7;
    }

    public int getOp8() {
        return op8;
    }

    public void setOp8(int op8) {
        this.op8 = op8;
    }



    public String getButton7Text() {
        return button7Text;
    }

    public void setButton7Text(String button7Text) {
        this.button7Text = button7Text;
    }

    public String getButton8Text() {
        return button8Text;
    }

    public void setButton8Text(String button8Text) {
        this.button8Text = button8Text;
    }



    public String getButton6Text() {
        return button6Text;
    }

    public void setButton6Text(String button6Text) {
        this.button6Text = button6Text;
    }

    public String getButton1Text() {
        return button1Text;
    }

    public void setButton1Text(String button1Text) {
        this.button1Text = button1Text;
    }

    public String getButton2Text() {
        return button2Text;
    }

    public void setButton2Text(String button2Text) {
        this.button2Text = button2Text;
    }

    public String getButton3Text() {
        return button3Text;
    }

    public void setButton3Text(String button3Text) {
        this.button3Text = button3Text;
    }

    public String getButton4Text() {
        return button4Text;
    }

    public void setButton4Text(String button4Text) {
        this.button4Text = button4Text;
    }

    public String getButton5Text() {
        return button5Text;
    }

    public void setButton5Text(String button5Text) {
        this.button5Text = button5Text;
    }



    public int getOptionNums() {
        return optionNums;
    }

    public void setOptionNums(int optionNums) {
        this.optionNums = optionNums;
    }

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


    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getImage() {
        return headerImage;
    }

    public void setImage(int i) {headerImage = i;}

    public int getPrevious() {
        return previous;
    }

    public String getQuestionText() {
        return questionText;
    }


}
