package ru.iad.restful.auth;

import ru.iad.dao.Update;
import ru.iad.entities.User;
import ru.iad.dao.Insert;
import ru.iad.dao.SimpleSearch;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/auth/")
@Stateless
public class AuthRequests {

    @EJB
    Insert insert;

    @EJB
    SimpleSearch ss;

    @EJB
    Update update;

    @POST
    @Path("registration")
    public Response registration
            (@FormParam("name") String username, @FormParam("password") String password) {
        int rtrn = insert.userInsert(username,password,"user");
        if(rtrn!=1) return Response.status(200)
                .entity("succes")
                .build();
        else return Response.status(200)
                .entity("error")
                .build();
    }


    @POST
    @Path("auth")
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public Response authentication
    (@FormParam("name") String username,@FormParam("password") String password) {
        User fu = ss.searchUserByName(username);
        if(fu==null) return Response.status(200)
                .entity("user not found")
                .build();
        if(fu.getPassword()==password) return Response.status(200)
                .entity("succes")
                .build();
        else return Response.status(200)
                .entity("password is incorrect")
                .build();
    }

    @POST
    @Path("addInfo")
    public Response addNewInfo
            (@FormParam("username") String username,@FormParam("name") String name,
             @FormParam("email") String email,@FormParam("info") String info) {
        if(update.userInfoUpdate(username, name, email, info)==true) return Response.status(200)
                .entity("succes")
                .build();
        else return Response.status(200)
                .entity("error")
                .build();
    }

}

