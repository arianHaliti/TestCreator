/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author arian
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

public class TempQuestions {
    //Questions
    private String desc;
    private int points;
    private int nrAnswers;
    //-----
    
    
    //Multiple vers Questions // True false // Single Question
    private int numberOfAnswers;
    private ArrayList<String> answerDesc;
    private ArrayList<Boolean> correctAnswer;
    
    
    public TempQuestions(int points ,ArrayList<Boolean> arr,String desc,ArrayList<String> potAnsw,int numberOfAnswers){
        this.points = points;
        correctAnswer = arr;
        this.desc = desc;
        this.answerDesc =potAnsw;
        this.numberOfAnswers =numberOfAnswers;
     
    }
    
//    public TempQuestions(int piket,String desc,String ans){
//        this.piket=piket;
//        this.desc=desc;
//    }
//    
    
    
    
    public String getDesc() {
        return desc;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Boolean>getAnsw() {
        return correctAnswer;
    }

    public ArrayList<String> getPotAnsw() {
        return answerDesc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setAnsw(ArrayList<Boolean> answ) {
        this.correctAnswer = answ;
    }

    public void setPotAnsw(ArrayList<String> potAnsw) {
        this.answerDesc = potAnsw;
    }
    public void setAnswerNr(int nr){
        nrAnswers =nr;
    }
    public int getAnswerNr(){
        return nrAnswers;
    }

    public void setNrAnswers(int nrAnswers) {
        this.nrAnswers = nrAnswers;
    }

    public int getNrAnswers() {
        return nrAnswers;
    }
    
}
