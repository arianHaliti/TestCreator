
package Model;

import BL.Countries;
import GUI.CountryForm;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class CountryTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Countries"};
    
    private List <Countries> data;
   
    
    public CountryTableModel(List<Countries>data){
        this.data = data;
    }

    public CountryTableModel() {
   
    }
    public void add(List<Countries>data){
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

    public Countries getCountry(int index){
        return data.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Countries c = (Countries)data.get(rowIndex);  
        switch(columnIndex){
            case 0:
                return c.getCountryname();
            default:
                return null;
        }
    }
        
    }

