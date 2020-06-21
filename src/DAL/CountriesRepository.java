package DAL;
import BL.Countries;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class CountriesRepository extends EntMngClass implements CountryInterface {
    
    public void create(Countries cou) throws CountryException {
        try{
            em.getTransaction().begin();
            em.persist(cou);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            
            if(thro.getMessage().contains("2627")){
            
                    throw new CountryException("E dhëna egziston !");
            }
        else{
                throw new CountryException("Create : "+thro.getClass()+" - "+thro.getMessage());
                }
    }
}
    public void edit(Countries cou) throws CountryException {
        try{
            em.getTransaction().begin();
            em.merge(cou);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new CountryException("E dhëna egziston");
            }
            else{
                throw new CountryException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }
    public void remove(Countries cou) throws CountryException {
        try{
            em.getTransaction().begin();
            cou = em.merge(cou);
            em.remove(cou);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new CountryException("Shteti është përdorur, nuk mund ta fshini");
            }
            else{
                 throw new CountryException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    public List <Countries> findAll() {
        return em.createNamedQuery("Countries.findAll").getResultList();
    }
//    public Countries findByFK(String couID) throws ProfesorException, CountryException{
//        Query query = em.createQuery("SELECT c FROM Countries c inner join Users u on c.Country_ID = u.UserID WHERE c.Country_ID = :Country_ID");
//        query.setParameter("Country_ID", couID);
//        try{
//            return (Countries)query.getSingleResult();
//        } catch (NoResultException nre) {
//              throw new CountryException("E dhëna nuk egziston!");
//        }
//    }
    
    @Override
    public Countries findById(String couID) throws CountryException {
        Query query = em.createQuery("SELECT c FROM Countries c WHERE c.Country_ID = :Country_ID");
        query.setParameter("Country_ID", couID);
        try{
            return (Countries)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new CountryException("E dhëna nuk egziston!");
        }
    }

    public Countries findByName(String cr)throws CountryException{
         Query query = em.createQuery("SELECT c FROM Countries c WHERE c.countryName = :cr");
        query.setParameter("cr", cr);
        try{
            return (Countries)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new CountryException("E dhëna nuk egziston!");
        }
    }
   public Countries findByCity(String ct)throws CountryException{
       //select * from Countries c inner join Cities ct on c.Country_ID = ct.Country_ID where ct.City_Name='Peja'

         Query query = em.createQuery("SELECT c FROM Countries c INNER JOIN c.citiesCollection ci where ci.cityName= :ct");
        query.setParameter("ct", ct);
        try{
            return (Countries)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new CountryException("E dhëna nuk egziston!");
        }
    }

    
}

