/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BL.Emails;
import BL.Phone;
import BL.Users;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
/**
 *
 * @author Hello
 */
public class EmailRepository extends EntMngClass implements EmailInterface{

    @Override
    public void create(Emails email) throws EmailException {
        try{
            em.getTransaction().begin();
            em.persist(email);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                throw new EmailException("E dhena ekziston!");
            }
            else{
                throw new EmailException("Create : "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public void edit(Emails email) throws EmailException {
        try{
            em.getTransaction().begin();
            em.merge(email);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                throw new EmailException("E dhena ekziston!");
            }
            else{
                throw new EmailException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public void remove(Emails email) throws EmailException {
        try{
            em.getTransaction().begin();
            em.remove(email);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new EmailException("E dhena eshte perdorur, nuk mund ta fshini");
            }
            else{
                throw new EmailException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public List<Emails> findlAll() {
        return em.createNamedQuery("Phone.findAll").getResultList();
    }

    @Override
    public Emails findById(String email) throws EmailException {
        Query query = em.createQuery("SELECT email FROM Emails email WHERE email.emailID = :email");
        query.setParameter("email", email);
        try{
            return (Emails)query.getSingleResult();
        }
        catch(NoResultException nre){
            throw new EmailException("E dhena nuk ekziston");
        }
    }
    public List<Emails> findByUserID(Users p){
        Query query = em.createQuery("SELECT u FROM Emails u WHERE u.userID = :p");
        query.setParameter("p", p);
        return query.getResultList();   
    }

   
    
}
