package DAL;
import BL.Profesors;
import BL.Students;
import BL.Users;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UserRepository extends EntMngClass implements UserInterface {
    
    public void create(Users user) throws UserException {
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new UserException("Useri dhëna egziston !");
            }
        else{
                throw new UserException("Create : "+thro.getClass()+" - "+thro.getMessage());
            }
    }
}
    public void edit(Users user) throws UserException {
        try{
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new UserException("E dhëna egziston");
            }
            else{
                throw new UserException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Users user) throws UserException {
        try{
            em.getTransaction().begin();
            user = em.merge(user);
            em.remove(user);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new UserException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new UserException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public Users findByUsername(String username, String password) throws UserException {
        Query query=em.createQuery("SELECT u FROM Users u WHERE u.loginName = :username AND u.hashCode = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        try{
            return (Users)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UserException("Shfytëzuesi apo fjalëkalimi është i gabuar!");
        }
    }
    public List <Users> findAll() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }
    
    public List<Users> findAdmins(int p){
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.privilege = :p");
        query.setParameter("p", p);
        return query.getResultList();   
    }
    
    
    @Override
    public Users findById(String userID) throws UserException {
        Query query = em.createQuery("SELECT u FROM Users u WHERE u.userID = :userID");
        query.setParameter("userID", userID);
        try{
            return (Users)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UserException("E dhëna nuk egziston!");
        }
    }
        public Profesors findByFK(Users p) throws ProfesorException{
        Query query = em.createQuery("SELECT p FROM Profesors p WHERE p.userID = :p");
        query.setParameter("p", p);
        try{
            return (Profesors)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ProfesorException("Nuk ka shfrytezues te kesi llojit!");
        }
    }
     public Students findByFKstd(Users p) throws ProfesorException{
        Query query = em.createQuery("SELECT p FROM Students p WHERE p.userID = :p");
        query.setParameter("p", p);
        try{
            return (Students)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new ProfesorException("Nuk ka shfrytezues te kesi llojit!");
        }
    }
    
}

