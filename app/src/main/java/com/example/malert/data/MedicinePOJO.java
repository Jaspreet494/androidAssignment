package com.example.malert.data;

/**
 * A class which helps in creating Plain Old Java Object
 */
public class MedicinePOJO {
    //ID for the reminder
    private int id;
    //Name for the medicine
    private String name;
    //Date and time when the medicine reminder should come
    private String dateAndTime;
    //Description of medicine
    private String description;

    //Constructor class to help assign
    public MedicinePOJO(int id, String name, String dateAndTime, String description)
    {
        this.id = id;
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.description = description;
    }

    // Getter / Setter functions
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
