/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Questions;
import BL.StudentAnswerTest;
import BL.StudentAnswers;
import BL.Students;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
/**
 *
 * @author arian
 */
    
public class StudentAnswersRepository extends EntMngClass implements StudentAnswerInterface {
    
    public void create(StudentAnswers a) throws AnswersException {
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
    public void edit(StudentAnswers a) throws AnswersException {
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
    public void remove(StudentAnswers a) throws AnswersException {
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
    
    public StudentAnswers findById(String a) throws AnswersException {
        Query query = em.createQuery("SELECT s FROM StudentAnswers s WHERE s.answerSID = :a");
        query.setParameter("a", a);
        try{
            return (StudentAnswers)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new AnswersException("E dhëna nuk egziston!");
        }
    }

    @Override
    public List<StudentAnswers> findlAll() {
        return em.createNamedQuery("StudentAnswers.findAll").getResultList();
    }
    
    public List<StudentAnswerTest> findCorrectAnswers(Questions qid , Students sid){
    /*
Select * from Student_Answers sa inner join Student_Answer_Test sat on sa.Answer_S_ID = sat.Answer_S_ID
inner join Student_Test st on st.Test_StudentID=sat.Test_StudentID 
inner join Questions q on sat.QuestionID = q.QuestionID
inner join Answers a on q.QuestionID = a.Question_FK
where sat.QuestionID = 77 and st.StudentID= 40 and sa.Answer_Ticked = a.Answer_correct


    */
        Query q = em.createQuery(
"SELECT DISTINCT sat FROM StudentAnswers sa INNER JOIN sa.studentAnswerTestCollection sat INNER JOIN sat.answerSID ans INNER JOIN sat.testStudentID ts INNER JOIN sat.questionID q INNER JOIN q.answersCollection a where sat.questionID = :qid AND ts.studentID = :sid" );
       q.setParameter("qid", qid);
       q.setParameter("sid",sid);
    
       return q.getResultList();
    }
}
