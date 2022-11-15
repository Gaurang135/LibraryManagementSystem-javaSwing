/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * 
 * 
 * @author 91750
 * 
 * 
 */


public class DefaulterList extends javax.swing.JFrame {

    /**
     * Creates new form Manage_Books
     */
    String studentname, course, branch;
    int studentid;
    DefaultTableModel model;
    
    
    public DefaulterList() {
        initComponents();
        setStudentDetails();
    }
    
    // to fetch table data and set to table
    public void setStudentDetails(){
       try {
           Connection con = DBconnection.getConnection();
            Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from defaulter_list");
            
           while(rs.next()){
               int studentid = rs.getInt("student_id");
               String studentname = rs.getString("student_name");
               String course = rs.getString("course");
               String branch = rs.getString("branch");
               
               Object[] obj ={studentid,studentname,course,branch};
               model = (DefaultTableModel) table_studentDetails.getModel();
               model.addRow(obj);
               
               
           }
       }catch(Exception e){
                   e.printStackTrace();
                   }
        
              
    }
    
    
    //To add Student details
    public boolean addStudent(){
        boolean isAdded = false;
        studentid = Integer.parseInt(txt_Sid.getText());
        studentname = txt_Sname.getText();
        course = Combo_Course.getSelectedItem().toString();
        branch =Combo_Branch.getSelectedItem().toString();
        if (Combo_Course.getSelectedItem() != "Courses" && Combo_Branch.getSelectedItem()!= "Branches"){
        try {
            Connection con = DBconnection.getConnection();
            String sql = "insert into defaulter_list values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentid);
            pst.setString(2, studentname);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowcount = pst.executeUpdate();
            if (rowcount>0){
                isAdded = true;
            } else{
                isAdded = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        }
        return isAdded;
    } 
    
    //to update student details
    public boolean updateStudent(){
          boolean isUpdated = false;
        studentid = Integer.parseInt(txt_Sid.getText());
        studentname = txt_Sname.getText();
        course = Combo_Course.getSelectedItem().toString();
        branch =Combo_Branch.getSelectedItem().toString();
        
    
        
    try {
          Connection con = DBconnection.getConnection();
          String sql = "update defaulter_list set student_name = ?,course = ?,branch = ? where student_id = ?";
          PreparedStatement pst =con.prepareCall(sql);
            
            
            pst.setString(1, studentname);
            pst.setString(2, course);
            pst.setString(3, branch);
            pst.setInt(4, studentid);
            
            int rowcount = pst.executeUpdate();
            if(rowcount>0){
                isUpdated = true;
            }else{
                isUpdated= false;
            }
    
        }catch (Exception e){
            e.printStackTrace();
        }
    
    return isUpdated;
    }
    
   // To delete student details
    public boolean deleteStudent(){
          boolean isDeleted = false;
        studentid = Integer.parseInt(txt_Sid.getText());
        studentname = txt_Sname.getText();
        course = Combo_Course.getSelectedItem().toString();
        branch =Combo_Branch.getSelectedItem().toString();
       
        try{
            Connection con = DBconnection.getConnection();
            String sql = "delete from defaulter_list  where student_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, studentid);
            
            int rowcount = pst.executeUpdate();
            if (rowcount>0){
                isDeleted = true;
            } else{
                isDeleted = false;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return isDeleted;
    }

    // to clear table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) table_studentDetails.getModel();
        model.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_Sid = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Sname = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        Combo_Branch = new javax.swing.JComboBox<>();
        Combo_Course = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 120, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter Student ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 180, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 60, 60));

        txt_Sid.setBackground(new java.awt.Color(102, 102, 255));
        txt_Sid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_Sid.setPlaceholder("Enter Student ID");
        txt_Sid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_SidFocusLost(evt);
            }
        });
        jPanel1.add(txt_Sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 320, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 60, 60));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Student Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 240, 40));

        txt_Sname.setBackground(new java.awt.Color(102, 102, 255));
        txt_Sname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_Sname.setPlaceholder("Enter Student Name");
        txt_Sname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_SnameFocusLost(evt);
            }
        });
        txt_Sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SnameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 320, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 60, 60));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Select Course");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 230, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 60, 60));

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Select Student Branch");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 260, 40));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Delete");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 660, 150, 80));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("ADD");
        rSMaterialButtonCircle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 150, 80));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle4.setText("Update");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 660, 150, 80));

        Combo_Branch.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Branch.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        Combo_Branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Branches", "Plain", "INurture", "I.T.", "C.S.", "Mechanical", "Civill", "Electrical" }));
        Combo_Branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_BranchActionPerformed(evt);
            }
        });
        jPanel1.add(Combo_Branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, 320, 30));

        Combo_Course.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Course.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        Combo_Course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Courses", "B.C.A.", "B.Tech", "B.Arch", "M.C.A.", "M.Tech" }));
        Combo_Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_CourseActionPerformed(evt);
            }
        });
        jPanel1.add(Combo_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 462, 320, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel3.setText(" X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 60));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 50, 60));

        table_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        table_studentDetails.setAltoHead(40);
        table_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        table_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_studentDetails.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        table_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        table_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        table_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        table_studentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table_studentDetails.setRowHeight(30);
        table_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_studentDetails);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 850, 330));

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel1.setText(" Defaulter Students");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 420, 110));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 430, 10));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 1010, 830));

        setSize(new java.awt.Dimension(1530, 830));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SidFocusLost
      /*  if (checkDuplicateuser()== true){
            JOptionPane.showMessageDialog(rootPane, "Username Already Exists");
        }*/
    }//GEN-LAST:event_txt_SidFocusLost

    private void txt_SnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SnameFocusLost

    private void txt_SnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SnameActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
      
        if (deleteStudent()== true){
            JOptionPane.showMessageDialog(rootPane, "Student Details Deleted Successfully");
          clearTable();
          setStudentDetails();
       }else {
           JOptionPane.showMessageDialog(rootPane, "Student Deletion Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
     if (Combo_Course.getSelectedItem() != "Courses" && Combo_Branch.getSelectedItem()!= "Branches"){
        if ( addStudent() == true){
         
          JOptionPane.showMessageDialog(rootPane, "Student Added Successfully");
          clearTable();
          setStudentDetails();
          
      } else{
          JOptionPane.showMessageDialog(rootPane, "Student Addition Failed");
      }
     } else{
            JOptionPane.showMessageDialog(rootPane, "Please Select Valid Branch/Course");
        }
     
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
      if (Combo_Course.getSelectedItem() != "Courses" && Combo_Branch.getSelectedItem()!= "Branches"){
        if (updateStudent() == true){
            JOptionPane.showMessageDialog(rootPane, "Student Details updated succesfully");
            clearTable();
          setStudentDetails();
        } else{
            JOptionPane.showMessageDialog(rootPane, "Student Details Updation Failed");
        }
      } else{
            JOptionPane.showMessageDialog(rootPane, "Please Select Valid Branch/Course");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
      Homepage home = new Homepage();
      home.setVisible(true);
      dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void table_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_studentDetailsMouseClicked
        
        int rowNo = table_studentDetails.getSelectedRow();
        TableModel model = table_studentDetails.getModel();
        
        txt_Sid.setText(model.getValueAt(rowNo, 0).toString());
        txt_Sname.setText(model.getValueAt(rowNo, 1).toString());
        Combo_Course.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        Combo_Branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
        
        
    }//GEN-LAST:event_table_studentDetailsMouseClicked

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked
        
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

    private void Combo_BranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_BranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_BranchActionPerformed

    private void Combo_CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_CourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_CourseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DefaulterList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_Branch;
    private javax.swing.JComboBox<String> Combo_Course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojeru_san.complementos.RSTableMetro table_studentDetails;
    private app.bolivia.swing.JCTextField txt_Sid;
    private app.bolivia.swing.JCTextField txt_Sname;
    // End of variables declaration//GEN-END:variables
}
