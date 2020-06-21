/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.ProgramsSubjects;
import java.util.List;

/**
 *
 * @author arian
 */
public interface ProgramSubjectInterface {
    void create(ProgramsSubjects ps)throws ProgramSubjectException;
    void edit(ProgramsSubjects ps)throws ProgramSubjectException;
    void remove(ProgramsSubjects ps)throws ProgramSubjectException;
    List<ProgramsSubjects> findlAll();
    ProgramsSubjects findById(String ps)throws ProgramSubjectException;
}
