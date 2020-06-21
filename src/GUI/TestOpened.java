/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
    
import java.util.Timer;
import java.util.TimerTask;
import BL.Answers;
import BL.Questions;
import BL.Test;
import DAL.AnswerRepository;
import DAL.QuestionRepository;
import Model.QuestionTableModel;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import BL.StudentAnswerTest;
import BL.StudentAnswers;
import DAL.StudentAnswerTestRepository;
import BL.StudentTest;
import DAL.AnswersException;
import DAL.StudentAnswersRepository;
import DAL.StudentException;
import DAL.StudentTestRepository;
import DAL.TestiRepository;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author XONI
 */
public class TestOpened extends javax.swing.JInternalFrame {
    Test t;
    boolean bol= true;
    static Timer timer ;
    static int interval;
    StudentTest st;
    Questions quest;
    int nrQuest;
    int count=1;
    StudentTestRepository str = new StudentTestRepository();
    TestiRepository tr = new TestiRepository();
    StudentAnswerTestRepository satr = new StudentAnswerTestRepository();
    QuestionTableModel qtm = new QuestionTableModel();
    QuestionRepository qr = new QuestionRepository();
    AnswerRepository ar = new AnswerRepository();
    StudentAnswersRepository saar = new StudentAnswersRepository();
    /**
     * Creates new form TestOpened
     */
    public TestOpened(Test t,StudentTest st) {
        initComponents();
        this.t = t;
        this.st = st;
         points.setText("Points: "+t.getPoints());
         nrTotalQuestions.setText(t.getNrQuestions()+"");
         
         loadQuestion();
         loadTableQuestions();
         Timer();
    }
    private void loadQuestion(){
        nrTotalQuestions.setText("Total Questions : "+t.getNrQuestions());
        nrTotalPoints.setText("Piket Totale: "+t.getPoints());
        pointss.setText("Piket Totale: "+t.getPoints());
        questionPoints.setText("Points : "+qr.findTestQuestions(t).get(0).getPointNr());
        emriMbiemri.setText(st.getStudentID().getUserID().getFirstName()+ " "+st.getStudentID().getUserID().getSurName());
        timerC.setText(t.getDuration()+"");
        drejtimiLabe.setText(t.getProgramSubjectID().getProgramID().getProgramName());
        emriKolo.setText(t.getTestName());
        emriProfes.setText(t.getProgramSubjectID().getProfesorSubjectID().getProfesorID().getUserID().getFirstName()+ " "+t.getProgramSubjectID().getProfesorSubjectID().getProfesorID().getUserID().getSurName());
        createStudentAnswers();
    }
    private void createStudentAnswers(){
        try{
            List<Answers> temp = ar.findByTest(t.getTestID());
            for(int i = 0  ;i < temp.size();i++){
                

                StudentAnswers sa = new StudentAnswers();
                sa.setAnswerTicked(false);
                saar.create(sa);

                StudentAnswerTest sat = new StudentAnswerTest();
                sat.setQuestionID(temp.get(i).getQuestionFK());
                sat.setTestStudentID(st);
                sat.setAnswerID(temp.get(i));
                sat.setAnswerSID(sa);
                
                satr.create(sat);
                
            }
        }catch(AnswersException e){
            JOptionPane.showMessageDialog(points, e.getMessage());
        }
    }
    private void loadTableQuestions(){
        List<Questions> lista = qr.findTestQuestions(t);
        qtm.add(lista);
        questionTable.setModel(qtm);
        qtm.fireTableDataChanged();
        tabelaSelectedIndexChange();
        questionTable.setRowSelectionInterval(0,0);
    }
     private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = questionTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                
                if(quest!=null)
                    save();
                
                
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    count = selectedIndex;
                    if(count>0){
                        previous_btn.setEnabled(true);
                    }
                    else if(count<questionTable.getRowCount()-1){
                        next_btn.setEnabled(true);
                    }
                    Questions q = qtm.getQuestions(selectedIndex);
                    questionDesc.setText(q.getQuestionDesc());
                    questionPoints.setText(q.getPointNr()+"");
                    nrQuestion.setText("NR: "+(count+1));
                    
                    quest =q;
                    try{
                        //List<Answers> temp = qr.findAnswers(q,st.getStudentID());
                        List<StudentAnswers> temp =satr.findByQuestion(q,st.getStudentID());

                      
                        switch(q.getOptionnr()){
                            case 4:
                                option5.setSelected(temp.get(3).getAnswerTicked());
                            case 3:
                                option4.setSelected(temp.get(2).getAnswerTicked());
                            case 2:
                                option1.setSelected(temp.get(0).getAnswerTicked());
                                option2.setSelected(temp.get(1).getAnswerTicked());
                        }
                        
                        
                    }catch(Exception e){
                        System.out.println("? "+e.getMessage());
                    }
                    
                    getAnswers(q);
                    
                    
                    
                    
                }
            }
        });
    }
    private void getAnswers(Questions q){
       List<Answers> temp = qr.findAnswersStud(q,st.getStudentID());
       nrQuest = temp.size();
       changeQuestions();

        switch(temp.size())
       {
           case 4:
                option5.setText(temp.get(3).getAnswerDesc());
           case 3 :
                option4.setText(temp.get(2).getAnswerDesc());
           case 2 :
                option1.setText(temp.get(0).getAnswerDesc());
                option2.setText(temp.get(1).getAnswerDesc());
       }
    }

private void changeQuestions(){
         
         switch(nrQuest){
             
            case 2 :
                option5.setVisible(false);
                option4.setVisible(false);
                option1.setVisible(true);
                option2.setVisible(true);

            break;
            
            case 3 :
                option5.setVisible(false);
                option4.setVisible(true);
                
                
            break;
            
            case 4 :
                option5.setVisible(true);
                option4.setVisible(true);
        }
    }    
    
private void save(){
 try {
        int row =questionTable.getSelectedRow();
        
                Questions q = quest;
                List<StudentAnswers> temp =satr.findByQuestion(q,st.getStudentID());
                //System.out.println(q.getOptionnr()+" NR OPTIONS");
                switch(q.getOptionnr()){
                    case 4:
                        temp.get(3).setAnswerTicked(option5.isSelected());
                    case 3:
                        temp.get(2).setAnswerTicked(option4.isSelected());
                    case 2:
                        temp.get(1).setAnswerTicked(option2.isSelected());
                        temp.get(0).setAnswerTicked(option1.isSelected());
                }
                //System.out.println(temp.size()+" SIZE OF  ARRAYA");
                for(int i = 0 ;i<temp.size();i++){
                    saar.edit(temp.get(i));
                }
                
               // JOptionPane.showMessageDialog(this, "E dhëna u ruajt me sukses !");
            
            
        

        } catch (AnswersException    e) {
            
            JOptionPane.showMessageDialog(this, e.getMessage());
        }  
      
}
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalPoints = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        drejtimiLabe = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pointss = new javax.swing.JLabel();
        points = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nrQuestions = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        emriProfes = new javax.swing.JLabel();
        emriKolo = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        emriMbiemri = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        timerC = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        finish_btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionTable = new javax.swing.JTable();
        nrTotalQuestions = new javax.swing.JLabel();
        nrTotalPoints = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        option2 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        option1 = new javax.swing.JRadioButton();
        option5 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        questionDesc = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        questionPoints = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        nrQuestion = new javax.swing.JLabel();
        previous_btn = new javax.swing.JButton();
        next_btn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("TEST");
        setMinimumSize(new java.awt.Dimension(1234, 608));

        totalPoints.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Subject :");

        drejtimiLabe.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        drejtimiLabe.setForeground(new java.awt.Color(51, 51, 51));
        drejtimiLabe.setText("SHKI");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("12/03/2017");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Date :");

        pointss.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        pointss.setForeground(new java.awt.Color(51, 51, 51));
        pointss.setText("Total Points :");

        points.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        points.setForeground(new java.awt.Color(51, 51, 51));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Questions :");

        nrQuestions.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nrQuestions.setForeground(new java.awt.Color(51, 51, 51));
        nrQuestions.setText("20");

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Professor :");

        emriProfes.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        emriProfes.setForeground(new java.awt.Color(51, 51, 51));
        emriProfes.setText("Fisnik Prekazi");

        emriKolo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        emriKolo.setForeground(new java.awt.Color(51, 51, 51));
        emriKolo.setText("Kollokfiumi 1");

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Test name :");

        javax.swing.GroupLayout totalPointsLayout = new javax.swing.GroupLayout(totalPoints);
        totalPoints.setLayout(totalPointsLayout);
        totalPointsLayout.setHorizontalGroup(
            totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPointsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalPointsLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(totalPointsLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emriProfes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(totalPointsLayout.createSequentialGroup()
                        .addGroup(totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(totalPointsLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nrQuestions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(totalPointsLayout.createSequentialGroup()
                                .addGroup(totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(totalPointsLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(drejtimiLabe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(totalPointsLayout.createSequentialGroup()
                                        .addComponent(pointss)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(points, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(totalPointsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emriKolo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        totalPointsLayout.setVerticalGroup(
            totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalPointsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(drejtimiLabe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(emriKolo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(emriProfes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(nrQuestions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pointss)
                    .addComponent(points))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOGIN INFOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Logged as :");

        emriMbiemri.setText("Yllzon Sejdiu");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emriMbiemri)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(emriMbiemri))
                .addGap(5, 5, 5))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "COUNTDOWN TIMER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        timerC.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        timerC.setForeground(new java.awt.Color(51, 51, 51));
        timerC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerC.setText("90 : 00");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/three-quarters-of-an-hour.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(timerC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel13)
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(timerC)
                .addGap(0, 0, 0))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FINISH THE TEST", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        finish_btn.setForeground(new java.awt.Color(51, 51, 51));
        finish_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/task-complete.png"))); // NOI18N
        finish_btn.setText("FINISH");
        finish_btn.setIconTextGap(10);
        finish_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finish_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finish_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(finish_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUESTIONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        questionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nr", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(questionTable);

        nrTotalQuestions.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nrTotalQuestions.setForeground(new java.awt.Color(102, 102, 102));
        nrTotalQuestions.setText("Total Questions : 10");

        nrTotalPoints.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nrTotalPoints.setForeground(new java.awt.Color(102, 102, 102));
        nrTotalPoints.setText("Total Points : 100");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nrTotalQuestions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nrTotalPoints, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(61, 61, 61)
                .addComponent(nrTotalQuestions)
                .addGap(3, 3, 3)
                .addComponent(nrTotalPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CURRENT QUESTION", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        option2.setText("WHATEVER THE OPTION");

        option4.setText("WHATEVER THE OPTION");
        option4.setVisible(false);

        option1.setText("WHATEVER THE OPTION");

        option5.setText("WHATEVER THE OPTION");
        option5.setVisible(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(option1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(option2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(option5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(option4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(option2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(option4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(option5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        questionDesc.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        questionDesc.setForeground(new java.awt.Color(51, 51, 51));
        questionDesc.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        questionDesc.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(questionDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(questionDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        questionPoints.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        questionPoints.setForeground(new java.awt.Color(51, 51, 51));
        questionPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionPoints.setText("Points : 10");
        questionPoints.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nrQuestion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nrQuestion.setForeground(new java.awt.Color(51, 51, 51));
        nrQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nrQuestion.setText("Nr : 1");
        nrQuestion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(nrQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(questionPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(questionPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nrQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        previous_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/left-angle-bracket.png"))); // NOI18N
        previous_btn.setText("PREVIOUS");
        previous_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previous_btnActionPerformed(evt);
            }
        });

        next_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play-symbol.png"))); // NOI18N
        next_btn.setText("NEXT");
        next_btn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(previous_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(next_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(next_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(previous_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(totalPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void finish_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finish_btnActionPerformed
        if(evt==null){
            JOptionPane.showMessageDialog(this, "Testi ka perfunduar diten e mir");
            save();
            calculate();
            this.dispose();
            
        }else{
        save();
        int res =JOptionPane.showConfirmDialog(null,
"A jeni i sigurt qe doni te perfundoni Testin?",null, JOptionPane.YES_NO_OPTION);
                    if(res == JOptionPane.YES_OPTION){
                        
                        timer.cancel();
                        this.dispose();
                        calculate();
                    }
        }
    }//GEN-LAST:event_finish_btnActionPerformed
    private void calculate(){
        List<Questions> qtemp = qr.findTestQuestions(t);
      System.out.println(qtemp.size());
        for(int i =0 ;i< qtemp.size();i++){
            
            boolean correct=true;
            List<StudentAnswerTest> stdTemp = saar.findCorrectAnswers(qtemp.get(i), st.getStudentID());
   
            for(int j = 0 ; j < qtemp.get(i).getOptionnr();j++){
                
                if(stdTemp.get(j).getAnswerID().getAnswercorrect()!= stdTemp.get(j).getAnswerSID().getAnswerTicked()){
                    correct=false;
                }
            }   
            if(correct){
                st.setNrPikeve(st.getNrPikeve()+qtemp.get(i).getPointNr());
              System.out.println(qtemp.get(i).getPointNr());
            }
              st.setTestDone(true);

                try{

                    str.edit(st);
                    
                }catch(StudentException s){
                    JOptionPane.showMessageDialog(this, "ERROR Pike e studentit");
                }
         }
     }

    
    private void previous_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previous_btnActionPerformed
//        System.out.println(questionTable.getRowCount());
//        System.out.println(count);
        if(count >=0){
            count--;
            
            try{
                questionTable.setRowSelectionInterval(count ,count);
            }
            catch(Exception e){
                questionTable.setRowSelectionInterval(questionTable.getRowCount()-1 ,questionTable.getRowCount()-1);
            }
            if(count== 0){
                previous_btn.setText("Last Quest");
                
            }
            else
                previous_btn.setText("PREVIOUS");
            
             if(count+1 == questionTable.getRowCount())
                next_btn.setText("1st Quest");
            else 
                next_btn.setText("NEXT");
            
        }
        else{
            previous_btn.setEnabled(false);
        }
    }//GEN-LAST:event_previous_btnActionPerformed

    private void next_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next_btnActionPerformed
       
        if(count <questionTable.getRowCount()){
            
            //ystem.out.println("SAVED  !!!!");
            count++;
            try{
                questionTable.setRowSelectionInterval(count ,count);
            }catch(Exception e){
                questionTable.setRowSelectionInterval(0  ,0);
            
            }
            if(count+1 == questionTable.getRowCount())
                next_btn.setText("1st Quest");
            else 
                next_btn.setText("NEXT");
             if(count== 0){
                previous_btn.setText("Last Quest");
                
            }
            else
                previous_btn.setText("PREVIOUS");
        }
//        else{
//            next_btn.setText("1st Quest");
//        }
       
       
        
    }//GEN-LAST:event_next_btnActionPerformed

private void Timer(){
    interval= t.getDuration()*60;
    
   
    int delay = 1000;
    int period = 1000;
   
    timer = new Timer();
    
    timer.scheduleAtFixedRate(new TimerTask() {

        @Override
        public void run() {
//interval = Integer.parseInt(secs)*1000*60;
   // System.out.println(setInterval());
    int timwe = setInterval();
 int seconds = (int) (timwe % 60);
int minutes = (int) ((timwe /60) );
//int hours   = (int) ((timwe / (1000*60*60)) % 24);
   timerC.setText(minutes+ " : "+seconds);
            
     //System.out.println(secs);
    
        }
    }, delay, period);
}

private  int setInterval() {
    if (interval == 0){
        timer.cancel();
        ActionEvent ect = null;
        
       finish_btnActionPerformed(ect);
    }
    if(interval <300){
        if(bol){
            timerC.setForeground(new java.awt.Color(255, 0, 0));
            bol=false;
        }
        else{
            timerC.setForeground(new java.awt.Color(51, 51, 51));
            bol = true;
        }
        
    }
    return --interval;
    
    
}
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel drejtimiLabe;
    private javax.swing.JLabel emriKolo;
    private javax.swing.JLabel emriMbiemri;
    private javax.swing.JLabel emriProfes;
    private javax.swing.JButton finish_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next_btn;
    private javax.swing.JLabel nrQuestion;
    private javax.swing.JLabel nrQuestions;
    private javax.swing.JLabel nrTotalPoints;
    private javax.swing.JLabel nrTotalQuestions;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option4;
    private javax.swing.JRadioButton option5;
    private javax.swing.JLabel points;
    private javax.swing.JLabel pointss;
    private javax.swing.JButton previous_btn;
    private javax.swing.JLabel questionDesc;
    private javax.swing.JLabel questionPoints;
    private javax.swing.JTable questionTable;
    private javax.swing.JLabel timerC;
    private javax.swing.JPanel totalPoints;
    // End of variables declaration//GEN-END:variables
}
