package ru.iad.restful.search;

import com.google.gson.Gson;
import ru.iad.dao.ComplexSearch;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.ResponseMention;

import javax.ejb.*;
import javax.ws.rs.*;
import java.util.*;


@Path("/search/mentions/")
@Stateless
public class MentionsSearchRequest {
    @EJB
    private SimpleSearch ss;

    @EJB
    private ComplexSearch cs;

    @POST
    @Path("byZoo")
    @Produces({"application/xml","application/json"})
    public String findMentionsByZoo(@FormParam("zoo") String zoo){
        List<Mentions> mentionsList = cs.searchMentionsByZoo(zoo);
        List<MentionHelp> re=new ArrayList<>();
        for(Mentions m: mentionsList)
        {
            MentionType mt = ss.searchMentionTypeById(m.getIdВидаУпоминания());
            MentionHelp eh = new MentionHelp(
                    m.getНазваниеУпоминания(),mt.getНазваниеВидаУпоминания(),
                    m.getIdУпоминания()
            );
            re.add(eh);
        }
        Gson gson = new Gson();
        return gson.toJson(re);
    }

    @POST
    @Path("byName")
    @Produces({"application/xml","application/json"})
    public String findMentionByName(@FormParam("name") String name){
        Mentions mention = ss.searchMentionByName(name);
        MentionType mt = ss.searchMentionTypeById(mention.getIdВидаУпоминания());
        MentionHelp mentionHelp = new MentionHelp(
                    mention.getНазваниеУпоминания(),mt.getНазваниеВидаУпоминания(),
                    mention.getIdУпоминания()
        );
        Gson gson = new Gson();
        return gson.toJson(mentionHelp);
    }


    @POST
    @Path("byType")
    @Produces({"application/xml","application/json"})
    public String findEventsByType(@FormParam("type") String type){
        List<Mentions> mentionsList = cs.searchMentionsByType(type);
        List<MentionHelp> re=new ArrayList<>();
        for(Mentions m: mentionsList)
        {
            MentionHelp eh = new MentionHelp(
                    m.getНазваниеУпоминания(),type,
                    m.getIdУпоминания()
            );
            re.add(eh);
        }
        Gson gson = new Gson();
        return gson.toJson(re);

    }


    @POST
    @Path("byDate")
    @Produces({"application/xml","application/json"})
    public String findEventByDate(@FormParam("date") Date date, @FormParam("before") Boolean before){
        List<Events> event = cs.searchEventByDate(date,before);
        List<EventHelp> re=new ArrayList<>();
        for(Events e: event)
        {
            Zoo zoo = ss.searchZooById(e.getIdЗоопарка());
            EventHelp eh = new EventHelp(
                    e.getНазвание(),zoo.getНазвание(),e.getIdМероприятия()
            );
            re.add(eh);
        }
        Gson gson = new Gson();
        return gson.toJson(re);
    }

    @GET
    @Path("byId/{id}")
    @Produces({"application/xml","application/json"})
    public String findEventById(@PathParam("id") Integer id){
        Gson gson = new Gson();
        Mentions mention = ss.searchMentionById(id);
        MentionType et = ss.searchMentionTypeById(mention.getIdВидаУпоминания());
        Employees emp = ss.searchEmployeeById(mention.getIdСотрудника());
        Zoo zoo = ss.searchZooById(mention.getIdЗоопарка());
        Animals animal = ss.searchAnimalById(mention.getIdЖивотного());
        ResponseMention rm = new ResponseMention(
                mention.getНазваниеУпоминания(), et.getНазваниеВидаУпоминания(),
                mention.getДатаПубликации(), animal.getИмя(), zoo.getНазвание(), emp.getФио()
        );
        return gson.toJson(rm);
    }
}

class MentionHelp
{
    private String name;
    private String type;
    private Integer id;

    public MentionHelp(String name, String type, Integer id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }
}
