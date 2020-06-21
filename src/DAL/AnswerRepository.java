package DAL;
import BL.Answers;
import BL.Test;
import DAL.AnswersException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class AnswerRepository extends EntMngClass implements AnswerInterface {
    
    public void create(Answers a) throws AnswersException {
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
    public void edit(Answers a) throws AnswersException {
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
    public void remove(Answers a) throws AnswersException {
        try{
            em.getTransaction().begin();
            a= em.merge(a);
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
    
    public Answers findById(String a) throws AnswersException {
        Query query = em.createQuery("SELECT s FROM Answers s WHERE s.AnswerID = :a");
        query.setParameter("a", a);
        try{
            return (Answers)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new AnswersException("E dhëna nuk egziston!");
        }
    }

    @Override
    public List<Answers> findlAll() {
        return em.createNamedQuery("Answers.findAll").getResultList();
    }

    public List<Answers> findByTest(Integer t){
        Query q = em.createQuery("SELECT a from Answers a INNER JOIN a.questionFK q INNER JOIN q.testFK tk where tk.testID = :t");
        q.setParameter("t", t);
        
        return q.getResultList();
    }
    
}

