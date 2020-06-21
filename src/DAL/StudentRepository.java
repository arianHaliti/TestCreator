package DAL;
import BL.Students;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class StudentRepository extends EntMngClass implements StudentInterface {
    
    public void create(Students std) throws StudentException {
        try{
            em.getTransaction().begin();
            em.persist(std);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new StudentException("E dhëna egziston !");
            }
        else{
                throw new StudentException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Students std) throws StudentException {
        try{
            em.getTransaction().begin();
            em.merge(std);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new StudentException("E dhëna egziston");
            }
            else{
                throw new StudentException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Students std) throws StudentException {
        try{
            em.getTransaction().begin();
            std = em.merge(std);
            em.remove(std);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new StudentException("Studenti është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new StudentException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Students> findAll() {
        return em.createNamedQuery("Students.findAll").getResultList();
    }
    public Students findById(String stdID) throws StudentException {
        Query query = em.createQuery("SELECT s FROM Students s WHERE s.StudentID = :StudentID");
        query.setParameter("StudentID", stdID);
        try{
            return (Students)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new StudentException("E dhëna nuk egziston!");
        }
    }

    
}

