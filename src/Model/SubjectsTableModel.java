/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Subjects;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lirim
 */
public class SubjectsTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"SubjectName","ECTS"};
    
    private List <Subjects> data;
   
    
    public SubjectsTableModel(List<Subjects>data){
        this.data = data;
    }

    public SubjectsTableModel() {
   
    }
    public void add(List<Subjects>data){
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

    public Subjects getSubjects(int index){
        return data.get(index);
    }


    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Subjects s = (Subjects)data.get(rowIndex);
    
        switch(columnIndex){
            case 0:
                return s.getSubjectName();
            case 1:
                return s.getCredits();
            default:
                return null;
        }
    }
        
    }



