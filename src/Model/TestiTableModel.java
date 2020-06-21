/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hello
 */

import BL.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TestiTableModel extends AbstractTableModel{

    private final String [] columnNames = {"Emri i testit","Profesori","Lenda","Numri i pyetjeve",
        "Minutat e testit","Totali i pikeve","Testi Aktiv"};
    
    private List <Test>data;
    
     public TestiTableModel(List<Test>data){
        this.data = data;
    }

    public TestiTableModel() {
   
    }
    public void add(List<Test>data){
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

    public Test getTesti(int index){
        return data.get(index);
    }
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
   
 @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Test t = (Test)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return t.getTestName();
            case 1:
                return t.getProgramSubjectID().getProfesorSubjectID().getProfesorID().getUserID().getFirstName()+ " - "+
                        t.getProgramSubjectID().getProfesorSubjectID().getProfesorID().getUserID().getSurName();
            case 2:
                return t.getProgramSubjectID().getProfesorSubjectID().getSubjectID().getSubjectName();
            case 3:
                return t.getNrQuestions();
            case 4:
                return t.getDuration();
             case 5: 
                 return t.getPoints();
             case 6:
                 return t.getTestActive()?"PO":"JO";
            
            default:
                return null;
        }
    }
    
}
