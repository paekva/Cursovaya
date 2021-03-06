package ru.iad.admin;

import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.iad.dao.SimpleSearch;
import ru.iad.entities.Tickets;
import ru.iad.entities.TicketsType;
import ru.iad.entities.Zoo;
import ru.iad.response.*;

@Path("/admin/get")
@Stateful
public class GetInfoService {

    @EJB
    SimpleSearch simpleSearch;

    @GET
    @Path("/employees/{zooId}")
    @Produces({"application/xml", "application/json"})
    public String allEmployees(@PathParam("zooId") Integer id) {

        Gson gson = new Gson();
        List<ResponseEmployee> ResponseEmployee = new ArrayList<ResponseEmployee>();

        String json = gson.toJson(ResponseEmployee);
        return json;
    }

    @GET
    @Path("/tickets/{zooId}/{typeId}")
    @Produces({"application/xml", "application/json"})
    public String allTickets(@PathParam("zooId") Integer zooId,@PathParam("typeId") Integer typeId ) {

        Gson gson = new Gson();
        List<ResponseTickets> responseTickets = new ArrayList<>();
        List<Tickets> ticketsList = simpleSearch.searchAllTickets();
        for(int i =0;i<ticketsList.size();i++)
        {
            Zoo zoo = simpleSearch.searchZooById(ticketsList.get(i).getIdЗоопарка());
            TicketsType tt = simpleSearch.searchTicketsTypeById(ticketsList.get(i).getIdКатегории());
            ResponseTickets ticket = new ResponseTickets(ticketsList.get(i).getIdБилета(), zoo.getНазвание(),ticketsList.get(i).getДатаПокупки(),tt.getНазваниеКатегории());
            responseTickets.add(ticket);
        }
        String json = gson.toJson(responseTickets);
        return json;
    }
}

