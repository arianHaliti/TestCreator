/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import BL.Cities;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hello
 */
public class CityTableModel extends AbstractTableModel{

    private final String [] columnNames = {"Cities"};
    private List <Cities> data;    
    
    public CityTableModel (List<Cities>data){
        this.data = data;
    }
    
    public CityTableModel(){
        
    }
    
    public void add(List<Cities>data){
        this.data = data;
    }
    
    @Override
    public int getRowCount(){
        return data.size();
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    public void remove(int row){
        data.remove(row);
    }
    
    public Cities getCities(int index){
        return data.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cities c = (Cities)data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return c.getCityName();
            default:
                return null;
        }
    }
    
}
