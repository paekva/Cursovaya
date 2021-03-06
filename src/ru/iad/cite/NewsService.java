package ru.iad.cite;

import com.google.gson.Gson;
import ru.iad.dao.SimpleSearch;
import ru.iad.entities.News;
import ru.iad.entities.Zoo;
import ru.iad.response.ResponseNews;
import ru.iad.response.ResponseZoo;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;

@Path("/news")
@Stateless
public class NewsService {

    @EJB
    SimpleSearch simpleSearch;

    @GET
    @Path("/all")
    public String allNews(){
        Gson gson = new Gson();
        List<ResponseNews> responseNews = new ArrayList<ResponseNews>();

        List<News> newsList = simpleSearch.searchAllNews();
        for(int i =0;i<newsList.size();i++)
        {
            ResponseNews news = new ResponseNews(newsList.get(i).getId(),newsList.get(i).getHeader(),newsList.get(i).getDate(),newsList.get(i).getContent());
            responseNews.add(news);
        }
		
        String json = gson.toJson(responseNews);
        return json;
    }

    @GET
    @Path("/single/{id}")
    public String singleNews(@PathParam("id") Integer id){
        News news = simpleSearch.searchNewsyId(id);
        Gson gson = new Gson();
        String json = gson.toJson(news);
        return json;
    }
}

