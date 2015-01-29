/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.shadernodedefinition.wizard;

import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings({"unchecked", "rawtypes"})
public final class SNDefVisualPanel2 extends JPanel {

    private final Object[] emptyObj = {"", "", ""};
    private final String type;

    /**
     * Creates new form SNDefVisualPanel2
     */
    public SNDefVisualPanel2(String type) {
        initComponents();
        this.type = type;
        titleLabel.setText(type);
        varTable.getColumnModel().getSelectionModel().addListSelectionListener(new ExploreSelectionListener());
    }

    @Override
    public String getName() {
        return type;
    }

    public String[][] getData() {

        DefaultTableModel model = (DefaultTableModel) varTable.getModel();
        String[][] data = new String[model.getRowCount()][3];
        for (int i = 0; i < model.getRowCount(); i++) {
            data[i][0] = (String) model.getValueAt(i, 0);
            data[i][1] = (String) model.getValueAt(i, 1);
            data[i][2] = (String) model.getValueAt(i, 2);
        }

        return data;
    }

    // Add this class to the body of MyTable class.
    private class ExploreSelectionListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {              
                int row = varTable.getSelectedRow();
                int col = varTable.getSelectedColumn();
                // Make sure we start with legal values.
                if (col < 0) {
                    col = 0;
                }
                if (row < 0) {
                    row = 0;
                }
                // Find the next editable cell.
                while (!varTable.isCellEditable(row, col)) {
                    col++;
                    if (col > varTable.getColumnCount() - 1) {
                        col = 1;
                        row = (row == varTable.getRowCount() - 1) ? 1 : row + 1;
                    }
                }
                // Select the cell in the table.
                final int r = row, c = col;
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        varTable.changeSelection(r, c, false, false);
                    }
                });
                // Edit.
                if (varTable.isCellEditable(row, col)) {
                    varTable.editCellAt(row, col);
                    ((JTextField) varTable.getEditorComponent()).selectAll();
                    varTable.getEditorComponent().requestFocusInWindow();
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varTable = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();

        varTable.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        varTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Name", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(varTable);

        org.openide.awt.Mnemonics.setLocalizedText(titleLabel, org.openide.util.NbBundle.getMessage(SNDefVisualPanel2.class, "SNDefVisualPanel2.titleLabel.text")); // NOI18N

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jme3/gde/materials/multiview/widgets/icons/picture_add.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(addButton, org.openide.util.NbBundle.getMessage(SNDefVisualPanel2.class, "SNDefVisualPanel2.addButton.text")); // NOI18N
        addButton.setToolTipText(org.openide.util.NbBundle.getMessage(SNDefVisualPanel2.class, "SNDefVisualPanel2.addButton.toolTipText")); // NOI18N
        addButton.setAlignmentX(0.5F);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        delButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jme3/gde/materials/multiview/widgets/icons/picture_delete.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(delButton, org.openide.util.NbBundle.getMessage(SNDefVisualPanel2.class, "SNDefVisualPanel2.delButton.text")); // NOI18N
        delButton.setToolTipText(org.openide.util.NbBundle.getMessage(SNDefVisualPanel2.class, "SNDefVisualPanel2.delButton.toolTipText")); // NOI18N
        delButton.setAlignmentX(0.5F);
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titleLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(delButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) varTable.getModel();
        model.addRow(emptyObj);
    }//GEN-LAST:event_addButtonActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) varTable.getModel();
        int selRow = varTable.getSelectedRow();
        if (selRow >= 0) {
            model.removeRow(selRow);
        }
    }//GEN-LAST:event_delButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton delButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTable varTable;
    // End of variables declaration//GEN-END:variables
}
