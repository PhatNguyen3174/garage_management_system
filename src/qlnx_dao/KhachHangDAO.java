/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
import qlnx_pojo.KhachHangPoJo;

/**
 *
 * @author phatnguyen
 */
public class KhachHangDAO {
    public static ArrayList<KhachHangPoJo> layDSKhachHang(){
        ArrayList<KhachHangPoJo> dsKH = new ArrayList<KhachHangPoJo>();
        try {
            String sql = "Select * from KHACHHANG";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                KhachHangPoJo kh = new KhachHangPoJo();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setDiaChi(rs.getString("DIACHI"));
                kh.setPhone_number(rs.getString("SDT"));
                dsKH.add(kh);             
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }    
        return dsKH;
    }
    
    public static boolean themKhachHang(KhachHangPoJo kh){
       boolean kq = false;
        try {
            String sql =  "declare" +
                    "    l_bfile BFILE;" +
                    "    l_blob BLOB;" +
                    "    l_dest_offset integer :=1;" +
                    "    l_src_offset integer :=1;" +
                    "    l_lobmaxsize constant integer := DBMS_LOB.LOBMAXSIZE;" +
                    "    begin" +
                    "    INSERT INTO KHACHHANG(TENKH,DIACHI,SDT, ANH) " +
                    "    VALUES(N'"+kh.getTenKH()+"', N'"+kh.getDiaChi()+"', ?, empty_blob())" +
                    "    return ANH into l_blob;" +
                    "    l_bfile := bfilename('QLNX_DIREC',?);" +
                    "    DBMS_LOB.fileopen(l_bfile, DBMS_LOB.file_readonly);" +
                    "    DBMS_LOB.loadblobfromfile (l_blob, l_bfile, l_lobmaxsize, l_dest_offset, l_src_offset);" +
                    "    DBMS_LOB.fileclose(l_bfile);" +
                    "    commit;" +
                    "end; ";
            OracleSeverProvider provider  = new OracleSeverProvider();
            provider.open();        
            PreparedStatement ptms = provider.getPre(sql);
            ptms.setString(1, kh.getPhone_number());   
            ptms.setString(2, kh.getAnh());
            int n = ptms.executeUpdate();
            if(n == 1){
                return true;
            }
            provider.close();
            JOptionPane.showMessageDialog(null, "Thêm Thành Công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
    public static boolean xoaKhachHang(String ma_kh){      
        boolean kq = false;
        try {
            String sql = "DELETE FROM KHACHHANG WHERE MAKH = '"+ma_kh+"' ";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();         
            int n = provider.excuteUpdate(sql);
            if(n > 0){
                return true;
            }
            provider.close();
            JOptionPane.showMessageDialog(null, "Đã xóa Khách Hàng");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
    public static boolean capnhatKhachHang(KhachHangPoJo kh ){
        boolean kq = false;
        try {
             String sql =  "declare" +
                    "    l_bfile BFILE;" +
                    "    l_blob BLOB;" +
                    "    l_dest_offset integer :=1;" +
                    "    l_src_offset integer :=1;" +
                    "    l_lobmaxsize constant integer := DBMS_LOB.LOBMAXSIZE;" +
                    "    begin" +
                    "    UPDATE KHACHHANG SET TENKH = N'"+kh.getTenKH()+"',DIACHI = N'"+kh.getDiaChi()+"',SDT =?, ANH = empty_blob() WHERE MAKH = ? " +
                    "    return ANH into l_blob;" +
                    "    l_bfile := bfilename('QLNX_DIREC',?);" +
                    "    DBMS_LOB.fileopen(l_bfile, DBMS_LOB.file_readonly);" +
                    "    DBMS_LOB.loadblobfromfile (l_blob, l_bfile, l_lobmaxsize, l_dest_offset, l_src_offset);" +
                    "    DBMS_LOB.fileclose(l_bfile);" +
                    "    commit;" +
                    "end; ";                           
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            PreparedStatement ptms = provider.getPre(sql);  
            ptms.setString(1, kh.getPhone_number());  
            ptms.setString(2, kh.getMaKH());
            ptms.setString(3, kh.getAnh());
            

            int n = ptms.executeUpdate();
            if(n > 0){
                kq =  true;
            }
            provider.close();
            JOptionPane.showMessageDialog(null, "Cập nhật Thành Công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
    public static ArrayList<KhachHangPoJo> timKiemKHtheoTen(String tenKH){
        ArrayList<KhachHangPoJo> dsKH = new ArrayList<>();
        try {
            String sql = "Select * from KHACHHANG where MAKH = '"+tenKH+"'";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();            
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                KhachHangPoJo kh = new KhachHangPoJo();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setDiaChi(rs.getString(4));
                kh.setPhone_number(rs.getString(3));
                dsKH.add(kh);                                 
            }
            provider.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return dsKH;
    }
}
