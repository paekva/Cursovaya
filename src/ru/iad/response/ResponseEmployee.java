package ru.iad.response;

public class ResponseEmployee
{
    private Integer id;
    private String name;
    private Integer age;
    private String profession;

    public ResponseEmployee(Integer id, String name, Integer age, String profession) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.profession = profession;
    }
}
