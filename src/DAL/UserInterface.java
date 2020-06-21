
package DAL;

import BL.Users;
import DAL.UserException;
import java.util.List;

public interface UserInterface{
     void create(Users user) throws UserException;
     void edit (Users user) throws UserException;
    void remove(Users user) throws UserException;
    List<Users> findAll();
    Users findById(String user) throws UserException;
}
