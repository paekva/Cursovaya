package ru.iad.restful.auth;

import com.google.gson.Gson;
import ru.iad.dao.*;
import ru.iad.entities.*;
import ru.iad.response.ResponseEmployee;
import ru.iad.response.ResponseTickets;
import ru.iad.response.ResponseUser;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/main")
@Stateless
public class AuthRequests {

    @EJB
    private Insert insert;

    @EJB
    private SimpleSearch ss;

    @EJB
    private ComplexSearch cs;

    @EJB
    private Update update;

    @POST
    @Path("registration")
    public Response registration
            (ResponseUser user) {
        int rtrn = insert.userInsert(user.getLogin(),user.getRole(),"USER", user.getName(), user.getEmail(), user.getInfo());
        if(rtrn!=1) return Response.status(200)
                .entity("success")
                .build();
        else return Response.status(401)
                .entity("error")
                .build();
    }

    @GET
    @Path("/employees/{name}")
    @Produces({"application/xml", "application/json"})
    public Response oneEmployee(@PathParam("name") String name) {
        Gson gson = new Gson();
        Employees employees = ss.searchEmployeeByName(name);
        if(employees!=null)
        {
            ResponseEmployee re = new ResponseEmployee(employees.getСтажРаботы(),employees.getФио(),employees.getПрофессия());
            return Response.status(200)
                    .entity(gson.toJson(re))
                    .build();
        }
        else
        {
            return Response.status(401).build();
        }
    }

    @GET
    @Path("/tickets")
    @Produces({"application/xml", "application/json"})
    public Response allTickets() {
        Gson gson = new Gson();
        List<ResponseTickets> responseTickets = new ArrayList<>();
        List<Tickets> ticketsList = ss.searchAllTickets();

        for (Tickets t:ticketsList) {
            Zoo zoo = ss.searchZooById(t.getIdЗоопарка());
            TicketsType tt = ss.searchTicketsTypeById(t.getIdКатегории());
            ResponseTickets ticket = new ResponseTickets(zoo.getНазвание(),t.getДатаПокупки(),tt.getНазваниеКатегории());
            responseTickets.add(ticket);
        }

        return Response.status(200)
                .entity(gson.toJson(responseTickets))
                .build();
    }

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("/ticket/{login}")
    public Response tickets (@PathParam("login") String login) {
        Gson gson = new Gson();
        ResponseUser ru;
        User fu = ss.searchUserByName(login);
        List<ResponseTickets> ResponseTickets = new ArrayList<ResponseTickets>();
        List<Tickets> foundTickets = null;
        if (fu != null) {
            foundTickets = ss.searchTicketsByUser(fu.getId());
            for (Tickets t : foundTickets) {
                Zoo zoo = ss.searchZooById(t.getIdЗоопарка());
                TicketsType tt = ss.searchTicketsTypeById(t.getIdКатегории());
                ResponseTickets rt = new ResponseTickets(
                        zoo.getНазвание(), t.getДатаПокупки(),
                        tt.getНазваниеКатегории());
                ResponseTickets.add(rt);
            }
        }
        return Response.status(200)
                .entity(gson.toJson(ResponseTickets))
                .build();
    }

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("/auth/{login}/{pass}")
    public Response authentication (@PathParam("login") String login,@PathParam("pass") String pass) {
        Gson gson = new Gson();
        ResponseUser ru;
        User fu = ss.searchUserByName(login);
        if(fu!=null)/*&&(fu.getPassword().equals(pass)))*/
        {
           ru = new ResponseUser(fu.getUsername(),fu.getRole(),fu.getName(),fu.getEmail(),fu.getInfo());
        }
        else ru = new ResponseUser("","NOT",null, null, null);
        return Response.status(200)
                .entity(gson.toJson(ru))
                .build();
    }

    @POST
    @Path("addInfo")
    public Response addNewInfo
            (@FormParam("username") String username,@FormParam("name") String name,
             @FormParam("email") String email,@FormParam("info") String info) {
        if(update.userInfoUpdate(username, name, email, info)) return Response.status(200)
                .entity("success")
                .build();
        else return Response.status(200)
                .entity("error")
                .build();
    }

}

