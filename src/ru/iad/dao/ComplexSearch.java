package ru.iad.dao;

import ru.iad.entities.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class ComplexSearch {

    @EJB
    SimpleSearch ss;

    //ANIMALS
    /**
     * Функция поиска записи в таблице
     * @see Animals
     * по виду животного
     * @see AnimalType
     * @return Возвращает список животных данного вида
    **/
    public static List<Animals> searchAnimalByType(String type)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                AnimalType result = SimpleSearch.searchAnimalTypeByName(type);
                int id = result.getIdВида();
                Query query = em.createQuery("SELECT m from Animals as m where m.idВида = :paramName");
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
     * @see Animals
     * по зоопарку
     * @see Zoo
     * @return Возвращает список всех животных данного зоопарка
    **/
    public static List<Animals> searchAnimalByZoo(String zoo)
    {
        Zoo result = SimpleSearch.searchZooByName(zoo);
        int id = result.getIdЗоопарка();
        List list=new ArrayList();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Places as m where m.idЗоопарка = :paramName");
                query.setParameter("paramName", id);
                list = query.getResultList();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        List<Animals> resultList = new ArrayList<Animals>();
        Animals animal;
        Places item;
        for(int i=0;i<list.size();i++)
        {
            item = (Places) list.get(i);
            System.out.println(item.getНазваниеПлощадки());
            animal = SimpleSearch.searchAnimalById(item.getIdЖивотного());
            System.out.println("3 " + i);
            resultList.add(i,animal);
        }
        return resultList;
    }


    //УПОМИНАНИЯ
    /**
     * Функция поиска записи в таблице
     * @see Mentions
     * по типу упоминаний
     * @see MentionType
     * @return Возвращает список всех упоминаний данного типа
    **/
    public static List<Mentions> searchMentionsByType(String type)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                MentionType result = SimpleSearch.searchMentionTypeByName(type);
                int id = result.getIdВидаУпоминания();
                Query query = em.createQuery("SELECT m from Mentions as m where m.idВидаУпоминания = :paramName");
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
     * @see Mentions
     * по зоопарку
     * @see Zoo
     * @return Возвращает список всех упоминаний, относящихся к данному зоопарку непосредственно
    **/
    public static List<Mentions> searchMentionsByZoo(String zoo)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Zoo result = SimpleSearch.searchZooByName(zoo);
                int id = result.getIdЗоопарка();
                Query query = em.createQuery("SELECT m from Mentions as m where m.idЗоопарка = :paramName");
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
     * @see Mentions
     * по зоопарку
     * @see Animals
     * @return Возвращает список всех упоминаний, относящихся к данному животному непосредственно
    **/
    public static List<Animals> searchMentioningByAnimal(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                List<Animals> result = SimpleSearch.searchAnimalByName(name);
                int id = result.get(0).getIdЖивотного();
                Query query = em.createQuery("SELECT m from Mentions as m where m.idЖивотного = :paramName");
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
     * @see Mentions
     * по дате
     * @return Возвращает список всех упоминаний до или после заданной даты
**/
    public static List<Mentions> searchMentionsByDate(Date date, Boolean before)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query;
                if(before) query = em.createQuery("SELECT m from Mentions as m where m.датаПубликации <= :paramName");
                else query = em.createQuery("SELECT m from Mentions as m where m.датаПубликации >= :paramName");
                return query.getResultList();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    //СОТРУДНИКИ
    /**
     * Функция поиска записи в таблице
     * @see Activity
     * по сотруднику
     * @see Employees
     * @return Возвращает список всех видов деятельности данного сотрудника
**/
    public static List<Activity> searchEmployeesActivities(String name)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                List<Employees> result = SimpleSearch.searchEmployeeByName(name);
                int id = result.get(0).getIdСотрудника();

                Query query = em.createQuery("SELECT m from Activity as m where m.idСотрудника = :paramName");
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
     * @see Employees
     * по идентефикатору
     * @see Zoo
     * @return Возвращает список всех сотрудников данного зоопарка
     **/
    public static List<Employees> searchEmployeesByZoo(Integer zooId)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("SELECT m from Activity as m where m.idЗоопарка = :paramName");
                query.setParameter("paramName", zooId);
                List<Activity> activities = query.getResultList();
                List<Employees> employees=new ArrayList<>();
                for(int k=0;k<activities.size();k++)
                {
                    Integer id = activities.get(k).getIdСотрудника();
                    Employees emp = SimpleSearch.searchEmployeeById(id);
                    employees.add(emp);
                }
                return employees;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    //ПРОКАТ
    /**
     * Функция поиска записи в таблице
     * @see ПрокатЖивотныхEntity
     * по дате
     * @return Возвращает список всех событий взятия на прокат до или после заданной даты

    public static List<ПрокатЖивотныхEntity> AnimalRentialSearchByDate(Session session, Date date, Boolean before)
    {
        session.beginTransaction();
        Query query;

        if(before) query = session.createQuery("from ПрокатЖивотныхEntity where датаВзятия <= :paramName");
        else query = session.createQuery("from ПрокатЖивотныхEntity where датаВзятия >= :paramName");

        query.setParameter("paramName", date);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    //МЕРОПРИЯТИЯ
    /**
     * Функция поиска записи в таблице
     * @see Events
     * по типу мероприятий
     * @see EventType
     * @return Возвращает список всех мероприятий данного типа
**/
    public static List<Events> searchEventByType(String type)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                EventType result = SimpleSearch.searchEventTypeByName(type);
                int id = result.getIdТипаМероприятия();
                Query query = em.createQuery("SELECT m from Events as m where m.idТипаМероприятия = :paramName");
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
     * @see Events
     * по зоопарку
     * @see Zoo
     * @return Возвращает список всех мероприятий данного зоопарка
**/
    public static List<Events> searchEventByZoo( String zoo)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Zoo result = SimpleSearch.searchZooByName( zoo);
                int id = result.getIdЗоопарка();

                Query query = em.createQuery("SELECT m from Events as m where m.idЗоопарка = :paramName");
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
     * @see Events
     * по дате
     * @return Возвращает список всех мероприятий до или после заданной даты
**/
    public static List<Events> searchEventByDate(Date date, Boolean before)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query;

                if(before) query = em.createQuery("SELECT m from Events as m where m.датаВремяМероприятия <= :paramName");
                else query = em.createQuery("SELECT m from Events as m where m.датаВремяМероприятия >= :paramName");
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


    //БИЛЕТЫ
    /**
     * Функция поиска записи в таблице
     * @see Tickets
     * по зоопарку
     * @see Zoo
     * @return Возвращает список всех билетов, проданных в данном зоопарке
**/
    public static List<Tickets> searchTicketsByZoo(String zoo)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Zoo result = SimpleSearch.searchZooByName(zoo);
                int id = result.getIdЗоопарка();
                Query query = em.createQuery("SELECT m from Tickets as m where m.idЗоопарка = :paramName");
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


    //ПЛОЩАДКИ
    /**
     * Функция поиска записи в таблице
     * @see Places
     * по зоопарку
     * @see Zoo
     * @return Возвращает список всех площадок, находящихся в данном зоопарке
**/
    public static List<Places> PlaceSearchByZoo(String zoo) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Zoo result = SimpleSearch.searchZooByName(zoo);
                int id = result.getIdЗоопарка();
                Query query = em.createQuery("SELECT m from Places as m where m.idЗоопарка = :paramName");
                query.setParameter("paramName", id);
                return query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}