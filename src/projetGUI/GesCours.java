/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetGUI;

import javax.swing.JOptionPane;
import classes.DAO.CoursDAO;
import classes.metiers.Cours;

/**
 *
 * @author jeanl
 */
public class GesCours extends javax.swing.JPanel {
    
    CoursDAO coursDAO = null;
    Cours loc1 = null;

    /** Creates new form GesCours */
    public GesCours() {
        initComponents();
    }
    
    public void setCoursDAO(CoursDAO coursDAO) {
        this.coursDAO = coursDAO;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textHEURES = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_kmtotaux = new javax.swing.JLabel();
        lbl_acompte = new javax.swing.JLabel();
        lbl_id_loc = new javax.swing.JLabel();
        textIDCOURS = new javax.swing.JTextField();
        textMATIERE = new javax.swing.JTextField();
        buttRech = new javax.swing.JButton();
        buttUpdate = new javax.swing.JButton();
        buttDel = new javax.swing.JButton();

        textHEURES.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textHEURES.setMinimumSize(new java.awt.Dimension(50, 20));
        textHEURES.setPreferredSize(new java.awt.Dimension(150, 30));
        textHEURES.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textHEURESKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion d'un cours via identifiant");

        lbl_kmtotaux.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_kmtotaux.setText("Matière :");

        lbl_acompte.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_acompte.setText("Heures :");

        lbl_id_loc.setText("ID du cours :");

        textIDCOURS.setMinimumSize(new java.awt.Dimension(50, 20));
        textIDCOURS.setPreferredSize(new java.awt.Dimension(150, 30));
        textIDCOURS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDCOURSActionPerformed(evt);
            }
        });
        textIDCOURS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textIDCOURSKeyTyped(evt);
            }
        });

        textMATIERE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textMATIERE.setMinimumSize(new java.awt.Dimension(50, 20));
        textMATIERE.setPreferredSize(new java.awt.Dimension(150, 30));
        textMATIERE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textMATIEREKeyTyped(evt);
            }
        });

        buttRech.setText("Rechercher le local");
        buttRech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttRechActionPerformed(evt);
            }
        });

        buttUpdate.setText("Update le local");
        buttUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttUpdateActionPerformed(evt);
            }
        });

        buttDel.setText("Delete le local");
        buttDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(buttRech, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttDel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_id_loc)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_kmtotaux, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_acompte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textMATIERE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(textHEURES, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(textIDCOURS, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id_loc)
                    .addComponent(textIDCOURS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMATIERE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_kmtotaux))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_acompte)
                    .addComponent(textHEURES, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttRech, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttDel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textIDCOURSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDCOURSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDCOURSActionPerformed

    private void buttRechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttRechActionPerformed

        try {
            if (!textIDCOURS.getText().isEmpty()) {
                int idCours = Integer.parseInt(textIDCOURS.getText());
                loc1 = coursDAO.read(idCours);
                textMATIERE.setText(""+loc1.getMatière());
                textHEURES.setText(""+loc1.getHeures());
               
                JOptionPane.showMessageDialog(this, "Local trouvé", "Found", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Champ d'ID vide, veuillez le compléter", "ERREUR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttRechActionPerformed

    private void buttUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttUpdateActionPerformed
        try {
            if (!textIDCOURS.getText().isEmpty()) {
                int idLoc=Integer.parseInt(textIDCOURS.getText());
                String matiere = textMATIERE.getText();
                int heures = Integer.parseInt(textHEURES.getText());
                Cours loc1 = new Cours(idLoc,matiere,heures);
                coursDAO.update(loc1);
                JOptionPane.showMessageDialog(this, "Cours mis à jour", "success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Champ d'ID vide, veuillez le compléter", "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttUpdateActionPerformed

    private void buttDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttDelActionPerformed
        try {
            if (!textIDCOURS.getText().isEmpty()) {
                int idCours = Integer.parseInt(textIDCOURS.getText());
                coursDAO.delete(loc1);
                textHEURES.setText("");
                textIDCOURS.setText("");
                textMATIERE.setText("");
                JOptionPane.showMessageDialog(this, "Cours effacé", "success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Champ d'ID vide, veuillez le compléter", "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttDelActionPerformed

    private void textIDCOURSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textIDCOURSKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || (Character.isSpaceChar(c))) {
            textIDCOURS.setEditable(false);
        } else {
            textIDCOURS.setEditable(true);
        }
    }//GEN-LAST:event_textIDCOURSKeyTyped

    private void textMATIEREKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMATIEREKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || (Character.isSpaceChar(c))) {
            textMATIERE.setEditable(false);
        } else {
            textMATIERE.setEditable(true);
        }
    }//GEN-LAST:event_textMATIEREKeyTyped

    private void textHEURESKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textHEURESKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || (Character.isSpaceChar(c))) {
            textHEURES.setEditable(false);
        } else {
            textHEURES.setEditable(true);
        }
    }//GEN-LAST:event_textHEURESKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttDel;
    private javax.swing.JButton buttRech;
    private javax.swing.JButton buttUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_acompte;
    private javax.swing.JLabel lbl_id_loc;
    private javax.swing.JLabel lbl_kmtotaux;
    private javax.swing.JTextField textHEURES;
    private javax.swing.JTextField textIDCOURS;
    private javax.swing.JTextField textMATIERE;
    // End of variables declaration//GEN-END:variables

}
