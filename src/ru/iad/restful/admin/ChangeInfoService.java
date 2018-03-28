package ru.iad.restful.admin;
/*READY, NOT TESTED*/
import ru.iad.dao.Update;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Date;

@Path("/admin/change")
@Stateful
public class ChangeInfoService {

    @EJB
    Update update;

    @POST
    @Path("/animal")
    public void changeAnimal(@FormParam("id") Integer id, @FormParam("features") String features,
                             @FormParam("state") String state) {
        update.animalUpdate(id,features,state);
    }

    @POST
    @Path("/zoo/{header}/{content}")
    public void changeZoo(@FormParam("name") String name, @FormParam("director") String director,
                          @FormParam("functionality") String functionality){
        update.zooUpdate(name,director,functionality);
    }
}
