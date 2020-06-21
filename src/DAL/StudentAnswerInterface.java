/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.StudentAnswers;
import java.util.List;
/**
 *
 * @author arian
 */
public interface StudentAnswerInterface {
    void create(StudentAnswers a)throws AnswersException;
    void edit(StudentAnswers a)throws AnswersException;
    void remove(StudentAnswers a)throws AnswersException;
    List<StudentAnswers> findlAll();
    StudentAnswers findById(String a)throws AnswersException;
    
}
