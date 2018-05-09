package ru.iad.restful.search;

import com.google.gson.Gson;
import ru.iad.dao.ComplexSearch;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.ResponseMention;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;


@Path("/search/mentions/")
@Stateless
public class MentionsSearchRequest {
    @EJB
    private SimpleSearch ss;

    @EJB
    private ComplexSearch cs;

    @GET
    @Path("{zoo}/{type}")
    @Produces({"application/xml","application/json"})
    public Response findMentions(@PathParam("zoo") Integer zoo,@PathParam("type") Integer type){
        List<Mentions> mentionsList = cs.searchMention(zoo,type);
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
        return Response.status(200)
                .entity(gson.toJson(re))
                .build();
    }

    @GET
    @Path("byId/{id}")
    @Produces({"application/xml","application/json"})
    public Response findMentionById(@PathParam("id") Integer id){
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
        return Response.status(200)
                .entity(gson.toJson(rm))
                .build();
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
