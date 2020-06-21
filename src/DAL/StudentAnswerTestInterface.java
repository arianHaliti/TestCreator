/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.StudentAnswerTest;
import java.util.List;
/**
 *
 * @author arian
 */
public interface StudentAnswerTestInterface {
    void create(StudentAnswerTest a)throws AnswersException;
    void edit(StudentAnswerTest a)throws AnswersException;
    void remove(StudentAnswerTest a)throws AnswersException;
    List<StudentAnswerTest> findlAll();
    StudentAnswerTest findById(String a)throws AnswersException;
    
}
