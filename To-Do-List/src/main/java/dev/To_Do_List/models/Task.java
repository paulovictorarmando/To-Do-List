package dev.To_Do_List.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Task(){}
    public Task(String name, String description, User user)
    {
        this.name = name;
        this.description = description;
        this.user = user;
    }
    public String getName() {
        return name;
    }

    public Long getId(){
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
