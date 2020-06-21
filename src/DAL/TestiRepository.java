/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BL.Profesors;
import BL.Programs;
import BL.Students;
import BL.Test;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
        
/**
 *
 * @author Hello
 */
public class TestiRepository extends EntMngClass implements TestiInterface {

    @Override
    public void create(Test testi) throws TestiException {
       try{
           em.getTransaction().begin();
           em.persist(testi);
           em.getTransaction().commit();
       }
       catch(Throwable thro){
           if(thro.getMessage().contains("2627")){
               throw new TestiException("E dhena ekziston!");
           }
           else{
               throw new TestiException("Create: "+thro.getClass()+ " - "+thro.getMessage());
           }
       }
    }

    @Override
    public void edit(Test testi) throws TestiException {
       try{
           em.getTransaction().begin();
           em.merge(testi);
           em.getTransaction().commit();
       }
       catch(Throwable thro){
           if(thro.getMessage().contains("2627")){
               throw new TestiException("E dhena ekziston");
           }
           else{
               throw new TestiException("Update: "+thro.getClass()+" - "+thro.getMessage());
           }
       }
    }

    @Override
    public void remove(Test testi) throws TestiException {
        try{
            em.getTransaction().begin();
            testi = em.merge(testi);
            em.remove(testi);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new TestiException("Testi është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new TestiException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public List<Test> findAll() {
        return em.createNamedQuery("Test.findAll").getResultList();
    }

    @Override
    public Test findById(int t) throws TestiException {
        Query query = em.createQuery("SELECT p FROM Test p WHERE p.testID = :t");
        query.setParameter("t", t);
        try{
            return (Test)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new TestiException("E dhëna nuk egziston!");
        }
    }
    
    public List<Test> findByProfesor(Profesors p){
        Query q = em.createQuery("SELECT t FROM Test t INNER JOIN t.programSubjectID pgs INNER JOIN pgs.profesorSubjectID ps where ps.profesorID = :p");
        q.setParameter("p", p);
        
        return q.getResultList();
        
    }
    public Test findByName(String name){
        Query query = em.createQuery("SELECT p FROM Test p WHERE p.testName = :name");
        query.setParameter("name", name);
        return (Test)query.getSingleResult();
    }
    public List<Test> findByProgram(Programs  p ){
        Query q = em.createQuery(
"SELECT t FROM Test t INNER JOIN t.programSubjectID ps where ps.programID = :p ");
        q.setParameter("p", p);
        
        return q.getResultList();
        
    }
      public List<Test> findByProfesor(Students p){
        Query q = em.createQuery("SELECT t FROM Test t");
        
        
        return q.getResultList();
        
    }
      public List<Test> findByStudents(Integer tz){
      /*select * from Test t inner join Student_Test st on t.TestID = st.TestID
where t.TestID =21*/
        Query q = em.createQuery(
"SELECT st from Test t INNER JOIN t.studentTestCollection st where t.testID = :tz");
        q.setParameter("tz",tz);
        return q.getResultList();
      }
     
      
      
}
