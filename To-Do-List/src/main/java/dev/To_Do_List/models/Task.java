package dev.To_Do_List.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String discription;
    @ManyToOne
    private User user;
    public task(){}
    public task(String name, String discription, User user)
    {
        this.name = name;
        this.discription = discription
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
