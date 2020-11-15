package com.clarktribe.qtn;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author  Geoff Clark
 * @e-mail  gclark82@gmail.com
 * 
 */

public class StatCalcGUI extends javax.swing.JFrame {

    public StatCalcGUI() {
        initComponents();
    }
    
    private boolean checkErrors(String values) {
        if(values.contains(",,")) { values = values.replaceAll(",,", ","); }
        if(values.startsWith(",")) { values = values.substring(1); }
        if(values.endsWith(",")) { values = values.substring(0,values.length() 
                -1); }
        if(values.equals("")) { 
                errorMessage(1);
                return true;
        }
        else {
            if(values.startsWith(",") || values.endsWith(",") || 
                    values.contains(",,")) {
                errorMessage(2);
                return true;
        }
        }
        return false;
    }
    
    private void errorMessage(int message) {
        answerText.setText("");
        String message1 = "<html><font color='red'><b>ERROR: </b>&nbsp; Please "
                + "input numbers in to the Data field.</font></html>";
        String message2 = "<html><font color='red'><b>ERROR: </b>&nbsp; Please "
                + "check the Data field for extra commas.</font></html>";
        String message3 = "<html><font color='red'><b>ERROR: </b>&nbsp; Unspeci"
                + "fied error has occured.</font></html>";
        if(message == 1){
            answerBox.setText(message1); 
        } else {
            if(message == 2){
                answerBox.setText(message2);
            } else {
                answerBox.setText(message3);
            }
        }
    }
    
    private String getValues() {
        String valueString = inputBox.getText().replaceAll("\\s","");
        return valueString;
    }
    
    private String findMean(String values) {
        String[] strValues = values.split(",");
        final int lengthArray = strValues.length;
        int[] integerArray = new int[lengthArray];
        double total = 0;
        for (int i = 0; i < lengthArray; i++) {
            integerArray[i] = Integer.parseInt(strValues[i]);
            total = total + integerArray[i];
        }
        double mean = total / integerArray.length;
        String meanValue = String.format("%.1f",mean);
        return meanValue.toString();
    }
    
    private void setMean(String values) {
        String mean = findMean(values);
        setAnswer("<html><b>Mean: &nbsp;</b>" + mean + "</html>");
    }
    
    private String findMedian(String values) {
        String[] strValues = values.split(",");
        final int lengthArray = strValues.length;
        int[] integerArray = new int[lengthArray];
        for (int i = 0; i < lengthArray; i++) {
            integerArray[i] = Integer.parseInt(strValues[i]);
        }
        double median = 0;
        Arrays.sort(integerArray);
        if(lengthArray % 2 == 0) {
            int medianA = (lengthArray -1) / 2;
            int medianB = (lengthArray / 2);
            median = ((double)(integerArray[medianA] + integerArray[medianB])) 
                    / 2;
            } else {
            int medianIndex = (lengthArray - 1) / 2;
            median = integerArray[medianIndex];
        }
        String medianValue = String.valueOf(median);
        return medianValue;
    }
    
    private void setMedian(String values) {
        String median = findMedian(values);
        setAnswer("<html><b>Median: &nbsp;</b>" + median + "</html>");
    }
    
    private String findMode(String values) {
        String[] strValues = values.split(",");
        final int lengthArray = strValues.length;
        int[] integerArray = new int[lengthArray];
        double mode = 0;
        double maxCount = 0;
        for (int i = 0; i < lengthArray; i++) {
            integerArray[i] = Integer.parseInt(strValues[i]);
            int value = integerArray[i];
            int count = 1;
            for (int j = 0; j < lengthArray; j++) {
                if (integerArray[j] == value) count++;
                if (count > maxCount) {
                    mode = value;
                    maxCount = count;
                }
            }
        }
        String modeValue = String.valueOf(mode);
        return modeValue;
    }
    
    private void setMode(String values) {
        String mode = findMode(values);
        setAnswer("<html><b>Mode: &nbsp;</b>" + mode + "</html>");
    }
    
    private void set3M (String values) {
        String mean = findMean(values);
        String median = findMedian(values);
        String mode = findMode(values);
        setAnswer("<html><b>Mean: &nbsp;</b>" + mean + "<br/>" + "<b>Median: &n"
                + "bsp;</b>" + median + "<br/>" + "<b>Mode: &nbsp;</b>" + mode 
                + "</html>");
    }
    
    private void aboutMessage() throws InterruptedException {
        setBox("About This App:");
        String aboutText = "<html>This application was created by Geoff Clark <"
                + "br><br>Original concept from CSU.CSCI325 class was expanded "
                + "upon.<br><br>Contact info: &nbsp;Contact info: gclark82@gmai"
                + "l.com</html>";
        answerBox.setText(aboutText);
    }
    
    private void setAnswer(String answer) {
        setBox("Answer:");
        answerBox.setText(answer);
    }
    
    private void setBox(String text) {
        answerText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        answerText.setText(text);
    }
    
    private void clearAnswer() {
        inputBox.setText("");
        answerText.setText("");
        answerBox.setText("");
    }
    
    private void exitProcess() {
        System.exit(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statTitle = new javax.swing.JLabel();
        instText = new javax.swing.JLabel();
        dataText = new javax.swing.JLabel();
        calcMeanButton = new javax.swing.JButton();
        calcMedianButton = new javax.swing.JButton();
        calcModeButton = new javax.swing.JButton();
        calc3MButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        inputBox = new javax.swing.JTextField();
        answerBox = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        answerText = new javax.swing.JLabel();
        aboutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Statistics Calculator");

        statTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        statTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statTitle.setText("Statistics Calculator");

        instText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instText.setText("<html>Enter your data separated by a comma, then select function to perform.");

        dataText.setText("Data:");

        calcMeanButton.setText("Calculate Mean");
        calcMeanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcMeanButtonActionPerformed(evt);
            }
        });

        calcMedianButton.setText("Calculate Median");
        calcMedianButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcMedianButtonActionPerformed(evt);
            }
        });

        calcModeButton.setText("Calculate Mode");
        calcModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcModeButtonActionPerformed(evt);
            }
        });

        calc3MButton.setText("Calculate Mean, Median, and Mode");
        calc3MButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calc3MButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        inputBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputBoxKeyTyped(evt);
            }
        });

        answerBox.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        answerText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(instText)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dataText)
                        .addGap(142, 142, 142)
                        .addComponent(calc3MButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(inputBox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calcMeanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calcMedianButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(answerText, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 275, Short.MAX_VALUE))
                                    .addComponent(answerBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(calcModeButton)
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(closeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(aboutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(statTitle)
                .addGap(4, 4, 4)
                .addComponent(instText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataText)
                    .addComponent(calcMeanButton)
                    .addComponent(calcMedianButton)
                    .addComponent(calcModeButton)
                    .addComponent(inputBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calc3MButton)
                        .addGap(9, 9, 9)
                        .addComponent(aboutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(answerText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(answerBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcMeanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcMeanButtonActionPerformed
        String values = getValues();
        if(checkErrors(values) == false) {
            setMean(values);
        }
    }//GEN-LAST:event_calcMeanButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
       exitProcess();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void inputBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputBoxKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == 
                KeyEvent.VK_COMMA || c == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_inputBoxKeyTyped

    private void calcMedianButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcMedianButtonActionPerformed
        String values = getValues();
        if(checkErrors(values) == false) {
            setMedian(values);
        }
    }//GEN-LAST:event_calcMedianButtonActionPerformed

    private void calcModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcModeButtonActionPerformed
        String values = getValues();
        if(checkErrors(values) == false) {
            setMode(values);
        }
    }//GEN-LAST:event_calcModeButtonActionPerformed

    private void calc3MButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calc3MButtonActionPerformed
        String values = getValues();
        if(checkErrors(values) == false) {
            set3M(values);
        }
    }//GEN-LAST:event_calc3MButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearAnswer();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        try {
            aboutMessage();
        } catch (InterruptedException ex) {
            Logger.getLogger(StatCalcGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aboutButtonActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing
                    .UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatCalcGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatCalcGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatCalcGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatCalcGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatCalcGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JLabel answerBox;
    private javax.swing.JLabel answerText;
    private javax.swing.JButton calc3MButton;
    private javax.swing.JButton calcMeanButton;
    private javax.swing.JButton calcMedianButton;
    private javax.swing.JButton calcModeButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel dataText;
    private javax.swing.JTextField inputBox;
    private javax.swing.JLabel instText;
    private javax.swing.JLabel statTitle;
    // End of variables declaration//GEN-END:variables
}
