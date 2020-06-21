/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import BL.Emails;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Hello
 */
public class EmailTableModele extends AbstractTableModel{

//    public static void setModel(EmailTableModele etm) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    private final String [] columnNames = {"Emails"};

    private List <Emails> data;
    
    public EmailTableModele(List<Emails>data){
        this.data = data;
    }
    
    public EmailTableModele(){
        
    }
    
    public void add(List<Emails>data){
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
    public Emails getEmails(int index){
        return data.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Emails e = (Emails)data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return e.getEmailAdress();
            default:
                return null;
        }
    }
}
