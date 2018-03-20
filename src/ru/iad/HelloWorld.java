package ru.iad;

import ru.iad.dao.Insert;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.Animals;
import ru.iad.entities.EventType;
import ru.iad.entities.TicketsType;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Stateless
@LocalBean
@Path("hello")
public class HelloWorld {

    @EJB
    SimpleSearch simpleSearch;
    @GET
    public String sayHello()
    {
        EventType ticketsType = simpleSearch.searchEventTypeByName("Праздник");
        return Integer.toString(ticketsType.getIdТипаМероприятия());
    }
}
