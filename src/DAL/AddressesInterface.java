/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Addresses;
import java.util.List;

/**
 *
 * @author arian
 */
public interface AddressesInterface  {
    void create(Addresses a)throws AddressException;
    void edit(Addresses a)throws AddressException;
    void remove(Addresses a)throws AddressException;
    List<Addresses> findAll();
    Addresses findById(String a)throws AddressException;
}
