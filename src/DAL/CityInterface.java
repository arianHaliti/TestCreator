/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BL.Cities;
import java.util.List;
/**
 *
 * @author Hello
 */
public interface CityInterface {
    void create(Cities city)throws CityException;
    void edit(Cities city)throws CityException;
    void remove(Cities city)throws CityException;
    List<Cities> findAll();
    Cities findById(Cities city)throws CityException;
}

