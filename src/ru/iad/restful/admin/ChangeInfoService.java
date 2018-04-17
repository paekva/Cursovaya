package ru.iad.restful.admin;
/*READY, NOT TESTED*/
import ru.iad.dao.Update;
import javax.ejb.*;
import javax.ws.rs.*;

@Path("/admin/change")
@Stateful
public class ChangeInfoService {

    @EJB
    private Update update;

    @POST
    @Path("/animal")
    public void changeAnimal(@FormParam("id") Integer id, @FormParam("features") String features,
                             @FormParam("state") String state) {
        update.animalUpdate(id,features,state);
    }

    @POST
    @Path("/zoo")
    public void changeZoo(@FormParam("name") String name, @FormParam("manager") String manager,
                          @FormParam("functionality") String functionality){
        update.zooUpdate(name,manager,functionality);
    }
}
