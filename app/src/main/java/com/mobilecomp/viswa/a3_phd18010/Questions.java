package com.mobilecomp.viswa.a3_phd18010;

import android.content.Context;

import java.util.ArrayList;

public class Questions {


    private int ID;
    private String question;
    private int qChoice;
    private int qAnswer;
    public Questions()
    {
        ID=0;
        question = "";
        qChoice = 0;
        qAnswer=0;
    }
    public Questions(String question, int qChoice, int qAnswer)
    {
        this.question = question;
        this.qChoice = qChoice;
        this.qAnswer=qAnswer;
    }
    public Questions(String question, int qAnswer)
    {
        this.question = question;
        this.qAnswer=qAnswer;
    }
    public int getID(){
        return ID;
    }

    public String getQuestion() {
        return question;
    }

    public int getqChoice() {
        return qChoice;
    }

    public int getqAnswer() {
        return qAnswer;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setqChoice(int qChoice) {
        this.qChoice = qChoice;
    }

    public void setqAnswer(int qAnswer) {
        this.qAnswer = qAnswer;
    }

    // To be removed
    public Questions(String title){

        this.question = title;
    }

    public String getTitle() {
        return question;
    }
}
