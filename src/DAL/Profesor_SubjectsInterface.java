
package DAL;

import BL.ProfesorSubjects;

import java.util.List;

public interface Profesor_SubjectsInterface{
     void create(ProfesorSubjects prf) throws ProfesorException;
     void edit (ProfesorSubjects prf) throws ProfesorException;
    void remove(ProfesorSubjects prf) throws ProfesorException;
    List<ProfesorSubjects> findAll();
    ProfesorSubjects findById(String prf) throws ProfesorException;
}
