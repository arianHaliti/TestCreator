package DAL;
import BL.ProfesorSubjects;

import BL.Profesors;
import BL.Subjects;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class Profesor_SubjectRepository extends EntMngClass implements Profesor_SubjectsInterface {
    
    
    public void create(ProfesorSubjects prf) throws ProfesorException {
        try{
            em.getTransaction().begin();
            em.persist(prf);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new ProfesorException("E dhëna egziston !");
            }
        else{
                throw new ProfesorException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(ProfesorSubjects prf) throws ProfesorException {
        try{
            em.getTransaction().begin();
            em.merge(prf);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new ProfesorException("E dhëna egziston");
            }
            else{
                throw new ProfesorException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(ProfesorSubjects prf) throws ProfesorException {
        try{
            em.getTransaction().begin();
            prf = em.merge(prf);
            em.remove(prf);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new ProfesorException("Lenda e  Profes është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new ProfesorException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <ProfesorSubjects> findAll() {
        return em.createNamedQuery("ProfesorSubjects.findAll").getResultList();
    }
    
    public ProfesorSubjects findById(String p) throws ProfesorException {
        Query query = em.createQuery("SELECT p FROM ProfesorSubjects p WHERE p.profesorSubjectID = :p");
        query.setParameter("p", p);
        try{
            return (ProfesorSubjects)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ProfesorException("E dhëna nuk egziston!");
        }
    }
    public ProfesorSubjects findByProfIdSubId(Profesors d ,Subjects s) throws ProfesorException {
        Query query = em.createQuery("SELECT p FROM ProfesorSubjects p WHERE p.profesorID = :d and p.subjectID = :s");
        query.setParameter("d", d);
        query.setParameter("s", s);
        
        try{
            return (ProfesorSubjects)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ProfesorException("E dhëna nuk egziston!");
        }
    }
    public List<ProfesorSubjects> findByProfId(Profesors d)  {
        Query query = em.createQuery("SELECT p FROM ProfesorSubjects p WHERE p.profesorID = :d ");
        query.setParameter("d", d);
        return query.getResultList();
    }
}

