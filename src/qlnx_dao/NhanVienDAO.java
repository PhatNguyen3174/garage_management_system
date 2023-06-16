/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_dao;

import java.util.ArrayList;
import qlnx_pojo.NhanVienPoJo;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author phatnguyen
 */
public class NhanVienDAO {
    public static ArrayList<NhanVienPoJo> layDSNhanVien(){
        ArrayList<NhanVienPoJo> dsNV = new ArrayList<NhanVienPoJo>();
        try {
            String sql = "Select * from NHANVIEN";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                NhanVienPoJo nv = new NhanVienPoJo();
                nv.setMaNV(rs.getString(1));
                nv.setMaCV(rs.getString(2));
                nv.setTennv(rs.getString(3));
                nv.setTenDN(rs.getString(4));
                nv.setPass(rs.getString(5));
                nv.setSdt(rs.getString(6));
                nv.setDiachi(rs.getString(7));
                dsNV.add(nv);               
            }
            provider.close();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }    
        return dsNV;
    }
    public static ArrayList<NhanVienPoJo> timKiemNVtheoTen(String tenNV){
        ArrayList<NhanVienPoJo> dsNV = new ArrayList<>();
        try {
            String sql = "Select * from NHANVIEN where MANV = '"+tenNV+"'";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                NhanVienPoJo nv = new NhanVienPoJo();
                nv.setMaNV(rs.getString(1));
                nv.setMaCV(rs.getString(2));
                nv.setTennv(rs.getString(3));
                nv.setTenDN(rs.getString(4));
                nv.setPass(rs.getString(5));
                nv.setSdt(rs.getString(6));
                nv.setDiachi(rs.getString(7));                        
                dsNV.add(nv);               
            }
            provider.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return dsNV;
    }
    public static boolean themNhanVien(NhanVienPoJo nv){
       boolean kq = false;
        try {
             String sql =  "declare" +
                    "    l_bfile BFILE;" +
                    "    l_blob BLOB;" +
                    "    l_dest_offset integer :=1;" +
                    "    l_src_offset integer :=1;" +
                    "    l_lobmaxsize constant integer := DBMS_LOB.LOBMAXSIZE;" +
                    "    begin" +
                    "    INSERT INTO NHANVIEN(TENNV,TENDN,PASSWORD,DIACHI,SDT,MACV, ANH) " +
                    "    VALUES(N'"+nv.getTennv()+"', ?, ?, N'"+nv.getDiachi()+"', ? ,? , empty_blob())" +
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
            ptms.setString(1, nv.getTenDN());
            ptms.setString(2, nv.getPass());
            ptms.setString(3, nv.getSdt());
            ptms.setString(4, nv.getMaCV());
            ptms.setString(5, nv.getAnh());
            int n = ptms.executeUpdate();
            if(n == 1){
                return true;
            }
            provider.close();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
    
    public static boolean xoaNhanVien(String manv){      
        boolean kq = false;
        try {
            String sql = "DELETE FROM NHANVIEN WHERE MANV = ?";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            PreparedStatement ptms = provider.getPre(sql);
            ptms.setString(1, manv);       
            int n = ptms.executeUpdate();
            if(n == 1){
                return true;
            }
            provider.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
    
    public static boolean capnhatNhanVien(NhanVienPoJo nv ){
        boolean kq = false;
        try {
            String sql =  "declare" +
                    "    l_bfile BFILE;" +
                    "    l_blob BLOB;" +
                    "    l_dest_offset integer :=1;" +
                    "    l_src_offset integer :=1;" +
                    "    l_lobmaxsize constant integer := DBMS_LOB.LOBMAXSIZE;" +
                    "    begin" +
                    "    UPDATE NHANVIEN SET TENNV = ?,TENDN =?,PASSWORD =?,DIACHI=?,SDT=?,MACV=?, ANH = empty_blob() WHERE MANV =? " +
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
            ptms.setString(1, nv.getTennv());
            ptms.setString(2, nv.getTenDN());
            ptms.setString(3, nv.getPass());
            ptms.setString(4, nv.getDiachi());
            ptms.setString(5, nv.getSdt());
            ptms.setString(6, nv.getMaCV());
            ptms.setString(8, nv.getAnh());
            ptms.setString(7, nv.getMaNV());
            int n = ptms.executeUpdate();
            if(n == 1){
                kq =  true;
            }
            provider.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
        
    
    
}
