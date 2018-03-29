package ru.iad.restful.search;

import com.google.gson.Gson;
import ru.iad.dao.ComplexSearch;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.ResponseEvent;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;


@Path("/search/events/")
@Stateless
public class EventsSearchRequests {
    @EJB
    private SimpleSearch ss;

    @EJB
    ComplexSearch cs;

    @POST
    @Path("byZoo")
    @Produces({"application/xml","application/json"})
    public String findEventsByZoo(@FormParam("zoo") String zoo){
        List<Events> eventsList = cs.searchEventByZoo(zoo);
        List<EventHelp> re=new ArrayList<>();
        for(Events e: eventsList)
        {
            EventHelp eh = new EventHelp(
                    e.getНазвание(),zoo,e.getIdМероприятия()
            );
            re.add(eh);
        }
        Gson gson = new Gson();
        return gson.toJson(re);
    }

    @POST
    @Path("byName")
    @Produces({"application/xml","application/json"})
    public String findEventsByName(@FormParam("name") String name){
        Gson gson = new Gson();
        List<EventHelp> re = new ArrayList<>();
        List<Events> events = ss.searchEventByName(name);
        for(Events e:events)
        {
            Zoo zoo = ss.searchZooById(e.getIdЗоопарка());
            EventHelp eh = new EventHelp(
                    e.getНазвание(),zoo.getНазвание(),e.getIdМероприятия()
            );
            re.add(eh);
        }
        return gson.toJson(events);
    }


    @POST
    @Path("byType")
    @Produces({"application/xml","application/json"})
    public String findEventsByType(@FormParam("type") String type){
        Gson gson = new Gson();
        List<EventHelp> re = new ArrayList<>();
        List<Events> eventsList = cs.searchEventByType(type);
        for(Events e:eventsList)
        {
            Zoo zoo = ss.searchZooById(e.getIdЗоопарка());
            EventHelp eh = new EventHelp(
                    e.getНазвание(),zoo.getНазвание(),e.getIdМероприятия()
            );
            re.add(eh);
        }
        return gson.toJson(re);

    }


    @GET
    @Path("byId/{id}")
    @Produces({"application/xml","application/json"})
    public String findEventById(@PathParam("id") Integer id){
        Gson gson = new Gson();
        Events event = ss.searchEventById(id);
        EventType et = ss.searchEventTypeById(event.getIdТипаМероприятия());
        Employees emp = ss.searchEmployeeById(event.getIdСотрудника());
        Zoo zoo = ss.searchZooById(event.getIdЗоопарка());
        ResponseEvent ra = new ResponseEvent(
           event.getНазвание(), et.getНазваниеТипаМероприятия(), event.getДатаВремяМероприятия(),
                event.getСтоимостьБилетов(),zoo.getНазвание(), emp.getФио()
        );
        return gson.toJson(ra);
    }
}

class EventHelp
{
    private String name;
    private String zoo;
    private Integer id;

    public EventHelp(String name, String zoo, Integer id) {
        this.name = name;
        this.zoo = zoo;
        this.id = id;
    }
}
