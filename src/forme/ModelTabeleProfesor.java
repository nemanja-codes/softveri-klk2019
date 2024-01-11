/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Profesor;

/**
 *
 * @author necam
 */
public class ModelTabeleProfesor extends AbstractTableModel {
    private List<Profesor> listaProfesora;
    private String[] kolone = {"id", "ime", "prezime", "zvanje", "status"};

    public ModelTabeleProfesor(List<Profesor> listaProfesora) {
        this.listaProfesora = listaProfesora;
    }
    
    @Override
    public int getRowCount() {
        return listaProfesora.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Profesor p = listaProfesora.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getIme();
            case 2:
                return p.getPrezime();
            case 3:
                return p.getZvanje();
            case 4:
                return p.getStatus();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Profesor> getListaProfesora() {
        return listaProfesora;
    }

    public void setListaProfesora(List<Profesor> listaProfesora) {
        this.listaProfesora = listaProfesora;
    }
    
    
    
    
    
}
