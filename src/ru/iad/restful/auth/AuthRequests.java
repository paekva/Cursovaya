package ru.iad.restful.auth;

import ru.iad.dao.*;
import ru.iad.entities.User;
import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/auth/")
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
        if(fu.getPassword().equals(password)) return Response.status(200)
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
        if(update.userInfoUpdate(username, name, email, info)) return Response.status(200)
                .entity("succes")
                .build();
        else return Response.status(200)
                .entity("error")
                .build();
    }

}

