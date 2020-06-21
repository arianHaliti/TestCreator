/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BL.Profesors;
import BL.ProfesorSubjects;
import BL.Programs;
import BL.ProgramsSubjects;
import BL.Subjects;
import DAL.ProfesorException;
import DAL.Profesor_SubjectRepository;
import DAL.ProgramRepository;
import DAL.ProgramSubjectException;
import DAL.ProgramSubjectRepository;
import DAL.ProgramsException;
import DAL.SubjectsRepository;
import Model.ProgramTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author arian
 */
public class ProgramForm extends javax.swing.JInternalFrame {
    ProgramRepository por = new ProgramRepository();
    ProgramTableModel ptm = new ProgramTableModel();
    SubjectsRepository sr = new SubjectsRepository();
    ProgramSubjectRepository posr = new ProgramSubjectRepository();
    
    Profesor_SubjectRepository psr = new Profesor_SubjectRepository();
    
    DefaultListModel subjectModel = new DefaultListModel();
    DefaultListModel programModel = new DefaultListModel();
    ArrayList <ProfesorSubjects> subjectMod = new ArrayList<>();
    ArrayList <ProfesorSubjects> programMod = new ArrayList<>();
    
    
    
    public ProgramForm() {
        initComponents();
        tabelaLoad();
        this.setLocation(330,40);
        
    }


    
    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = programTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                subjectMod.clear();
                programMod.clear();
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Programs p = ptm.getPrograms(selectedIndex);
                    
                    drejtimField.setText(p.getProgramName());
                    masterCombo.setSelectedIndex(p.getMaster()==true?0:1);
                    listProgramLoad(p);
                    listSubjectLoad(p);
                }
            }
        });
    }
   private void listProgramLoad(Programs p){
       
        List <ProfesorSubjects> lista =sr.findSubjectsProgram(p);
        programModel = new DefaultListModel();
        for(int i = 0 ;  i <lista.size() ; i++){
             programModel.addElement(lista.get(i).getProfesorID().getUserID().getFirstName()+" "+
                     lista.get(i).getProfesorID().getUserID().getSurName()+ " - "+
                     lista.get(i).getSubjectID().getSubjectName());
             programMod.add(lista.get(i));
             
        }    
        subjectProgramList.setModel(programModel);
 
    }
    private void listSubjectLoad(Programs p){
        List <ProfesorSubjects> lista =sr.findSubjectNotPrograms(p);

        subjectModel = new DefaultListModel();
        for(int i = 0 ;  i <lista.size() ; i++){
             subjectModel.addElement(lista.get(i).getProfesorID().getUserID().getFirstName()+" "+
                     lista.get(i).getProfesorID().getUserID().getSurName()+ " - "+
                     lista.get(i).getSubjectID().getSubjectName());
             subjectMod.add(lista.get(i));
            // System.out.println(subjectMod.size());
        }    
        subjectList.setModel(subjectModel);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        subjectProgramList = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        subjectList = new javax.swing.JList<>();
        drejtimField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        masterCombo = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        save_btn = new javax.swing.JButton();
        delete_btn2 = new javax.swing.JButton();
        cancel_btn2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        programTable = new javax.swing.JTable();
        in_btn = new javax.swing.JButton();
        out_btn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(688, 541));

        subjectProgramList.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        subjectProgramList.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane6.setViewportView(subjectProgramList);

        subjectList.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        subjectList.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane7.setViewportView(subjectList);

        drejtimField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        drejtimField.setForeground(new java.awt.Color(51, 51, 51));
        drejtimField.setMargin(new java.awt.Insets(2, 5, 2, 5));
        drejtimField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drejtimFieldActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Emri i Lendeve me Profesor :");

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("A ka Master :");

        masterCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        masterCombo.setForeground(new java.awt.Color(51, 51, 51));
        masterCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Po", "Jo" }));

        jLabel27.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Emri i Drejtimi :");

        jLabel28.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Lendet ne Drejtim :");

        save_btn.setForeground(new java.awt.Color(51, 51, 51));
        save_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        save_btn.setText("SAVE");
        save_btn.setIconTextGap(10);
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        delete_btn2.setForeground(new java.awt.Color(51, 51, 51));
        delete_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rubbish-bin.png"))); // NOI18N
        delete_btn2.setText("DELETE");
        delete_btn2.setIconTextGap(10);
        delete_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn2ActionPerformed(evt);
            }
        });

        cancel_btn2.setForeground(new java.awt.Color(51, 51, 51));
        cancel_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel-button.png"))); // NOI18N
        cancel_btn2.setText("CANCEL");
        cancel_btn2.setIconTextGap(10);
        cancel_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btn2ActionPerformed(evt);
            }
        });

        programTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(programTable);

        in_btn.setText(">");
        in_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                in_btnActionPerformed(evt);
            }
        });

        out_btn.setText("<");
        out_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                out_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(5, 5, 5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(in_btn)
                                    .addComponent(out_btn))
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cancel_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delete_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27))
                                .addGap(139, 139, 139))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(drejtimField)
                                .addGap(56, 56, 56)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(masterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(137, 137, 137))))
                    .addComponent(jScrollPane1))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(masterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drejtimField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel28))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(in_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(out_btn)
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancel_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drejtimFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drejtimFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drejtimFieldActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        try {
            int row = programTable.getSelectedRow();
            if (drejtimField.getText().equals("") || !drejtimField.getText().matches("[a-zA-ZÇçËë]+?")) {
                JOptionPane.showMessageDialog(this, drejtimField.getText().equals("")?
                        "Ju lutem mbushni drejtimin :":"Drejtimi nuk duhet te mbaj numra apo karaktere speciale", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(drejtimField.getText().length()>100){
            JOptionPane.showMessageDialog(this,"Emri i Drejtimit eshte shum i madhe",
                    "Error", JOptionPane.ERROR_MESSAGE);
           
          }
            
            else {
                if (row == -1) {
                    Programs p = new Programs();
                    p.setProgramName(drejtimField.getText());
                    p.setMaster(masterCombo.getSelectedIndex()==0?true:false);
                    por.create(p);
                    
                    saveSubjects(p);
                    JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
                } else {
                    Programs p = this.ptm.getPrograms(row);

                    p.setProgramName(drejtimField.getText());
                    p.setMaster(masterCombo.getSelectedIndex()==0?true:false);
                    por.edit(p);
                    
                    
                    saveSubjects(p);
                    JOptionPane.showMessageDialog(this, "E dhëna u editua me sukses");
                }
                emptyObject();
                tabelaLoad();
            };

        } catch (ProgramsException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }

    
    }//GEN-LAST:event_save_btnActionPerformed
      private void saveSubjects(Programs p){
        
        
        List<ProfesorSubjects> list = posr.findProfesorSubjects(p); 
        System.out.println("367 "+list.size());        
        System.out.println("368 "+programMod.size() + " -- "+subjectMod.size());
        try{    
            
            
            if(list.size()==0){
                for(int i = 0 ; i <programMod.size();i++){
                    ProgramsSubjects ps = new ProgramsSubjects();
                    ps.setProgramID(p);
                    ps.setProfesorSubjectID(programMod.get(i));
                    
                    posr.create(ps);
                }
            }
            else{
                //list lendet e profese
                //prof lendet e update
                for(int i = 0 ; i <programMod.size();i++){
                    if(!list.contains(programMod.get(i))){
                       ProgramsSubjects ps = new ProgramsSubjects();
                        ps.setProgramID(p);
                        ps.setProfesorSubjectID(programMod.get(i));
                        
                        posr.create(ps);
                        
                    }
                    
                }
               for(int i = 0 ; i <subjectMod.size();i++){
                    
                if(list.contains(subjectMod.get(i))){
                    
                    posr.remove(posr.findByProfesorSubject(p,subjectMod.get(i)));
                    }
                }
                
            }
       }catch( ProgramSubjectException pf){
            JOptionPane.showMessageDialog(this, pf.getMessage());                    
        }
    }
    private void emptyObject(){
        programTable.clearSelection();
        DefaultListModel listModel = new DefaultListModel();
        
        listModel.clear();
        subjectProgramList.setModel(listModel);
       subjectProgramList.setModel(listModel);
        subjectMod.clear();
        programMod.clear();
        programModel.clear();
        subjectModel.clear();
        listSubjectLoad();
        drejtimField.setText("");
        masterCombo.setSelectedIndex(0);
        
    
    }
    public void tabelaLoad(){
        List<Programs> temp = por.findAll();
        ptm.add(temp);
        programTable.setModel(ptm);
        ptm.fireTableDataChanged();
        tabelaSelectedIndexChange();
        listSubjectLoad();
   
    }
    private void listSubjectLoad(){
        
        List <ProfesorSubjects> lista =psr.findAll();

        subjectModel = new DefaultListModel();
        for(int i = 0 ;  i <lista.size() ; i++){
             subjectModel.addElement(lista.get(i).getProfesorID().getUserID().getFirstName()+" "+
                     lista.get(i).getProfesorID().getUserID().getSurName()+ " - "+
                     lista.get(i).getSubjectID().getSubjectName());
             subjectMod.add(lista.get(i));
            // System.out.println(subjectMod.size());
        }    
        subjectList.setModel(subjectModel);
        
    
    
    }
    
    private void delete_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn2ActionPerformed
        try{
            int row = programTable.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    Programs p = this.ptm.getPrograms(row);
                    por.remove(p);
                    tabelaLoad();
                    emptyObject();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(ProgramsException pe){
            JOptionPane.showMessageDialog(this, pe.getMessage());
        }

    }//GEN-LAST:event_delete_btn2ActionPerformed

    private void cancel_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btn2ActionPerformed
        emptyObject();
    }//GEN-LAST:event_cancel_btn2ActionPerformed

    private void in_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_in_btnActionPerformed
        List<String> temp = subjectList.getSelectedValuesList();
        int [] tem =  subjectList.getSelectedIndices();
        System.out.println(tem.length);
        for(int i =0 ; i<temp.size() ; i++){
            
            addOnProgramList(subjectList,subjectProgramList,temp.get(i),tem);
        }
        //print();
    }//GEN-LAST:event_in_btnActionPerformed

    private void out_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_out_btnActionPerformed
         List<String> temp = subjectProgramList.getSelectedValuesList();
           int [] tem =  subjectProgramList.getSelectedIndices();
           
           
        for(int i =0 ; i<temp.size() ; i++){
           
            addOnSubjectsList(subjectList,subjectProgramList,temp.get(i),tem);
        }
        //print();
    }//GEN-LAST:event_out_btnActionPerformed
 private void addOnProgramList(JList subject,JList profesor, String name , int [] temp){
        programModel.addElement(name);
       for(int i = 0 ; i < subjectModel.getSize();i++){
             if(subjectModel.get(i).equals(name)){
               
               subjectModel.remove(i);
               programMod.add(subjectMod.get(i));
               subjectMod.remove(i);
              
             }
       }
       profesor.setModel(programModel);
       subject.setModel(subjectModel);
        
    }
    private void addOnSubjectsList(JList subject,JList profesor, String name,int []temp){
        subjectModel.addElement(name);
            
       for(int i = 0 ; i < programModel.getSize();i++){
           if(programModel.get(i).equals(name)){
               programModel.remove(i);
               subjectMod.add(programMod.get(i));
               programMod.remove(i);
               
           }
       }
       subject.setModel(subjectModel);
       profesor.setModel(programModel);
       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_btn2;
    private javax.swing.JButton delete_btn2;
    private javax.swing.JTextField drejtimField;
    private javax.swing.JButton in_btn;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JComboBox<String> masterCombo;
    private javax.swing.JButton out_btn;
    private javax.swing.JTable programTable;
    private javax.swing.JButton save_btn;
    private javax.swing.JList<String> subjectList;
    private javax.swing.JList<String> subjectProgramList;
    // End of variables declaration//GEN-END:variables
}
