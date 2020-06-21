/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Hello
 */
import BL.Test;
import DAL.TestiException;
import java.util.List;

public interface TestiInterface {
    void create(Test testi) throws TestiException;
    void edit (Test testi) throws TestiException;
    void remove(Test testi) throws TestiException;
    List<Test> findAll();
    Test findById(int testi) throws TestiException;
}
