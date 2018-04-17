package ru.iad.restful.search;

import com.google.gson.Gson;
import ru.iad.dao.ComplexSearch;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.ResponseTickets;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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
    public Response findTicketsByZoo(@FormParam("zoo") String zoo){
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
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(re))
                .build();
    }

    @POST
    @Path("byDate")
    @Produces({"application/xml","application/json"})
    public Response findTicketsByDate(@FormParam("date") Date date, @FormParam("before") Boolean before){
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
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(re))
                .build();
    }


    @POST
    @Path("byType")
    @Produces({"application/xml","application/json"})
    public Response findTicketsByType(@FormParam("type") String type){
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
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(rt))
                .build();

    }

}