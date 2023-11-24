package com.taskmanager.taskmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class task {
    
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name="titre")
	private String titre;
	
	@Column(name="contenu")
	private String contenu;
	
	@Column(name="auteur")
	private String auteur;

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
