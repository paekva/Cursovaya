package ru.iad.restful.search;

import com.google.gson.Gson;
import ru.iad.dao.ComplexSearch;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.ResponseEvent;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/search/events/")
@Stateless
public class EventsSearchRequests {
    @EJB
    private SimpleSearch ss;

    @EJB
    ComplexSearch cs;

    @GET
    @Path("{zoo}/{type}")
    @Produces({"application/xml","application/json"})
    public Response findEvents(@PathParam("zoo") Integer zoo, @PathParam("type") Integer type){
        List<Events> events = cs.searchEvent(type,zoo);
        List<EventHelp> re=new ArrayList<>();
        if(events!=null)
        {
            for(Events e: events)
            {
                EventType et = ss.searchEventTypeById(e.getIdТипаМероприятия());
                EventHelp eh = new EventHelp(
                        e.getНазвание(),et.getНазваниеТипаМероприятия(),e.getIdМероприятия()
                );
                re.add(eh);
            }
        }
        else re.add(new EventHelp("","",0));

        Gson gson = new Gson();
        return Response.status(200)
                .entity(gson.toJson(re))
                .build();
    }


    @GET
    @Path("byId/{id}")
    @Produces({"application/xml","application/json"})
    public Response findEventById(@PathParam("id") Integer id){
        Gson gson = new Gson();
        Events event = ss.searchEventById(id);
        EventType et = ss.searchEventTypeById(event.getIdТипаМероприятия());
        Employees emp = ss.searchEmployeeById(event.getIdСотрудника());
        Zoo zoo = ss.searchZooById(event.getIdЗоопарка());
        ResponseEvent ra = new ResponseEvent(
           event.getНазвание(), et.getНазваниеТипаМероприятия(), event.getДатаВремяМероприятия(),
                event.getСтоимостьБилетов(),zoo.getНазвание(), emp.getФио()
        );
        return Response.status(200)
                .entity(gson.toJson(ra))
                .build();
    }
}

class EventHelp
{
    private String name;
    private String type;
    private Integer id;

    public EventHelp(String name, String type, Integer id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }
}
