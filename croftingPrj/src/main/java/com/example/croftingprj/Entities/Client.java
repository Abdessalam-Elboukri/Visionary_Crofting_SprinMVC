package com.example.croftingprj.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nom;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telephone;
    private String password;

    @OneToMany(mappedBy = "client" , fetch = FetchType.LAZY)
    private List<Commande> commandes ;

    public Client() {
    }

    public Client(String nom, String email, String telephone, String password, List<Commande> commandes) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.commandes = commandes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //@JsonIgnore
    public List<Commande> getCommandes() {
        return commandes;
    }

    //@JsonSetter
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", commandes=" + commandes +
                '}';
    }
}
