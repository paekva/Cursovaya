package ru.iad.response;

public class ResponseUser {

    private String login;
    private String name;
    private String email;
    private String info;
    private String role;

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getInfo() {
        return info;
    }

    public String getRole() {
        return role;
    }

    public ResponseUser(String login, String role, String name, String email, String info) {
        this.login = login;
        this.name = name;
        this.email = email;
        this.info = info;
        this.role = role;
    }
}
