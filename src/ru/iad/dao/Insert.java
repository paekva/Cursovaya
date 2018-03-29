package ru.iad.dao;

import ru.iad.entities.*;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
public class Insert {

    @EJB
    private SimpleSearch ss;
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
    public void placeInsert( String zoo, String name, String flora, String animal, Integer square)
    {
        try {
            Zoo zooItem= ss.searchZooByName(zoo);
            if(zooItem==null) throw new Exception();
            int idZoo = zooItem.getIdЗоопарка();

            int idKindOfFlora = 0;
            List<Flora> floraItem = ss.searchFloraByName(flora);
            if(floraItem.size()!=0) idKindOfFlora = floraItem.get(0).getIdВидаРастения();

            int idAnimal = 0;
            List <Animals> animalItem = ss.searchAnimalByName(animal);
            if(animalItem.size()!=0) idAnimal = animalItem.get(0).getIdЖивотного();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Places place = new Places();
            place.setНазваниеПлощадки(name);
            place.setIdЗоопарка(idZoo);
            place.setIdВидаРастения(idKindOfFlora);
            place.setIdЖивотного(idAnimal);
            em.getTransaction().begin();
            em.persist(place);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Incorrect data!");
        }
    }

    /**
     * Функция вставки записи в таблицу
     * @see News
     */
    public void newsInsert(String header, String content, Date date)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            News news = new News();
            news.setHeader(header);
            news.setContent(content);
            news.setDate(date);
            em.getTransaction().begin();
            em.persist(news);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see Activity
     */
    public void activityInsert( String kindOfActivity, String zoo, String employee, Double hours)
    {
        try {
            int idZoo;
            Zoo zooItem= ss.searchZooByName(zoo);
            if(zooItem==null) throw new Exception();
            else idZoo = zooItem.getIdЗоопарка();

            ActivityType activityKindItem = ss.searchActivityTypeByName(kindOfActivity);
            if(activityKindItem==null) throw new Exception();
            int idKindOfActivity = activityKindItem.getIdТипаДеятельности();

            List <Employees> employeeItem = ss.searchEmployeeByName(employee);
            if(employeeItem.size()==0) throw new Exception();
            int idEmployee = employeeItem.get(0).getIdСотрудника();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Activity activity = new Activity();
            activity.setIdЗоопарка(idZoo);
            activity.setКоличествоЧасовВНеделю(hours);
            activity.setIdСотрудника(idEmployee);
            activity.setIdТипаДеятельности(idKindOfActivity);
            em.getTransaction().begin();
            em.persist(activity);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    /**
     * Функция вставки записи в таблицу
     * @see AnimalRential
     */

    public void insertAnimalRential(String zooGiving, String animal, Date dateTaken, String zooTaking, String nameOfTaker, String aim, Double cost, Date dateReturn)
    {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Zoo zooG = ss.searchZooByName(zooGiving);
            Zoo zooR = ss.searchZooByName(zooTaking);
            Animals animals = (ss.searchAnimalByName(animal)).get(0);
            AnimalRential ar = new AnimalRential();
            ar.setДатаВзятия(dateTaken);
            ar.setДатаВозврата(dateReturn);
            ar.setIdЖивотного(animals.getIdЖивотного());
            ar.setIdЗоопаркаБерущего(zooR.getIdЗоопарка());
            ar.setIdЗоопаркаДающего(zooG.getIdЗоопарка());
            ar.setЦель(aim);
            ar.setФиоБерущего(nameOfTaker);
            ar.setЦенаУслуги(cost);
            em.getTransaction().begin();
            em.persist(ar);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see Mentions
     */

    public void mentionInsert( String name, String kindOfMentioning, String zoo, String animal, String employee, Date date)
    {
        try {
            MentionType mentioningItem= ss.searchMentionTypeByName(kindOfMentioning);
            if(mentioningItem==null) throw new Exception();
            int idKindOfMentioning = mentioningItem.getIdВидаУпоминания();

            List<Employees> employeeItem = ss.searchEmployeeByName(employee);
            int idEmployee = 0;
            if(employeeItem.size()!=0)idEmployee = employeeItem.get(0).getIdСотрудника();

            Zoo zooItem= ss.searchZooByName(zoo);
            int idZoo = 0;
            if(zooItem != null) idZoo = zooItem.getIdЗоопарка();

            List <Animals> animalItem = ss.searchAnimalByName(animal);
            if(animalItem.size()==0) throw new Exception();
            int idAnimal = animalItem.get(0).getIdЖивотного();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Mentions mentions = new Mentions();
            mentions.setНазваниеУпоминания(name);
            mentions.setIdВидаУпоминания(idKindOfMentioning);
            mentions.setIdЖивотного(idAnimal);
            mentions.setIdЗоопарка(idZoo);
            mentions.setIdСотрудника(idEmployee);
            em.getTransaction().begin();
            em.persist(mentions);
            em.getTransaction().commit();

        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see Events
     */
    public void eventInsert( String name, String zoo, String kind, String employee, Date date, Double duration, Double cost)
    {
        try {
            List <Employees> employeeItem = ss.searchEmployeeByName(employee);
            if(employeeItem.size()==0) throw new Exception();
            int idEmployee = employeeItem.get(0).getIdСотрудника();

            Zoo zooItem= ss.searchZooByName(zoo);
            if(zooItem == null) throw new Exception();
            int idZoo = zooItem.getIdЗоопарка();

            EventType eventItem= ss.searchEventTypeByName(kind);
            if(eventItem==null) throw new Exception();
            int idKind = eventItem.getIdТипаМероприятия();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Events events = new Events();
            events.setНазвание(name);
            events.setIdЗоопарка(idZoo);
            events.setIdТипаМероприятия(idKind);
            events.setIdСотрудника(idEmployee);
            events.setДатаВремяМероприятия(date);
            events.setПродолжительность(duration);
            events.setСтоимостьБилетов(cost);
            em.getTransaction().begin();
            em.persist(events);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see Tickets
     */

    public void ticketInsert( String zoo, String employee, Date date, String category)
    {
        try {
            List <Employees> employeeItem = ss.searchEmployeeByName(employee);
            if(employeeItem.size()==0) throw new Exception();
            int idEmployee = employeeItem.get(0).getIdСотрудника();

            Zoo zooItem= ss.searchZooByName(zoo);
            if(zooItem == null) throw new Exception();
            int idZoo = zooItem.getIdЗоопарка();

            TicketsType categoryItem = ss.searchTicketsTypeByName(category);
            if(categoryItem==null) throw new Exception();
            int idCategory = categoryItem.getIdКатегории();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Tickets tickets = new Tickets();
            tickets.setIdЗоопарка(idZoo);
            tickets.setIdКатегории(idCategory);
            tickets.setIdСотрудника(idEmployee);
            tickets.setДатаПокупки(date);
            em.getTransaction().begin();
            em.persist(tickets);
            em.getTransaction().commit();

        } catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Incorrect data!");
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see Employees
     */
    public void employeeInsert( String name, String sex, String profession, String education, Double workExperience)
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
     * @see Animals
     */
    public void animalInsert( String name, String kind, Date dateOfBirth, String features, String father, String mother, String condition)
    {
        try {
            AnimalType animalKindItem = ss.searchAnimalTypeByName(kind);
            if(animalKindItem==null) throw new Exception();
            int idKind = animalKindItem.getIdВида();

            List<Animals> animalItemF = ss.searchAnimalByName(father);
            int idFather=0;
            if(animalItemF.size()!=0) idFather = animalItemF.get(0).getIdЖивотного();

            List<Animals> animalItemM= ss.searchAnimalByName(mother);
            int idMother=0;
            if(animalItemM.size()!=0) idMother = animalItemM.get(0).getIdЖивотного();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();
            Animals animal = new Animals();
            animal.setIdВида(idKind);
            if(idFather==0) animal.setIdПапы(null);
            else animal.setIdПапы(idFather);

            if(idMother==0) animal.setIdПапы(null);
            else animal.setIdПапы(idMother);
            animal.setДатаРождения(dateOfBirth);
            animal.setОсобенности(features);
            animal.setИмя(name);
            animal.setСостояние(condition) ;
            em.getTransaction().begin();
            em.persist(animal);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Функция вставки записи в таблицу
     * @see Flora
     */
    public void floraInsert( String nameOfKind, String featuresOfKind)
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
    public void activityTypeInsert( String nameOfKindOfActivity, String description)
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
    public void ticketsTypeInsert( String nameOfCategory, String description, Double cost)
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
    public void mentionTypeInsert( String nameOfKindOfMentionings)
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
    public void eventTypeInsert( String nameOfKindOfEvents)
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
    public void animalTypeInsert( String name, String features, Double average)
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
    public int userInsert( String username, String password, String role)
    {
        try {
            String userRole;
            if(role.equals("admin")) userRole = "ADMIN";
            else userRole = "USER";

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursUnit");
            EntityManager em = emf.createEntityManager();

            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setRole(userRole);
            newUser.setInfo("");
            newUser.setEmail("");
            newUser.setName("");

            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();
            return 0;
        } catch(Exception e)
        {
            return 1;
        }
    }
}

