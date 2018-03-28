package ru.iad.response;

public class ResponseEmployee
{
    private Integer id;
    private String name;
    private String profession;

    public ResponseEmployee(Integer id, String name, String profession) {
        this.id = id;
        this.name = name;
        this.profession = profession;
    }
}
