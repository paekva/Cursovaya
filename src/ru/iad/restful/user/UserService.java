package ru.iad.restful.user;

import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.*;
import ru.iad.supplies.EmailSender;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.util.*;

@Path("/user")
@Stateful
public class UserService {

    @EJB
    private SimpleSearch ss;

    @GET
    @Path("/tickets/{id}")
    public Response allUserTickets(@PathParam("id") Integer id){
        Gson gson = new Gson();
        List<ResponseTickets> ResponseTickets = new ArrayList<ResponseTickets>();

        List<Tickets> foundTickets = ss.searchTicketsByUser(id);

        for (Tickets t: foundTickets) {
            Zoo zoo = ss.searchZooById(t.getIdЗоопарка());
            TicketsType tt = ss.searchTicketsTypeById(t.getIdКатегории());
            ResponseTickets rt = new ResponseTickets(
                    zoo.getНазвание(), t.getДатаПокупки(),
                    tt.getНазваниеКатегории());
            ResponseTickets.add(rt);
        }
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(ResponseTickets))
                .build();
    }

    @GET
    @Path("/info/{id}")
    public Response userInfo(@PathParam("id") Integer id){
        Gson gson = new Gson();
        User usr = ss.searchUserById(id);
        ResponseUser user = new ResponseUser(usr.getId(),usr.getUsername(), usr.getName(),
                usr.getEmail(),usr.getInfo(),usr.getRole());
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(user))
                .build();
    }

    @POST
    @Path("/rential}")
    public Response create(ResponseAR ar) {
        Date curTime = new Date();
        DateFormat format = DateFormat.getDateInstance();
        String header = "Заявка на прокат животного. " + format.format(curTime);
        String content = "Заявка на прокат животного " + ar.getAnimal() +" \n ОТ: " + ar.getFio()
                + " \n ОРГАНИЗАЦИЯ: " + ar.getOrganisation() + " \n ДАТЫ: " + ar.getDateFrom()
                + " - " + ar.getDateTo() + "\n ЦЕЛЬ: " + ar.getPurpose() + "\n КОНТАКТНЫЙ EMAIL: " + ar.getEmail();

        EmailSender es = new EmailSender("katrinpayvl@gmail.com", "rfnz89grf");
        es.send(header, content, "katrinpayvl@gmail.com", "paekva@yandex.ru");

        return Response.ok().build();
    }
}

