package ru.iad.restful.admin;
/*READY, NOT TESTED*/
import ru.iad.dao.Insert;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.Date;

@Path("/admin/add")
@Stateless
public class AddInfoService {

    @EJB
    Insert insert;

    @POST
    @Path("/news")
    public void addNews
            (@FormParam("header") String header, @FormParam("content") String content)  {
        insert.newsInsert(header,content, new Date());
    }

    @POST
    @Path("/animal")
    public void addAnimal(@FormParam("name") String name, @FormParam("features") String features,
                          @FormParam("date") Date date, @FormParam("father") String father,
                          @FormParam("mother") String mother, @FormParam("condition") String condition,
                          @FormParam("kind") String kind) {
        insert.animalInsert(name,kind,date,features,father,mother,condition);
    }

    @POST
    @Path("/zoo")
    public void addZoo(@FormParam("name") String name, @FormParam("functional") String functional,
                       @FormParam("manager") String manager, @FormParam("location") String location,
                       @FormParam("date") Date date, @FormParam("staff") int staff,
                       @FormParam("animals") int animals) {
        insert.zooInsert(name,functional,manager, location, date, staff, animals);
    }

    @POST
    @Path("/place")
    public void addPlace(@FormParam("zoo") String zoo, @FormParam("name") String name,
                         @FormParam("flora") String flora, @FormParam("animal") String animal,
                         @FormParam("square") Integer square) {
        insert.placeInsert(zoo,name,flora,animal,square);
    }

    @POST
    @Path("/event")
    public void addEvent(@FormParam("name") String name, @FormParam("zoo") String zoo,
                         @FormParam("employee") String employee,  @FormParam("type") String type,
                         @FormParam("date") Date date,  @FormParam("duration") Double duration,
                         @FormParam("cost") Double cost) {
        insert.eventInsert(name,zoo,type,employee,date,duration,cost);
    }
}
