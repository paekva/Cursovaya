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

    public List<Animals> searchAnimalByName(String name){
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
    public Animals searchAnimalById(  int id)
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
    public AnimalType searchAnimalTypeByName(String name)
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
    public AnimalType searchAnimalTypeById(int id)
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


    /**
     * Функция поиска записи в таблице
     * @see AnimalType
     * @return Возвращает лист зоопарков
     */
    public List<AnimalType> searchAllAnimalTypes()
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from AnimalType as m");
                return query.getResultList();
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
     * @see Mentions по идентификатору
     * @return Возвращает упоминание с таким id
     */
    public Mentions searchMentionById(Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Mentions as m WHERE m.idУпоминания=:paramName");
                query.setParameter("paramName", id);
                return (Mentions) query.getResultList().get(0);
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
     * @see Mentions по имени
     * @return Возвращает упоминание с таким именем
     */

    public Mentions searchMentionByName(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Mentions as m WHERE m.названиеУпоминания=:paramName");
                query.setParameter("paramName", name);
                return (Mentions)query.getResultList().get(0);
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
    public MentionType searchMentionTypeByName(String name)
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
    public MentionType searchMentionTypeById(Integer id)
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

    /**
     * Функция поиска записи в таблице
     * @see MentionType
     * @return Возвращает лист зоопарков
     */
    public List<MentionType> searchAllMentionTypes()
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from MentionType as m");
                return query.getResultList();
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
    public Events searchEventById(Integer id)
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
    public List<Events> searchEventByName(  String name)
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
    public EventType searchEventTypeById(  Integer id)
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
    public EventType searchEventTypeByName(  String name)
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

    /**
     * Функция поиска записи в таблице
     * @see EventType
     * @return Возвращает лист зоопарков
     */
    public List<EventType> searchAllEventTypes()
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from EventType as m");
                return query.getResultList();
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
    public List<Tickets> searchTicketsByDate(Date date, Boolean before)
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
    public List<Tickets> searchTicketsByUser( Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Tickets as m WHERE m.idСотрудника=:paramName");
                query.setParameter("paramName", id);
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
     * @see TicketsType по названию
     * @return Возвращает тип категории билета, имеющий такое название
     */
    public TicketsType searchTicketsTypeByName(String name)
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
    public TicketsType searchTicketsTypeById(  Integer id)
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


    /**
     * Функция поиска записи в таблице
     * @see Tickets
     * @return Возвращает лист зоопарков
     */
    public List<Tickets> searchAllTickets()
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Tickets as m");
                return query.getResultList();
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
    public Employees searchEmployeeByName(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Employees as m WHERE m.фио=:paramName");
                query.setParameter("paramName", name);
                return (Employees)query.getSingleResult();
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
    public Employees searchEmployeeById(  Integer id)
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
    public ActivityType searchActivityTypeByName(  String name)
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
     * @return Возвращает зоопарк под данным именем
     */
    public Zoo searchZooByName(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Zoo as m WHERE m.название=:paramName");
                query.setParameter("paramName", name);
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
     * @see Zoo по id
     * @return Возвращает лист зоопарков, записанных под данным id
     */
    public Zoo searchZooById(  Integer id)
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
     * @see Zoo
     * @return Возвращает лист зоопарков
     */
    public List<Zoo> searchAllZoo()
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Zoo as m");
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
     * @see News
     * @return Возвращает лист зоопарков
     */
    public List<News> searchAllNews()
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from News as m");
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
     * @see News по id
     * @return Возвращает лист зоопарков, записанных под данным id
     */
    public News searchNewsyId(  Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from News as m WHERE m.id=:paramName");
                query.setParameter("paramName", id);
                return (News)query.getResultList().get(0);
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
    public List<Flora> searchFloraByName(String name)
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
    public List<Places> searchPlaceById(String name)
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
     * Функция поиска записи в таблице
     * @see Places по
     * @see Animals
     * @return Возвращает лист площадок, записанных под данным именем
     */
    public Places searchPlaceByAnimal(Animals animal)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Places as m WHERE m.idЖивотного=:paramName");
                query.setParameter("paramName", animal.getIdЖивотного());
                return (Places)query.getSingleResult();
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
     * @see User по имени
     */

    public User searchUserByName(String username)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                em.getTransaction().begin();
                Query query = em.createQuery("SELECT m from User as m WHERE m.username=:paramName");
                query.setParameter("paramName", username);
                User usr=(User)query.getSingleResult();
                em.getTransaction().commit();
                return usr;
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
     * @see User по имени
     */

    public User searchUserById(Integer id)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                em.getTransaction().begin();
                Query query = em.createQuery("SELECT m from User as m WHERE m.id=:paramName");
                query.setParameter("paramName", id);
                User usr=(User)query.getSingleResult();
                em.getTransaction().commit();
                return usr;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
