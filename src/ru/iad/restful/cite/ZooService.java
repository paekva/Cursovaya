package ru.iad.restful.cite;
/*READY*/

import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.Zoo;
import ru.iad.response.ResponseZoo;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;


@Path("/zoo")
@Stateless
public class ZooService {

    @EJB
    SimpleSearch simpleSearch;

    @GET
    @Path("/all")
    @Produces({"application/xml", "application/json"})
    public String allZoo() {
        Gson gson = new Gson();
        List<ResponseZoo> ResponseZoo = new ArrayList<ResponseZoo>();
        List<Zoo> zooList = simpleSearch.searchAllZoo();
        for(int i =0;i<zooList.size();i++)
        {
            ResponseZoo zoo = new ResponseZoo(zooList.get(i).getIdЗоопарка(),zooList.get(i).getНазвание(),zooList.get(i).getМестоположение());
            ResponseZoo.add(zoo);
        }
        String json = gson.toJson(ResponseZoo);
        return json;
    }

    @GET
    @Path("/single/{id}")
    public String singleZoo(@PathParam("id") Integer id)
    {
        Zoo zoo = simpleSearch.searchZooById(id);
        Gson gson = new Gson();
        String json = gson.toJson(zoo);
        return json;
    }
}

