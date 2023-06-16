/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_dao;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
import qlnx_pojo.*;

/**
 *
 * @author phatnguyen
 */
public class ChuyenXeDAO {
    public static ArrayList<ChuyenXePoJo> layDanhSachCX(){
        ArrayList<ChuyenXePoJo> dsCX = new ArrayList<ChuyenXePoJo>();
        try {
            String sql = """
                         SELECT CX.MACHUYEN, CX.TENCHUYEN, TX.TENTUYEN, X.BIENSO,CX.GIOXP FROM CHUYENXE CX
                         INNER JOIN TUYENXE TX ON CX.MATUYEN = TX.MATUYEN
                         INNER JOIN XE X ON CX.MAXE = X.MAXE""";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                ChuyenXePoJo cx = new ChuyenXePoJo();
                cx.setMaChuyen(rs.getString(1));
                cx.setTenChuyen(rs.getString(2));
                cx.setMaTuyen(rs.getString(3));
                cx.setMaXe(rs.getString(4));
                cx.setGioXP(rs.getString(5));                 
                dsCX.add(cx);             
            }            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }    
        return dsCX;
    }
    public static boolean themCX(ChuyenXePoJo cx){
        boolean kq = false;
        try {
            String sql = "INSERT INTO CHUYENXE (MACHUYEN, TENCHUYEN, MATUYEN, MAXE, GIOXP)" +
"                         VALUES (?,N'"+cx.getTenChuyen()+"',(select matuyen from tuyenxe where tentuyen = N'"+cx.getMaTuyen()+"'), (select maxe from xe where bienso=?), ?)";
                         
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            PreparedStatement ptms = provider.getPre(sql);
            ptms.setString(1, cx.getMaChuyen());
            ptms.setString(2, cx.getMaXe());
            ptms.setString(3, cx.getGioXP());
            int n = ptms.executeUpdate();
            if(n == 1){
                kq = true;
            }
            JOptionPane.showMessageDialog(null, "Thêm Thành Công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
    public static boolean xoaCX(String maChuyen){
        boolean kq = false;
        try {
            String sql = "DELETE FROM CHUYENXE WHERE MACHUYEN = '"+maChuyen+"'";
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
    public static boolean capnhatCX(ChuyenXePoJo cx){
        boolean kq = false;
        try {
            String sql ="UPDATE CHUYENXE SET TENCHUYEN = N'"+cx.getTenChuyen()+"'," +
"                        MATUYEN = (select matuyen from tuyenxe where tentuyen = N'"+cx.getMaTuyen()+"')," +
"                        MAXE = (select maxe from xe where bienso =?)," +
"                        GIOXP = ?" +
"                        WHERE MACHUYEN = ?";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            PreparedStatement ptms = provider.getPre(sql);
            ptms.setString(1, cx.getMaXe());
            ptms.setString(2, cx.getGioXP());
            ptms.setString(3, cx.getMaChuyen());
            int n = ptms.executeUpdate();
            if(n ==1){
                kq = true;
            }
            JOptionPane.showMessageDialog(null, "Đã Cập Nhật Chuyến Xe");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
    public static ArrayList<ChuyenXePoJo> timCX(String maxe){
        ArrayList<ChuyenXePoJo> dsCX = new ArrayList<ChuyenXePoJo>();
        try {
            String sql = "SELECT CX.MACHUYEN, CX.TENCHUYEN, TX.TENTUYEN, X.BIENSO,CX.GIOXP FROM CHUYENXE CX" +
"                         INNER JOIN TUYENXE TX ON CX.MATUYEN = TX.MATUYEN" +
"                         INNER JOIN XE X ON CX.MAXE = X.MAXE WHERE MACHUYEN = '"+maxe+"' " ;
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                ChuyenXePoJo cx = new ChuyenXePoJo();
                cx.setMaChuyen(rs.getString(1));
                cx.setTenChuyen(rs.getString(2));
                cx.setMaTuyen(rs.getString(3));
                cx.setMaXe(rs.getString(4));
                cx.setGioXP(rs.getString(5));                 
                dsCX.add(cx);             
            }            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }    
        return dsCX;
    }
    
}
