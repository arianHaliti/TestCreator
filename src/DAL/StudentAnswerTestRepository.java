/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.StudentAnswers;
import BL.Questions;
import BL.StudentAnswerTest;
import BL.Students;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
/**
 *
 * @author arian
 */
    
public class StudentAnswerTestRepository extends EntMngClass implements StudentAnswerTestInterface {
    
    public void create(StudentAnswerTest a) throws AnswersException {
        try{
            em.getTransaction().begin();
           
            em.persist(a);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new AnswersException("E dhëna egziston !");
            }
        else{
                throw new AnswersException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(StudentAnswerTest a) throws AnswersException {
        try{
            em.getTransaction().begin();
            
            em.merge(a);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new AnswersException("E dhëna egziston");
            }
            else{
                throw new AnswersException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(StudentAnswerTest a) throws AnswersException {
        try{
            em.getTransaction().begin();
            if (!em.contains(a)) {
            a = em.merge(a);
            }

            em.remove(a);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new AnswersException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new AnswersException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    
    public StudentAnswerTest findById(String a) throws AnswersException {
        Query query = em.createQuery("SELECT s FROM Answers s WHERE s.AnswerID = :a");
        query.setParameter("a", a);
        try{
            return (StudentAnswerTest)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new AnswersException("E dhëna nuk egziston!");
        }
    }

    @Override
    public List<StudentAnswerTest> findlAll() {
        return em.createNamedQuery("Answers.findAll").getResultList();
    }
    
    public List<StudentAnswers > findByQuestion(Questions qz ,Students std){
        /*
        SELECT * FROM Student_Test st INNER JOIN Student_Answer_Test sat 
        on st.Test_StudentID = sat.Test_StudentID inner join 
        Student_Answers sa on sat.Answer_S_ID = sa.Answer_S_ID
        where sat.QuestionID=67 and st.StudentID=38

        */
        
        Query q = em.createQuery("SELECT sa FROM StudentTest st INNER JOIN st.studentAnswerTestCollection sat INNER JOIN sat.answerSID sa where sat.questionID = :qz and st.studentID = :std");
        q.setParameter("qz", qz);
        q.setParameter("std", std);
        return q.getResultList();
    }
  
    


}
