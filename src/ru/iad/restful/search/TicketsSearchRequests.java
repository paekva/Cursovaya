package ru.iad.restful.search;

import com.google.gson.Gson;
import ru.iad.dao.ComplexSearch;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.ResponseMention;
import ru.iad.response.ResponseTickets;

import javax.ejb.*;
import javax.ws.rs.*;
import java.util.*;


@Path("/search/tickets/")
@Stateless
public class TicketsSearchRequests {
    @EJB
    private SimpleSearch ss;

    @EJB
    private ComplexSearch cs;

    @POST
    @Path("byZoo")
    @Produces({"application/xml","application/json"})
    public String findTicketsByZoo(@FormParam("zoo") String zoo){
        List<Tickets> ticketsList = cs.searchTicketsByZoo(zoo);
        List<ResponseTickets> re=new ArrayList<>();
        for(Tickets t: ticketsList)
        {
            TicketsType tt = ss.searchTicketsTypeById(t.getIdКатегории());
            ResponseTickets eh = new ResponseTickets(
                    zoo,t.getДатаПокупки(),tt.getНазваниеКатегории()
            );
            re.add(eh);
        }
        Gson gson = new Gson();
        return gson.toJson(re);
    }

    @POST
    @Path("byDate")
    @Produces({"application/xml","application/json"})
    public String findTicketsByDate(@FormParam("date") Date date, @FormParam("before") Boolean before){
        List<Tickets> tickets = ss.searchTicketsByDate(date,before);
        List<ResponseTickets> re=new ArrayList<>();
        for(Tickets t: tickets)
        {
            TicketsType tt = ss.searchTicketsTypeById(t.getIdКатегории());
            Zoo zoo = ss.searchZooById(t.getIdЗоопарка());
            ResponseTickets eh = new ResponseTickets(
                    zoo.getНазвание(),t.getДатаПокупки(),tt.getНазваниеКатегории()
            );
            re.add(eh);
        }
        Gson gson = new Gson();
        return gson.toJson(re);
    }


    @POST
    @Path("byType")
    @Produces({"application/xml","application/json"})
    public String findTicketsByType(@FormParam("type") String type){
        TicketsType tt = ss.searchTicketsTypeByName(type);
        List<Tickets> ticketsList = ss.searchAllTickets();
        List<ResponseTickets> rt=new ArrayList<>();
        for(Tickets t: ticketsList)
        {
            if(t.getIdКатегории() == tt.getIdКатегории())
            {
                Zoo zoo = ss.searchZooById(t.getIdЗоопарка());
                ResponseTickets responseTicketst = new ResponseTickets(
                     zoo.getНазвание(), t.getДатаПокупки(), type
                );
                rt.add(responseTicketst);
            }
        }
        Gson gson = new Gson();
        return gson.toJson(rt);

    }

}
