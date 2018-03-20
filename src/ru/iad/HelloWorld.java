package ru.iad;

import com.google.gson.Gson;
import ru.iad.dao.ComplexSearch;
import ru.iad.dao.Insert;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.Animals;
import ru.iad.entities.EventType;
import ru.iad.entities.TicketsType;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
@Path("hello")
public class HelloWorld {

    @EJB
    SimpleSearch simpleSearch;

    @EJB
    Insert insert;

    @EJB
    ComplexSearch complexSearch;

    @GET
    @Produces({"application/xml", "application/json"})
    public String sayHello()
    {
        List<Animals> list = complexSearch.searchAnimalByType("Млекопитающие");
        String str="";
        for(int i=0;i<list.size();i++)
        {
            str+=(list.get(i)).getИмя();
        }
        Gson gson = new Gson();
        String json = gson.toJson(str);
        return json;
    }
}
