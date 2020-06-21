package Model;

import BL.Students;
import BL.Users;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class StudentiTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {
    "Login Name", "First Name", "Sure Name", "Password","Parent Name","Date of Birth","Gender","Personal No.","Drejtimi"};
    
    private List <Students> data;
   
    
    public StudentiTableModel(List<Students>data){
        this.data = data;
    }

    public StudentiTableModel() {
   
    }
    public void add(List<Students>data){
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

    public Students getStudenti(int index){
        return data.get(index);
    }
    
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Students s = (Students)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getUserID().getLoginName();
            case 1:
                return s.getUserID().getFirstName();
            case 2:
                return s.getUserID().getSurName();
            case 3:
                return s.getUserID().getHashCode();
            case 4 :
                return s.getParentName();
            case 5:
                return getDate(s.getDateOfBirth());
            case 6:
                return s.getGender();
            case 7:
                return s.getPersonalNumber();
            case 8:
                return s.getProgramID().getProgramName();
            default:
                return null;
        }
    }
        
    }


 