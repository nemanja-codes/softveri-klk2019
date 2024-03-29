/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import controller.Controller;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Predaje;
import model.Profesor;

/**
 *
 * @author necam
 */
public class Zadatak3Forma extends javax.swing.JFrame {
    private List<Profesor> sviProfesori;
    private List<Profesor> selektovaniProfesori;
    /**
     * Creates new form Zadatak3Forma
     */
    public Zadatak3Forma() {
        initComponents();
        setLocationRelativeTo(null);
        popuniTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProfesori = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAngazovanje = new javax.swing.JTable();
        jButtonPrikazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableProfesori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableProfesori.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jTableProfesori);

        jTableAngazovanje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableAngazovanje);

        jButtonPrikazi.setText("Prikazi angazovanja");
        jButtonPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrikaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPrikazi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButtonPrikazi)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrikaziActionPerformed
        selektovaniProfesori = new ArrayList<>();
        int[] nizIndeksaSelektovanihRedova = jTableProfesori.getSelectedRows();
        for (int i = 0; i < nizIndeksaSelektovanihRedova.length; i++) {
            Profesor p = sviProfesori.get(nizIndeksaSelektovanihRedova[i]);
            selektovaniProfesori.add(p);
        }
        
        List<Predaje> listaAngazovanja = Controller.getInstance().vratiListuAngazovanjaIzBaze(selektovaniProfesori);
        listaAngazovanja.sort(
                Comparator.comparing((Predaje p)-> p.getProfesor().getPrezime())
                            .thenComparing(p -> p.getProfesor().getIme())
                                .thenComparing(p -> p.getPredmet().getNaziv())
       );
        
        
        ModelTabeleAngazovanje mta = new ModelTabeleAngazovanje(listaAngazovanja);
        jTableAngazovanje.setModel(mta);
    }//GEN-LAST:event_jButtonPrikaziActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPrikazi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAngazovanje;
    private javax.swing.JTable jTableProfesori;
    // End of variables declaration//GEN-END:variables

    public void popuniTabelu() {
        sviProfesori = Controller.getInstance().vratiListuProfesoraIzBaze();
        
        ModelTabeleProfesor mtp = new ModelTabeleProfesor(sviProfesori);
        jTableProfesori.setModel(mtp);
    }
}
