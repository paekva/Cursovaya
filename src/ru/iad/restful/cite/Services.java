package ru.iad.restful.cite;

import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.AnimalType;
import ru.iad.entities.EventType;
import ru.iad.entities.MentionType;
import ru.iad.response.ResponseType;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;


@Path("/service")
@Stateless
public class Services {
    @EJB
    private SimpleSearch simpleSearch;

    @GET
    @Path("/animalTypes")
    @Produces({"application/xml", "application/json"})
    public Response allAnimalTypes() {
        Gson gson = new Gson();
        List<ResponseType> rat = new ArrayList<>();
        List<AnimalType> animalTypes = simpleSearch.searchAllAnimalTypes();
        for (AnimalType z:animalTypes) {
            ResponseType r = new ResponseType(z.getIdВида(),z.getНазвание());
            rat.add(r);
        }
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(rat))
                .build();
    }

    @GET
    @Path("/eventTypes")
    @Produces({"application/xml", "application/json"})
    public Response allEventTypes() {
        Gson gson = new Gson();
        List<ResponseType> rat = new ArrayList<>();
        List<EventType> eventTypes = simpleSearch.searchAllEventTypes();
        for (EventType z:eventTypes) {
            ResponseType r = new ResponseType(z.getIdТипаМероприятия(),z.getНазваниеТипаМероприятия());
            rat.add(r);
        }
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(rat))
                .build();
    }

    @GET
    @Path("/mentionTypes")
    @Produces({"application/xml", "application/json"})
    public Response allMentionTypes() {
        Gson gson = new Gson();
        List<ResponseType> rat = new ArrayList<>();
        List<MentionType> mentionTypes = simpleSearch.searchAllMentionTypes();
        for (MentionType z:mentionTypes) {
            ResponseType r = new ResponseType(z.getIdВидаУпоминания(),z.getНазваниеВидаУпоминания());
            rat.add(r);
        }
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(rat))
                .build();
    }
}
