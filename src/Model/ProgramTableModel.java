/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Programs;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author arian
 */
public class ProgramTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Drejtimi","Master"};
    
    private List <Programs> data;
   
    
    public ProgramTableModel(List<Programs>data){
        this.data = data;
    }

    public ProgramTableModel() {
   
    }
    public void add(List<Programs>data){
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

    public Programs getPrograms(int index){
        return data.get(index);
    }

//     public String getDate (Date date){
//        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
//        return da.format(date);
//    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Programs p = (Programs)data.get(rowIndex);
    
        switch(columnIndex){
            case 0:
                return p.getProgramName();
            case 1:
                return p.getMaster();
            default:
                return null;
        }
    }
        
    }



