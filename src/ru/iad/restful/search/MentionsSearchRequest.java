package ru.pip.search;
/*import org.hibernate.SessionFactory;
import ru.pip.dao.crud.HibernateSessionFactory;
import ru.pip.dao.entities.*;
import org.hibernate.Session;

        import javax.ejb.EJB;
        import javax.ejb.Stateless;
import javax.ws.rs.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

        import static ru.pip.dao.crud.SimpleSearch.*;
        import static ru.pip.dao.crud.ComplexSearch.*;

@Path("/search/mentions/")
@Stateless
public class MentionsSearchRequest {
    @EJB
    private HibernateSessionFactory mainBean;

    @GET
    @Path("zoo/{zoo}")
    @Produces({"application/xml","application/json"})
    public String helloworld(@PathParam("zoo") String zoo){
        return "hello"+zoo;
    }

    @POST
    @Path("zoo/{zoo}")
    @Produces({"application/xml","application/json"})
    public List<Mentions> findAnimalsByZoo(@PathParam("zoo") String zoo){
        Session session = mainBean.getSessionFactory().openSession();
        try {
            List<УпоминанияОЗоопаркеEntity> mentionsList = searchMentionsByZoo(session,zoo);
            if(mentionsList == null) throw new Exception();

            List<Mentions> mentions = new ArrayList<Mentions>();

            for (УпоминанияОЗоопаркеEntity a: mentionsList) {
                Mentions newMention = new Mentions(a.getНазваниеУпоминания(), zoo, a.getIdУпоминания());
                mentions.add(newMention);
            }

            return mentions;
        }
        catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("type/{type}")
    @Produces({"application/xml","application/json"})
    public List<Mentions> findAnimalsByType(@PathParam("type") String type){
        Session session = mainBean.getSessionFactory().openSession();
        try {
            List<УпоминанияОЗоопаркеEntity> mentionsList = searchMentionsByType(session,type);
            if(mentionsList == null) throw new Exception();

            List<Mentions> mentions = new ArrayList<Mentions>();

            for (УпоминанияОЗоопаркеEntity a: mentionsList) {
                ЗоопаркиEntity zoo = searchZooById(session,a.getIdЗоопарка());
                Mentions newMention = new Mentions(a.getНазваниеУпоминания(), zoo.getНазвание(), a.getIdУпоминания());
                mentions.add(newMention);
            }

            return mentions;
        }
        catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("date/{date}/{rule}")
    @Produces({"application/xml","application/json"})
    public List<Mentions> findAnimalsByDateBefore(@PathParam("date") String dateStr, @PathParam("rule") Boolean rule ){
        Session session = mainBean.getSessionFactory().openSession();
        try {
            Date date = new Date(); //!!!!!!!!!!!!!!!!!!!!!!
            List<УпоминанияОЗоопаркеEntity> mentionsList = searchMentionsByDate(session,date,rule);
            if(mentionsList == null) throw new Exception();

            List<Mentions> mentions = new ArrayList<Mentions>();

            for (УпоминанияОЗоопаркеEntity a: mentionsList) {
                ЗоопаркиEntity zoo = searchZooById(session,a.getIdЗоопарка());
                Mentions newMention = new Mentions(a.getНазваниеУпоминания(), zoo.getНазвание(), a.getIdУпоминания());
                mentions.add(newMention);
            }

            return mentions;
        }
        catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("mention/{id}")
    @Produces({"application/xml","application/json"})
    public ResponseMention findMention(@PathParam("id") Integer id){
        Session session = mainBean.getSessionFactory().openSession();
        try {
            УпоминанияОЗоопаркеEntity foundMention = searchMentionById(session,id);
            ВидыУпоминанийEntity type = searchKindOfMentionsById(session, foundMention.getIdВидаУпоминания());
            ЖивотныеEntity animal = searchAnimalById(session, foundMention.getIdЖивотного());
            String zooStr="Не известно";
            if(foundMention.getIdЗоопарка()!=null)
            {
                ЗоопаркиEntity zoo = searchZooById(session,foundMention.getIdЗоопарка());
                zooStr = zoo.getНазвание();
            }
            String emplStr="Не известно";
            if(foundMention.getIdСотрудника()!=null)
            {
                СотрудникиEntity emploee = searchEmployeeById(session,foundMention.getIdСотрудника());
                emplStr = emploee.getФио();
            }

            ResponseMention mention = new ResponseMention
                    (foundMention.getНазваниеУпоминания(),type.getНазваниеВидаУпоминания(),
                            foundMention.getДатаПубликации(),animal.getИмя(), zooStr, emplStr);
            return mention;
        }
        catch (Exception e) {
            return null;
        }
    }
}

class Mentions
{
    private String name;
    private String zoo;
    private Integer id;

    public Mentions(String name, String zoo, Integer id) {
        this.name = name;
        this.zoo = zoo;
        this.id = id;
    }
}

class ResponseMention {
    private String name;
    private String type;
    private Date date;
    private String animal;
    private String zoo;
    private String worker;

    public ResponseMention(String name, String type, Date date, String animal, String zoo, String worker) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.animal = animal;
        this.zoo = zoo;
        this.worker = worker;
    }
}*/