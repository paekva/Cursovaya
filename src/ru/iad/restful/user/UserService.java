package ru.iad.restful.user;

import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.*;
import ru.iad.supplies.EmailSender;

import javax.ejb.*;
import javax.ws.rs.*;
import java.text.DateFormat;
import java.util.*;

@Path("/user")
@Stateful
public class UserService {

    @EJB
    private SimpleSearch ss;

    @GET
    @Path("/tickets/{id}")
    public String allUserTickets(@PathParam("id") Integer id){
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

        return gson.toJson(ResponseTickets);
    }

    @GET
    @Path("/info/{id}")
    public String userInfo(@PathParam("id") Integer id){
        Gson gson = new Gson();
        User usr = ss.searchUserById(id);
        ResponseUser user = new ResponseUser(usr.getId(),usr.getUsername(), usr.getName(),
                usr.getEmail(),usr.getInfo());
        return gson.toJson(user);
    }


    @POST
    @Path("/rential}")
    public String applayForRential(@FormParam("email") String email, @FormParam("fio") String fio, @FormParam("animal") String animal,
                                   @FormParam("purpose") String purpose, @FormParam("organisation") String organisation,
                                   @FormParam("dateFrom") String dateFrom, @FormParam("dateTo") String dateTo){
        Date curTime = new Date();
        DateFormat format = DateFormat.getDateInstance();
        String header = "Заявка на прокат животного. " + format.format(curTime);
        String content = "Заявка на прокат животного " + animal +" \n ОТ: " + fio + " \n ОРГАНИЗАЦИЯ: " + organisation
                + " \n ДАТЫ: " + dateFrom + " - " + dateTo + "\n ЦЕЛЬ: " + purpose + "\n КОНТАКТНЫЙ EMAIL: " + email;

        EmailSender es = new EmailSender("katrinpayvl@gmail.com", "rfnz89grf");
        es.send(header, content, "katrinpayvl@gmail.com", "paekva@yandex.ru");

        return "succes";
    }
}

