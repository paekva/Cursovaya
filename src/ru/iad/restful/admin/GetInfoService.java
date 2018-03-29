package ru.iad.restful.admin;
/*READY, NOT TESTED*/
import com.google.gson.Gson;
import javax.ejb.*;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.*;

@Path("/admin/get")
@Stateful
public class GetInfoService {

    @EJB
    private SimpleSearch simpleSearch;

    @GET
    @Path("/tickets")
    @Produces({"application/xml", "application/json"})
    public String allTickets() {
        Gson gson = new Gson();
        List<ResponseTickets> responseTickets = new ArrayList<>();
        List<Tickets> ticketsList = simpleSearch.searchAllTickets();

        for (Tickets t:ticketsList) {
            Zoo zoo = simpleSearch.searchZooById(t.getIdЗоопарка());
            TicketsType tt = simpleSearch.searchTicketsTypeById(t.getIdКатегории());
            ResponseTickets ticket = new ResponseTickets(zoo.getНазвание(),t.getДатаПокупки(),tt.getНазваниеКатегории());
            responseTickets.add(ticket);
        }

        return gson.toJson(responseTickets);
    }
}

