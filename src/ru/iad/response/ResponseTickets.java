package ru.iad.response;

import java.util.Date;

public class ResponseTickets
{
    private String zoo;
    private Date date;
    private String type;

    public ResponseTickets(String zoo, Date date, String type) {
        this.zoo = zoo;
        this.date = date;
        this.type = type;
    }
}
