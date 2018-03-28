package ru.iad.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
public class Update {
    /**
     * Функция обновления записи в таблице
     * @see ru.iad.entities.Animals
     * полей Особенности и состояние
     * @return Возвращает логический тип успешно совершенной операции
    **/
    public static boolean animalUpdate(Integer id, String features, String state)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                em.getTransaction().begin();
                Query query = em.createQuery("update Animals as m set m.особенности = :features, m.состояние = :state where m.idЖивотного = :id");
                query.setParameter("id", id);
                query.setParameter("features", features);
                query.setParameter("state", state);
                int result = query.executeUpdate();
                em.getTransaction().commit();
                if(result>0) return true;
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Функция обновления записи в таблице
     * @see ru.iad.entities.Zoo
     * полей Директор и функционирование
     * @return Возвращает логический тип успешно совершенной операции
**/
    public static boolean zooUpdate(String name, String director, String functional)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("update Zoo as m set m.директор = :director, m.функциональность = :functional where m.название = :nameCode");
                query.setParameter("nameCode", name);
                query.setParameter("director", director);
                query.setParameter("functional", functional);
                int result = query.executeUpdate();
                if(result>0) return true;
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see ru.iad.entities.Places
     * поля площадь вольера
     * @return Возвращает логический тип успешно совершенной операции
**/
    public static boolean placeUpdate(String name, Integer square) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("update Places as m set m.площадь = :square where m.названиеПлощадки = :nameCode");
                query.setParameter("nameCode", name);
                query.setParameter("square", square);
                int result = query.executeUpdate();
                if(result>0) return true;
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see ru.iad.entities.Flora
     * поля особенности
     * @return Возвращает логический тип успешно совершенной операции
**/
    public static boolean floraUpdate(String name, String features)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("update Flora as m set m.особенностиВида = :features" +
                        " where m.названиеВида = :nameCode");
                query.setParameter("nameCode", name);
                query.setParameter("features", features);
                int result = query.executeUpdate();
                if(result>0) return true;
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see ru.iad.entities.Employees
     * поля опыт работы
     * @return Возвращает логический тип успешно совершенной операции
**/
    public static boolean employeeUpdate(String name, Double workExperience)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("update Employees as m set m.стажРаботы = :workExperience" +
                        " where m.фио = :nameCode");
                query.setParameter("nameCode", name);
                query.setParameter("workExperience", workExperience);
                int result = query.executeUpdate();
                if(result>0) return true;
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see ru.iad.entities.Tickets
     * поля стоимость
     * @return Возвращает логический тип успешно совершенной операции
**/
    public static boolean ticketTypeUpdate(String name, Double cost)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("update TicketsType as m set m.стоимость = :cost" +
                        " where m.названиеКатегории = :nameCode");
                query.setParameter("nameCode", name);
                query.setParameter("cost", cost);
                int result = query.executeUpdate();
                if(result>0) return true;
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see ru.iad.entities.ActivityType
     * поля описание
     * @return Возвращает логический тип успешно совершенной операции
**/
    public static boolean activityTypeUpdate(String name, String description)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("update ActivityType as m set m.описаниеДеятельности = :description" +
                        " where m.названиеТипаДеятельности = :nameCode");
                query.setParameter("nameCode", name);
                query.setParameter("description", description);
                int result = query.executeUpdate();
                if(result>0) return true;
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see ru.iad.entities.MentionType
     * поля описание
     * @return Возвращает логический тип успешно совершенной операции
**/
    public static boolean mentionTypeUpdate(String nameNew, String nameOld)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("update MentionType as m set m.названиеВидаУпоминания = :name" +
                        " where m.названиеВидаУпоминания = :nameCode");
                query.setParameter("nameCode", nameOld);
                query.setParameter("name", nameNew);
                int result = query.executeUpdate();
                if(result>0) return true;
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see ru.iad.entities.Activity
     * поля число часов работы
     * @return Возвращает логический тип успешно совершенной операции
**/
    public static boolean activityUpdate(Double count)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("update Activity as m set m.количествоЧасовВНеделю = :count" +
                        " where m.idТипаДеятельности = :idKind AND m.idСотрудника= : idEmployee");
                query.setParameter("count", count);
                int result = query.executeUpdate();
                if(result>0) return true;
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Функция обновления информации о пользователе
**/
    public static boolean userInfoUpdate(String username, String name, String email, String info)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            if (em != null) {
                Query query = em.createQuery("update User as m set m.name = :name" +
                        ", m.email = :email" + ", m.info = :info" + " where m.username = :username");
                query.setParameter("username", username);
                query.setParameter("name", name);
                query.setParameter("email", email);
                query.setParameter("info", info);
                em.getTransaction().begin();
                int result = query.executeUpdate();
                em.getTransaction().commit();
                if(result>0) return true;
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}