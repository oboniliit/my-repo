
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class RunBubbleSort extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form RunBubbleSort
     */
    public JPanel panel;
    private JPanel RBTimerJPanel;
    public static JLabel RBTimerLabel;
    public static JLabel grid[];
    public static int elmn;
    public static ArrayList<Triplet> sortInfo;

    public RunBubbleSort(long tarr[]) {
        //initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        panel = new JPanel();
        RBTimerJPanel = new JPanel();
        RBTimerLabel = new JLabel("Timer: ",JLabel.CENTER);
        this.add(panel);
        elmn = tarr.length;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 500, 100);
        RBTimerJPanel.setLayout(new BorderLayout());
        RBTimerJPanel.add(RBTimerLabel);
        this.add(RBTimerJPanel,BorderLayout.NORTH);
        
        panel.setLayout(new GridLayout(1, elmn + 1));
        panel.setPreferredSize(new Dimension(80, 150));
        grid = new JLabel[elmn + 1];
        for (int j = 0; j < elmn; j++) {
            grid[j] = new JLabel();
            grid[j].setBorder(new LineBorder(Color.BLACK));
            //grid[i][j].setBackground(Color.black);
            grid[j].setText(Long.toString(tarr[j]));
            grid[j].setOpaque(true);
            panel.add(grid[j]);
        }
        sortInfo = new ArrayList<Triplet>();
        for (int i = 0; i < elmn - 1; ++i) {
            for (int j = 0; j < elmn - i - 1; ++j) {
                if (tarr[j] > tarr[j + 1]) {
                    long swap = tarr[j];
                    tarr[j] = tarr[j + 1];
                    tarr[j + 1] = swap;
                    sortInfo.add(new Triplet(j, j + 1, 1));
                } else {
                    sortInfo.add(new Triplet(j, j + 1, 0));
                }
            }
        }
       // System.out.println(sortInfo.get(sortInfo.size() - 1).i + "-->" + sortInfo.get(sortInfo.size() - 1).j + "---->" + sortInfo.get(sortInfo.size() - 1).k);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        MainFrame.bs.setEnabled(true);
        MainFrame.bs.show();
    }//GEN-LAST:event_formWindowClosed

    @Override
    public void run() {
        this.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
