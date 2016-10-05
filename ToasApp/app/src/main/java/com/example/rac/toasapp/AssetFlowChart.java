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

    private void loadOp1()
    {
        //sets the current index to the nextYes of the current question
        currentIndex = currentQuestion.getOp1();
        //loads in the new question from the above
        currentQuestion = flowchart[currentIndex];
    }

    private void loadOp2()
    {
        //sets the current index to the nextNo of the current question
        currentIndex = currentQuestion.getOp2();
        //loads in the new question from the above
        currentQuestion = flowchart[currentIndex];
    }

    private void loadOp3()
    {
        //sets the current index to the nextNo of the current question
        currentIndex = currentQuestion.getOp3();
        //loads in the new question from the above
        currentQuestion = flowchart[currentIndex];
    }

    private void loadOp4()
    {
        //sets the current index to the nextNo of the current question
        currentIndex = currentQuestion.getOp4();
        //loads in the new question from the above
        currentQuestion = flowchart[currentIndex];
    }

    private void loadOp5()
    {
        //sets the current index to the nextNo of the current question
        currentIndex = currentQuestion.getOp5();
        //loads in the new question from the above
        currentQuestion = flowchart[currentIndex];
    }

    private void loadOp6()
    {
        //sets the current index to the nextNo of the current question
        currentIndex = currentQuestion.getOp6();
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


    public Question[] getFlowchart() {
        return flowchart;
    }

    public void setFlowchart(Question[] flowchart) {
        this.flowchart = flowchart;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public void assignIndex(int index, Question q)
    {
        flowchart[index] = q;
    }

}
