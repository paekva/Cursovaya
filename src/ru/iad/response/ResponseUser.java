package ru.iad.response;

public class ResponseUser {

    private Integer id;
    private String username;
    private String name;
    private String email;
    private String info;

    public ResponseUser(Integer id, String username, String name, String email, String info) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.info = info;
    }
}
