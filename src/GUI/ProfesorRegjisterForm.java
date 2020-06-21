package GUI;
        
import BL.ProfesorSubjects;
import BL.Profesors;
import BL.Subjects;

import BL.Users;
import DAL.ProfesorException;
import DAL.ProfesorRepository;
import DAL.Profesor_SubjectRepository;
import DAL.SubjectException;
import DAL.SubjectsRepository;
import DAL.UserException;
import DAL.UserRepository;
import Model.ProfesorTableModel;
import Model.SubjectsTableModel;
import java.awt.Dimension;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author XONI
 */
public class ProfesorRegjisterForm extends javax.swing.JInternalFrame {
    ProfesorTableModel ptm = new ProfesorTableModel();
    SubjectsTableModel stm = new SubjectsTableModel();
    SubjectsTableModel pstm = new SubjectsTableModel();
    ProfesorRepository pr = new ProfesorRepository();
    UserRepository ur = new UserRepository();
    SubjectsRepository sr = new SubjectsRepository();
    Profesor_SubjectRepository psr = new Profesor_SubjectRepository();
    Users u ;
    Profesors p;
    DefaultListModel subjectModel = new DefaultListModel();
    DefaultListModel profesorModel= new DefaultListModel();
    
    
    
    /**
     * Creates new form ProfesorGUI
     */
    public ProfesorRegjisterForm(MainForm mf) {
        initComponents();
        tableLoad();
        mf.getSize();
      
        
        Dimension desktopSize = mf.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (10));
        //this.setLocation(120,5);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cancel_btn2 = new javax.swing.JButton();
        first_name_field = new javax.swing.JTextField();
        last_name_field = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        save_btn2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        delete_btn2 = new javax.swing.JButton();
        subjectOUT_btn = new javax.swing.JButton();
        subjectIN_btn = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        degree_field = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtDitelindja = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        phone_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        subjectList = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        profesorSubjectsList = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        profesorTable = new javax.swing.JTable();

        setClosable(true);
        setForeground(new java.awt.Color(102, 102, 102));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PROFESSOR'S REGISTRATION FORM");
        setToolTipText("whatever");
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(1024, 697));

        jPanel5.setAutoscrolls(true);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREATE PROFESSORS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 15), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel6.setMaximumSize(new java.awt.Dimension(920, 347));
        jPanel6.setVerifyInputWhenFocusTarget(false);
        jPanel6.setMinimumSize(new Dimension(920,347));

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Password :");

        cancel_btn2.setForeground(new java.awt.Color(51, 51, 51));
        cancel_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel-button.png"))); // NOI18N
        cancel_btn2.setText("CANCEL");
        cancel_btn2.setIconTextGap(10);
        cancel_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btn2ActionPerformed(evt);
            }
        });

        first_name_field.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        first_name_field.setForeground(new java.awt.Color(51, 51, 51));
        first_name_field.setMargin(new java.awt.Insets(2, 5, 2, 5));
        first_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                first_name_fieldActionPerformed(evt);
            }
        });

        last_name_field.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        last_name_field.setForeground(new java.awt.Color(51, 51, 51));
        last_name_field.setMargin(new java.awt.Insets(2, 5, 2, 5));
        last_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last_name_fieldActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("First name :");

        password_field.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        password_field.setMargin(new java.awt.Insets(2, 5, 2, 5));

        save_btn2.setForeground(new java.awt.Color(51, 51, 51));
        save_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        save_btn2.setText("SAVE");
        save_btn2.setIconTextGap(10);
        save_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn2ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Last name :");

        jLabel28.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Username :");

        jLabel29.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Birthday :");

        username_field.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        username_field.setForeground(new java.awt.Color(51, 51, 51));
        username_field.setMargin(new java.awt.Insets(2, 5, 2, 5));
        username_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_fieldActionPerformed(evt);
            }
        });

        delete_btn2.setForeground(new java.awt.Color(51, 51, 51));
        delete_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rubbish-bin.png"))); // NOI18N
        delete_btn2.setText("DELETE");
        delete_btn2.setIconTextGap(10);
        delete_btn2.setVisible(false);
        delete_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn2ActionPerformed(evt);
            }
        });

        subjectOUT_btn.setText("<");
        subjectOUT_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectOUT_btnActionPerformed(evt);
            }
        });

        subjectIN_btn.setText(">");
        subjectIN_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectIN_btnActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("Choose subjects :");

        degree_field.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        degree_field.setForeground(new java.awt.Color(51, 51, 51));
        degree_field.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bachelor", "Master", "Doctor" }));

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Degree :");

        jLabel31.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setText("Lendet e Profesorit :");

        phone_btn.setForeground(new java.awt.Color(51, 51, 51));
        phone_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/open-book.png"))); // NOI18N
        phone_btn.setText("ADD MORE INFO");
        phone_btn.setIconTextGap(10);
        phone_btn.setVisible(false);
        phone_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_btnActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(subjectList);

        //jScrollPane1.setMaximumSize(new 374 211);
        jScrollPane1.setViewportView(profesorSubjectsList);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel30))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(subjectIN_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subjectOUT_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(first_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(last_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(txtDitelindja, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(degree_field, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(save_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancel_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete_btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(phone_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(28, 28, 28))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel26)
                        .addComponent(jLabel25))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28)
                                .addComponent(jLabel17)
                                .addComponent(jLabel29))
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDitelindja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(degree_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(last_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(first_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(subjectIN_btn)
                        .addGap(35, 35, 35)
                        .addComponent(subjectOUT_btn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TABLE OF PROFESSORS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 15), new java.awt.Color(102, 102, 102))); // NOI18N

        profesorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(profesorTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("FORMA");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void tableLoad(){    
        List<Profesors> lista = pr.findAll();
        ptm.add(lista);
        profesorTable.setModel(ptm);
        ptm.fireTableDataChanged();
        tabelaSelectedIndexChange();
        listSubjectLoad();
    }
     private void listSubjectLoad(){
        List <Subjects> lista =sr.findAll();

        subjectModel = new DefaultListModel();
        for(int i = 0 ;  i <lista.size() ; i++){
             subjectModel.addElement(lista.get(i).getSubjectName());
        }    
        subjectList.setModel(subjectModel);
        
    }
    
    
    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = profesorTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    
                    Profesors p = ptm.getProfesors(selectedIndex);
                    first_name_field.setText(p.getUserID().getFirstName());
                    last_name_field.setText(p.getUserID().getSurName());
                    username_field.setText(p.getUserID().getLoginName());
                    password_field.setText(p.getUserID().getHashCode());
                    //phone_field.setText(p.getUserID().getPhoneCollection());
                    //email_field.setText(p.getUserID().getEmailsCollection());
                    txtDitelindja.setDate(p.getDateOfBirth());
                    delete_btn2.setVisible(true);
                    phone_btn.setVisible(true);
                    u=p.getUserID();
                    listSubjectLoad(p);
                    listProfesorLoad(p);
                   
                }
            }
        });
    }
    private void listProfesorLoad(Profesors p){
       
        List <Subjects> lista =sr.findSubjectsProfesors(p.getProfesorID());
        profesorModel = new DefaultListModel();
        for(int i = 0 ;  i <lista.size() ; i++){
             profesorModel.addElement(lista.get(i).getSubjectName());
        }    
        profesorSubjectsList.setModel(profesorModel);
 
    }
    private void listSubjectLoad(Profesors p){
        List <Subjects> lista =sr.findSubjectNotProfesors(p);

        subjectModel = new DefaultListModel();
        for(int i = 0 ;  i <lista.size() ; i++){
             subjectModel.addElement(lista.get(i).getSubjectName());
        }    
        subjectList.setModel(subjectModel);
        
    }
    
    private void cancel_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btn2ActionPerformed
        emptyFields();
    }//GEN-LAST:event_cancel_btn2ActionPerformed

    private void first_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_first_name_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_first_name_fieldActionPerformed

    private void last_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last_name_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_last_name_fieldActionPerformed

    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_fieldActionPerformed

    private void delete_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn2ActionPerformed
        try{    
            
            int row = profesorTable.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                   
                    Profesors p = this.ptm.getProfesors(row);


                    pr.remove(p);
                    ur.remove(p.getUserID());
                    
               
                    tableLoad();
                    emptyFields();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch(ProfesorException |UserException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        
        }
    }//GEN-LAST:event_delete_btn2ActionPerformed

    private void save_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn2ActionPerformed
               try {
        int row =profesorTable.getSelectedRow();
        if(!errorCheck()) {
            if (row == -1) {
                Profesors p = new Profesors();
                Users u = new Users();
                u.setLoginName(username_field.getText());
                u.setFirstName(first_name_field.getText());
                u.setSurName(last_name_field.getText());
                u.setHashCode(password_field.getText());
                p.setDateOfBirth(txtDitelindja.getDate());
                p.setDegree(degree_field.getSelectedItem()+"");
                u.setPrivilege(1);
                p.setUserID(u);
         
                ur.create(u);
                pr.create(p);
                
                subjects(p);
                
                int res =JOptionPane.showConfirmDialog(null,
"Profesori u ruajt me sukses ,Deshironi te mbushni Informacione shtes?",null, JOptionPane.YES_NO_OPTION);
                    if(res == JOptionPane.YES_OPTION){
                        this.u = u;
                        phone_btnActionPerformed(evt);
                    }
            } else {
                Profesors p = this.ptm.getProfesors(row);

                p.getUserID().setLoginName(username_field.getText());
                p.getUserID().setHashCode(password_field.getText());
                p.getUserID().setFirstName(first_name_field.getText());
                p.getUserID().setSurName(last_name_field.getText());
                p.setDateOfBirth(txtDitelindja.getDate());
                p.setDegree(degree_field.getSelectedItem()+"");
                pr.edit(p);
                subjects(p);
                
                JOptionPane.showMessageDialog(this, "Te dhenat e Profesorit jan ruajtur ");
            }
            emptyFields();
            tableLoad();
        };

        } catch (ProfesorException | UserException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }  


    }//GEN-LAST:event_save_btn2ActionPerformed
    private void subjects(Profesors p){
        ArrayList<String> prof = new ArrayList<>();
        for(int i = 0 ; i<profesorModel.getSize();i++){
            prof.add((String)profesorModel.get(i));
        }
        
        ArrayList<String> subje = new ArrayList<>();
        System.out.println(subjectModel.getSize());
        for(int i = 0 ; i<subjectModel.getSize();i++){
            subje.add((String)subjectModel.get(i));    
        }
        
        List<Subjects> list = sr.findSubjectsProfesors(p.getProfesorID()); 
        try{        
            
            if(list.size()==0){
                for(int i = 0 ; i <prof.size();i++){
                    ProfesorSubjects ps = new ProfesorSubjects();
                    ps.setProfesorID(p);
                    ps.setSubjectID(sr.findBySubjectName(prof.get(i)));
                    psr.create(ps);
                }
            }
            else{
                //list lendet e profese
                //prof lendet e update
                for(int i = 0 ; i <prof.size();i++){
                    if(!list.contains(sr.findBySubjectName(prof.get(i)))){
                        ProfesorSubjects ps = new ProfesorSubjects();
                        ps.setProfesorID(p);
                        ps.setSubjectID(sr.findBySubjectName(prof.get(i)));
                        psr.create(ps);
                    }
                    
                }
                
                for(int i = 0 ; i <subje.size();i++){
                    
                if(list.contains(sr.findBySubjectName(subje.get(i)))){
                    psr.remove(psr.findByProfIdSubId(
                            p, sr.findBySubjectName(subje.get(i))));
                    }
                }
                
            }
       }catch(ProfesorException | SubjectException pf){
            JOptionPane.showMessageDialog(this, pf.getMessage());                    
        }
    }
    private void phone_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_btnActionPerformed
        if(this.getParent().getComponentCount() >1){
            
        }else{
            MoreInfos mi = new MoreInfos(u);
            this.getParent().add(mi);
            mi.show();
        }
    }//GEN-LAST:event_phone_btnActionPerformed

    private void subjectIN_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectIN_btnActionPerformed
        List<String> temp = subjectList.getSelectedValuesList();
        for(int i =0 ; i<temp.size() ; i++)
            addOnProfesorList(subjectList,profesorSubjectsList,temp.get(i));
    }//GEN-LAST:event_subjectIN_btnActionPerformed

    private void subjectOUT_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectOUT_btnActionPerformed
       List<String> temp = profesorSubjectsList.getSelectedValuesList();
        for(int i =0 ; i<temp.size() ; i++)
            addOnSubjectsList(subjectList,profesorSubjectsList,temp.get(i)); 
    }//GEN-LAST:event_subjectOUT_btnActionPerformed
    private void addOnProfesorList(JList subject,JList profesor, String name){
        profesorModel.addElement(name);
            
       for(int i = 0 ; i < subjectModel.getSize();i++){
           if(subjectModel.get(i).equals(name)){
               
               subjectModel.remove(i);
           }
       }
       profesor.setModel(profesorModel);
       subject.setModel(subjectModel);
        
    }
    private void addOnSubjectsList(JList subject,JList profesor, String name){
        subjectModel.addElement(name);
            
       for(int i = 0 ; i < profesorModel.getSize();i++){
           if(profesorModel.get(i).equals(name)){
               profesorModel.remove(i);
           }
       }
       subject.setModel(subjectModel);
       profesor.setModel(profesorModel);
       
    }
//    
//    List <Subjects> lista =sr.findSubjectsProfesors(p.getProfesorID());
//        DefaultListModel model;
//        model = new DefaultListModel();
//        for(int i = 0 ;  i <lista.size() ; i++){
//             model.addElement(lista.get(i).getSubjectName());
//        }    
//        profesorSubjects.setModel(model);
 
public void emptyFields(){
        profesorTable.clearSelection();
        username_field.setText("");
        first_name_field.setText("");
        last_name_field.setText("");
        password_field.setText("");
        degree_field.setSelectedIndex(0);
        txtDitelindja.setDate(null);
        delete_btn2.setVisible(false);
        phone_btn.setVisible(false);
        
        
        subjectModel.clear();
        profesorModel.clear();
        DefaultListModel <String> temp = new DefaultListModel();
        List<Subjects> sub = sr.findAll();
        for (Subjects sub1 : sub) {
            subjectModel.addElement(sub1.getSubjectName());
        }
        subjectList.setModel(subjectModel);
        profesorSubjectsList.setModel(temp);
        
        
    }
     public boolean errorCheck(){
        
        String pattern ="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";// Strong password
      //  String number =".*\\d+.*";//A osht numer
        String letters = "[a-zA-ZÇçËë]+?";
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(stamp.getTime());
         
        
         if (first_name_field.getText().equals("") || !first_name_field.getText().matches(letters)) {
            JOptionPane.showMessageDialog(this, first_name_field.getText().equals("")
                    ?"Mbush emrin":"Emri duhet te jet vetem me shkronja",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }else if(first_name_field.getText().length()>50){
            JOptionPane.showMessageDialog(this,"Emri eshte shum i madhe",
                    "Error", JOptionPane.ERROR_MESSAGE);
           return true;   
          }
         
         else if(last_name_field.getText().equals("") || !last_name_field.getText().matches(letters) ){
            JOptionPane.showMessageDialog(this, last_name_field.getText().equals("")
                    ?"Mbush mbiemrin":"Mbiemri duhet te jet vetem me shkronja",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }else if(last_name_field.getText().length()>50){
            JOptionPane.showMessageDialog(this,"Mbiemri eshte shum i madhe",
                    "Error", JOptionPane.ERROR_MESSAGE);
           return true;   
          }
        else if (username_field.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mbush username fushen:", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }else if(username_field.getText().length()>30){
            JOptionPane.showMessageDialog(this,"username eshte shum i madhe",
                    "Error", JOptionPane.ERROR_MESSAGE);
           return true;   
          }
        else if(!password_field.getText().matches(pattern)){
            JOptionPane.showMessageDialog(this,
                    "Passwordi duhet te ket se paku 8 karaktere dhe se paku : 1 uppercase ,"
                            + "1 numer, 1 lowercase ,1 special karakter dhe pa hapesira"
                    , "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else if(password_field.getText().length()>50){
            JOptionPane.showMessageDialog(this,"Emri eshte shum i madhe",
                    "Error", JOptionPane.ERROR_MESSAGE);
           return true;   
          }
        else if(txtDitelindja.getDate()==null ){
                    JOptionPane.showMessageDialog(this,
                       "Mbush daten e lindjes"
                        , "Error", JOptionPane.ERROR_MESSAGE);
                return true;
        }
        else if( txtDitelindja.getDate().after(date)){
            JOptionPane.showMessageDialog(this,
                       "Data eshte dhene ne te ardhmen !"
                        , "Error", JOptionPane.ERROR_MESSAGE);
                return true;
        }
        else if(txtDitelindja.getDate().before(java.sql.Date.valueOf("1900-12-12"))){
            JOptionPane.showMessageDialog(this,
                       "Data eshte dhene shum e vjeter"
                        , "Error", JOptionPane.ERROR_MESSAGE);
                return true;
        }
        else if(date.getYear()-txtDitelindja.getDate().getYear() <=18){
            System.out.println(date.compareTo(txtDitelindja.getDate()));
            JOptionPane.showMessageDialog(this,
                       "Personi eshte shum i ri !"
                        , "Error", JOptionPane.ERROR_MESSAGE);
                return true;
        }
          
    
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_btn2;
    private javax.swing.JComboBox<String> degree_field;
    private javax.swing.JButton delete_btn2;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField last_name_field;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JButton phone_btn;
    private javax.swing.JList<String> profesorSubjectsList;
    private javax.swing.JTable profesorTable;
    private javax.swing.JButton save_btn2;
    private javax.swing.JButton subjectIN_btn;
    private javax.swing.JList<String> subjectList;
    private javax.swing.JButton subjectOUT_btn;
    private com.toedter.calendar.JDateChooser txtDitelindja;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
