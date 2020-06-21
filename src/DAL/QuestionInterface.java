/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Questions;
/**
 *
 * @author arian
 */
import java.util.List;
public interface QuestionInterface {
    void create(Questions prf) throws QuestionsException;
     void edit (Questions prf) throws QuestionsException;
    void remove(Questions prf) throws QuestionsException;
    List<Questions> findAll();
    Questions findById(String prf) throws QuestionsException;
}

