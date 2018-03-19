package ru.iad;

import ru.iad.dao.Insert;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.sql.Date;

@Stateless
@LocalBean
@Path("hello")
public class HelloWorld {

    @EJB
    Insert insert;
    @GET
    public String sayHello()
    {
        Date zooDate = new Date(100000);
        insert.zooInsert("Мордовский национальный парк","работает","Вилкова А.Ю", "Саранск, республика Мордовия", zooDate,300,1202);
        return "Hello!";
    }
}
