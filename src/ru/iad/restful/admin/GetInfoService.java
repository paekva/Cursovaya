package ru.iad.restful.admin;
/*READY, NOT TESTED*/
import com.google.gson.Gson;
import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.*;
import ru.iad.response.*;

@Path("/admin/get")
@Stateful
public class GetInfoService {

    @EJB
    private SimpleSearch simpleSearch;



    @GET
    @Path("/employees/{name}")
    @Produces({"application/xml", "application/json"})
    public Response oneEmployee(@PathParam("name") String name) {
        Gson gson = new Gson();
        Employees employees = simpleSearch.searchEmployeeByName(name);
        if(employees!=null)
        {
            ResponseEmployee re = new ResponseEmployee(employees.getСтажРаботы(),employees.getФио(),employees.getПрофессия());
            return Response.status(200)
                    .entity(gson.toJson(re))
                    .build();
        }
        else
        {
            return Response.status(401).build();
        }
    }
}

