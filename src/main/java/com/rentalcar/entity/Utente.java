package com.rentalcar.entity;

import javax.persistence.*;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "datadinascita")
    private String datadinascita;

    @ManyToOne
    @JoinColumn(name = "ruolo", nullable = false)
    private TipologiaUtente ruolo;

    public Utente(){}

    public Utente(String nome, String cognome, String datadinascita, TipologiaUtente ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.datadinascita = datadinascita;
        this.ruolo = ruolo;
    }

    public int  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDatadinascita() {
        return datadinascita;
    }

    public void setDatadinascita(String datadinascita) {
        this.datadinascita = datadinascita;
    }

    public TipologiaUtente getRuolo() {
        return ruolo;
    }

    public void setRuolo(TipologiaUtente ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", data di nascita=" + datadinascita + ", ruolo=" + ruolo.getRuolo() + "]";
    }
}
