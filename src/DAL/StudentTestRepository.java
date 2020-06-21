package DAL;
import BL.StudentTest;
import BL.Students;
import BL.Test;
import BL.Users;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class StudentTestRepository extends EntMngClass implements StudentTestInterface {
    
    public void create(StudentTest std) throws StudentException {
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
    public void edit(StudentTest std) throws StudentException {
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
    public void remove(StudentTest std) throws StudentException {
        try{
            em.getTransaction().begin();
            em.remove(std);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new StudentException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new StudentException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <StudentTest> findAll() {
        return em.createNamedQuery("StudentTest.findAll").getResultList();
    }
    public StudentTest findById(String t) throws StudentException {
        Query query = em.createQuery("SELECT s FROM StudentTest s WHERE s.testStudentID = :t");
        query.setParameter("t", t);
        try{
            return (StudentTest)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new StudentException("E dhëna nuk egziston!");
        }
    }
    public StudentTest findByStudentAndTest(Students s ,Test t)throws StudentException{
        Query query = em.createQuery("SELECT st FROM StudentTest st where st.studentID= :s and st.testID = :t ");
        query.setParameter("t", t);
        query.setParameter("s",s);
        try{
            return (StudentTest)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new StudentException("E dhëna nuk egziston!");
        }
    }
    public List<StudentTest> findByTest(Test p){
        Query query = em.createQuery(
"SELECT st FROM StudentTest st WHERE st.testID = :p");
        query.setParameter("p",p);
        
        return query.getResultList();
    }

    public List<StudentTest> findByUsers(Integer u){
         Query query = em.createQuery(
"SELECT st FROM StudentTest st INNER JOIN st.studentID s INNER JOIN s.userID us where us.userID = :u");
         query.setParameter("u",u);
        
        return query.getResultList();
    }
}

