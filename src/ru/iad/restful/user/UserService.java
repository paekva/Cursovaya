package ru.iad.restful.user;

import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.dao.Update;
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

    @EJB
    private Update up;

    @GET
    @Produces({"application/xml", "application/json"})
    @Path("/tickets/{login}")
    public Response allUserTickets(@PathParam("login") String login){
        Gson gson = new Gson();
        List<ResponseTickets> ResponseTickets = new ArrayList<ResponseTickets>();

        //User fu = ss.searchUserByName(login);
        List<Tickets> foundTickets;
        foundTickets = ss.searchTicketsByUser(4);
        return Response.status(200)
                .entity(gson.toJson(foundTickets))
                .build();

        /*for (Tickets t: foundTickets) {
            Zoo zoo = ss.searchZooById(t.getIdЗоопарка());
            TicketsType tt = ss.searchTicketsTypeById(t.getIdКатегории());
            ResponseTickets rt = new ResponseTickets(
                    zoo.getНазвание(), t.getДатаПокупки(),
                    tt.getНазваниеКатегории());
            ResponseTickets.add(rt);
        }*/
    }

    @POST
    @Path("/info")
    public Response userInfo(ResponseUser user){
        User usr = ss.searchUserByName(user.getLogin());
        if(usr==null) return Response.status(500).build();
        boolean result = up.userInfoUpdate(user.getLogin(),user.getName(),user.getEmail(),user.getInfo());
        if(!result) return Response.status(500).build();
        else return Response.ok().build();
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

