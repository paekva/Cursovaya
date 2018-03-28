package ru.pip.search;
/*import org.hibernate.SessionFactory;
import ru.pip.dao.crud.HibernateSessionFactory;
import ru.pip.dao.entities.*;
        import org.hibernate.Session;

        import javax.ejb.EJB;
        import javax.ejb.Stateless;
        import javax.ws.rs.POST;
        import javax.ws.rs.Path;
        import javax.ws.rs.PathParam;
        import javax.ws.rs.Produces;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

        import static ru.pip.dao.crud.SimpleSearch.*;
        import static ru.pip.dao.crud.ComplexSearch.*;

@Path("/search/events/")
@Stateless
public class EventsSearchRequests {
    @EJB
    private HibernateSessionFactory mainBean;

    @POST
    @Path("zoo/{zoo}")
    @Produces({"application/xml","application/json"})
    public List<Event> findAnimalsByZoo(@PathParam("zoo") String zoo){
        Session session = mainBean.getSessionFactory().openSession();
        try {
            List<МероприятияEntity> eventList = searchEventByZoo(session,zoo);
            if(eventList == null) throw new Exception();

            List<Event> events = new ArrayList<Event>();

            for (МероприятияEntity a: eventList) {
                Event newEvent = new Event(a.getНазвание(), zoo, a.getIdМероприятия());
                events.add(newEvent);
            }

            return events;
        }
        catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("type/{type}")
    @Produces({"application/xml","application/json"})
    public List<Event> findAnimalsByType(@PathParam("type") String type){
        Session session = mainBean.getSessionFactory().openSession();
        try {
            List<МероприятияEntity> eventList = searchEventByType(session,type);
            if(eventList == null) throw new Exception();

            List<Event> events = new ArrayList<Event>();

            for (МероприятияEntity a: eventList) {
                ЗоопаркиEntity zoo = searchZooById(session,a.getIdЗоопарка());
                Event newEvent = new Event(a.getНазвание(), zoo.getНазвание(), a.getIdМероприятия());
                events.add(newEvent);
            }

            return events;
        }
        catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("date/{date}/{rule}")
    @Produces({"application/xml","application/json"})
    public List<Event> findAnimalsByDate(@PathParam("date") String dateStr,@PathParam("rule") Boolean rule){
        Session session = mainBean.getSessionFactory().openSession();
        try {
            Date date = new Date(); //!!!!!!!!!!!!!!!!!!!!!!
            List<МероприятияEntity> eventList = searchEventByDate(session,date,rule);
            if(eventList == null) throw new Exception();

            List<Event> events = new ArrayList<Event>();

            for (МероприятияEntity a: eventList) {
                ЗоопаркиEntity zoo = searchZooById(session,a.getIdЗоопарка());
                Event newEvent = new Event(a.getНазвание(), zoo.getНазвание(), a.getIdМероприятия());
                events.add(newEvent);
            }

            return events;
        }
        catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("event/{id}")
    @Produces({"application/xml","application/json"})
    public ResponseEvent findEvent(@PathParam("id") Integer id){
        Session session = mainBean.getSessionFactory().openSession();
        try {
            МероприятияEntity foundEvent = searchEventById(session,id);
            ТипыМероприятийEntity type = searchKindOfEventsById(session, foundEvent.getIdТипаМероприятия());
            String zooStr="Не известно";
            if(foundEvent.getIdЗоопарка()!=null)
            {
                ЗоопаркиEntity zoo = searchZooById(session,foundEvent.getIdЗоопарка());
                zooStr = zoo.getНазвание();
            }
            String emplStr="Не известно";
            if(foundEvent.getIdСотрудника()!=null)
            {
                СотрудникиEntity emploee = searchEmployeeById(session,foundEvent.getIdСотрудника());
                emplStr = emploee.getФио();
            }

            ResponseEvent event = new ResponseEvent
                    (foundEvent.getНазвание(),type.getНазваниеТипаМероприятия(), foundEvent.getДатаВремяМероприятия(),
                            foundEvent.getСтоимостьБилетов().toString(),zooStr, emplStr);
            return event;
        }
        catch (Exception e) {
            return null;
        }
    }
}

class Event
{
    private String name;
    private String zoo;
    private Integer id;

    public Event(String name, String zoo, Integer id) {
        this.name = name;
        this.zoo = zoo;
        this.id = id;
    }
}

class ResponseEvent {
    private String name;
    private String type;
    private Date date;
    private String ticketCost;
    private String zoo;
    private String worker;

    public ResponseEvent(String name, String type, Date date, String ticketCost, String zoo, String worker) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.ticketCost = ticketCost;
        this.zoo = zoo;
        this.worker = worker;
    }
}*/
