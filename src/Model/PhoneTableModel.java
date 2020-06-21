package Model;

import BL.Phone;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PhoneTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {"Phone Numbers "};
    
    private List <Phone> data;
   
    
    public PhoneTableModel(List<Phone>data){
        this.data = data;
    }

    public PhoneTableModel() {
   
    }
    public void add(List<Phone>data){
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

    public Phone getPhone(int index){
        return data.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Phone p = (Phone)data.get(rowIndex);  
        switch(columnIndex){
            case 0:
                return p.getPhoneNumber();
            default:
                return null;
        }
    }
        
    }

