package DAL;
import BL.ProfesorSubjects;
import BL.Profesors;
import BL.Subjects;
import BL.Programs;
import BL.Students;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class SubjectsRepository extends EntMngClass implements SubjectsInterface {
    
    public void create(Subjects s) throws SubjectException {
        try{
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new SubjectException("E dhëna egziston !");
            }
        else{
                throw new SubjectException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Subjects s) throws SubjectException {
        try{
            em.getTransaction().begin();
            em.merge(s);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new SubjectException("E dhëna egziston");
            }
            else{
                throw new SubjectException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Subjects s) throws SubjectException {
        try{
            em.getTransaction().begin();
            s=em.merge(s);
            em.remove(s);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){

                throw new SubjectException("Lenda e caktuar është nën përdorim, nuk mund të fshihet");
            }
            else{
                 throw new SubjectException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Subjects> findAll() {
        return em.createNamedQuery("Subjects.findAll").getResultList();
    }
    public Subjects findById(String subjectID) throws SubjectException {
        Query query = em.createQuery("SELECT u FROM Subject u WHERE u.SubjectID = :subjectID");
        query.setParameter("SubjectID", subjectID);
        try{
            return (Subjects)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new SubjectException("E dhëna nuk egziston!");
        }
    }
    public List<Subjects> findSubjectsProfesors(int  p)  {
/*        
select * from Subjects s inner join Profesor_Subjects ps on s.SubjectID = ps.SubjectID inner join
Profesors p on ps.ProfesorID = p.ProfesorID
where p.ProfesorID=2

        SELECT c1, c2 FROM Country c1 INNER JOIN c1.neighbors c2
        
SELECT bm.blogId FROM BlogMembers bm INNER JOIN bm.blogId b 
    INNER JOIN b.blogPostsList bp INNER JOIN bp.blogPostCommentList bpc 
    INNER JOIN bpc.blogMembersId bmt WHERE bm.userId = :userId
*/
        Query query=em.createQuery(
"SELECT s FROM Subjects s inner join s.profesorSubjectsCollection ps inner join ps.profesorID p WHERE p.profesorID = :p");
        query.setParameter("p", p);
        
        return query.getResultList();
        
    }
    public Subjects findBySubjectName(String  p) throws SubjectException {
        Query query = em.createQuery("SELECT s FROM Subjects s WHERE s.subjectName = :p");
        query.setParameter("p", p);
        try{
            return (Subjects)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new SubjectException("E dhëna nuk egziston!");
        }
        
    }
    public List<Subjects> findSubjectNotProfesors(Profesors p){
        /*
        select s.SubjectName  from Subjects s  except
        select s.SubjectName from Subjects s inner join
        Profesor_Subjects ps on s.SubjectID = ps.SubjectID 
        WHERE ps.ProfesorID =2

        */
      Query query=em.createQuery(
"SELECT s FROM Subjects s except "
+ "SELECT s FROM Subjects s  inner join s.profesorSubjectsCollection ps"
+ " WHERE ps.profesorID = :p");
        query.setParameter("p", p);
        
        return query.getResultList();  
    
    }
    public List<ProfesorSubjects> findSubjectNotPrograms(Programs p ){
        /*
    select ps.Profesor_SubjectID from Profesor_Subjects ps 
    except
    select ps.Profesor_SubjectID from Profesor_Subjects ps inner join
    Programs_Subjects pg on ps.Profesor_SubjectID = pg.Profesor_SubjectID
    where pg.ProgramID=1

        */
      Query query=em.createQuery(
"SELECT  ps FROM ProfesorSubjects ps except "
+ "SELECT ps from ProfesorSubjects ps inner join ps.programsSubjectsCollection pg  where pg.programID = :p");
        query.setParameter("p", p);
        
        return query.getResultList();  
        
    }
    
    public List<ProfesorSubjects> findSubjectsProgram(Programs d){
        /*
        select ps.Profesor_SubjectID from Profesor_Subjects ps
        except
        select p.Profesor_SubjectID from Profesor_Subjects p inner join Programs_Subjects ps
        on p.Profesor_SubjectID = ps.Profesor_SubjectID
        where p.Profesor_SubjectID = 21

        
        select * from Subjects s inner join Profesor_Subjects ps on s.SubjectID = ps.SubjectID
    inner join Profesor_Subjects ppg on ppg.Profesor_SubjectID = ps.Profesor_SubjectID
    where s.SubjectID=1

        
        */
        Query query=em.createQuery("Select ps from Subjects s inner join s.profesorSubjectsCollection ps inner join ps.programsSubjectsCollection ppg  where ppg.programID = :d");
        
        query.setParameter("d", d);
        
        return query.getResultList();
    }
    public List<Subjects> findByProgram(String d , Profesors p){
    /*
        select * from Subjects s inner join Profesor_Subjects ps on s.SubjectID = ps.SubjectID 
        inner join Programs_Subjects pgs on pgs.Profesor_SubjectID = ps.Profesor_SubjectID
where pgs.ProgramID = 6 and ps.ProfesorID= 1

        */
        Query query=em.createQuery(
        "SELECT s from Subjects s inner join s.profesorSubjectsCollection ps INNER JOIN ps.programsSubjectsCollection pgs INNER JOIN pgs.programID pgg where pgg.programName = :d and ps.profesorID = :p ");
        
        query.setParameter("d", d);
        query.setParameter("p", p);
        
        
        return query.getResultList();
    }
    
 
}

