
package DAL;

import BL.Subjects;
import DAL.UserException;
import java.util.List;

public interface SubjectsInterface{
     void create(Subjects user) throws SubjectException;
     void edit (Subjects user) throws SubjectException;
    void remove(Subjects user) throws SubjectException;
    List<Subjects> findAll();
    Subjects findById(String user) throws SubjectException;
}
