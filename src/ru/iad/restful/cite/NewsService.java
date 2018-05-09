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
        for(int i =newsList.size()-1;i>newsList.size()-5;i--)
        {
            ResponseNews news = new ResponseNews(newsList.get(i).getId(),newsList.get(i).getHeader(),newsList.get(i).getDate(),newsList.get(i).getContent());
            responseNews.add(news);
        }

        return Response.status(200)
                .entity(gson.toJson(responseNews))
                .build();
    }
}

