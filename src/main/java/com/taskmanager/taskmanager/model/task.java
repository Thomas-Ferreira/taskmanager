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
    @JoinColumn(name = "auteurId")
	private user auteurId;

    // Default constructor (needed by JPA)
    public task() {}
    
    // Constructor with parameters
    public task(String titre, String contenu, user auteurId) {
        this.titre = titre;
        this.contenu = contenu;
        this.auteurId = auteurId;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public user getAuteur() {
        return auteurId;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setAuteur(user auteurId) {
        this.auteurId = auteurId;
    }
}
