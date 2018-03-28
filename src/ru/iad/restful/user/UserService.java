package ru.iad.restful.user;

import com.google.gson.Gson;
import ru.iad.response.*;
import ru.iad.supplies.EmailSender;

import javax.ejb.Stateful;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/user")
@Stateful
public class UserService {

    @GET
    @Path("/tickets")
    public String allResponseTickets(){
        Gson gson = new Gson();
        List<ResponseTickets> ResponseTickets = new ArrayList<ResponseTickets>();
        Date firstD = new Date(100000000);
        ResponseTickets first = new ResponseTickets(1,"Создание сайта", firstD, "студенческий");
        ResponseTickets second = new ResponseTickets(2,"Начинаем заполнение", firstD, "льготный");
        ResponseTickets third = new ResponseTickets(3,"Мишка в Уральском зоопарке", firstD, "студенческий");
        ResponseTickets forth = new ResponseTickets(4,"С наступившем 2018!", firstD, "общий");
        ResponseTickets fifth = new ResponseTickets(5,"Welcome", firstD, "общий");
        ResponseTickets.add(first);
        ResponseTickets.add(second);
        ResponseTickets.add(third);
        ResponseTickets.add(forth);
        ResponseTickets.add(fifth);
        String json = gson.toJson(ResponseTickets);
        return json;
    }

    @GET
    @Path("/info/{id}")
    public String userInfo(@PathParam("id") Integer id){
        Gson gson = new Gson();
        ResponseUser user = new ResponseUser(1,"paekva", "Павлова Екатерина",
                "paekva@yandex.ru", "Infoo");
        return gson.toJson(user);
    }

    @POST
    @Path("/info/{email}/{fio}/{animal}/{purpose}/{dateFrom}/{dateTo}/{organisation}")
    public String applayForRential(@PathParam("email") String email, @PathParam("fio") String fio, @PathParam("animal") String animal,
                                   @PathParam("purpose") String purpose, @PathParam("organisation") String organisation,
                                   @PathParam("dateFrom") String dateFrom, @PathParam("dateTo") String dateTo){
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

