/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author arian
 */

import BL.StudentTest;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class StudentTestModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Student ID",
    "Student Name","Test Name","Points"};
    
    private List <StudentTest> data;
   
    
    public StudentTestModel(List<StudentTest>data){
        this.data = data;
    }

    public StudentTestModel() {
   
    }
    public void add(List<StudentTest>data){
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        data.remove(row);
    }

    public StudentTest getStudentTest(int index){
        return data.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StudentTest st = (StudentTest)data.get(rowIndex);
   
        switch(columnIndex){
            case 0 :
                return st.getStudentID().getStudentID();
            case 1 :
                return st.getStudentID().getUserID().getFirstName()+" "+st.getStudentID().getUserID().getSurName();
            case 2:
                return st.getTestID().getTestName();
            case 3:
                return st.getNrPikeve()+"/"+st.getTestID().getPoints();
            case 4:
                return st.getTestID().getProgramSubjectID().getProfesorSubjectID().getProfesorID().getUserID().getFirstName();
            default:
                return null;
        }
    }
        
    }


 