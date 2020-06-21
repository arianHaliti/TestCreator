/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BL.Cities;
import BL.Countries;
import BL.Students;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
/**
 *
 * @author Hello
 */
public class CityRepository extends EntMngClass implements CityInterface{

    @Override
    public void create(Cities city) throws CityException {
        try{
            em.getTransaction().begin();
            em.persist(city);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                throw new CityException("E dhena ekziston");
            }
            else{
                throw new CityException("Create : "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public void edit(Cities city) throws CityException  {
        try{
            em.getTransaction().begin();
            em.merge(city);
            em.getTransaction().commit();
        }
        catch(Throwable thro){
            if(thro.getMessage().contains("2627")){
                    throw new CityException("E dhëna egziston");
            }
            else{
                throw new CityException("Update: "+thro.getClass()+" - "+thro.getMessage());
            }
                
        }
    }

    @Override
    public void remove(Cities city) throws CityException {
        try{
            em.getTransaction().begin();
            city = em.merge(city);
            em.remove(city);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new CityException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new CityException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public List<Cities> findAll() {
        return em.createNamedQuery("Cities.findAll").getResultList();
    }
    public List<Cities> findByCountry(Countries d){
        Query query = em.createQuery("SELECT c FROM Cities c WHERE c.countryID  = :d");
        query.setParameter("d", d);
        
        return query.getResultList();
    }

    @Override
    public Cities findById(Cities d) throws CityException {
        Query query = em.createQuery("SELECT c FROM Cities c WHERE c.City_ID = :d");
        query.setParameter("d", d);
        try{
            return (Cities)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new CityException("E dhëna nuk egziston!");
        }
    }
    public List<Cities> findByCountryName(String d)  {
        Query query = em.createQuery("SELECT ci FROM Countries c INNER JOIN c.citiesCollection ci WHERE c.countryname = :d ");
        query.setParameter("d", d);
        
        return query.getResultList();
    }
     public Cities findByName(String d) throws CityException {
        Query query = em.createQuery("SELECT c FROM Cities c WHERE c.cityName = :d");
        query.setParameter("d", d);
        try{
            return (Cities)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new CityException("Qyteti nuk egziston!");
        }
    }
     public Cities findCityByStdId(Students s) throws AddressException {
//        select * from Cities c inner join Addresses ad  on c.City_ID=ad.City_ID where ad.StudentID = 2

        Query query = em.createQuery("SELECT c FROM Cities c INNER JOIN c.addressesCollection ad where ad.studentID =:s");
        query.setParameter("s", s);
        try{
            return (Cities)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new AddressException("Adresa nuk egziston!") {};
        }
    }    
    
}
