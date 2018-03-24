package ru.iad.response;

import java.util.Date;

public class ResponseTickets
{
    private Integer id;
    private String zoo;
    private Date date;
    private String type;

    public ResponseTickets(Integer id, String zoo, Date date, String type) {
        this.id = id;
        this.zoo = zoo;
        this.date = date;
        this.type = type;
    }
}
