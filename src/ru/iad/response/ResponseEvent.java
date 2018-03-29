package ru.iad.response;

import java.util.Date;

public class ResponseEvent {
    private String name;
    private String type;
    private Date date;
    private Double ticketCost;
    private String zoo;
    private String worker;

    public ResponseEvent(String name, String type, Date date, Double ticketCost, String zoo, String worker) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.ticketCost = ticketCost;
        this.zoo = zoo;
        this.worker = worker;
    }
}
