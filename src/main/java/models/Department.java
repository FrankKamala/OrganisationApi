package models;

public class Department {

    private String name;
    private String description;
    private int noOfEmployees;
    private int id;

    public Department(String name, String description, int noOfEmployees) {
        this.name = name;
        this.description = description;
        this.noOfEmployees = noOfEmployees;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public void setNoOfEmployees(int noOfEmployees) { this.noOfEmployees = noOfEmployees; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
