package models;

public class News {

    private int id;
    private String content;
    private int departmentId;

    public News(String content, int departmentId) {
        this.content = content;
        this.departmentId = departmentId;
    }

}
