package DAL;
import BL.Addresses;
import BL.Students;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import DAL.AddressesInterface;

public class AddressRepository extends EntMngClass implements AddressesInterface {
    
    
    public void create(Addresses a) throws AddressException {
        try{
            em.getTransaction().begin();
           
            em.persist(a);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new AddressException("E dhëna egziston !");
            }
        else{
                throw new AddressException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Addresses a) throws AddressException {
        try{
            em.getTransaction().begin();
            
            em.merge(a);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new AddressException("E dhëna egziston");
            }
            else{
                throw new AddressException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Addresses a) throws AddressException {
        try{
            em.getTransaction().begin();
            a= em.merge(a);
            em.remove(a);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new AddressException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new AddressException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    
    public Addresses findById(String a) throws AddressException {
        Query query = em.createQuery("SELECT s FROM Addresses s WHERE s.addressID = :a");
        query.setParameter("a", a);
        try{
            return (Addresses)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new AddressException("Adresa nuk egziston!") {};
        }
    }

    @Override
    public List<Addresses> findAll() {
        return em.createNamedQuery("Addresses.findAll").getResultList();
    }

    public Addresses findByStdId(Students s) throws AddressException {
        Query query = em.createQuery("SELECT a FROM Addresses a WHERE a.studentID  = :s");
        query.setParameter("s", s);
        try{
            return (Addresses)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new AddressException("Adresa nuk egziston!") {};
        }
    }
       
}

