package ru.iad.auth;

import ru.iad.dao.Update;
import ru.iad.entities.User;
import ru.iad.dao.Insert;
import ru.iad.dao.SimpleSearch;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;


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
    @Path("regist/{username}/{password}/{role}")
    @Produces({"application/xml", "application/json"})
    public String registration(@PathParam("username") String username, @PathParam("password") String password, @PathParam("role") String role) {
        int rtrn = insert.userInsert(username,password,role);
        if(rtrn==1) return "error";
        else return "succes";
    }

    @POST
    @Path("auth/{username}/{password}")
    @Produces({"application/xml", "application/json"})
    public String authentication(@PathParam("username") String username, @PathParam("password") String password) {
        User fu = ss.searchUserByName(username);
        if(fu.getPassword()==password) return "succes";
        else return "error";
    }

    @POST
    @Path("addInfo/{username}/{name}/{email}/{info}")
    @Produces({"application/xml", "application/json"})
    public String addNewInfo(@PathParam("username") String username, @PathParam("name") String name, @PathParam("email") String email, @PathParam("info") String info) {
     if(update.userInfoUpdate(username, name, email, info)==true) return "succes";
     else return "error";
    }

}

