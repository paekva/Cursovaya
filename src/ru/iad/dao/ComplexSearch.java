package ru.iad.dao;

import ru.iad.entities.*;

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
     * @see УпоминанияОЗоопаркеEntity
     * по типу упоминаний
     * @see ВидыУпоминанийEntity
     * @return Возвращает список всех упоминаний данного типа

    public static List<УпоминанияОЗоопаркеEntity> searchMentionsByType(Session session, String type)
    {
        ВидыУпоминанийEntity result = SimpleSearch.searchKindOfMentionByName(session, type);;
        int id = result.getIdВидаУпоминания();
        session.beginTransaction();
        Query query = session.createQuery("from УпоминанияОЗоопаркеEntity where названиеУпоминания = :paramName");
        query.setParameter("paramName", id);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    /**
     * Функция поиска записи в таблице
     * @see УпоминанияОЗоопаркеEntity
     * по зоопарку
     * @see ЗоопаркиEntity
     * @return Возвращает список всех упоминаний, относящихся к данному зоопарку непосредственно

    public static List<УпоминанияОЗоопаркеEntity> searchMentionsByZoo(Session session, String zoo)
    {
        List<ЗоопаркиEntity> result = SimpleSearch.searchZooByName(session, zoo);;
        int id = result.get(0).getIdЗоопарка();
        session.beginTransaction();
        Query query = session.createQuery("from УпоминанияОЗоопаркеEntity where названиеУпоминания = :paramName");
        query.setParameter("paramName", id);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    /**
     * Функция поиска записи в таблице
     * @see УпоминанияОЗоопаркеEntity
     * по зоопарку
     * @see ЗоопаркиEntity
     * @return Возвращает список всех упоминаний, относящихся к данному зоопарку непосредственно

    public static List<УпоминанияОЗоопаркеEntity> searchMentioningByAnimal(Session session, Integer id)
    {
        session.beginTransaction();
        Query query = session.createQuery("from УпоминанияОЗоопаркеEntity where idЖивотного = :paramName");
        query.setParameter("paramName", id);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    /**
     * Функция поиска записи в таблице
     * @see УпоминанияОЗоопаркеEntity
     * по дате
     * @return Возвращает список всех упоминаний до или после заданной даты

    public static List<УпоминанияОЗоопаркеEntity> searchMentionsByDate(Session session, Date date, Boolean before)
    {
        session.beginTransaction();
        Query query;

        if(before) query = session.createQuery("from УпоминанияОЗоопаркеEntity where датаПубликации <= :paramName");
        else query = session.createQuery("from УпоминанияОЗоопаркеEntity where датаПубликации >= :paramName");

        query.setParameter("paramName", date);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    //СОТРУДНИКИ
    /**
     * Функция поиска записи в таблице
     * @see УпоминанияОЗоопаркеEntity
     * по зоопарку
     * @see ЗоопаркиEntity
     * @return Возвращает список всех видов деятельности данного сотрудника

    public static List<ВидДеятельностиEntity> EmployeesActivities(Session session, String name)
    {
        List<СотрудникиEntity> result = SimpleSearch.EmployeeSearchByName(session, name);;
        int id = result.get(0).getIdСотрудника();
        session.beginTransaction();
        Query query = session.createQuery("from ВидДеятельностиEntity where idСотрудника = :paramName");
        query.setParameter("paramName", id);
        List list = query.list();
        session.getTransaction().commit();
        return list;
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
     * @see МероприятияEntity
     * по типу мероприятий
     * @see ТипыМероприятийEntity
     * @return Возвращает список всех мероприятий данного типа

    public static List<МероприятияEntity> searchEventByType(Session session, String type)
    {
        ТипыМероприятийEntity result = SimpleSearch.searchKindOfEventsByName(session, type);
        int id = result.getIdТипаМероприятия();
        session.beginTransaction();
        Query query = session.createQuery("from МероприятияEntity where idТипаМероприятия = :paramName");
        query.setParameter("paramName", id);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    /**
     * Функция поиска записи в таблице
     * @see МероприятияEntity
     * по зоопарку
     * @see ЗоопаркиEntity
     * @return Возвращает список всех мероприятий данного зоопарка

    public static List<МероприятияEntity> searchEventByZoo(Session session, String zoo)
    {
        List<ЗоопаркиEntity> result = SimpleSearch.searchZooByName(session, zoo);
        int id = result.get(0).getIdЗоопарка();
        session.beginTransaction();
        Query query = session.createQuery("from МероприятияEntity where idЗоопарка = :paramName");
        query.setParameter("paramName", id);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    /**
     * Функция поиска записи в таблице
     * @see МероприятияEntity
     * по дате
     * @return Возвращает список всех мероприятий до или после заданной даты

    public static List<МероприятияEntity> searchEventByDate(Session session,Date date, Boolean before)
    {
        session.beginTransaction();
        Query query;

        if(before) query = session.createQuery("from МероприятияEntity where датаВремяМероприятия <= :paramName");
        else query = session.createQuery("from МероприятияEntity where датаВремяМероприятия >= :paramName");

        query.setParameter("paramName", date);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }


    //БИЛЕТЫ
    /**
     * Функция поиска записи в таблице
     * @see БилетыEntity
     * по зоопарку
     * @see ЗоопаркиEntity
     * @return Возвращает список всех билетов, проданных в данном зоопарке

    public static List<БилетыEntity> searchTicketsByZoo(Session session, String zoo)
    {
        List<ЗоопаркиEntity> result = SimpleSearch.searchZooByName(session, zoo);
        int id = result.get(0).getIdЗоопарка();
        session.beginTransaction();
        Query query = session.createQuery("from БилетыEntity where idЗоопарка = :paramName");
        query.setParameter("paramName", id);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }


    //ПЛОЩАДКИ
    /**
     * Функция поиска записи в таблице
     * @see ПлощадкиEntity
     * по зоопарку
     * @see ЗоопаркиEntity
     * @return Возвращает список всех площадок, находящихся в данном зоопарке

    public static List<ПлощадкиEntity> PlaceSearchByZoo(Session session, String zoo)
    {
        List<ЗоопаркиEntity> result = SimpleSearch.searchZooByName(session, zoo);
        int id = result.get(0).getIdЗоопарка();
        session.beginTransaction();
        Query query = session.createQuery("from ПлощадкиEntity where idЗоопарка = :paramName");
        query.setParameter("paramName", id);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }
}
*/
}