/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author necam
 */
public class Predmet {
    private int id;
    private String naziv;
    private int ESP;

    public Predmet() {
    }

    public Predmet(int id, String naziv, int ESP) {
        this.id = id;
        this.naziv = naziv;
        this.ESP = ESP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getESP() {
        return ESP;
    }

    public void setESP(int ESP) {
        this.ESP = ESP;
    }

    @Override
    public String toString() {
        return "Predmet{" + "naziv=" + naziv + '}';
    }
    
    
}
