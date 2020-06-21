package GUI;

import BL.Answers;
import BL.Test;
import BL.Questions;
import DAL.AnswerRepository;
import DAL.AnswersException;
import DAL.QuestionRepository;
import DAL.QuestionsException;
import DAL.TestiException;
import DAL.TestiRepository;
import Model.QuestionTableModel;
import Model.TempQuestions;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author XONI
 */
public class TestQuestions extends javax.swing.JInternalFrame {
    private int nrQuest =2;
    private int count =0;
    private int score =0;
    Test t ;
    ArrayList<TempQuestions> list = new ArrayList<>();
    QuestionTableModel qtm = new QuestionTableModel();
    QuestionRepository qr = new QuestionRepository();
    AnswerRepository ar = new AnswerRepository();
    TestiRepository tr = new TestiRepository();
    
    
    public TestQuestions(Test t) {
        initComponents();
        name_label.setText(name_label.getText()+" "+t.getTestName());
        points_label.setText(points_label.getText()+" "+t.getPoints());
        drejtimi_label.setText(drejtimi_label.getText()+" "+t.getProgramSubjectID().getProgramID().getProgramName());
        drejtimi_label1.setText(drejtimi_label1.getText()+ " "+t.getProgramSubjectID().getProfesorSubjectID().getSubjectID().getSubjectName());
        this.t = t;
        tableLoad();
        jPanel3.setSize(602, 203 );
        count= t.getNrQuestions();
        ActionEvent evt=  null;
        questionType_comboActionPerformed(evt);
    }
    private void tableLoad(){
        List<Questions> lista = qr.findTestQuestions(t);
        qtm.add(lista);
        questionTable.setModel(qtm);
        qtm.fireTableDataChanged();
        points_label.setText("Piket Totale: "+t.getPoints());
        tabelaSelectedIndexChange();
        
    }
   private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = questionTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    
                    Questions q = qtm.getQuestions(selectedIndex);
                    desc_area.setText(q.getQuestionDesc());
                    pointsNumber.setText(q.getPointNr()+"");
                    questionType_combo.setSelectedIndex(q.getQuestionType());
                    getAnswers(q);
                    
                    if(q.getQuestionType()==0){
                        plus_btn.setVisible(false);
                        minus_btn.setVisible(false);
                    }
                    
                    
                }
            }
        });
    }
   private void getAnswers(Questions q){
       List<Answers> temp = qr.findAnswers(q);
       nrQuest = temp.size();
       changeQuestions();
    
     switch(temp.size())
    {
        case 4:
            jRadioButton4.setSelected(temp.get(3).getAnswercorrect());
            fourthQuestion_field.setText(temp.get(3).getAnswerDesc());
            
        case 3 :
            jRadioButton3.setSelected(temp.get(2).getAnswercorrect());
            thirdQuestion_field.setText(temp.get(2).getAnswerDesc());
            
        case 2 :
            jRadioButton2.setSelected(temp.get(1).getAnswercorrect());
            secondQuestion_field.setText(temp.get(1).getAnswerDesc());
            jRadioButton1.setSelected(temp.get(0).getAnswercorrect());
            firstQuestion_field.setText(temp.get(0).getAnswerDesc());
                
        
    }  
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionTable = new javax.swing.JTable();
        delete_btn = new javax.swing.JButton();
        name_label = new javax.swing.JLabel();
        points_label = new javax.swing.JLabel();
        drejtimi_label = new javax.swing.JLabel();
        drejtimi_label1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc_area = new javax.swing.JTextArea();
        pointsNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        fourthQuestion_field = new javax.swing.JTextField();
        thirdQuestion_field = new javax.swing.JTextField();
        secondQuestion_field = new javax.swing.JTextField();
        firstQuestion_field = new javax.swing.JTextField();
        plus_btn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        minus_btn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        new_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        cancle_btn = new javax.swing.JButton();
        questionType_combo = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("TEST MAKER");
        setMinimumSize(new java.awt.Dimension(1072, 629));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUESTIONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        questionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Question", "Question Points"
            }
        ));
        jScrollPane1.setViewportView(questionTable);

        delete_btn.setForeground(new java.awt.Color(51, 51, 51));
        delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rubbish-bin.png"))); // NOI18N
        delete_btn.setText("DELETE");
        delete_btn.setIconTextGap(10);
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        name_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        name_label.setForeground(new java.awt.Color(102, 102, 102));
        name_label.setText("Test Name :");

        points_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        points_label.setForeground(new java.awt.Color(102, 102, 102));
        points_label.setText("Total Points :");

        drejtimi_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        drejtimi_label.setForeground(new java.awt.Color(102, 102, 102));
        drejtimi_label.setText("Drejtimi:");

        drejtimi_label1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        drejtimi_label1.setForeground(new java.awt.Color(102, 102, 102));
        drejtimi_label1.setText("Lenda:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drejtimi_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drejtimi_label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(points_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drejtimi_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drejtimi_label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(points_label, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUESTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        desc_area.setColumns(20);
        desc_area.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        desc_area.setForeground(new java.awt.Color(51, 51, 51));
        desc_area.setRows(5);
        jScrollPane2.setViewportView(desc_area);

        pointsNumber.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        pointsNumber.setForeground(new java.awt.Color(51, 51, 51));
        pointsNumber.setMargin(new java.awt.Insets(2, 5, 2, 5));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Points :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pointsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(pointsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ANSWERS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setVisible(false);

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton4.setVisible(false);

        fourthQuestion_field.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        fourthQuestion_field.setForeground(new java.awt.Color(51, 51, 51));
        fourthQuestion_field.setMargin(new java.awt.Insets(2, 5, 2, 5));
        fourthQuestion_field.setVisible(false);
        fourthQuestion_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourthQuestion_fieldActionPerformed(evt);
            }
        });

        thirdQuestion_field.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        thirdQuestion_field.setForeground(new java.awt.Color(51, 51, 51));
        thirdQuestion_field.setMargin(new java.awt.Insets(2, 5, 2, 5));
        thirdQuestion_field.setVisible(false);
        thirdQuestion_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirdQuestion_fieldActionPerformed(evt);
            }
        });

        secondQuestion_field.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        secondQuestion_field.setForeground(new java.awt.Color(51, 51, 51));
        secondQuestion_field.setMargin(new java.awt.Insets(2, 5, 2, 5));
        secondQuestion_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondQuestion_fieldActionPerformed(evt);
            }
        });

        firstQuestion_field.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        firstQuestion_field.setForeground(new java.awt.Color(51, 51, 51));
        firstQuestion_field.setMargin(new java.awt.Insets(2, 5, 2, 5));
        firstQuestion_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstQuestion_fieldActionPerformed(evt);
            }
        });

        plus_btn.setForeground(new java.awt.Color(51, 51, 51));
        plus_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-button.png"))); // NOI18N
        plus_btn.setVisible(false);
        plus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plus_btnActionPerformed(evt);
            }
        });

        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/angle-arrow-down.png"))); // NOI18N
        jButton4.setIconTextGap(10);

        minus_btn.setForeground(new java.awt.Color(51, 51, 51));
        minus_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rounded-remove-button.png"))); // NOI18N
        minus_btn.setVisible(false);
        minus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minus_btnActionPerformed(evt);
            }
        });

        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/up-arrow.png"))); // NOI18N
        jButton6.setIconTextGap(30);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourthQuestion_field))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondQuestion_field))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstQuestion_field, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thirdQuestion_field, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minus_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plus_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(plus_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(firstQuestion_field)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(minus_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(secondQuestion_field))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(thirdQuestion_field, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fourthQuestion_field))
                .addGap(15, 15, 15))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPTIONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        new_btn.setForeground(new java.awt.Color(51, 51, 51));
        new_btn.setText("Perfundo");
        new_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_btnActionPerformed(evt);
            }
        });

        save_btn.setForeground(new java.awt.Color(51, 51, 51));
        save_btn.setText("Ruaj");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        cancle_btn.setForeground(new java.awt.Color(51, 51, 51));
        cancle_btn.setText("Cancle");
        cancle_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancle_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(cancle_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(new_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancle_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        questionType_combo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        questionType_combo.setForeground(new java.awt.Color(51, 51, 51));
        questionType_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "True/False", "Multiple Choice" }));
        questionType_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionType_comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(questionType_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(questionType_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        try{
            int row = questionTable.getSelectedRow();
            if(row > -1){
                Object [] ob = {"Po","Jo"};
                int i = javax.swing.JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
                if(i==0){
                    Questions q = this.qtm.getQuestions(row);
                    List<Answers> temp = qr.findAnswers(q);
                    for(int k = 0  ; k< temp.size();k++){
                        ar.remove(temp.get(k));
                    }
                    t.setPoints(t.getPoints()-q.getPointNr());
                    qr.remove(q);
                    count--;
                    t.setNrQuestions(count);
                    tr.edit(t);
                    tableLoad();
                    emptyObjects();
                    JOptionPane.showMessageDialog(this, "E dhëna është fshir me sukses !");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Nuk keni selektuar asgjë për të fshir !");
            }
        }catch( TestiException |QuestionsException | AnswersException q){
            JOptionPane.showMessageDialog(this, q.getMessage());
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void firstQuestion_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstQuestion_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstQuestion_fieldActionPerformed

    private void secondQuestion_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondQuestion_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondQuestion_fieldActionPerformed

    private void thirdQuestion_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirdQuestion_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thirdQuestion_fieldActionPerformed

    private void fourthQuestion_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourthQuestion_fieldActionPerformed
        
    }//GEN-LAST:event_fourthQuestion_fieldActionPerformed

    private void new_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_btnActionPerformed
         int res =JOptionPane.showConfirmDialog(null,
"A jeni i sigurt qe doni te perfundoni Testin?",null, JOptionPane.YES_NO_OPTION);
                    if(res == JOptionPane.YES_OPTION){
                        
                       
                        this.dispose();
                        
                    }
//emptyObjects();
    }//GEN-LAST:event_new_btnActionPerformed

public void answers(Questions q,int row,int nrOptions){
    
    try{
        if(row == -1){
            if(nrQuest>=2){
                Answers a = new Answers();
                Answers b = new Answers();

                a.setAnswerDesc(firstQuestion_field.getText());
                a.setAnswercorrect(jRadioButton1.isSelected());
                a.setQuestionFK(q);
                b.setAnswerDesc(secondQuestion_field.getText());
                b.setAnswercorrect(jRadioButton2.isSelected());
                b.setQuestionFK(q);

                ar.create(a);
                ar.create(b);

            }
            if(nrQuest>=3){
                Answers c = new Answers();
                c.setAnswerDesc(thirdQuestion_field.getText());
                c.setAnswercorrect(jRadioButton3.isSelected());
                c.setQuestionFK(q);

                ar.create(c);
            }
            if(nrQuest>=4){
                Answers d = new Answers();
                d.setAnswerDesc(fourthQuestion_field.getText());
                d.setAnswercorrect(jRadioButton4.isSelected());
                d.setQuestionFK(q);

                ar.create(d);
            }
         
        }else{
            List<Answers> temp = qr.findAnswers(q);
            if(nrQuest>=2){
                Answers a = temp.get(0);
                Answers b = temp.get(1);

                a.setAnswerDesc(firstQuestion_field.getText());
                a.setAnswercorrect(jRadioButton1.isSelected());
                a.setQuestionFK(q);
                b.setAnswerDesc(secondQuestion_field.getText());
                b.setAnswercorrect(jRadioButton2.isSelected());
                b.setQuestionFK(q);

                ar.edit(a);
                ar.edit(b);

            }
            if(nrQuest>=3 && temp.size()>=3){
                
                Answers c = temp.get(2);
                c.setAnswerDesc(thirdQuestion_field.getText());
                c.setAnswercorrect(jRadioButton3.isSelected());
                c.setQuestionFK(q);

                ar.edit(c);
            }
            else if(nrQuest>=3){
                Answers c = new Answers();
                c.setAnswerDesc(thirdQuestion_field.getText());
                c.setAnswercorrect(jRadioButton3.isSelected());
                c.setQuestionFK(q);
                
                ar.create(c);
            }else if (temp.size()>=3){
                Answers  c = temp.get(2);
                ar.remove(c);
            }
           
            if(nrQuest>=4 && temp.size()>=4){
                Answers d = temp.get(3);
                d.setAnswerDesc(fourthQuestion_field.getText());
                d.setAnswercorrect(jRadioButton4.isSelected());
                d.setQuestionFK(q);

                ar.edit(d);
            } else if(nrQuest>=4){
                Answers d = new Answers();
                d.setAnswerDesc(fourthQuestion_field.getText());
                d.setAnswercorrect(jRadioButton4.isSelected());
                d.setQuestionFK(q);
                
                ar.create(d);
            }else if(temp.size()>=4){
                Answers d = temp.get(3);
                ar.remove(d);
            }
           
            
        }
    }catch(AnswersException ae ){
        JOptionPane.showMessageDialog(this, ae.getMessage());
    }        
        
}
    



    private void plus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plus_btnActionPerformed
        if(nrQuest<4)
            nrQuest++;
        changeQuestions();
       
    }//GEN-LAST:event_plus_btnActionPerformed

    private void minus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minus_btnActionPerformed
        if(nrQuest>2)
            nrQuest--;
        changeQuestions();
       
    }//GEN-LAST:event_minus_btnActionPerformed

    private void questionType_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionType_comboActionPerformed
        if(questionType_combo.getSelectedIndex()==0){
            nrQuest=2;
            changeQuestions();
            plus_btn.setVisible(false);
            minus_btn.setVisible(false);
            
            emptyFields();
            firstQuestion_field.setText("PO");
            
            firstQuestion_field.setEditable(false);
            
            secondQuestion_field.setText("JO");
            secondQuestion_field.setEditable(false);
        }
        else{
            emptyFields();
            firstQuestion_field.setEditable(true);
            secondQuestion_field.setEditable(true);
            plus_btn.setVisible(true);
            minus_btn.setVisible(true);
        }
    }//GEN-LAST:event_questionType_comboActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
       try {
        int row =questionTable.getSelectedRow();
        if(desc_area.getText().equals("")) {
            JOptionPane.showMessageDialog(this, 
                    "Fill the Question  space :", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(desc_area.getText().length()>1000){
                JOptionPane.showMessageDialog(this,
                        "Emri i Pytjes eshte shum i gjat (deri ne 1000 shkronja)","Error",JOptionPane.ERROR_MESSAGE);
                
            }
        else if(pointsNumber.getText().equals("")|| !pointsNumber.getText().matches("[0-9]+?") || pointsNumber.getText().equals("0")){
            JOptionPane.showMessageDialog(this,pointsNumber.getText().equals("")?
                    "Fill the Point field:":"Points field duhet te jet Numer pozitiv i plot", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else if(pointsNumber.getText().length()>2){
                JOptionPane.showMessageDialog(this,
                        "Emri i Pikeve te Pytjes eshte shum i gjat (deri ne 99 pik)","Error",JOptionPane.ERROR_MESSAGE);
                
            }
        else{
            if (row == -1) {
                Questions q = new Questions();
                
              
                q.setOptionnr(nrQuest);
                q.setQuestionType(questionType_combo.getSelectedIndex());
                q.setQuestionDesc(desc_area.getText());
                q.setPointNr(Integer.parseInt(pointsNumber.getText()));
                q.setTestFK(t);
                count++;
                t.setPoints(t.getPoints()+Integer.parseInt(pointsNumber.getText()));
                score +=Integer.parseInt(pointsNumber.getText());
                t.setNrQuestions(count);
                tr.edit(t);
                qr.create(q);
                
                answers(q,row,0);

               // JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
            } else {
                Questions q = this.qtm.getQuestions(row);
                answers(q,row,q.getOptionnr());
                t.setPoints(t.getPoints()-q.getPointNr());
                score = score - q.getPointNr();
                q.setQuestionDesc(desc_area.getText());
                q.setPointNr(Integer.parseInt(pointsNumber.getText()));
                q.setOptionnr(nrQuest);
                q.setQuestionType(questionType_combo.getSelectedIndex());
                q.setTestFK(t);
                t.setPoints(t.getPoints()+Integer.parseInt(pointsNumber.getText()));
                score+=Integer.parseInt(pointsNumber.getText());
                
                qr.edit(q);
                
               // JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
            }
            emptyObjects();
            tableLoad();
            
        };

        } catch (QuestionsException  | TestiException e) {
            
            JOptionPane.showMessageDialog(this, e.getMessage());
        }  
        
    }//GEN-LAST:event_save_btnActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(questionType_combo.getSelectedIndex()==0){
            if(jRadioButton1.isSelected())
                jRadioButton2.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(questionType_combo.getSelectedIndex()==0){
            if(jRadioButton2.isSelected())
                jRadioButton1.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void cancle_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancle_btnActionPerformed
        emptyObjects();
// TODO add your handling code here:
    }//GEN-LAST:event_cancle_btnActionPerformed
    private void emptyFields(){
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        
        firstQuestion_field.setText("");
        secondQuestion_field.setText("");
        thirdQuestion_field.setText("");
        fourthQuestion_field.setText("");
    }
    private void emptyObjects(){
        questionTable.clearSelection();
        desc_area.setText("");
        firstQuestion_field.setText("");
        secondQuestion_field.setText("");
        thirdQuestion_field.setText("");
        fourthQuestion_field.setText("");
        pointsNumber.setText("");
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        minus_btn.setVisible(false);
        plus_btn.setVisible(false);
        questionType_combo.setSelectedIndex(0);
        nrQuest=2;
        
    }
    
    private ArrayList<Boolean> getCorrectAnswers(){
        ArrayList<Boolean> temp = new ArrayList<>();
        temp.add(jRadioButton1.isSelected());
        temp.add(jRadioButton2.isSelected());
        if(nrQuest==2)return temp;
        temp.add(jRadioButton3.isSelected());
        if(nrQuest==3)return temp;
        temp.add(jRadioButton4.isSelected());
        return temp;
    }
    private ArrayList<String> getQuestionDescs(){
        ArrayList<String> temp = new ArrayList<>();
        temp.add(firstQuestion_field.getText());
        temp.add(secondQuestion_field.getText());
        if(nrQuest==2)return temp;
        temp.add(thirdQuestion_field.getText());
        if(nrQuest==3)return temp;
        temp.add(fourthQuestion_field.getText());
        return temp;
    }
    private void changeQuestions(){
         
         switch(nrQuest){
             
            case 2 :
                jRadioButton3.setVisible(false);
                jRadioButton4.setVisible(false);
                thirdQuestion_field.setVisible(false);
                fourthQuestion_field.setVisible(false);
                minus_btn.setVisible(false);
                plus_btn.setVisible(true);
            break;
            
            case 3 :
                jRadioButton3.setVisible(true);
                thirdQuestion_field.setVisible(true);
                jRadioButton4.setVisible(false);
                fourthQuestion_field.setVisible(false);
                plus_btn.setVisible(true);

            break;
            
            case 4 :
                plus_btn.setVisible(false);
                jRadioButton3.setVisible(true);
                thirdQuestion_field.setVisible(true);
                jRadioButton4.setVisible(true);
                fourthQuestion_field.setVisible(true);
                minus_btn.setVisible(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton cancle_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextArea desc_area;
    private javax.swing.JLabel drejtimi_label;
    private javax.swing.JLabel drejtimi_label1;
    private javax.swing.JTextField firstQuestion_field;
    private javax.swing.JTextField fourthQuestion_field;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton minus_btn;
    private javax.swing.JLabel name_label;
    private javax.swing.JButton new_btn;
    private javax.swing.JButton plus_btn;
    private javax.swing.JTextField pointsNumber;
    private javax.swing.JLabel points_label;
    private javax.swing.JTable questionTable;
    private javax.swing.JComboBox<String> questionType_combo;
    private javax.swing.JButton save_btn;
    private javax.swing.JTextField secondQuestion_field;
    private javax.swing.JTextField thirdQuestion_field;
    // End of variables declaration//GEN-END:variables
}
