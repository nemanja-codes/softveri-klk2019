/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author necam
 */
public class PoreskaStopa {
    private int sifra;
    private String skraceniNaziv;
    private double iznos;

    public PoreskaStopa() {
    }

    public PoreskaStopa(int sifra, String skraceniNaziv, double iznos) {
        this.sifra = sifra;
        this.skraceniNaziv = skraceniNaziv;
        this.iznos = iznos;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getSkraceniNaziv() {
        return skraceniNaziv;
    }

    public void setSkraceniNaziv(String skraceniNaziv) {
        this.skraceniNaziv = skraceniNaziv;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    @Override
    public String toString() {
        return skraceniNaziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PoreskaStopa other = (PoreskaStopa) obj;
        if (this.sifra != other.sifra) {
            return false;
        }
        if (Double.doubleToLongBits(this.iznos) != Double.doubleToLongBits(other.iznos)) {
            return false;
        }
        return Objects.equals(this.skraceniNaziv, other.skraceniNaziv);
    }
    
    
}
