package ru.iad.restful.auth;

import com.google.gson.Gson;
import ru.iad.dao.*;
import ru.iad.entities.User;
import ru.iad.response.ResponseUser;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/auth")
@Stateless
public class AuthRequests {

    @EJB
    private Insert insert;

    @EJB
    private SimpleSearch ss;

    @EJB
    private Update update;

    @POST
    @Path("registration")
    public Response registration
            (@FormParam("name") String username, @FormParam("password") String password) {
        int rtrn = insert.userInsert(username,password,"user");
        if(rtrn!=1) return Response.status(200)
                .entity("succes")
                .build();
        else return Response.status(401)
                .entity("error")
                .build();
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/auth")
    public String authentication (User login) {
        Gson gson = new Gson();
        ResponseUser ru;
        User fu = ss.searchUserByName(login.getUsername());
        if((fu!=null)&&(fu.getPassword().equals(login.getPassword())))
        {
           ru = new ResponseUser(fu.getId(),fu.getUsername(),fu.getName(),fu.getEmail(),fu.getInfo(),fu.getRole());
        }
        else ru = new ResponseUser(0,"","","","","NOT");
        return gson.toJson(ru);
    }

    @GET
    @Path("/single/{login}/{password}")
    @Produces({"application/xml", "application/json"})
    public Response authentication(@PathParam("login") String login,@PathParam("password") String pswd)
    {
        ResponseUser ru;
        User fu = ss.searchUserByName(login);
        if((fu!=null)&&(fu.getPassword().equals(pswd)))
        {
            ru = new ResponseUser(fu.getId(),fu.getUsername(),fu.getName(),fu.getEmail(),fu.getInfo(),fu.getRole());
        }
        else ru = new ResponseUser(0,"","","","","NOT");
        Gson gson = new Gson();
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(ru))
                .build();
    }

    @POST
    @Path("addInfo")
    public Response addNewInfo
            (@FormParam("username") String username,@FormParam("name") String name,
             @FormParam("email") String email,@FormParam("info") String info) {
        if(update.userInfoUpdate(username, name, email, info)) return Response.status(200)
                .entity("succes")
                .build();
        else return Response.status(200)
                .entity("error")
                .build();
    }

}

