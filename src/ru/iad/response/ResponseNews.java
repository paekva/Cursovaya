package ru.iad.response;

import java.util.Date;

public class ResponseNews
{
    private Integer id;
    private String header;
    private Date date;
    private String content;

    public ResponseNews(Integer id, String header, Date date, String content) {
        this.id = id;
        this.header = header;
        this.date = date;
        this.content = content;
    }
}
