/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BL.Countries;
import java.util.List;

/**
 *
 * @author arian
 */
public interface CountryInterface {
     void create(Countries co)throws CountryException;
    void edit(Countries co)throws CountryException;
    void remove(Countries co)throws CountryException;
    List<Countries> findAll() ;
    Countries findById(String co)throws CountryException;
}
