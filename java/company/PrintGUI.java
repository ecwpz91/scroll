
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * PrintGUI.java
 * Created on May 4, 2013, 11:48:31 PM
 * @author msurbey
 */
public class PrintGUI extends javax.swing.JFrame {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    private PrintStream out;
    private String filename;
    private String[] employee, dependent;
    private Object[] worksOn;
    private String[] employeeVars = {"FNAME","MINIT","LNAME","SSN","BDATE",
        "ADDRESS","SEX","SALARY","SUPERSSN","DNO","EMAIL"};
    private String[] dependentVars = {"ESSN","DEPENDENT_NAME","SEX","BDATE",
        "RELATION"};
    private String[] worksOnVars = {"ESSN","PNO","HOURS"};
    private String[] projects;
    private String[] projHours;


    /** Creates new form PrintGUI */
    public PrintGUI() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Department Manager 1.0");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("     Would you like to store a printable document in your current");

        jLabel2.setText("               directory containing the newly created employee?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        jSeparator1.setBackground(new java.awt.Color(59, 89, 152));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("DejaVu Sans", 1, 14));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        getContentPane().add(jPanel5, gridBagConstraints);

        jButton1.setText("Yes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 125, 0, 0);
        getContentPane().add(jButton1, gridBagConstraints);

        jButton2.setText("No");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 125);
        getContentPane().add(jButton2, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-435)/2, (screenSize.height-155)/2, 435, 155);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    employee = EmployeeGUI.getEmployee();
    dependent = EmployeeDependentGUI.getDependent();
    worksOn = EmployeeWorksOnGUI.getWorksOn();
    projects = (String[]) worksOn[1];
    projHours = (String[]) worksOn[2];
    
    filename = employee[2] + employee[0] + "Employee.txt";
    
    try {
        out = new PrintStream(new FileOutputStream(filename));
        System.setOut(out);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(PrintGUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    for (int i=0; i<13; i++) {
        out.append("*");
        if (i==12) {
            out.append("\n**EMPLOYEE***\n");
            for (int j=0;j<13;j++)
                out.append("*");
        }
    }
    out.append("\n");
    
    for (int i=0;i<employee.length;i++)
        out.append(employeeVars[i] + ": " + employee[i] + "\n");
    
    out.append("\n");
    for (int i=0; i<13; i++) {
        out.append("*");
        if (i==12) {
            out.append("\n**DEPENDENT**\n");
            for (int j=0;j<13;j++)
                out.append("*");
        }
    }
    out.append("\n");
    
    for (int i=0;i<dependent.length;i++)
        out.append(dependentVars[i] + ": " + dependent[i] + "\n");
    
    out.append("\n");
    for (int i=0; i<13; i++) {
        out.append("*");
        if (i==12) {
            out.append("\n**WORKS_ON***\n");
            for (int j=0;j<13;j++)
                out.append("*");
        }
    }
    out.append("\n");
    out.append(worksOnVars[0] + ": " + worksOn[0] + "\n");
    
    for (int i=0;i<projects.length;i++) {
        out.append(worksOnVars[1] + ": " + projects[i] + "\n" +
                worksOnVars[2] + ": " + projHours[i] + "\n");
    }
    
    setVisible(false);
    new PrintFileGUI(filename).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    	setVisible(false);
    	new GoodDayGUI().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
}