package ru.iad.restful.cite;
/*READY*/

import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.Zoo;
import ru.iad.response.ResponseZoo;

import javax.ejb.*;
import javax.ws.rs.*;
import java.util.*;


@Path("/zoo")
@Stateless
public class ZooService {

    @EJB
    private SimpleSearch simpleSearch;

    @GET
    @Path("/all")
    @Produces({"application/xml", "application/json"})
    public String allZoo() {
        Gson gson = new Gson();
        List<ResponseZoo> ResponseZoo = new ArrayList<ResponseZoo>();
        List<Zoo> zooList = simpleSearch.searchAllZoo();
        for (Zoo z:zooList) {
            ResponseZoo zoo = new ResponseZoo(z.getIdЗоопарка(),z.getНазвание(),z.getМестоположение());
            ResponseZoo.add(zoo);
        }

        return gson.toJson(ResponseZoo);
    }

    @GET
    @Path("/single/{id}")
    public String singleZoo(@PathParam("id") Integer id)
    {
        Zoo zoo = simpleSearch.searchZooById(id);
        Gson gson = new Gson();
        return gson.toJson(zoo);
    }
}

