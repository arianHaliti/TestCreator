package DAL;
import BL.Profesors;
import BL.Programs;
import BL.ProgramsSubjects;
import BL.Subjects;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ProgramRepository extends EntMngClass implements ProgramInterface {
    
    public void create(Programs p) throws ProgramsException {
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new ProgramsException("E dhëna egziston !");
            }
        else{
                throw new ProgramsException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Programs p) throws ProgramsException {
        try{
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new ProgramsException("E dhëna egziston");
            }
            else{
                throw new ProgramsException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Programs p) throws ProgramsException {
        try{
            em.getTransaction().begin();
            p= em.merge(p);
            em.remove(p);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new ProgramsException("Drejtimi është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new ProgramsException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Programs> findAll() {
        return em.createNamedQuery("Programs.findAll").getResultList();
    }
    public Programs findById(String programsID) throws ProgramsException {
        Query query = em.createQuery("SELECT p FROM Programs p WHERE p.programsID = :programsID");
        query.setParameter("programsID", programsID);
        try{
            return (Programs)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ProgramsException("E dhëna nuk egziston!");
        }
    }
    public Programs findByUsername(String programName) throws ProgramsException {
        Query query=em.createQuery("SELECT u FROM Programs u WHERE u.programName = :programName");
        query.setParameter("programName", programName);

        try{
            return (Programs)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ProgramsException("Shfytëzuesi apo fjalëkalimi është i gabuar!");
        }
    }
    public ProgramsSubjects findByProfesorAndSubject( Subjects s , Profesors p, Programs pg) {
        /*
        
select * from Programs_Subjects pgs inner join 
Profesor_Subjects ps on pgs.Profesor_SubjectID = ps.Profesor_SubjectID 
where ps.SubjectID = 6 and ps.ProfesorID = 1 and pgs.ProgramID =6
        */
        
        Query query=em.createQuery(
"SELECT pgs from ProgramsSubjects pgs INNER JOIN pgs.profesorSubjectID ps  where ps.profesorID = :p and ps.subjectID = :s and pgs.programID = :pg");
        query.setParameter("s", s);
        query.setParameter("p",p);
        query.setParameter("pg",pg);
        
        
            return (ProgramsSubjects)query.getSingleResult();
        
    }
    public List<Programs> findByProfesor( Profesors p) {
       /*
        select  DISTINCT pg.ProgramName from Programs pg inner join
        Programs_Subjects pgs on pg.ProgramsID = pgs.ProgramID inner join
        Profesor_Subjects ps on ps.Profesor_SubjectID = pgs.Profesor_SubjectID
where ps.ProfesorID =  5 
        */
        Query query = em.createQuery(
                "SELECT DISTINCT pg FROM Programs pg INNER JOIN pg.programsSubjectsCollection pgs INNER JOIN pgs.profesorSubjectID ps where ps.profesorID = :p" );
        query.setParameter("p", p);
    
        return query.getResultList();
    }
}
   

