package ru.iad.response;

public class ResponseUser {

    private Integer id;
    private String login;
    private String name;
    private String email;
    private String info;
    private String role;

    public ResponseUser(Integer id, String username, String name, String email, String info,String role) {
        this.id = id;
        this.login = username;
        this.name = name;
        this.email = email;
        this.info = info;
        this.role = role;
    }
}
