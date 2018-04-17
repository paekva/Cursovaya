package ru.iad.restful.search;

import com.google.gson.Gson;
import ru.iad.dao.ComplexSearch;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.ResponseAnimal;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/search")
@Stateless
public class AnimalSearchRequests {

    @EJB
    private SimpleSearch ss;

    @EJB
    private ComplexSearch cs;

    @GET
    @Path("animals/byZoo/{zoo}")
    @Produces({"application/xml","application/json"})
    public Response findAnimalsByZoo(@PathParam("zoo") String zoo){
        Gson gson = new Gson();
        List<AnimalHelp> animal = new ArrayList<>();
        List<Animals> animalsList = cs.searchAnimalByZoo(zoo);
        for(Animals a:animalsList)
        {
            AnimalType at = ss.searchAnimalTypeById(a.getIdВида());
            AnimalHelp ah = new AnimalHelp(
                    a.getИмя(), at.getНазвание(), a.getIdЖивотного()
            );
            animal.add(ah);
        }
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(animal))
                .build();
    }

    /*@GET
    @Path("animals/byName")
    @Produces({"application/xml", "application/json"})
    public String findAnimalsByName(@FormParam("name") String name){
        Gson gson = new Gson();
        List<AnimalHelp> animal = new ArrayList<>();
        List<Animals> animals = ss.searchAnimalByName(name);
        for (Animals a: animals) {
            AnimalType at = ss.searchAnimalTypeById(a.getIdВида());
            AnimalHelp ah = new AnimalHelp(a.getИмя(), at.getНазвание(), a.getIdЖивотного());
            animal.add(ah);
        }

        return gson.toJson(animal);

    }


    @POST
    @Path("animals/byType")
    @Produces({"application/xml","application/json"})
    public String findAnimalsByType(@FormParam("type") String type){
        Gson gson = new Gson();
        List<AnimalHelp> animal = new ArrayList<>();
        List<Animals> animalsList = cs.searchAnimalByType(type);
        for(Animals a:animalsList)
        {
            AnimalHelp ah = new AnimalHelp(
                    a.getИмя(), type, a.getIdЖивотного()
            );
            animal.add(ah);
        }
        return gson.toJson(animal);

    }


    @GET
    @Path("animal/{id}")
    @Produces({"application/xml","application/json"})
    public String findAnimal(@PathParam("id") Integer id){
        Gson gson = new Gson();
        Animals animal = ss.searchAnimalById(id);
        AnimalType at = ss.searchAnimalTypeById(animal.getIdВида());
        Animals mum = ss.searchAnimalById(animal.getIdМамы());
        Animals dad = ss.searchAnimalById(animal.getIdПапы());

        Places places = ss.searchPlaceByAnimal(animal);
        Zoo zoo = ss.searchZooById(places.getIdЗоопарка());
        ResponseAnimal ra = new ResponseAnimal(
                animal.getИмя(), at.getНазвание(), animal.getДатаРождения(),
                zoo.getНазвание(), dad.getИмя(), mum.getИмя(), animal.getОсобенности()
        );
        return gson.toJson(ra);
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
