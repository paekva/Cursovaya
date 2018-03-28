package ru.iad.restful.admin;

import javax.ejb.Stateful;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/admin/change")
@Stateful
public class ChangeInfoService {

    @POST
    @Path("/animal/{header}/{content}")
    public void changeAnimal(@PathParam("header") String header, @PathParam("content") String content) {

    }

    @POST
    @Path("/zoo/{header}/{content}")
    public void changeZoo(@PathParam("header") String header, @PathParam("content") String content) {

    }

    @POST
    @Path("/event/{header}/{content}")
    public void changeEvent(@PathParam("header") String header, @PathParam("content") String content) {

    }
}
