/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author 91750
 */
public class Homepage extends javax.swing.JFrame {

    /**
     * Creates new form Homepage
     */
    DefaultTableModel model;
    
    
    public Homepage() {
        initComponents();
        showPieChart();
        jPanel3.setSize(0,760);
        jLabel21.setSize(0,0);
        setStudentDetails();
        setBookDetails();
        setDataToCompartments();
    }
    
    Color mouseEnterColor = new Color(0,0,0);
    Color mouseExitColor = new Color(51,51,51);
    
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      
      
        try {
            Connection con = DBconnection.getConnection();
            String sql = "Select book_name, count(*) as issue_count from issued_bookdetails group by book_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               barDataset.setValue( rs.getString("book_name") , new Double( rs.getDouble("issue_count") ) );  
                
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
       
      
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issued Book Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
        piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        jPanelPieChart.removeAll();
        jPanelPieChart.add(barChartPanel, BorderLayout.CENTER);
        jPanelPieChart.validate();
    }
    
    
    //to set data in labels
    public void setDataToCompartments(){
        Statement st ;
        ResultSet rs;
        
        try {
            Connection con = DBconnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from issued_bookdetails where status = '"+"pending"+"'");
            rs.last();
            lbl_Issue.setText(Integer.toString(rs.getRow()));
            
            rs = st.executeQuery("select * from defaulter_list");
            rs.last();
            lbl_Defaulter.setText(Integer.toString(rs.getRow()));
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    // to fetch table data and set to table
    public void setBookDetails(){
         
       try {
           Connection con = DBconnection.getConnection();
            Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from book_details");
            
           while(rs.next()){
               String bookid = rs.getString("book_id");
               String bookname = rs.getString("book_name");
               String author = rs.getString("author");
               int qty = rs.getInt("quantiy");
               
               Object[] obj ={bookid,bookname,author,qty};
               model = (DefaultTableModel) table_BookDetails.getModel();
               model.addRow(obj);DefaultTableModel model;
               
               
           }
           rs.last();
           lbl_Books.setText(Integer.toString(rs.getRow()));
       }catch(Exception e){
                   e.printStackTrace();
                   }
         
              
    }
    
    
    // to fetch table data and set to table
    public void setStudentDetails(){
       try {
           Connection con = DBconnection.getConnection();
            Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from student_details");
            
           while(rs.next()){
               int studentid = rs.getInt("student_id");
               String studentname = rs.getString("student_name");
               String course = rs.getString("student_course");
               String branch = rs.getString("branch");
               
               Object[] obj ={studentid,studentname,course,branch};
               model = (DefaultTableModel) table_studentDetails.getModel();
               model.addRow(obj);
               
               
           }
           rs.last();
           lbl_Students.setText(Integer.toString(rs.getRow()));
       }catch(Exception e){
                   e.printStackTrace();
                   }
        
              
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
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        lbl_Defaulter = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        lbl_Students = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        lbl_Issue = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        lbl_Books = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_BookDetails = new rojeru_san.complementos.RSTableMetro();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanelPieChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 4, 50));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 10, 30, 50));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel2.setText("Welcome, Admin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 260, 50));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Library Management System");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 390, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 70));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel19.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8-menu-48.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        jPanel19.add(jLabel5);
        jLabel5.setBounds(10, 10, 50, 60);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8-left-arrow-48 (1).png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel21MousePressed(evt);
            }
        });
        jPanel19.add(jLabel21);
        jLabel21.setBounds(10, 10, 50, 60);

        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
        });
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Defaulter.setFont(new java.awt.Font("Arial Black", 1, 54)); // NOI18N
        lbl_Defaulter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_Defaulter.setText(" 7");
        lbl_Defaulter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_DefaulterMouseClicked(evt);
            }
        });
        jPanel21.add(lbl_Defaulter, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 141, 90));

        jLabel26.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel26.setText("No. Of Defaulters");
        jPanel21.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 170, 30));

        jPanel19.add(jPanel21);
        jPanel21.setBounds(1240, 70, 230, 170);

        jPanel22.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel22MouseClicked(evt);
            }
        });
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Students.setFont(new java.awt.Font("Arial Black", 1, 54)); // NOI18N
        lbl_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_Students.setText(" 7");
        lbl_Students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_StudentsMouseClicked(evt);
            }
        });
        jPanel22.add(lbl_Students, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 140, 90));

        jLabel29.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel29.setText("No. Of Students");
        jPanel22.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 170, -1));

        jPanel19.add(jPanel22);
        jPanel22.setBounds(560, 70, 230, 170);

        jPanel23.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel23MouseClicked(evt);
            }
        });
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Issue.setFont(new java.awt.Font("Arial Black", 1, 54)); // NOI18N
        lbl_Issue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_Issue.setText(" 7");
        lbl_Issue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_IssueMouseClicked(evt);
            }
        });
        jPanel23.add(lbl_Issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 143, 90));

        jLabel24.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel24.setText("Issued Books");
        jPanel23.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 30));

        jPanel19.add(jPanel23);
        jPanel23.setBounds(900, 70, 230, 170);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.setText("    Home");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 50));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel8.setText("    Home");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 50));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 290, 70));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 290, 70));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setForeground(java.awt.Color.lightGray);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel9.setForeground(java.awt.Color.lightGray);
        jLabel9.setText("     Features");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 190, 50));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 290, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel16.setForeground(java.awt.Color.lightGray);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel16.setText("    Manage Books");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 50));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 290, 60));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel11.setForeground(java.awt.Color.lightGray);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel11.setText("    Manage Students");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 50));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 290, 60));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel12.setForeground(java.awt.Color.lightGray);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel12.setText("    Issue Book");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 50));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 290, 60));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel13.setForeground(java.awt.Color.lightGray);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel13.setText("    Return Book");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 50));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 290, 60));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel14.setForeground(java.awt.Color.lightGray);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel14.setText("    View Record");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 50));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 290, 60));

        jPanel14.setBackground(new java.awt.Color(102, 102, 255));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel7.setText("     Logout");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 40));

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 290, 60));

        jPanel18.setBackground(new java.awt.Color(51, 51, 51));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel18MouseExited(evt);
            }
        });
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel17.setForeground(java.awt.Color.lightGray);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel17.setText("    Defaulter List");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        jPanel18.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 40));

        jPanel3.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 290, 60));

        jPanel24.setBackground(new java.awt.Color(51, 51, 51));
        jPanel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel24MouseExited(evt);
            }
        });
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel18.setForeground(java.awt.Color.lightGray);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel18.setText("    Issued Books");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        jPanel24.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 40));

        jPanel3.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 290, 60));

        jPanel19.add(jPanel3);
        jPanel3.setBounds(0, 0, 290, 760);

        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
        });
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Books.setFont(new java.awt.Font("Arial Black", 1, 54)); // NOI18N
        lbl_Books.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_Books.setText(" 7");
        lbl_Books.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_BooksMouseClicked(evt);
            }
        });
        jPanel20.add(lbl_Books, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel22.setText("No. Of Books");
        jPanel20.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 140, 30));

        jPanel19.add(jPanel20);
        jPanel20.setBounds(210, 70, 220, 170);

        table_BookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        table_BookDetails.setAltoHead(40);
        table_BookDetails.setColorBordeHead(new java.awt.Color(102, 102, 255));
        table_BookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_BookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_BookDetails.setFocusCycleRoot(true);
        table_BookDetails.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        table_BookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        table_BookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        table_BookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        table_BookDetails.setRowHeight(30);
        table_BookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_BookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_BookDetails);

        jPanel19.add(jScrollPane2);
        jScrollPane2.setBounds(300, 530, 580, 210);

        table_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        table_studentDetails.setAltoHead(40);
        table_studentDetails.setColorBordeHead(new java.awt.Color(102, 102, 255));
        table_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_studentDetails.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        table_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        table_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        table_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        table_studentDetails.setRowHeight(30);
        table_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_studentDetails);

        jPanel19.add(jScrollPane3);
        jScrollPane3.setBounds(300, 290, 580, 210);

        jLabel27.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel27.setText("Book Details :-");
        jPanel19.add(jLabel27);
        jLabel27.setBounds(300, 500, 170, 30);

        jLabel30.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel30.setText("Student Details :-");
        jPanel19.add(jLabel30);
        jLabel30.setBounds(300, 260, 170, 30);

        jPanelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel19.add(jPanelPieChart);
        jPanelPieChart.setBounds(980, 300, 490, 390);

        getContentPane().add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1530, 760));

        setSize(new java.awt.Dimension(1530, 830));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        Thread th = new Thread(){
            @Override
            public void run (){
                try{
                    for(int a=0;a<=6;a++){
                        Thread.sleep(50);
                          if (a==1){
                              jPanel3.setSize(50,760);
                              jLabel5.setSize(0,0);
                              jLabel21.setSize(50,60);
                          }
                          if (a==2){
                              jPanel3.setSize(100,760);
                          }
                          if (a==3){
                              jPanel3.setSize(150,760);
                          }
                          if (a==4){
                              jPanel3.setSize(200,760);
                          }
                          if (a==5){
                              jPanel3.setSize(250,760);
                          }
                          if (a==6){
                              jPanel3.setSize(290,760);
                          }
                    }
                } catch (Exception ex){
                    System.out.println(ex);
                }
            }
            
            
            
            
            
        }; th.start();
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MousePressed
        Thread th = new Thread(){
            @Override
            public void run (){
                try{
                    for(int a=0;a<=6;a++){
                        Thread.sleep(50);
                          if (a==1){
                              jPanel3.setSize(250,760);
                              jLabel5.setSize(50,60);
                              jLabel21.setSize(0,0);
                          }
                          if (a==2){
                              jPanel3.setSize(200,760);
                          }
                          if (a==3){
                              jPanel3.setSize(150,760);
                          }
                          if (a==4){
                              jPanel3.setSize(100,760);
                          }
                          if (a==5){
                              jPanel3.setSize(50,760);
                          }
                          if (a==6){
                              jPanel3.setSize(0,760);
                          }
                    }
                } catch (Exception ex){
                    System.out.println(ex);
                }
            }
        }; th.start();
    }//GEN-LAST:event_jLabel21MousePressed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        Manage_Books book = new Manage_Books();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
       jPanel8.setBackground(mouseEnterColor);  
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        jPanel8.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
     jPanel8.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
         jPanel8.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel8MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
         jPanel4.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
         jPanel4.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel11MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
         jPanel4.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
         jPanel4.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel4MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
         jPanel9.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
         jPanel9.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        jPanel9.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
       jPanel9.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel9MouseExited

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        jPanel10.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jPanel10.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        jPanel10.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
       jPanel10.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
         Manage_Books book = new Manage_Books();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jPanel11.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        jPanel11.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        jPanel11.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel11MouseExited

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        jPanel11.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
        jPanel18.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jPanel18.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jPanel18.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel17MouseExited

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        jPanel18.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel18MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        manageStudents student = new manageStudents();
        student.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
         manageStudents student = new manageStudents();
        student.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        IssueBook issue = new IssueBook();
        issue.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        IssueBook issue = new IssueBook();
        issue.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        ReturnBook Return = new ReturnBook();
        Return.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        ReturnBook Return = new ReturnBook();
        Return.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        viewRecord view = new viewRecord();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        viewRecord view = new viewRecord();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        DefaulterList defaulter = new DefaulterList();
        defaulter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
      DefaulterList defaulter = new DefaulterList();
        defaulter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        int result = JOptionPane.showConfirmDialog(this, "Confirm Logout", "Logout", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
            Loginpage login = new Loginpage();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        int result = JOptionPane.showConfirmDialog(this, "Confirm Logout", "Logout", JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
            Loginpage login = new Loginpage();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        issuedBooks i =new issuedBooks();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jPanel24.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        jPanel24.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel18MouseExited

    private void jPanel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseClicked
        issuedBooks i =new issuedBooks();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel24MouseClicked

    private void jPanel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseEntered
        jPanel24.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel24MouseEntered

    private void jPanel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseExited
        jPanel24.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel24MouseExited

    private void lbl_BooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_BooksMouseClicked
        Manage_Books book = new Manage_Books();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_BooksMouseClicked

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        Manage_Books book = new Manage_Books();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPanel20MouseClicked

    private void lbl_StudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_StudentsMouseClicked
        manageStudents student = new manageStudents();
        student.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_StudentsMouseClicked

    private void lbl_IssueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_IssueMouseClicked
       viewRecord view = new viewRecord();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_IssueMouseClicked

    private void jPanel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseClicked
        viewRecord view = new viewRecord();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel23MouseClicked

    private void lbl_DefaulterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DefaulterMouseClicked
        DefaulterList defaulter = new DefaulterList();
        defaulter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_DefaulterMouseClicked

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        DefaulterList defaulter = new DefaulterList();
        defaulter.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel21MouseClicked

    private void table_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_studentDetailsMouseClicked
        manageStudents student = new manageStudents();
        student.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_table_studentDetailsMouseClicked

    private void table_BookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_BookDetailsMouseClicked
        Manage_Books book = new Manage_Books();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_table_BookDetailsMouseClicked

    private void jPanel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseClicked
        manageStudents student = new manageStudents();
        student.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jPanel22MouseClicked

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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelPieChart;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_Books;
    private javax.swing.JLabel lbl_Defaulter;
    private javax.swing.JLabel lbl_Issue;
    private javax.swing.JLabel lbl_Students;
    private rojeru_san.complementos.RSTableMetro table_BookDetails;
    private rojeru_san.complementos.RSTableMetro table_studentDetails;
    // End of variables declaration//GEN-END:variables
}
