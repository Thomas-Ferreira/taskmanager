package com.taskmanager.taskmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TASKS")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	private String titre;
	private String contenu;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
	private User user;

    // Default constructor (needed by JPA)
    public Task() {}
    
    // Constructor with parameters
    public Task(String titre, String contenu, User user) {
        this.titre = titre;
        this.contenu = contenu;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public User getUser() {
        return user;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setUser(User User) {
        this.user = User;
    }
}
