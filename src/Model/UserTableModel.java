/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BL.Profesors;
import BL.Users;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author XONI
 */
public class UserTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {
    "Login Name", "First Name", "Sure Name", "Password"};
    
    private List <Users> data;
   
    
    public UserTableModel(List<Users>data){
        this.data = data;
    }

    public UserTableModel() {
   
    }
    public void add(List<Users>data){
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

    public Users getUsers(int index){
        return data.get(index);
    }
    
     public String getDate (Date date){
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        return da.format(date);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Users u = (Users)data.get(rowIndex);
        
            switch(columnIndex){

                case 0:
                    return u.getLoginName();
                case 1:
                    return u.getFirstName();
                case 2:
                    return u.getSurName();
                case 3:
                    return u.getHashCode();

                default:
                    return null;
            }
        }
    
    }


 