
package DAL;

import BL.Profesors;

import java.util.List;

public interface ProfesorInterface{
     void create(Profesors prf) throws ProfesorException;
     void edit (Profesors prf) throws ProfesorException;
    void remove(Profesors prf) throws ProfesorException;
    List<Profesors> findAll();
    Profesors findById(String prf) throws ProfesorException;
}
