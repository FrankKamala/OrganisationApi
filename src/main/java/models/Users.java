package models;

public class Users {
    private String name;
    private String position;
    private String roles;
    private int id;

    public Users(String roles, String position,String name) {
        this.name = name;
        this.roles = roles;
        this.position = position;
    }

}
