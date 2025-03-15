package gr.ihu.ict.msc.junglebook.model;

import java.io.Serializable;



public class Photo implements Serializable {
    private String name;
    private int id;

    private String description;

    public Photo(String name, int id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
