/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.StudentTest;
/**
 *
 * @author arian
 */
import java.util.List;
public interface StudentTestInterface {
    void create(StudentTest std) throws StudentException;
    void edit (StudentTest std) throws StudentException;
    void remove(StudentTest std) throws StudentException;
    List<StudentTest> findAll();
    StudentTest findById(String std) throws StudentException;
}
