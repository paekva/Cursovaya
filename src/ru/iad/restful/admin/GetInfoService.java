package ru.iad.restful.admin;
/*READY, NOT TESTED*/
import com.google.gson.Gson;
import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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
    public Response allTickets() {
        Gson gson = new Gson();
        List<ResponseTickets> responseTickets = new ArrayList<>();
        List<Tickets> ticketsList = simpleSearch.searchAllTickets();

        /*for (Tickets t:ticketsList) {
            Zoo zoo = simpleSearch.searchZooById(t.getIdЗоопарка());
            TicketsType tt = simpleSearch.searchTicketsTypeById(t.getIdКатегории());
            ResponseTickets ticket = new ResponseTickets(zoo.getНазвание(),t.getДатаПокупки(),tt.getНазваниеКатегории());
            responseTickets.add(ticket);
        }*/

        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(ticketsList))
                .build();
    }

    @GET
    @Path("/employees/{name}")
    @Produces({"application/xml", "application/json"})
    public Response oneEmployee(@PathParam("name") String name) {
        Gson gson = new Gson();
        Employees employees = simpleSearch.searchEmployeeByName(name);
        if(employees!=null)
        {
            ResponseEmployee re = new ResponseEmployee(employees.getIdСотрудника(),employees.getФио(),employees.getПрофессия());
            return Response.status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity(gson.toJson(re))
                    .build();
        }
        else
        {
            return Response.status(401).build();
        }
    }
}

