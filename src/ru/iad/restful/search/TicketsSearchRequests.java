package ru.pip.search;
/*
import org.hibernate.SessionFactory;
import ru.pip.dao.crud.HibernateSessionFactory;
import ru.pip.dao.entities.*;
import org.hibernate.Session;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.pip.dao.crud.SimpleSearch.*;
import static ru.pip.dao.crud.ComplexSearch.*;

@Path("/search/tickets/")
@Stateless
public class TicketsSearchRequests {
    @EJB
    private HibernateSessionFactory mainBean;

    /*  Поиск билетов для админа по дате и по зоопарку  */
    /*  Поиск билетов для пользователя по своему id  */
   /* @POST
    @Path("date/{date}/{rule}")
    @Produces({"application/xml","application/json"})
    public List<Ticket> findTicketsByDate(@PathParam("date") String dateStr, @PathParam("rule") Boolean rule )
    {
        Session session = mainBean.getSessionFactory().openSession();
        try {
            Date date = new Date(); //!!!!!!!!!!!!!!!!!!!!!!
            List<БилетыEntity> ticketsList = searchTicketsByDate(session,date,rule);
            if(ticketsList == null) throw new Exception();

            List<Ticket> tickets = new ArrayList<Ticket>();

            for (БилетыEntity a: ticketsList) {
                ВидыКатегорийEntity type = searchKindOfCategoryById(session, a.getIdКатегории());
                ЗоопаркиEntity zoo = searchZooById(session,a.getIdЗоопарка());
                Ticket newTicket = new Ticket(type.getНазваниеКатегории(),date,zoo.getНазвание());
                tickets.add(newTicket);
            }
            return tickets;
        }
        catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("zoo/{zoo}")
    @Produces({"application/xml","application/json"})
    public List<Ticket> findTicketsByZoo(@PathParam("zoo") String zoo)
    {
        Session session = mainBean.getSessionFactory().openSession();
        try {
            List<БилетыEntity> ticketsList = searchTicketsByZoo(session,zoo);
            if(ticketsList == null) throw new Exception();

            List<Ticket> tickets = new ArrayList<Ticket>();

            for (БилетыEntity a: ticketsList) {
                ВидыКатегорийEntity type = searchKindOfCategoryById(session, a.getIdКатегории());
                Ticket newTicket = new Ticket(type.getНазваниеКатегории(),a.getДатаПокупки(),zoo);
                tickets.add(newTicket);
            }
            return tickets;
        }
        catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("user/{user}")
    @Produces({"application/xml","application/json"})
    public List<Ticket> findTicketsByUser(@PathParam("user") Integer id)
    {
        Session session = mainBean.getSessionFactory().openSession();
        try {
            List<БилетыEntity> ticketsList = searchTicketsByUser(session,id);
            if(ticketsList == null) throw new Exception();

            List<Ticket> tickets = new ArrayList<Ticket>();

            for (БилетыEntity a: ticketsList) {
                ВидыКатегорийEntity type = searchKindOfCategoryById(session, a.getIdКатегории());
                ЗоопаркиEntity zoo = searchZooById(session,a.getIdЗоопарка());
                Ticket newTicket = new Ticket(type.getНазваниеКатегории(),a.getДатаПокупки(),zoo.getНазвание());
                tickets.add(newTicket);
            }
            return tickets;
        }
        catch (Exception e) {
            return null;
        }
    }
}

class Ticket
{
    private String type;
    private Date date;
    private String zoo;

    public Ticket(String type, Date date, String zoo) {
        this.type = type;
        this.date = date;
        this.zoo = zoo;
    }
}
*/