/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import controller.Controller;
import java.util.List;
import javax.swing.JOptionPane;
import model.Profesor;
import model.Status;

/**
 *
 * @author necam
 */
public class Zadatak2Forma extends javax.swing.JFrame {

    List<Profesor> sviProfesori;
    /**
     * Creates new form Zadatak2Forma
     */
    public Zadatak2Forma() {
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
        jButtonIzmeni = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTableProfesori);

        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonIzmeni)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButtonIzmeni)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        int selektovaniRed = jTableProfesori.getSelectedRow();
        if(selektovaniRed == -1) {
            JOptionPane.showMessageDialog(this, "Nije izabran nijedan profesor!", "Greska", JOptionPane.ERROR_MESSAGE);
          
        }
        Profesor profesorZaIzmenu = sviProfesori.get(selektovaniRed);
        if(profesorZaIzmenu.getStatus().equals(Status.PENZIONISAN)) {
            JOptionPane.showMessageDialog(this, "GRESKA", "Greska", JOptionPane.ERROR_MESSAGE);
        } else {
            IzmenaProfesora ip = new IzmenaProfesora(this, true, profesorZaIzmenu);
            ip.setVisible(true);
        }
        
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProfesori;
    // End of variables declaration//GEN-END:variables

    public void popuniTabelu() {
        sviProfesori = Controller.getInstance().vratiListuProfesoraIzBaze();
        
        ModelTabeleProfesor mtp = new ModelTabeleProfesor(sviProfesori);
        jTableProfesori.setModel(mtp);
    }
}
