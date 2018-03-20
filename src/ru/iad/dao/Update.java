package ru.iad.dao;

public class Update {
    /**
     * Функция обновления записи в таблице
     * @see Animals
     * полей Особенности и состояние
     * @return Возвращает логический тип успешно совершенной операции

    public static boolean animalUpdate(Session session, String name, String features, String state)
    {
        session.beginTransaction();
        Query query = session.createQuery("update ЖивотныеEntity set особенности = :features" +
                ", состояние = :state" + " where имя = :nameCode");
        query.setParameter("nameCode", name);
        query.setParameter("features", features);
        query.setParameter("state", state);
        int result = query.executeUpdate();
        if(result>0) return true;
        return false;
    }
    /**
     * Функция обновления записи в таблице
     * @see dao.entities.ЗоопаркиEntity
     * полей Директор и функционирование
     * @return Возвращает логический тип успешно совершенной операции

    public static boolean zooUpdate(Session session, String name, String director, String functional)
    {
        session.beginTransaction();
        Query query = session.createQuery("update ЗоопаркиEntity set директор = :director" +
                ", функциональность = :functional"+ " where название = :nameCode");
        query.setParameter("nameCode", name);
        query.setParameter("director", director);
        query.setParameter("functional", functional);
        int result = query.executeUpdate();
        if(result>0) return true;
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see dao.entities.ПлощадкиEntity
     * поля площадь вольера
     * @return Возвращает логический тип успешно совершенной операции

    public static boolean placeUpdate(Session session, String name, Integer square) {
        session.beginTransaction();
        Query query = session.createQuery("update ПлощадкиEntity set площадь = :square" +
                " where названиеПлощадки = :nameCode");
        query.setParameter("nameCode", name);
        query.setParameter("square", square);
        int result = query.executeUpdate();
        if (result > 0) return true;
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see dao.entities.ФлораEntity
     * поля особенности
     * @return Возвращает логический тип успешно совершенной операции

    public static boolean floraUpdate(Session session, String name, String features)
    {
        session.beginTransaction();
        Query query = session.createQuery("update ФлораEntity set особенностиВида = :features" +
                " where названиеВида = :nameCode");
        query.setParameter("nameCode", name);
        query.setParameter("features", features);
        int result = query.executeUpdate();
        if(result>0) return true;
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see dao.entities.СотрудникиEntity
     * поля опыт работы
     * @return Возвращает логический тип успешно совершенной операции

    public static boolean employeeUpdate(Session session, String name, Double workExperience)
    {
        session.beginTransaction();
        Query query = session.createQuery("update СотрудникиEntity set стажРаботы = :workExperience" +
                " where фио = :nameCode");
        query.setParameter("nameCode", name);
        query.setParameter("workExperience", workExperience);
        int result = query.executeUpdate();
        if(result>0) return true;
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see dao.entities.ВидыКатегорийEntity
     * поля стоимость
     * @return Возвращает логический тип успешно совершенной операции

    public static boolean kindOfCategoryUpdate(Session session, String name, Double cost)
    {
        session.beginTransaction();
        Query query = session.createQuery("update ВидыКатегорийEntity set стоимость = :cost" +
                " where названиеКатегории = :nameCode");
        query.setParameter("nameCode", name);
        query.setParameter("cost", cost);
        int result = query.executeUpdate();
        if(result>0) return true;
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see dao.entities.ВидДеятельностиEntity
     * поля описание
     * @return Возвращает логический тип успешно совершенной операции

    public static boolean kindOfActivityUpdate(Session session, String name, String description)
    {
        session.beginTransaction();
        Query query = session.createQuery("update ТипДеятельностиEntity set описаниеДеятельности = :description" +
                " where названиеТипаДеятельности = :nameCode");
        query.setParameter("nameCode", name);
        query.setParameter("description", description);
        int result = query.executeUpdate();
        if(result>0) return true;
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see dao.entities.ВидыУпоминанийEntity
     * поля описание
     * @return Возвращает логический тип успешно совершенной операции

    public static boolean kindOfMentioningUpdateId(Session session, String nameNew, String nameOld)
    {
        session.beginTransaction();
        Query query = session.createQuery("update ВидыУпоминанийEntity set названиеВидаУпоминания = :name" +
                " where названиеВидаУпоминания = :nameCode");
        query.setParameter("nameCode", nameOld);
        query.setParameter("name", nameNew);
        int result = query.executeUpdate();
        if(result>0) return true;
        return false;
    }

    /**
     * Функция обновления записи в таблице
     * @see dao.entities.ТипДеятельностиEntity
     * поля число часов работы
     * @return Возвращает логический тип успешно совершенной операции

    public static boolean typeOfActivityUpdateId(Session session, Double count)
    {
        session.beginTransaction();
        Query query = session.createQuery("update ВидДеятельностиEntity set количествоЧасовВНеделю = :count" +
                " where idТипаДеятельности = :idKind AND idСотрудника= : idEmployee");
        query.setParameter("count", count);
        int result = query.executeUpdate();
        if(result>0) return true;
        return false;
    }


    /**
     * Функция обновления информации о пользователе

    public static boolean updateUserInfo(Session session, String username, String name, String email, String info)
    {
        session.beginTransaction();
        Query query = session.createQuery("update User set name = :name" +
                ", email = :email" + ", info = :info" + " where username = :username");
        query.setParameter("username", username);
        query.setParameter("name", name);
        query.setParameter("email", email);
        query.setParameter("info", info);
        int result = query.executeUpdate();
        if(result>0) return true;
        return false;
    }
}*/
}