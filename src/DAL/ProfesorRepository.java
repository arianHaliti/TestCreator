package DAL;
import BL.Profesors;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ProfesorRepository extends EntMngClass implements ProfesorInterface {
    
    public void create(Profesors prf) throws ProfesorException {
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
    public void edit(Profesors prf) throws ProfesorException {
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
    public void remove(Profesors prf) throws ProfesorException {
        try{
            em.getTransaction().begin();
            prf = em.merge(prf);
            em.remove(prf);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new ProfesorException("Profesori i caktuar është nën përdorim, nuk mund të fshihet");
            }
            else{
                 throw new ProfesorException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Profesors> findAll() {
        return em.createNamedQuery("Profesors.findAll").getResultList();
    }

    
    public Profesors findById(String prfID) throws ProfesorException {
        Query query = em.createQuery("SELECT p FROM Profesors p WHERE p.ProfesorsID = :ProfesorsID");
        query.setParameter("ProfesorsID", prfID);
        try{
            return (Profesors)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ProfesorException("E dhëna nuk egziston!");
        }
    }
    
}

