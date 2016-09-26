package com.example.rac.toasapp;

import android.widget.ImageView;

/**
 * Created by Rac on 9/26/2016.
 */

public class Question
//This class will serve as a question per index of the flowchart.
{

    private ImageView image;
    private int nextYes, nextNo, previous;
    private String questionText;



    public void setImage(ImageView image) {
        this.image = image;
    }

    public void setNextYes(int nextYes) {
        this.nextYes = nextYes;
    }

    public void setNextNo(int nextNo) {
        this.nextNo = nextNo;
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

    public int getNextYes() {
        return nextYes;
    }

    public int getNextNo() {
        return nextNo;
    }

    public int getPrevious() {
        return previous;
    }

    public String getQuestionText() {
        return questionText;
    }

}
