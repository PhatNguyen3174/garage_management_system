/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlnx_gui;

import java.awt.Image;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import qlnx_dao.*;

/**
 *
 * @author phatnguyen
 */
public class Home extends javax.swing.JFrame {
     private String user;
     OracleSeverProvider db = new OracleSeverProvider();

    /**
     * Creates new form Home
     */
    public Home(String username) {
        initComponents();
        this.setLocationRelativeTo(null);
        db.open();
        this.user = username;
        this.setTitle("Trang Chủ");
        load_home();
        load_anh(username);
        
    }

    private Home() {
        
    }
    

    private void load_home(){
        String userLG = this.user;
        String sql = "select tennv from nhanvien where tendn='"+userLG+"'";   
        ResultSet rsnx = db.excuteQuery(sql);
        try {
            if(rsnx.next()){
                String strDN = rsnx.getString("TENNV");
                txtlabel.setText(strDN);               
            }
            else{
                txtlabel.setText("Admin");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error"+e);
        }
    }
    private void closeForm() {
        dispose(); // đóng form hiện tại
    }
     private void load_anh(String id) {
        try { 
            String sql = "select anh from qlnx.nhanvien where tendn= '"+id+"'";
            ResultSet rs = db.excuteQuery(sql);
            if (rs.next()) {
                byte[] img = rs.getBytes(1);
                ImageIcon myImage = new ImageIcon(img);
                Image img1 = myImage.getImage();
                Image newImg = img1.getScaledInstance(121, 144, Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                lblAnh.setIcon(image);
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, "Error"+ e);
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        txtlabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDangXuat = new com.k33ptoo.components.KButton();
        lblAnh = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        btnKhachHang = new com.k33ptoo.components.KButton();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        btnNhanVien = new com.k33ptoo.components.KButton();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        btnXe = new com.k33ptoo.components.KButton();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jLabel7 = new javax.swing.JLabel();
        btnChuyenXe = new com.k33ptoo.components.KButton();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jLabel8 = new javax.swing.JLabel();
        btnTuyenXe = new com.k33ptoo.components.KButton();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        btnDatVe = new com.k33ptoo.components.KButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        kGradientPanel1.setForeground(new java.awt.Color(51, 51, 51));
        kGradientPanel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        kGradientPanel1.setkEndColor(new java.awt.Color(153, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 255, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("ỨNG DỤNG BÁN VÉ XE KHÁCH");

        txtlabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtlabel.setForeground(new java.awt.Color(102, 102, 102));
        txtlabel.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Wecome to");

        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangXuat.setkBorderRadius(36);
        btnDangXuat.setkEndColor(new java.awt.Color(153, 255, 255));
        btnDangXuat.setkStartColor(new java.awt.Color(0, 153, 102));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res_anh/tranthanh.jpg"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblAnh)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(114, 114, 114)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtlabel))
                    .addComponent(lblAnh))
                .addGap(40, 40, 40))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(51, 255, 204));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res_anh/user.png"))); // NOI18N

        btnKhachHang.setText("Khách Hàng");
        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKhachHang.setkBorderRadius(36);
        btnKhachHang.setkEndColor(new java.awt.Color(153, 255, 255));
        btnKhachHang.setkHoverForeGround(new java.awt.Color(153, 204, 255));
        btnKhachHang.setkHoverStartColor(new java.awt.Color(51, 255, 102));
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel3.setkEndColor(new java.awt.Color(0, 204, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(51, 255, 204));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res_anh/staff.png"))); // NOI18N

        btnNhanVien.setText("Nhân Viên");
        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhanVien.setkBorderRadius(36);
        btnNhanVien.setkEndColor(new java.awt.Color(153, 255, 255));
        btnNhanVien.setkHoverForeGround(new java.awt.Color(153, 204, 255));
        btnNhanVien.setkHoverStartColor(new java.awt.Color(51, 255, 102));
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(46, 46, 46))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        kGradientPanel4.setkEndColor(new java.awt.Color(0, 204, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(51, 255, 204));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res_anh/bus.png"))); // NOI18N

        btnXe.setText("Quản lý Xe");
        btnXe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXe.setkBorderRadius(36);
        btnXe.setkEndColor(new java.awt.Color(153, 255, 255));
        btnXe.setkHoverForeGround(new java.awt.Color(153, 204, 255));
        btnXe.setkHoverStartColor(new java.awt.Color(51, 255, 102));
        btnXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(btnXe, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXe, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel6.setkEndColor(new java.awt.Color(0, 204, 255));
        kGradientPanel6.setkStartColor(new java.awt.Color(51, 255, 204));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res_anh/icon_cxe.png"))); // NOI18N

        btnChuyenXe.setText("Thông tin Chuyến Xe");
        btnChuyenXe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChuyenXe.setkBorderRadius(36);
        btnChuyenXe.setkEndColor(new java.awt.Color(153, 255, 255));
        btnChuyenXe.setkHoverForeGround(new java.awt.Color(153, 204, 255));
        btnChuyenXe.setkHoverStartColor(new java.awt.Color(51, 255, 102));
        btnChuyenXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenXeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel6Layout.createSequentialGroup()
                        .addComponent(btnChuyenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(31, 31, 31))))
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChuyenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel7.setkEndColor(new java.awt.Color(0, 204, 255));
        kGradientPanel7.setkStartColor(new java.awt.Color(51, 255, 204));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res_anh/bus.png"))); // NOI18N

        btnTuyenXe.setText("Thông tin Tuyến Xe");
        btnTuyenXe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTuyenXe.setkBorderRadius(36);
        btnTuyenXe.setkEndColor(new java.awt.Color(153, 255, 255));
        btnTuyenXe.setkHoverForeGround(new java.awt.Color(153, 204, 255));
        btnTuyenXe.setkHoverStartColor(new java.awt.Color(51, 255, 102));
        btnTuyenXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTuyenXeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel7Layout = new javax.swing.GroupLayout(kGradientPanel7);
        kGradientPanel7.setLayout(kGradientPanel7Layout);
        kGradientPanel7Layout.setHorizontalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel7Layout.createSequentialGroup()
                        .addComponent(btnTuyenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(46, 46, 46))))
        );
        kGradientPanel7Layout.setVerticalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTuyenXe, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        kGradientPanel8.setkEndColor(new java.awt.Color(0, 204, 255));
        kGradientPanel8.setkStartColor(new java.awt.Color(51, 255, 204));

        btnDatVe.setText("Đặt Vé");
        btnDatVe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDatVe.setkBorderRadius(36);
        btnDatVe.setkEndColor(new java.awt.Color(153, 255, 255));
        btnDatVe.setkHoverForeGround(new java.awt.Color(153, 204, 255));
        btnDatVe.setkHoverStartColor(new java.awt.Color(51, 255, 102));
        btnDatVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatVeActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res_anh/ticket.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel8Layout = new javax.swing.GroupLayout(kGradientPanel8);
        kGradientPanel8.setLayout(kGradientPanel8Layout);
        kGradientPanel8Layout.setHorizontalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel8Layout.createSequentialGroup()
                        .addComponent(btnDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        kGradientPanel8Layout.setVerticalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kGradientPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhap home = new DangNhap();
        home.setVisible(true);
        closeForm();       
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
        KhachHang kh = new KhachHang(this.user);
        kh.setVisible(true);
        closeForm();
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        String txt = txtlabel.getText();
        if(!txt.equals("Admin")){
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập");           
        }
        else{
            NhanVien nv = new NhanVien(this.user);
            nv.setVisible(true);
            closeForm();
            
        }


        
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnDatVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatVeActionPerformed
         try {
             // TODO add your handling code here:
             VeXe vx = new VeXe(this.user);
             vx.setVisible(true);
         } catch (ParseException e) {
             JOptionPane.showMessageDialog(this, "Error"+e);
         }
       
        
    }//GEN-LAST:event_btnDatVeActionPerformed

    private void btnChuyenXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenXeActionPerformed
        // TODO add your handling code here:
        ChuyenXe cx = new ChuyenXe(this.user);
        cx.setVisible(true);
        closeForm();
    }//GEN-LAST:event_btnChuyenXeActionPerformed

    private void btnTuyenXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTuyenXeActionPerformed
        // TODO add your handling code here:
        TuyenXe tx = new TuyenXe(this.user);
        tx.setVisible(true);
        closeForm();
    }//GEN-LAST:event_btnTuyenXeActionPerformed

    private void btnXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXeActionPerformed
        // TODO add your handling code here:
        Xe xe = new Xe(this.user);
        xe.setVisible(true);
        closeForm();
    }//GEN-LAST:event_btnXeActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnChuyenXe;
    private com.k33ptoo.components.KButton btnDangXuat;
    private com.k33ptoo.components.KButton btnDatVe;
    private com.k33ptoo.components.KButton btnKhachHang;
    private com.k33ptoo.components.KButton btnNhanVien;
    private com.k33ptoo.components.KButton btnTuyenXe;
    private com.k33ptoo.components.KButton btnXe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel txtlabel;
    // End of variables declaration//GEN-END:variables
}
