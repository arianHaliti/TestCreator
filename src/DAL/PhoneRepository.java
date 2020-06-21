
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Phone;
import BL.Users;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author arian
 */
public class PhoneRepository extends EntMngClass implements PhoneInterface {


    public void create(Phone p) throws PhoneException {
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new PhoneException("E dhëna egziston !");
            }
        else{
                throw new PhoneException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Phone p) throws PhoneException {
        try{
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new PhoneException("E dhëna egziston");
            }
            else{
                throw new PhoneException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Phone p) throws PhoneException {
        try{
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new PhoneException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new PhoneException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Phone> findAll() {
        return em.createNamedQuery("Phone.findAll").getResultList();
    }
    
    public Phone findById(String p) throws PhoneException {
        Query query = em.createQuery("SELECT p FROM Phone p WHERE p.PhoneNumberID= :p");
        query.setParameter("p", p);
        try{
            return (Phone)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new PhoneException("E dhëna nuk egziston!");
        }
    }
    
    public List<Phone> findByUserID(Users p){
        Query query = em.createQuery("SELECT u FROM Phone u WHERE u.userID = :p");
        query.setParameter("p", p);
        return query.getResultList();   
    }

   

    
}
