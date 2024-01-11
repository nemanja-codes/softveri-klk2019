/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Predaje;

/**
 *
 * @author necam
 */
public class ModelTabeleAngazovanje extends AbstractTableModel {
    private List<Predaje> lista;
    private String[] kolone = {"id","ime","prezime","naziv"};

    public ModelTabeleAngazovanje(List<Predaje> lista) {
        this.lista = lista;
    }
    
   
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predaje p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getProfesor().getIme();
            case 2:
                return p.getProfesor().getPrezime();
            case 3:
                return p.getPredmet().getNaziv();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Predaje> getLista() {
        return lista;
    }

    public void setLista(List<Predaje> lista) {
        this.lista = lista;
    }
    
    
    
}
