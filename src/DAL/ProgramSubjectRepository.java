package DAL;
import BL.ProfesorSubjects;
import BL.Programs;
import BL.ProgramsSubjects;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ProgramSubjectRepository extends EntMngClass implements ProgramSubjectInterface {
    
    public void create(ProgramsSubjects a) throws ProgramSubjectException {
        try{
            em.getTransaction().begin();
           
            em.persist(a);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new ProgramSubjectException("E dhëna egziston !");
            }
        else{
                throw new ProgramSubjectException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(ProgramsSubjects a) throws ProgramSubjectException {
        try{
            em.getTransaction().begin();
            
            em.merge(a);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new ProgramSubjectException("E dhëna egziston");
            }
            else{
                throw new ProgramSubjectException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(ProgramsSubjects a) throws ProgramSubjectException {
        try{
            em.getTransaction().begin();
            a = em.merge(a);
            em.remove(a);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new ProgramSubjectException("Lenda ne Drejtim është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new ProgramSubjectException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    
    public ProgramsSubjects findById(String a) throws ProgramSubjectException {
        Query query = em.createQuery("SELECT s FROM ProgramsSubjects s WHERE s.programSubjectID = :a");
        query.setParameter("a", a);
        try{
            return (ProgramsSubjects)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ProgramSubjectException("E dhëna nuk egziston!");
        }
    }

    @Override
    public List<ProgramsSubjects> findlAll() {
        return em.createNamedQuery("ProgramSubjects.findAll").getResultList();
    }
    
    public List<ProfesorSubjects> findProfesorSubjects(Programs p){
        Query query = em.createQuery(
"SELECT ps.profesorSubjectID from ProgramsSubjects ps where ps.programID = :p");
        query.setParameter("p", p);
        
        return query.getResultList();
    }
    
    public ProgramsSubjects findByProfesorSubject(Programs p ,ProfesorSubjects ps) throws ProgramSubjectException{
        Query query = em.createQuery(
"SELECT s FROM ProgramsSubjects s WHERE s.programID = :p and s.profesorSubjectID = :ps");
        query.setParameter("p", p);
        query.setParameter("ps", ps);
        
        try{
            return (ProgramsSubjects)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ProgramSubjectException("E dhëna nuk egziston!");
        }
    }

  
    
}

