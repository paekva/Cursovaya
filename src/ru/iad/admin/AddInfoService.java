package ru.iad.admin;

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
    @Path("/news/{header}/{content}")
    public void addNews(@PathParam("header") String header, @PathParam("content") String content) {
        insert.newsInsert(header,content, new Date());
    }

    @POST
    @Path("/animal/{name}/{kind}/{date}/{features}/{father}/{mother}/{condition}")
    public void addAnimal(@PathParam("name") String name, @PathParam("features") String features,
                          @PathParam("date") Date date, @PathParam("father") String father,
                          @PathParam("mother") String mother, @PathParam("condition") String condition,
                          @PathParam("kind") String kind) {
        insert.animalInsert(name,kind,date,features,father,mother,condition);
    }

    @POST
    @Path("/zoo/{name}/{functional}/{manager}/{location}/{date}/{staff}/{animals}")
    public void addZoo(@PathParam("name") String name, @PathParam("functional") String functional,
                       @PathParam("manager") String manager, @PathParam("location") String location,
                       @PathParam("date") Date date, @PathParam("staff") int staff,
                       @PathParam("animals") int animals) {
        insert.zooInsert(name,functional,manager, location, date, staff, animals);
    }

    @POST
    @Path("/place/{header}/{content}")
    public void addPlace(@PathParam("header") String header, @PathParam("content") String content) {

    }

    @POST
    @Path("/event/{header}/{content}")
    public void addEvent(@PathParam("header") String header, @PathParam("content") String content) {

    }
}
