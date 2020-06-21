
package DAL;

import BL.Students;
import DAL.StudentException;
import java.util.List;

public interface StudentInterface{
     void create(Students std) throws StudentException;
     void edit (Students std) throws StudentException;
    void remove(Students std) throws StudentException;
    List<Students> findAll();
    Students findById(String std) throws StudentException;
}
