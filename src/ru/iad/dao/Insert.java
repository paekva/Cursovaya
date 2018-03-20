package ru.iad.dao;

import ru.iad.entities.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
public class Insert {

    //Зоопарки

    /**
     * Функция вставки записи в таблицу
     * @see Zoo
     */
    public void zooInsert(String zooName, String fuctional, String managerName, String location, Date dateOfOpening, int staff, int animals)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
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

    /**
     * Функция вставки записи в таблицу
     * @see Places
     */
    public static void placeInsert( String zoo, String name, String flora, String animal, Integer square)
    {
        try {
            Zoo zooItem= SimpleSearch.searchZooByName(zoo);
            if(zooItem==null) throw new Exception();
            int idZoo = zooItem.getIdЗоопарка();

            int idKindOfFlora = 0;
            List<Flora> floraItem = SimpleSearch.searchFloraByName(flora);
            if(floraItem.size()!=0) idKindOfFlora = floraItem.get(0).getIdВидаРастения();

            int idAnimal = 0;
            List <Animals> animalItem = SimpleSearch.searchAnimalByName(animal);
            if(animalItem.size()!=0) idAnimal = animalItem.get(0).getIdЖивотного();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Places place = new Places();
            place.setНазваниеПлощадки(name);
            place.setIdЗоопарка(idZoo);
            /*MORE HERE*/
            em.getTransaction().begin();
            em.persist(zoo);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Incorrect data!");
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see Activity
     */
    public static void activityInsert( String kindOfActivity, String zoo, String employee, Double hours)
    {
        try {
            int idZoo;
            Zoo zooItem= SimpleSearch.searchZooByName(zoo);
            if(zooItem==null) throw new Exception();
            else idZoo = zooItem.getIdЗоопарка();

            ActivityType activityKindItem = SimpleSearch.searchActivityTypeByName(kindOfActivity);
            if(activityKindItem==null) throw new Exception();
            int idKindOfActivity = activityKindItem.getIdТипаДеятельности();

            List <Employees> employeeItem = SimpleSearch.searchEmployeeByName(employee);
            if(employeeItem.size()==0) throw new Exception();
            int idEmployee = employeeItem.get(0).getIdСотрудника();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Activity activity = new Activity();
            activity.setIdЗоопарка(idZoo);
            activity.setКоличествоЧасовВНеделю(hours);
            /*MORE HERE*/
            em.getTransaction().begin();
            em.persist(zoo);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    /**
     * Функция вставки записи в таблицу
     * @see ПрокатЖивотныхEntity
     */
    /*
    public static void RentAnimalInsert( String zooGiving, String animal, Date dateTaken, String zooTaking, String name, String aim, Double cost, Date dateReturn)
    {
        try {
            List <Zoo> zooItemG= SimpleSearch.searchZooByName(session,zooGiving);
            if(zooItemG.size()==0) throw new Exception();
            int idZooGiving = zooItemG.get(0).getIdЗоопарка();

            List <Zoo> zooItemT= SimpleSearch.searchZooByName(session,zooTaking);
            int idZooTaking = 0;
            if(zooItemT.size()!=0) idZooTaking = zooItemT.get(0).getIdЗоопарка();

            List <ЖивотныеEntity> animalItem = SimpleSearch.searchAnimalByName(session,animal);
            if(animalItem.size()==0) throw new Exception();
            int idAnimal = animalItem.get(0).getIdЖивотного();

            session.beginTransaction();
            ПрокатЖивотныхEntity rentAnimal = new ПрокатЖивотныхEntity();
            rentAnimal.setIdЗоопаркаДающего(idZooGiving);
            rentAnimal.setIdЖивотного(idAnimal);
            rentAnimal.setДатаВзятия(dateTaken);
            if(idZooTaking!=0) rentAnimal.setIdЗоопаркаБерущего(idZooTaking);
            rentAnimal.setФиоБерущего(name);
            rentAnimal.setЦель(aim);
            rentAnimal.setЦенаУслуги(cost) ;
            rentAnimal.setДатаВозврата(dateReturn);
            session.save(rentAnimal);
            session.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }*/


    /**
     * Функция вставки записи в таблицу
     * @see УпоминанияОЗоопаркеEntity
     */
    /*
    public static void MentioningInsert( String name, String kindOfMentioning, String zoo, String animal, String employee, Date date)
    {
        try {
            ВидыУпоминанийEntity mentioningItem= SimpleSearch.searchKindOfMentionByName(session, kindOfMentioning);
            if(mentioningItem==null) throw new Exception();
            int idKindOfMentioning = mentioningItem.getIdВидаУпоминания();

            List<СотрудникиEntity> employeeItem = SimpleSearch.EmployeeSearchByName(session,employee);
            int idEmployee = 0;
            if(employeeItem.size()!=0)idEmployee = employeeItem.get(0).getIdСотрудника();

            List <Zoo> zooItem= SimpleSearch.searchZooByName(session,zoo);
            int idZoo = 0;
            if(zooItem.size()!=0) idZoo = zooItem.get(0).getIdЗоопарка();

            List <ЖивотныеEntity> animalItem = SimpleSearch.searchAnimalByName(session,animal);
            if(animalItem.size()==0) throw new Exception();
            int idAnimal = animalItem.get(0).getIdЖивотного();

            session.beginTransaction();
            УпоминанияОЗоопаркеEntity mentioning = new УпоминанияОЗоопаркеEntity();
            mentioning.setНазваниеУпоминания(name);
            mentioning.setIdВидаУпоминания(idKindOfMentioning);
            if(idZoo!=0) mentioning.setIdЗоопарка(idZoo);
            mentioning.setIdЖивотного(idAnimal);
            if(idEmployee!=0) mentioning.setIdСотрудника(idEmployee);
            mentioning.setДатаПубликации(date);
            session.save(mentioning);
            session.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    */

    /**
     * Функция вставки записи в таблицу
     * @see МероприятияEntity
     */
    /*
    public static void EventInsert( String name, String zoo, String kind, String employee, Date date, Double duration, Double cost)
    {
        try {
            List <СотрудникиEntity> employeeItem = SimpleSearch.EmployeeSearchByName(session,employee);
            if(employeeItem.size()==0) throw new Exception();
            int idEmployee = employeeItem.get(0).getIdСотрудника();

            List <Zoo> zooItem= SimpleSearch.searchZooByName(session,zoo);
            if(zooItem.size()==0) throw new Exception();
            int idZoo = zooItem.get(0).getIdЗоопарка();

            ТипыМероприятийEntity eventItem= SimpleSearch.searchKindOfEventsByName(session,kind);
            if(eventItem==null) throw new Exception();
            int idKind = eventItem.getIdТипаМероприятия();

            session.beginTransaction();
            МероприятияEntity event = new МероприятияEntity();
            event.setНазвание(name);
            event.setIdЗоопарка(idZoo);
            event.setIdТипаМероприятия(idKind);
            event.setIdСотрудника(idEmployee);
            event.setДатаВремяМероприятия(date);
            event.setПродолжительность(duration);
            event.setСтоимостьБилетов(cost) ;
            session.save(event);
            session.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }*/

    /**
     * Функция вставки записи в таблицу
     * @see БилетыEntity
     */
    /*
    public static void TicketInsert( String zoo, String employee, Date date, String category)
    {
        try {
            List <СотрудникиEntity> employeeItem = SimpleSearch.EmployeeSearchByName(session,employee);
            if(employeeItem.size()==0) throw new Exception();
            int idEmployee = employeeItem.get(0).getIdСотрудника();

            List <Zoo> zooItem= SimpleSearch.searchZooByName(session,zoo);
            if(zooItem.size()==0) throw new Exception();
            int idZoo = zooItem.get(0).getIdЗоопарка();

            ВидыКатегорийEntity categoryItem = SimpleSearch.searchKindOfCategoryByName(session,category);
            if(categoryItem==null) throw new Exception();
            int idCategory = categoryItem.getIdКатегории();

            session.beginTransaction();
            БилетыEntity ticket = new БилетыEntity();
            ticket.setIdЗоопарка(idZoo);
            ticket.setIdСотрудника(idEmployee);
            ticket.setДатаПокупки(date);
            ticket.setIdКатегории(idCategory);
            session.save(ticket);
            session.getTransaction().commit();

        } catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Incorrect data!");
        }
    }*/


    /**
     * Функция вставки записи в таблицу
     * @see Employees
     */
    public static void employeeInsert( String name, String sex, String profession, String education, Double workExperience)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Employees employee = new Employees();
            employee.setФио(name);
            employee.setПол(sex);
            employee.setОбразование(education);
            employee.setПрофессия(profession);
            employee.setСтажРаботы(workExperience);
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see ЖивотныеEntity
     */
    /*
    public static void AnimalInsert( String name, String kind, Date dateOfBirth, String features, String father, String mother, String condition)
    {
        try {
            ВидыЖивотныхEntity animalKindItem = SimpleSearch.searchKindOfAnimalByName(session,kind);
            if(animalKindItem==null) throw new Exception();
            int idKind = animalKindItem.getIdВида();

            List<ЖивотныеEntity> animalItemF = SimpleSearch.searchAnimalByName(session,father);
            int idFather=0;
            if(animalItemF.size()!=0) idFather = animalItemF.get(0).getIdЖивотного();

            List<ЖивотныеEntity> animalItemM= SimpleSearch.searchAnimalByName(session,mother);
            int idMother=0;
            if(animalItemM.size()!=0) idMother = animalItemM.get(0).getIdЖивотного();


            session.beginTransaction();
            ЖивотныеEntity animal = new ЖивотныеEntity();
            animal.setIdВида(idKind);
            animal.setИмя(name);
            animal.setДатаРождения(dateOfBirth);
            animal.setОсобенности(features);

            if(idFather==0) animal.setIdПапы(null);
            else animal.setIdПапы(idFather);

            if(idMother==0) animal.setIdПапы(null);
            else animal.setIdПапы(idMother);

            animal.setСостояние(condition) ;
            session.save(animal);
            session.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    */


    /**
     * Функция вставки записи в таблицу
     * @see Flora
     */
    public static void floraInsert( String nameOfKind, String featuresOfKind)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Flora flora = new Flora();
            flora.setНазваниеВида(nameOfKind);
            flora.setОсобенностиВида(featuresOfKind);
            em.getTransaction().begin();
            em.persist(flora);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see ActivityType
     */
    public static void activityTypeInsert( String nameOfKindOfActivity, String description)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            ActivityType activityType = new ActivityType();
            activityType.setНазваниеТипаДеятельности(nameOfKindOfActivity);
            activityType.setОписаниеДеятельности(description);
            em.getTransaction().begin();
            em.persist(activityType);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see TicketsType
     */
    public static void ticketsTypeInsert( String nameOfCategory, String description, Double cost)
    {
        try {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            TicketsType ticketsType = new TicketsType();
            ticketsType.setНазваниеКатегории(nameOfCategory);
            ticketsType.setОписаниеКатегории(description);
            ticketsType.setСтоимость(cost);
            em.getTransaction().begin();
            em.persist(ticketsType);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see MentionType
     */
    public static void mentionTypeInsert( String nameOfKindOfMentionings)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            MentionType mentionType = new MentionType();
            mentionType.setНазваниеВидаУпоминания(nameOfKindOfMentionings);
            em.getTransaction().begin();
            em.persist(mentionType);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see EventType
     */
    public static void eventTypeInsert( String nameOfKindOfEvents)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            EventType eventType = new EventType();
            eventType.setНазваниеТипаМероприятия(nameOfKindOfEvents);
            em.getTransaction().begin();
            em.persist(eventType);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see AnimalType
     */
    public static void animalTypeInsert( String name, String features, Double average)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            AnimalType kindOfAnimals = new AnimalType();
            kindOfAnimals.setНазвание(name);
            kindOfAnimals.setОсобенности(features);
            kindOfAnimals.setСрПродолжЖизни(average);
            em.getTransaction().begin();
            em.persist(kindOfAnimals);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    /**
     * Добавление нового пользователя
     */


    /*
    public static void UserInsert( String username, String password, String role) throws Exception
    {
            session.beginTransaction();
            Roles userRole;
            if(role.equals("admin")) userRole = Roles.ADMIN;
            else userRole = Roles.USER;
            User newUser = new User(username, password, userRole);
            session.save(newUser);
            session.getTransaction().commit();
    }
    */
}

