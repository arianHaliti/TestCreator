/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author arian
 */

import BL.Questions;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class QuestionTableModel extends AbstractTableModel {
    
    private final String [] columnNames = {
    "Question","Question Points"};
    
    private List <Questions> data;
   
    
    public QuestionTableModel(List<Questions>data){
        this.data = data;
    }

    public QuestionTableModel() {
   
    }
    public void add(List<Questions>data){
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

    public Questions getQuestions(int index){
        return data.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Questions q = (Questions)data.get(rowIndex);
   
        switch(columnIndex){
            case 0:
                return q.getQuestionDesc();
            case 1:
                return q.getPointNr();
            default:
                return null;
        }
    }
        
    }


 