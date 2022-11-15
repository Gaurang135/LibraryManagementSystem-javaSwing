/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 91750
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    //to check whether student is defaulter or not
    public boolean defaulterStudent(){
        int studentId = Integer.parseInt(txt_Sid.getText());
        try {
           Connection con = DBconnection.getConnection();
           String sql = "select * from defaulter_list where student_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
           ResultSet rs = pst.executeQuery();
            
           if(rs.next()){
              return true;
           }
    }catch (Exception e){
        e.printStackTrace();
    }
        return false;
    }
    
    
    
    //to validate details
    public boolean validateDetails(){
        

        
        
        if (txt_Bid.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Book ID");
            return false;
        }
        
        if (txt_Sid.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Student ID");
            return false;
        }
        
        
        
        return true;
    }
    

    
    //To fetch Book details from database and display it when needed
    public void bookDetails() {
        int bookId = Integer.parseInt(txt_Bid.getText());
        try {
            Connection con = DBconnection.getConnection();

            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Bid.setText(rs.getString("book_id"));
                Bname.setText(rs.getString("book_name"));
                Bauth.setText(rs.getString("author"));
                Bqty.setText(rs.getString("quantiy"));

            } else {
                lbl_Berror.setText("** Invalid Book ID**");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    

    // to fetch student data 
    public void studentDetails() {
        int studentId = Integer.parseInt(txt_Sid.getText());
        try {
            Connection con = DBconnection.getConnection();

            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Sid.setText(rs.getString("student_id"));
                Sname.setText(rs.getString("student_name"));
                Scourse.setText(rs.getString("student_course"));
                Sbranch.setText(rs.getString("branch"));

            } else {
                lbl_Serror.setText("** Invalid Student ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // to insert issue book data in database
    public boolean issueBook() {
        boolean isIssued = false;
        int bookId = Integer.parseInt(txt_Bid.getText());
        int studentId = Integer.parseInt(txt_Sid.getText());
        String bookName = Bname.getText();
        String studentName = Sname.getText();

        Date uissueDate = Date_issue.getDatoFecha();
        Date udueDate = Date_due.getDatoFecha();

        Long L1 = uissueDate.getTime();
        Long L2 = udueDate.getTime();
        java.sql.Date sIssueDate = new java.sql.Date(L1);
        java.sql.Date sDueDate = new java.sql.Date(L2);

        try {
            Connection con = DBconnection.getConnection();
            String sql = "insert into issued_bookdetails(book_id,book_name,student_id,student_name,"
                    + "issue_date,due_date,status) values(?,?,?,?,?,?,?) ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setString(2,bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName );
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "pending");
            
            int RowCount = pst.executeUpdate();
            if(RowCount > 0){
                isIssued = true;
            } else{
                isIssued = false;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;
    }
    
    public void updateBookCount(){
        
        int bookId = Integer.parseInt(txt_Bid.getText());
        try {
            Connection con = DBconnection.getConnection();
            String sql= "update book_details set quantiy = quantiy - 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
               int initialcount = Integer.parseInt(Bqty.getText());
               Bqty.setText(Integer.toString(initialcount - 1));
            }else{
                JOptionPane.showMessageDialog(this,"Can't Update Book Quantity ");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    
    // to check wheter book is already issued to the student or not
    public boolean isIssued(){
        
        boolean isIssued = false;
        int bookId = Integer.parseInt(txt_Bid.getText());
        int studentId = Integer.parseInt(txt_Sid.getText());
        
        try {
            Connection con = DBconnection.getConnection();
            String sql = "select * from issued_bookdetails where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3,"pending");
            
          ResultSet rs =  pst.executeQuery();
          if(rs.next()){
              isIssued = true;
          } else{
              isIssued = false;
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Bqty = new javax.swing.JLabel();
        Bname = new javax.swing.JLabel();
        Bauth = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_Berror = new javax.swing.JLabel();
        Bid = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_Berror1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Sid = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Sname = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Scourse = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Sbranch = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_Serror = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_Bid = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Sid = new app.bolivia.swing.JCTextField();
        Date_issue = new rojeru_san.componentes.RSDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Date_due = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_main.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, -1));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 60));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 360, 5));

        Bqty.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Bqty.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Bqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 270, 40));

        Bname.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Bname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 260, 40));

        Bauth.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Bauth.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Bauth, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 280, 40));

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Book ID : -");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 120, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText("  Book Details");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 330, 100));

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book Name : -");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 150, 40));

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Author : -");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 120, 40));

        lbl_Berror.setFont(new java.awt.Font("Arial Black", 0, 21)); // NOI18N
        lbl_Berror.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lbl_Berror, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, 360, 50));

        Bid.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Bid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 270, 40));

        jLabel17.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Quantity : -");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 120, 40));

        lbl_Berror1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbl_Berror1.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lbl_Berror1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 610, 310, 50));

        jPanel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 830));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sid.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Sid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(Sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 180, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 370, 5));

        Sname.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Sname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(Sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 260, 40));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Course : -");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 120, 40));

        Scourse.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Scourse.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(Scourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 240, 40));

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Student ID : -");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 140, 40));

        jLabel18.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Student Name : -");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 170, 40));

        jLabel19.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Branch : -");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 120, 40));

        Sbranch.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Sbranch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(Sbranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 230, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel2.setText(" Student Details");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 360, -1));

        lbl_Serror.setFont(new java.awt.Font("Arial Black", 0, 21)); // NOI18N
        lbl_Serror.setForeground(new java.awt.Color(255, 255, 0));
        jPanel4.add(lbl_Serror, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, 360, 50));

        jPanel_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 480, 830));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel1.setText("    Issue Book");
        jPanel_main.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 120, 310, 100));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 220, 360, 5));

        jPanel8.setBackground(new java.awt.Color(102, 102, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel3.setText(" X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 70));

        jPanel_main.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 0, 50, 70));

        txt_Bid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_Bid.setPlaceholder("Enter Book ID....");
        txt_Bid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BidFocusLost(evt);
            }
        });
        jPanel_main.add(txt_Bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 300, 330, 40));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Enter Book ID : -");
        jPanel_main.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 300, 150, 40));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Issue Date : -");
        jPanel_main.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 450, 150, 40));

        txt_Sid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_Sid.setPlaceholder("Enter Student ID....");
        txt_Sid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_SidFocusLost(evt);
            }
        });
        jPanel_main.add(txt_Sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 370, 330, 40));

        Date_issue.setForeground(new java.awt.Color(255, 51, 51));
        Date_issue.setColorBackground(new java.awt.Color(255, 51, 51));
        Date_issue.setColorForeground(new java.awt.Color(255, 51, 51));
        Date_issue.setPlaceholder("Select Issue Date...  ");
        jPanel_main.add(Date_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 450, 330, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Enter Student ID : -");
        jPanel_main.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 370, 170, 40));

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Due Date : -");
        jPanel_main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 520, 150, 40));

        Date_due.setForeground(new java.awt.Color(255, 51, 51));
        Date_due.setColorBackground(new java.awt.Color(255, 51, 51));
        Date_due.setColorForeground(new java.awt.Color(255, 51, 51));
        Date_due.setPlaceholder("Select Due Date...  ");
        jPanel_main.add(Date_due, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 520, 330, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("Issue Book");
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
        jPanel_main.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 660, 430, 80));

        getContentPane().add(jPanel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 830));

        setSize(new java.awt.Dimension(1530, 830));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Homepage home = new Homepage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txt_BidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BidFocusLost
        if (!txt_Bid.getText().equals("")) {
            bookDetails();

        } else {
            Bid.setText("");
            Bname.setText("");
            Bauth.setText("");
            Bqty.setText("");
            lbl_Berror.setText("");
        }
    }//GEN-LAST:event_txt_BidFocusLost

    private void txt_SidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SidFocusLost
        if (!txt_Sid.getText().equals("")) {
            studentDetails();

        } else {
            Sid.setText("");
            Sname.setText("");
            Scourse.setText("");
            Sbranch.setText("");
            lbl_Serror.setText("");
        }
    }//GEN-LAST:event_txt_SidFocusLost

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked

    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
    if (Bqty.getText().equals(0)){
        JOptionPane.showMessageDialog(this, "Book Not Available");
    } else{
        
        if(validateDetails() == true){
        
        if(defaulterStudent()== false){
        if(isIssued()== false){
            
            if (issueBook() == true){
          JOptionPane.showMessageDialog(rootPane,"Book Issued Successfully");
          updateBookCount();
          
      }else{
          JOptionPane.showMessageDialog(this, "Cannot Issue Book");
      }
    } else {
        JOptionPane.showMessageDialog(this, "Book Already Issued by the Student");
    }
    }else{
            JOptionPane.showMessageDialog(this, "The Student is Defaulter");
        }
    }
    }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bauth;
    private javax.swing.JLabel Bid;
    private javax.swing.JLabel Bname;
    private javax.swing.JLabel Bqty;
    private rojeru_san.componentes.RSDateChooser Date_due;
    private rojeru_san.componentes.RSDateChooser Date_issue;
    private javax.swing.JLabel Sbranch;
    private javax.swing.JLabel Scourse;
    private javax.swing.JLabel Sid;
    private javax.swing.JLabel Sname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel_main;
    private javax.swing.JLabel lbl_Berror;
    private javax.swing.JLabel lbl_Berror1;
    private javax.swing.JLabel lbl_Serror;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private app.bolivia.swing.JCTextField txt_Bid;
    private app.bolivia.swing.JCTextField txt_Sid;
    // End of variables declaration//GEN-END:variables
}
