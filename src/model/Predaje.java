 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author necam
 */
public class Predaje {
    private int id;
    private Profesor profesor;
    private Predmet predmet;

    public Predaje() {
    }

    public Predaje(int id, Profesor profesor, Predmet predmet) {
        this.id = id;
        this.profesor = profesor;
        this.predmet = predmet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    @Override
    public String toString() {
        return "Predaje{" + "id=" + id + ", profesor=" + profesor + ", predmet=" + predmet + '}';
    }
    
    
}
