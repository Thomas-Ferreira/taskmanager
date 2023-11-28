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
public class task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	private String titre;
	private String contenu;

    @ManyToOne
    @JoinColumn(name = "userId")
	private user User;

    // Default constructor (needed by JPA)
    public task() {}
    
    // Constructor with parameters
    public task(String titre, String contenu, user User) {
        this.titre = titre;
        this.contenu = contenu;
        this.User = User;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public user getUser() {
        return User;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setUser(user User) {
        this.User = User;
    }
}
