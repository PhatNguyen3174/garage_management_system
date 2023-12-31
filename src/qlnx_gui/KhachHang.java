/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlnx_gui;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import qlnx_dao.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qlnx_pojo.*;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author phatnguyen
 */
public class KhachHang extends javax.swing.JFrame {
    
    OracleSeverProvider db = new OracleSeverProvider();
    String anh = "P:\\ANHDOAN_JAVA\\hoangnamtien.jpg";
    private String username;

    /**
     * Creates new form KhachHang
     */
    public KhachHang(String user) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Khách Hàng");
        this.username = user;
        db.open();
        DefaultTableModel dtmKH = (DefaultTableModel) tblKhachHang.getModel();
        String[] tieuDe = {"Mã Khách Hàng","Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại"};
        dtmKH.setColumnIdentifiers(tieuDe);
        tblKhachHang.setModel(dtmKH);
        load_kh();

    }

    private KhachHang() {
        
    }
    private void closeForm() {
        dispose(); // đóng form hiện tại
    }

    private void load_kh() {
        DefaultTableModel dtmKH = (DefaultTableModel) tblKhachHang.getModel();
        ArrayList<KhachHangPoJo> dsKH = KhachHangDAO.layDSKhachHang();
        dtmKH.setRowCount(0);
        for (KhachHangPoJo kh : dsKH) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(kh.getMaKH());
            vec.add(kh.getTenKH());
            vec.add(kh.getDiaChi());
            vec.add(kh.getPhone_number());
            dtmKH.addRow(vec);
        }
    }

    private void load_anh(String id) {
        try { 
            String sql = "select anh from qlnx.khachhang where tenkh= N'"+id+"'";
            ResultSet rs = db.excuteQuery(sql);
            if (rs.next()) {
                byte[] img = rs.getBytes(1);
                ImageIcon myImage = new ImageIcon(img);
                Image img1 = myImage.getImage();
                Image newImg = img1.getScaledInstance(273, 289, Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                lblAnh.setIcon(image);
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, "Error"+ e);
        }
    }

    public ImageIcon ResizeImage(String path) {
        ImageIcon myImage = new ImageIcon(path);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(273, 289, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
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
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        btnThem = new com.k33ptoo.components.KButton();
        btnXoa = new com.k33ptoo.components.KButton();
        btnSua = new com.k33ptoo.components.KButton();
        btnTim = new com.k33ptoo.components.KButton();
        jLabel9 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        lblAnh = new javax.swing.JLabel();
        btnChonAnh = new com.k33ptoo.components.KButton();
        btnThoat = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(153, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 255, 204));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("THÔNG TIN KHÁCH HÀNG");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("KHÁCH HÀNG");

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("Mã Khách Hàng");

        txtMaKH.setBackground(new java.awt.Color(255, 255, 255));
        txtMaKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 51, 204)));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("Địa Chỉ");

        txtDiaChi.setBackground(new java.awt.Color(255, 255, 255));
        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 51, 204)));

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 204));
        jLabel7.setText("Số điện thoại");

        txtSoDienThoai.setBackground(new java.awt.Color(255, 255, 255));
        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSoDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 51, 204)));

        btnThem.setText("THÊM");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnThem.setkBorderRadius(36);
        btnThem.setkEndColor(new java.awt.Color(0, 102, 102));
        btnThem.setkStartColor(new java.awt.Color(0, 255, 204));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("XÓA");
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnXoa.setkBorderRadius(36);
        btnXoa.setkEndColor(new java.awt.Color(0, 102, 102));
        btnXoa.setkStartColor(new java.awt.Color(0, 255, 204));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("SỬA");
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSua.setkBorderRadius(36);
        btnSua.setkEndColor(new java.awt.Color(0, 204, 204));
        btnSua.setkStartColor(new java.awt.Color(0, 255, 204));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTim.setText("TÌM");
        btnTim.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnTim.setkBorderRadius(36);
        btnTim.setkEndColor(new java.awt.Color(0, 204, 204));
        btnTim.setkStartColor(new java.awt.Color(0, 255, 204));
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 204));
        jLabel9.setText("Tên Khách Hàng");

        txtTenKH.setBackground(new java.awt.Color(255, 255, 255));
        txtTenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 51, 204)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jLabel6))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(68, 68, 68)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(151, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res_anh/hoangnamtien.jpg"))); // NOI18N

        btnChonAnh.setText("CHỌN ẢNH");
        btnChonAnh.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnChonAnh.setkBorderRadius(36);
        btnChonAnh.setkEndColor(new java.awt.Color(0, 204, 204));
        btnChonAnh.setkStartColor(new java.awt.Color(0, 255, 204));
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        btnThoat.setText("THOÁT");
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThoat.setkBorderRadius(30);
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lblAnh))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(lblAnh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {
            String tenKH = txtTenKH.getText();
            String diaChi = txtDiaChi.getText();
            String phone = txtSoDienThoai.getText();
            String anhkh = anh.substring(anh.lastIndexOf('\\') + 1);
            KhachHangPoJo kh = new KhachHangPoJo();
            kh.setTenKH(tenKH);
            kh.setDiaChi(diaChi);
            kh.setPhone_number(phone);
            kh.setAnh(anhkh);
            KhachHangDAO.themKhachHang(kh);
            load_kh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error"+ e);
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String tenKH = txtMaKH.getText();
        KhachHangDAO.xoaKhachHang(tenKH);
        load_kh();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String maKH = txtMaKH.getText();
        String tenKH = txtTenKH.getText();
        String diaChi = txtDiaChi.getText();
        String phone = txtSoDienThoai.getText();
        String anhkh = anh.substring(anh.lastIndexOf('\\') + 1);
        KhachHangPoJo kh = new KhachHangPoJo();
        kh.setMaKH(maKH);
        kh.setTenKH(tenKH);
        kh.setDiaChi(diaChi);
        kh.setPhone_number(phone);
        kh.setAnh(anhkh);
        KhachHangDAO.capnhatKhachHang(kh);
        load_kh();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtmKH = (DefaultTableModel) tblKhachHang.getModel();
        String maKH = txtMaKH.getText();
        ArrayList<KhachHangPoJo> dsKH = KhachHangDAO.timKiemKHtheoTen(maKH);
        dtmKH.setRowCount(0);
        for (KhachHangPoJo kh : dsKH) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(kh.getMaKH());
            vec.add(kh.getTenKH());
            vec.add(kh.getDiaChi());
            vec.add(kh.getPhone_number());
            dtmKH.addRow(vec);
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser f = new JFileChooser("P:\\ANHDOAN_JAVA");
            f.setDialogTitle("Mở ảnh");
            f.showOpenDialog(null);
            File fanh = f.getSelectedFile();
            anh = fanh.getAbsolutePath();
            lblAnh.setIcon(ResizeImage(String.valueOf(anh)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn ảnh");
        }


    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        int row =tblKhachHang.getSelectedRow();
        txtMaKH.setText(String.valueOf(tblKhachHang.getValueAt(row, 0)));
        txtTenKH.setText(String.valueOf(tblKhachHang.getValueAt(row, 1)));
        txtDiaChi.setText(String.valueOf(tblKhachHang.getValueAt(row, 2)));
        txtSoDienThoai.setText(String.valueOf(tblKhachHang.getValueAt(row, 3)));
        
        
        load_anh(txtTenKH.getText());
                   

    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        Home home = new Home(this.username);
        home.setVisible(true);
        closeForm();
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnChonAnh;
    private com.k33ptoo.components.KButton btnSua;
    private com.k33ptoo.components.KButton btnThem;
    private com.k33ptoo.components.KButton btnThoat;
    private com.k33ptoo.components.KButton btnTim;
    private com.k33ptoo.components.KButton btnXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
