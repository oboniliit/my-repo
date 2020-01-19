
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.w3c.dom.css.Counter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class SimuLCS extends javax.swing.JFrame {

    /**
     * Creates new form SimuLCS
     */
    //private static SimuLCS oneInstance = null;
    MainFrame kk;
    RunLCS ins;
    Timer tim, kim;
    static long counter = 0;

    public SimuLCS(MainFrame T) {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        kk = T;
        TextFieldString1.setText("");
        TextFieldString2.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelString1 = new javax.swing.JLabel();
        TextFieldString1 = new javax.swing.JTextField();
        LabelString2 = new javax.swing.JLabel();
        TextFieldString2 = new javax.swing.JTextField();
        ButtonLCSProcced = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        LabelString1.setText("First String");

        LabelString2.setText("Second String");

        TextFieldString2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldString2ActionPerformed(evt);
            }
        });

        ButtonLCSProcced.setText("Procced");
        ButtonLCSProcced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLCSProccedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelString2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelString1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextFieldString1)
                    .addComponent(TextFieldString2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonLCSProcced)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ButtonLCSProcced, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelString1)
                            .addComponent(TextFieldString1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelString2)
                            .addComponent(TextFieldString2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(192, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldString2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldString2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldString2ActionPerformed

    
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        //oneInstance = null;
        //System.out.println("SimuLCS.formWindowClosed()");
        kk.setEnabled(true);
        kk.show();
        counter = 0;

    }//GEN-LAST:event_formWindowClosed

    private void ButtonLCSProccedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLCSProccedActionPerformed
        // TODO add your handling code here:
        /* Create and display the form */
        MainFrame.pp.setEnabled(false);
        String aa = TextFieldString1.getText();
        String bb = TextFieldString2.getText();
        if (aa.length() == 0 || bb.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please! Insert non-empty two strings.");
            MainFrame.pp.setEnabled(true);
            MainFrame.pp.show();
            return;
        }
        counter = System.currentTimeMillis();
        ins = new RunLCS(aa, bb);
        Thread t = new Thread(ins);
        t.start();
        tim = new Timer(500, new ActionListener() {
            int i = 1;
            int j = 1;
            String kk = new String();

            @Override
            public void actionPerformed(ActionEvent e) {
                long second = (System.currentTimeMillis() - counter) / 1000;
                long minute = second / 60;
                second = second - (minute * 60);
                ins.TimerLabel.setText(minute + " Minute(s) and "
                        + second + " Second(s)");
                if (j > ins.col) {
                    i++;
                    if (i > ins.row) {
                        counter = 0;
                        tim.stop();
                    }
                    j = 1;
                }
                if (i > ins.row) {
                    kim = new Timer(550, new ActionListener() {
                        int ii = ins.row;
                        int jj = ins.col;

                        @Override
                        public void actionPerformed(ActionEvent ee) {
                            if (ii < 0 || jj < 0) {
                                counter = 0;
                                return;
                            }
                            if (ins.path[ii][jj] == 1) {
                                ins.grid[ii][jj].setBackground(Color.DARK_GRAY);
                                ii = ii - 1;
                                jj = jj - 1;
                            }
                            if (ins.path[ii][jj] == 2) {
                                ii = ii - 1;
                            }
                            if (ins.path[ii][jj] == 3) {
                                jj = jj - 1;
                            }
                        }
                    });
                    kim.start();
                    if (ins.lcs.length() > 0) {
                        JOptionPane.showMessageDialog(null, "LCS is : " + ins.lcs);
                    } else {
                        JOptionPane.showMessageDialog(null, "No Common Subsequence!");
                    }
                    return;
                }
                kk = Integer.toString(ins.memo[i][j]);
                if (ins.path[i][j] == 1) {
                    kk = kk + '\u2196';
                } else if (ins.path[i][j] == 2) {
                    kk = kk + '\u2191';
                } else {
                    kk = kk + '\u2190';
                }
                ins.grid[i][j].setText(kk);
                ins.grid[i][j].setFont(new Font("Serif", Font.BOLD, 30));
                j++;
            }
        });
        tim.start();
        //this.dispose();
    }//GEN-LAST:event_ButtonLCSProccedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLCSProcced;
    private javax.swing.JLabel LabelString1;
    private javax.swing.JLabel LabelString2;
    private javax.swing.JTextField TextFieldString1;
    private javax.swing.JTextField TextFieldString2;
    // End of variables declaration//GEN-END:variables
}
