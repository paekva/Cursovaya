package ru.iad.dao;

import ru.iad.entities.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Stateless
public class SimpleSearch {

    //________# 1 ________________

    /**
     * Функция поиска записи в таблице
     * @see Animals по имени
     * @return Возвращает список животных с таким именем
     */

    public List<Animals> searchAnimalsByName(String name){
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Animals as m WHERE m.имя=:paramName");
                query.setParameter("paramName", name);
                return query.getResultList();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see Animals по id
     * @return Возвращает животное с таким идентификатором
     */
    public static Animals searchAnimalById(  int id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Animals as m WHERE m.idЖивотного=:paramName");
                query.setParameter("paramName", id);
                return (Animals)query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see AnimalType по имени
     * @return Возвращает тип животных, имеющий такое имя
     */
    public static AnimalType searchAnimalTypeByName(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from AnimalType as m WHERE m.название=:paramName");
                query.setParameter("paramName", name);
                return (AnimalType)query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * Функция поиска записи в таблице
     * @see AnimalType по идентификатору
     * @return Возвращает тип животных, имеющий такое id
     */
    public static AnimalType searchAnimalTypeById(int id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from AnimalType as m WHERE m.idВида=:paramName");
                query.setParameter("paramName", id);
                return (AnimalType)query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    //________# 2 ________________

    /**
     * Функция поиска записи в таблице
     * @see Mention по идентификатору
     * @return Возвращает упоминание с таким id
     */
    public static Mention searchMentionById(Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Mention as m WHERE m.idУпоминания=:paramName");
                query.setParameter("paramName", id);
                return (Mention) query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see Mention по имени
     * @return Возвращает упоминание с таким именем
     */

    public static Mention searchMentionByName(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Mention as m WHERE m.названиеУпоминания=:paramName");
                query.setParameter("paramName", name);
                return (Mention)query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see MentionType по имени
     * @return Возвращает тип упоминания, имеющий такое имя
     */
    public static MentionType searchMentionTypeByName(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from MentionType as m WHERE m.названиеВидаУпоминания=:paramName");
                query.setParameter("paramName", name);
                return (MentionType) query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see MentionType по идентификатору
     * @return Возвращает тип упоминания, имеющий такое id
     */
    public static MentionType searchMentionTypeById(Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from MentionType as m WHERE m.idВидаУпоминания=:paramName");
                query.setParameter("paramName", id);
                return (MentionType) query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    //________# 4 ________________
    /**
     * Функция поиска записи в таблице
     * @see Events по идентефикатору
     * @return Возвращает мероприятие с данным id
     */
    public static Events searchEventById(Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Events as m WHERE m.idМероприятия=:paramName");
                query.setParameter("paramName", id);
                return (Events)query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see Events по имени
     * @return Возвращает лист мероприятий, записанных под данным именем
     */
    public static List<Events> searchEventByName(  String name)
    {
        try {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
        EntityManager em = emf.createEntityManager();
        if (em != null) {
            Query query = em.createQuery("SELECT m from Events as m WHERE m.название=:paramName");
            query.setParameter("paramName", name);
            return query.getResultList();
        }
    }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see EventType по идентефикатору
     * @return Возвращает тип мероприятия, имеющий такой id
     */
    public static EventType searchEventTypeById(  Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from EventType as m WHERE m.idТипаМероприятия=:paramName");
                query.setParameter("paramName", id);
                return (EventType) query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see EventType по названию
     * @return Возвращает тип мероприятия, имеющий такое название
     */
    public static EventType searchEventTypeByName(  String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from EventType as m WHERE m.названиеТипаМероприятия=:paramName");
                query.setParameter("paramName", name);
                return (EventType) query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    //________# 5 ________________

    /**
     * Функция поиска записи в таблице
     * @see TicketsType
     * по дате
     * @return Возвращает список всех билетов, купленных до или после заданной даты
     */
    public static List<Tickets> searchTicketsByDate(Date date, Boolean before)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query;
                if(before) query = em.createQuery("SELECT m from Tickets m where m.датаПокупки <= :paramName");
                else query = em.createQuery("SELECT m from Tickets m where m.датаПокупки >= :paramName");
                query.setParameter("paramName", date);
                return query.getResultList();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see TicketsType
     * по дате
     * @return Возвращает список всех билетов, купленных данным пользователем
     */
    /*public static List<Tickets> searchTicketsByUser( Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Tickets as m WHERE m.=:paramName");
                query.setParameter("paramName", name);
                return query.getResultList();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }*/


    /**
     * Функция поиска записи в таблице
     * @see TicketsType по названию
     * @return Возвращает тип категории билета, имеющий такое название
     */
    public static TicketsType searchTicketsTypeByName(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from TicketsType as m WHERE m.названиеКатегории=:paramName");
                query.setParameter("paramName", name);
                return (TicketsType)query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see TicketsType по id
     * @return Возвращает тип категории билета, имеющий такое id
     */
    public static TicketsType searchTicketsTypeById(  Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from TicketsType as m WHERE m.idКатегории=:paramName");
                query.setParameter("paramName", id);
                return (TicketsType)query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    //________# 6 ________________
    /**
     * Функция поиска записи в таблице
     * @see Employees по имени
     * @return Возвращает лист сотрудников, записанных под данным именем
     */
    public static List<Employees> searchEmployeeByName(  String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Employees as m WHERE m.фио=:paramName");
                query.setParameter("paramName", name);
                return query.getResultList();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see Employees по имени
     * @return Возвращает сотрудника с данным идентефикатором
     */
    public static Employees searchEmployeeById(  Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Employees as m WHERE m.idСотрудника=:paramName");
                query.setParameter("paramName", id);
                return (Employees) query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * Функция поиска записи в таблице
     * @see ActivityType по названию
     * @return Возвращает тип деятельности сотрудников зоопарка, имеющий такое название
     */
    public static ActivityType searchActivityTypeById(  String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from ActivityType as m WHERE m.названиеТипаДеятельности=:paramName");
                query.setParameter("paramName", name);
                return (ActivityType)query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    //________# 7 ________________
    /**
     * Функция поиска записи в таблице
     * @see Zoo по имени
     * @return Возвращает лист зоопарков, записанных под данным именем
     */
    public static List<Zoo> searchZooByName(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Zoo as m WHERE m.idЗоопарка=:paramName");
                query.setParameter("paramName", name);
                return query.getResultList();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * Функция поиска записи в таблице
     * @see Zoo по id
     * @return Возвращает лист зоопарков, записанных под данным id
     */
    public static Zoo searchZooById(  Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Zoo as m WHERE m.idЗоопарка=:paramName");
                query.setParameter("paramName", id);
                return (Zoo)query.getResultList().get(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска записи в таблице
     * @see Flora по имени
     * @return Возвращает лист растений, записанных под данным именем
     */
    public static List<Flora> searchFloraByName(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Flora as m WHERE m.названиеВида=:paramName");
                query.setParameter("paramName", name);
                return query.getResultList();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * Функция поиска записи в таблице
     * @see Places по имени
     * @return Возвращает лист площадок, записанных под данным именем
     */
    public static List<Places> searchPlaceById(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Places as m WHERE m.названиеПлощадки=:paramName");
                query.setParameter("paramName", name);
                return query.getResultList();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Функция поиска пользователя
     */
    /*public static List<User> UserSearch(  String username)
    {
        session.beginTransaction();
        Query query = session.createQuery("from User where username = :paramName");
        query.setParameter("paramName", username);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }*/
}
