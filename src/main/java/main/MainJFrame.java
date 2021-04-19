package main;

import logic.WierszTrojkataPascala;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class MainJFrame extends javax.swing.JFrame {

    private JTextArea resultTextArea;
    private JTextField numberTextField;

    public MainJFrame() {
        initComponents();
    }

    private void initComponents() {

        JToolBar jToolBar = new JToolBar();
        numberTextField = new JTextField();
        JButton calcButton = new JButton();
        JScrollPane jScrollPane = new JScrollPane();
        resultTextArea = new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jToolBar.add(numberTextField);

        numberTextField.setColumns(30);
        calcButton.setText("Calc");
        calcButton.setFocusable(true);
        calcButton.addActionListener(this::calcButtonActionPerformed);
        jToolBar.add(calcButton);

        resultTextArea.setColumns(20);
        resultTextArea.setRows(5);
        jScrollPane.setViewportView(resultTextArea);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jToolBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jToolBar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    private void calcButtonActionPerformed(ActionEvent evt) {
        resultTextArea.setText("");
        try {
            int n = Integer.parseInt(numberTextField.getText());
            if (n<0) {
                resultTextArea.setText("Nieprawidlowy numer wiersza");
            } else {
                for (int i = 0; i <= n; i++) {
                    WierszTrojkataPascala row = new WierszTrojkataPascala(i);
                    resultTextArea.append(row +"\n");
                }
            }
        } catch (NumberFormatException e) {
            resultTextArea.setText("Nieprawidlowy numer wiersza");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainJFrame().setVisible(true));
    }

}
