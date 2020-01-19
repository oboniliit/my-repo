
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class SimuBubbleSort extends javax.swing.JFrame {

    /**
     * Creates new form SimuBubbleSort
     */
    MainFrame bk;
    RunBubbleSort rbs;
    Timer tim;
    static long RBcounter = 0;

    public SimuBubbleSort(MainFrame T) {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        bk = T;
        ArrayInputTextField.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArrayInputTextField = new javax.swing.JTextField();
        ButtonBSProcced = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        ButtonBSProcced.setText("Procced");
        ButtonBSProcced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBSProccedActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Insert Space Separated Numbers");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ArrayInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonBSProcced))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArrayInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBSProcced, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        bk.setEnabled(true);
        bk.show();
    }//GEN-LAST:event_formWindowClosed

    private void ButtonBSProccedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBSProccedActionPerformed
        // TODO add your handling code here:
        MainFrame.bs.setEnabled(false);
        if (ArrayInputTextField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please! Insert at least one number.");
            MainFrame.bs.setEnabled(true);
            MainFrame.bs.show();
            return;
        }
        String str[] = ArrayInputTextField.getText().split(" ");
        RBcounter = System.currentTimeMillis();
        long arr[] = new long[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Long.parseLong(str[i]);
        }
        rbs = new RunBubbleSort(arr);
        Thread t = new Thread(rbs);
        t.start();
        tim = new Timer(500, new ActionListener() {
            int ii = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                long second = (System.currentTimeMillis() - RBcounter) / 1000;
                long minute = second / 60;
                second = second - (minute * 60);
                rbs.RBTimerLabel.setText(minute + " Minute(s) and "
                        + second + " Second(s)");
                if (ii > 0) {
                    rbs.grid[rbs.sortInfo.get(ii - 1).i].setBackground(Color.WHITE);
                    rbs.grid[rbs.sortInfo.get(ii - 1).j].setBackground(Color.WHITE);
                    if (rbs.sortInfo.get(ii - 1).k == 1) {
                        String fst = rbs.grid[rbs.sortInfo.get(ii - 1).i].getText();
                        String scd = rbs.grid[rbs.sortInfo.get(ii - 1).j].getText();
                        rbs.grid[rbs.sortInfo.get(ii - 1).i].setText(scd);
                        rbs.grid[rbs.sortInfo.get(ii - 1).j].setText(fst);
                    }
                }
                if (ii == rbs.sortInfo.size()) {
                    rbs.grid[rbs.sortInfo.get(ii - 1).i].setBackground(Color.WHITE);
                    rbs.grid[rbs.sortInfo.get(ii - 1).j].setBackground(Color.WHITE);
                    String fst = rbs.grid[rbs.sortInfo.get(ii - 1).i].getText();
                    String scd = rbs.grid[rbs.sortInfo.get(ii - 1).j].getText();
                    if (rbs.sortInfo.get(ii - 1).k == 1) {
                        rbs.grid[rbs.sortInfo.get(ii - 1).i].setText(fst);
                        rbs.grid[rbs.sortInfo.get(ii - 1).j].setText(scd);
                    }
                    tim.stop();
                    return;
                }
                if (rbs.sortInfo.get(ii).k == 0) {
                    rbs.grid[rbs.sortInfo.get(ii).i].setBackground(Color.green);
                    rbs.grid[rbs.sortInfo.get(ii).j].setBackground(Color.green);
                } else {
                    rbs.grid[rbs.sortInfo.get(ii).i].setBackground(Color.red);
                    rbs.grid[rbs.sortInfo.get(ii).j].setBackground(Color.red);
                }
                ii++;
            }
        });
        tim.start();
    }//GEN-LAST:event_ButtonBSProccedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ArrayInputTextField;
    private javax.swing.JButton ButtonBSProcced;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
