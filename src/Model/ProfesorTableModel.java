package Model;

import BL.Profesors;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ProfesorTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {
    "Login Name","Password", "First Name", "Sure Name","Date of Birth", "Degree",};
    
    private List <Profesors> data;
   
    
    public ProfesorTableModel(List<Profesors>data){
        this.data = data;
    }

    public ProfesorTableModel() {
   
    }
    public void add(List<Profesors>data){
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

    public Profesors getProfesors(int index){
        return data.get(index);
    }
    
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Profesors p = (Profesors)data.get(rowIndex);
   // "Login Name","Password", "First Name", "Sure Name","Date of Birth", "Degree",};    
        switch(columnIndex){
            case 0:
                return p.getUserID().getLoginName();
            case 1:
                return p.getUserID().getHashCode();
            case 2:
                return p.getUserID().getFirstName();
            case 3:
                return p.getUserID().getSurName();
            case 4:
                return getDate(p.getDateOfBirth());
            case 5:
                return p.getDegree();
            default:
                return null;
        }
    }
        
    }


 