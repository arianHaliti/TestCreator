package DAL;
import BL.Answers;
import BL.Questions;
import BL.Students;
import BL.Test;
import DAL.QuestionsException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class QuestionRepository extends EntMngClass implements QuestionInterface {
    
    public void create(Questions q) throws QuestionsException {
        try{
            em.getTransaction().begin();
            //em.detach(q);
            em.persist(q);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new QuestionsException("E dhëna egziston !");
            }
        else{
                throw new QuestionsException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Questions q) throws QuestionsException {
        try{
            em.getTransaction().begin();
            em.merge(q);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new QuestionsException("E dhëna egziston");
            }
            else{
                throw new QuestionsException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Questions q) throws QuestionsException {
        try{
            em.getTransaction().begin();
             q = em.merge(q);
             em.remove(q);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                System.out.println(thro.getMessage());
                throw new QuestionsException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new QuestionsException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Questions> findAll() {
        return em.createNamedQuery("Questions.findAll").getResultList();
    }
    public Questions findById(String q) throws QuestionsException {
        Query query = em.createQuery("SELECT s FROM Questions s WHERE s.QuestionID = :q");
        query.setParameter("q", q);
        try{
            return (Questions)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new QuestionsException("E dhëna nuk egziston!");
        }
    }
    public List<Answers> findAnswers(Questions q){
        
        
        Query query = em.createQuery("SELECT a FROM Answers a WHERE a.questionFK = :q");
        query.setParameter("q", q);
        return query.getResultList();
    }
    public List<Questions> findTestQuestions(Test t){
        Query query = em.createQuery("SELECT s FROM Questions s WHERE s.testFK = :t");
        query.setParameter("t", t);
        return query.getResultList();
    }
    public List<Answers> findAnswersStud(Questions q, Students s){
        /*
        SELECT * from Answers a inner join Student_Answer_Test sat on a.AnswerID = sat.AnswerID 
        inner join Student_Test st on sat.Test_StudentID = st.Test_StudentID
where st.StudentID = 38 and  a.Question_FK = 67

        */
        
        Query query = em.createQuery(
"Select a FROM Answers a INNER JOIN a.studentAnswerTestCollection sat INNER JOIN sat.testStudentID st WHERE st.studentID = :s and a.questionFK = :q");
        query.setParameter("q", q);
        query.setParameter("s",s);
        return query.getResultList();
        
    }
    
}

