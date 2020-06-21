/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Answers;
import java.util.List;

/**
 *
 * @author arian
 */
public interface AnswerInterface  {
    void create(Answers email)throws AnswersException;
    void edit(Answers email)throws AnswersException;
    void remove(Answers email)throws AnswersException;
    List<Answers> findlAll();
    Answers findById(String email)throws AnswersException;
}
