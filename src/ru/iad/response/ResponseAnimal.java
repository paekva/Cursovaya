package ru.iad.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResponseAnimal {
    private String name;
    private String spicies;
    private Integer age;
    private String zoo;
    private String dad;
    private String mum;
    private String info;
    private List<String> mentions;

    public List<String> getMentions() {
        return mentions;
    }

    public ResponseAnimal(String name, String spicies, Date birthDate, String zoo, String dad, String mum, String info) {
        this.name = name;
        this.spicies = spicies;
        Date nd = new Date();
        long diff = (nd.getTime() - birthDate.getTime()) / 1000;
        long devide = 3600 * 24 * 365;
        long time = diff / devide;
        this.age = (int) time;
        this.zoo = zoo;
        this.dad = dad;
        this.mum = mum;
        this.info = info;
        this.mentions = new ArrayList<String>();
    }
}