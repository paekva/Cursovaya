package ru.iad.restful.cite;
/*READY*/
import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.News;
import ru.iad.response.ResponseNews;

import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/news")
@Stateless
public class NewsService {

    @EJB
    private SimpleSearch simpleSearch;

    @GET
    @Path("/all")
    @Produces({"application/xml", "application/json"})
    public Response allNews(){
        Gson gson = new Gson();
        List<ResponseNews> responseNews = new ArrayList<ResponseNews>();

        List<News> newsList = simpleSearch.searchAllNews();
        for(int i =0;i<4;i++) //HERE IS HARDCODED 4
        {
            ResponseNews news = new ResponseNews(newsList.get(i).getId(),newsList.get(i).getHeader(),newsList.get(i).getDate(),newsList.get(i).getContent());
            responseNews.add(news);
        }

        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(gson.toJson(responseNews))
                .build();
    }
}

