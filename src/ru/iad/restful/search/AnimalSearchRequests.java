package ru.iad.restful.search;

import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.Animals;
import ru.iad.response.ResponseAnimal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/search")
@Stateless
public class AnimalSearchRequests {

    @EJB
    SimpleSearch ss;

    @GET
    @Path("animals/byName")
    @Produces({"application/xml", "application/json"})
    public String animalsByName(@FormParam("name") String name){
        Gson gson = new Gson();

        String json = gson.toJson("");
        return json;

    }

    /*@POST
    @Path("zoo/{zoo}")
    @Produces({"application/xml","application/json"})
    public List<Animals> findAnimalsByZoo(@PathParam("zoo") String zoo){

    }

    @POST
    @Path("type/{type}")
    @Produces({"application/xml","application/json"})
    public List<Animals> findAnimalsByType(@PathParam("type") String type){

    }

    @GET
    @Path("animal/{id}")
    @Produces({"application/xml","application/json"})
    public ResponseAnimal findAnimal(@PathParam("id") Integer id){

    }*/
}

class AnimalHelp
{
    private String name;
    private String type;
    private Integer id;

    public AnimalHelp(String name, String type, Integer id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }
}
