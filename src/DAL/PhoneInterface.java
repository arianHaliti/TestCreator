
package DAL;

import BL.Phone;

import java.util.List;

public interface PhoneInterface{
     void create(Phone prf) throws PhoneException;
     void edit (Phone prf) throws PhoneException;
    void remove(Phone prf) throws PhoneException;
    List<Phone> findAll();
    Phone findById(String prf) throws PhoneException;
}
