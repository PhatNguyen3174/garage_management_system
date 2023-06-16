/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_dao;

import java.util.ArrayList;
import qlnx_pojo.*;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author phatnguyen
 */
public class XeDAO {
    public static ArrayList<XePoJo> layDanhSachXe(){
        ArrayList<XePoJo> dsXe = new ArrayList<XePoJo>();
        try {
            String sql = "Select XE.MAXE, NHANVIEN.TENNV ,XE.BIENSO,XE.TENXE from XE JOIN NHANVIEN ON XE.MANV = NHANVIEN.MANV";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                XePoJo xe = new XePoJo();
                xe.setMaXe(rs.getString(1));
                xe.setMaNV(rs.getString(2));
                xe.setBienSo(rs.getString(3));
                xe.setTenXe(rs.getString(4));
                dsXe.add(xe);
            }
            provider.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return dsXe;
    }
    public static boolean themXe(XePoJo xe){
        boolean kq = true;
        try {
            String sql =  "declare" +
                    "    l_bfile BFILE;" +
                    "    l_blob BLOB;" +
                    "    l_dest_offset integer :=1;" +
                    "    l_src_offset integer :=1;" +
                    "    l_lobmaxsize constant integer := DBMS_LOB.LOBMAXSIZE;" +
                    "    begin" +
                    "    INSERT INTO XE(MANV,TENXE,BIENSO, ANH) " +
                    "    VALUES((SELECT MANV FROM NHANVIEN WHERE TENNV = N'"+xe.getMaNV()+"' AND MACV = 'TX'), ?, ?, empty_blob())" +
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
            ptms.setString(1, xe.getTenXe());
            ptms.setString(2, xe.getBienSo());
            ptms.setString(3, xe.getAnh());
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
    
    public static boolean xoaXe(String maXe){
        boolean kq = false;
        try {
            String sql = "DELETE FROM XE WHERE MAXE = '"+maXe+"'";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            int n = provider.excuteUpdate(sql);
            if(n == 1){
                kq = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
    
    public static boolean suaXe(XePoJo xe){
        boolean kq = false;
        try {
            String sql =  "declare" +
                    "    l_bfile BFILE;" +
                    "    l_blob BLOB;" +
                    "    l_dest_offset integer :=1;" +
                    "    l_src_offset integer :=1;" +
                    "    l_lobmaxsize constant integer := DBMS_LOB.LOBMAXSIZE;" +
                    "    begin" +
                    "    UPDATE XE SET MANV = (SELECT MANV FROM NHANVIEN WHERE TENNV = N'"+xe.getMaNV()+"') ,TENXE = ?,BIENSO = ?, ANH = empty_blob() WHERE MAXE = '"+xe.getMaXe()+"'" +
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
            ptms.setString(1, xe.getTenXe());
            ptms.setString(2, xe.getBienSo());
            ptms.setString(3, xe.getAnh());
            int n = ptms.executeUpdate();
            if(n == 1){
                kq = true;
            }
            provider.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
    public static ArrayList<XePoJo> timKiemXe(String maXe){
        ArrayList<XePoJo> dsXe = new ArrayList<XePoJo>();
        try {
            String sql = "Select XE.MAXE, NHANVIEN.TENNV ,XE.BIENSO,XE.TENXE from XE JOIN NHANVIEN ON XE.MANV = NHANVIEN.MANV where maxe = '"+maXe+"'";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                XePoJo xe = new XePoJo();
                xe.setMaXe(rs.getString(1));
                xe.setMaNV(rs.getString(2));
                xe.setBienSo(rs.getString(3));
                xe.setTenXe(rs.getString(4));
                dsXe.add(xe);
            }
            provider.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return dsXe;
    }
    
   
   
}
