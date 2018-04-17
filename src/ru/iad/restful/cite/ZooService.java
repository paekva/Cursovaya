package ru.iad.restful.cite;
/*READY*/

import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.Zoo;
import ru.iad.response.ResponseZoo;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;


@Path("/zoo")
@Stateless
public class ZooService {

    @EJB
    private SimpleSearch simpleSearch;

    @GET
    @Path("/all")
    @Produces({"application/xml", "application/json"})
    public Response allZoo() {
        Gson gson = new Gson();
        List<ResponseZoo> ResponseZoo = new ArrayList<ResponseZoo>();
        List<Zoo> zooList = simpleSearch.searchAllZoo();
        for (Zoo z:zooList) {
            ResponseZoo zoo = new ResponseZoo(z.getIdЗоопарка(),z.getНазвание(),z.getМестоположение());
            ResponseZoo.add(zoo);
        }
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(ResponseZoo))
                .build();
    }

    @GET
    @Path("/single/{id}")
    @Produces({"application/xml", "application/json"})
    public Response singleZoo(@PathParam("id") Integer id)
    {
        Zoo zoo = simpleSearch.searchZooById(id);
        FullZoo fz = new FullZoo(zoo.getIdЗоопарка(), zoo.getДатаОснования(), zoo.getДиректор(), zoo.getКоличествоЖивотных(),
                zoo.getМестоположение(), zoo.getНазвание(), zoo.getФункциональность(), zoo.getШтат());
        Gson gson = new Gson();
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(fz))
                .build();
    }
}

class FullZoo
{
    Integer id;
    Date date;
    String manager;
    Integer animals;
    String place;
    String name;
    String func;
    Integer employees;

    public FullZoo(Integer id, Date date, String manager, Integer animals, String place, String name, String func, Integer employees) {
        this.id = id;
        this.date = date;
        this.manager = manager;
        this.animals = animals;
        this.place = place;
        this.name = name;
        this.func = func;
        this.employees = employees;
    }
}