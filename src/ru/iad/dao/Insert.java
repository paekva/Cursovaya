package ru.iad.dao;

import ru.iad.entities.Zoo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.sql.Date;

@Stateless
@LocalBean
public class Insert {

    //@PersistenceContext(unitName = "cursUnit", type = PersistenceContextType.EXTENDED)
    //private EntityManager em;

    public void zooInsert(String zooName, String fuctional, String managerName,  String location, Date dateOfOpening, int staff, int animals)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
        EntityManager em = emf.createEntityManager();
        try {
            Zoo zoo = new Zoo();
            zoo.setНазвание(zooName);
            zoo.setФункциональность(fuctional);
            zoo.setДиректор(managerName);
            zoo.setМестоположение(location);
            zoo.setДатаОснования(dateOfOpening);
            zoo.setШтат(staff);
            zoo.setКоличествоЖивотных(animals);
            em.getTransaction().begin();
            em.persist(zoo);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
