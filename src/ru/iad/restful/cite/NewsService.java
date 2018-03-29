package ru.iad.restful.cite;
/*READY*/
import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.News;
import ru.iad.response.ResponseNews;

import javax.ejb.*;
import javax.ws.rs.*;
import java.util.*;

@Path("/news")
@Stateless
public class NewsService {

    @EJB
    private SimpleSearch simpleSearch;

    @GET
    @Path("/all")
    @Produces({"application/xml", "application/json"})
    public String allNews(){
        Gson gson = new Gson();
        List<ResponseNews> responseNews = new ArrayList<ResponseNews>();

        List<News> newsList = simpleSearch.searchAllNews();
        for(int i =0;i<5;i++) //HERE IS HARDCODED 5
        {
            ResponseNews news = new ResponseNews(newsList.get(i).getId(),newsList.get(i).getHeader(),newsList.get(i).getDate(),newsList.get(i).getContent());
            responseNews.add(news);
        }

        return gson.toJson(responseNews);
    }

    @GET
    @Path("/single/{id}")
    public String singleNews(@PathParam("id") Integer id){
        News news = simpleSearch.searchNewsyId(id);
        Gson gson = new Gson();

        return gson.toJson(news);
    }
}

