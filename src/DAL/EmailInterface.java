/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BL.Emails;
import java.util.List;
/**
 *
 * @author Hello
 */
public interface EmailInterface {
    void create(Emails email)throws EmailException;
    void edit(Emails email)throws EmailException;
    void remove(Emails email)throws EmailException;
    List<Emails> findlAll();
    Emails findById(String email)throws EmailException;
}
