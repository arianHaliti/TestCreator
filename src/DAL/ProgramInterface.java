/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Programs;
import java.util.List;

/**
 *
 * @author arian
 */
public interface ProgramInterface{
    void create(Programs prf) throws ProgramsException;
    void edit (Programs prf) throws ProgramsException;
    void remove(Programs prf) throws ProgramsException;
    List<Programs> findAll();
    Programs findById(String prf) throws ProgramsException;

}
