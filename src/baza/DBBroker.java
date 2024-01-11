/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Profesor;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Predaje;
import model.Predmet;
import model.Status;
import model.Zvanje;

/**
 *
 * @author necam
 */
public class DBBroker {

    public List<Profesor> vratiListuProfesoraIzBaze() {
        List<Profesor> lista = new ArrayList<>();
        String upit = "SELECT * FROM PROFESOR";
        try {
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()) {
                int id = rs.getInt("id");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                Zvanje zvanje = Zvanje.valueOf(rs.getString("zvanje"));
                Status status = Status.valueOf(rs.getString("status"));
                
                Profesor p = new Profesor(id, ime, prezime, zvanje, status);
                
                lista.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lista;
    }

    public void azurirajProfesora(int id, String ime, String prezime, Zvanje z) {
        String upit = "UPDATE PROFESOR SET IME = ?, PREZIME = ?, ZVANJE = ? WHERE ID = ?";
        try {
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, ime);
            ps.setString(2, prezime);
            ps.setString(3, String.valueOf(z));
            ps.setInt(4, id);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Predaje> vratiListuAngazovanjaIzBaze(List<Profesor> selektovaniProfesori) {
        List<Predaje> lista = new ArrayList<>();
        
        for (Profesor profesor : selektovaniProfesori) {
            String upit = "SELECT * FROM PREDAJE\n" +
                        "JOIN PROFESOR ON PREDAJE.PROFESOR=PROFESOR.ID\n" +
                        "JOIN PREDMET ON PREDAJE.PREDMET=PREDMET.ID\n" +
                        "WHERE PREDAJE.PROFESOR="+profesor.getId();
            try {
                Statement st = Konekcija.getInstance().getConnection().createStatement();
                ResultSet rs = st.executeQuery(upit);
                while(rs.next()) {
                    int idPredmet = rs.getInt("predmet.id");
                    String nazivPredmeta = rs.getString("predmet.naziv");
                    int ESP = rs.getInt("predmet.ESP");
                    Predmet predmet = new Predmet(idPredmet, nazivPredmeta, ESP);
                    int idAngazovanja = rs.getInt("predaje.id");
                    Predaje predaje = new Predaje(idAngazovanja, profesor, predmet);
                    
                    lista.add(predaje);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return lista;
    }
    
}
