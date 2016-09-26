package com.example.rac.toasapp;

/**
 * Created by Rac on 9/26/2016.
 */

public class AssetFlowChart {

    /*The flowchart contains an array of questions and a current question. The flow chart can load
    in the nextyes, nextno, and previous option as well as navigating to the first node.

    */
    private Question flowchart[]= new Question[99];
    int currentIndex = 0;
    private Question currentQuestion = flowchart[currentIndex];
    //an array of questions.

    private void loadnextYes()
    {
        //sets the current index to the nextYes of the current question
        currentIndex = currentQuestion.getNextYes();
        //loads in the new question from the above
        currentQuestion = flowchart[currentIndex];
    }

    private void loadnextNo()
    {
        //sets the current index to the nextNo of the current question
        currentIndex = currentQuestion.getNextNo();
        //loads in the new question from the above
        currentQuestion = flowchart[currentIndex];
    }

    private void loadPrevious()
    {
        //sets the current index to the previous of the current question
        currentIndex = currentQuestion.getPrevious();
        //loads in the new question from the above
        currentQuestion = flowchart[currentIndex];
    }

    private void restart()
    {
        currentIndex = 0;
        currentQuestion = flowchart[0];
    }
}
