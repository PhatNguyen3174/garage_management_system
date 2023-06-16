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


public class TuyenXeDAO {
    public static ArrayList<TuyenXePoJo> layDSTX(){
        ArrayList<TuyenXePoJo> dsTX = new ArrayList<TuyenXePoJo>();
        try {
            String sql = "Select * from tuyenxe";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs =  provider.excuteQuery(sql);
            while(rs.next()){
                TuyenXePoJo tx = new TuyenXePoJo();
                tx.setMaTuyen(rs.getString(1));
                tx.setTenTuyen(rs.getString(2));
                tx.setBenxeDi(rs.getString(3));
                tx.setBenxeDen(rs.getString(4));
                dsTX.add(tx);
            }
            provider.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return dsTX;
    }
   public static boolean themTX(TuyenXePoJo tx){
       boolean kq = false;
       try {
           String sql = "INSERT INTO TUYENXE (MATUYEN,TENTUYEN, BENXEDI, BENXEDEN) VALUES (?,N'"+tx.getTenTuyen()+"', N'"+tx.getBenxeDi()+"', N'"+tx.getBenxeDi()+"')";
           OracleSeverProvider provider = new OracleSeverProvider();
           provider.open();
           PreparedStatement ptms = provider.getPre(sql);
           ptms.setString(1, tx.getMaTuyen());
           int n = ptms.executeUpdate();
           if(n== 1){
               kq = true;
           }
           provider.close();
           JOptionPane.showMessageDialog(null,"Thêm thành công");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error"+ e);
       }
       return kq;
   }
   public static boolean xoaTX(String maTuyen){
       boolean kq = false;
       try {
           String sql = "DELETE FROM TUYENXE WHERE MATUYEN ='"+maTuyen+"'";
           OracleSeverProvider provider = new OracleSeverProvider();
           provider.open();
           int n = provider.excuteUpdate(sql);
           if(n== 1){
               kq = true;
           }
           provider.close();
           JOptionPane.showMessageDialog(null, "Đã xóa Tuyến Xe");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error"+ e);
       }
       return kq;
   }
   public static boolean capnhatTX(TuyenXePoJo tx){
       boolean kq = false;
       try {
           String sql = "UPDATE TUYENXE SET TENTUYEN=?, BENXEDEN =N'"+tx.getBenxeDen()+"', BENXEDI = N'"+tx.getBenxeDi()+"' WHERE MATUYEN =? ";
           OracleSeverProvider provider = new OracleSeverProvider();
           provider.open();
           PreparedStatement ptms = provider.getPre(sql);
           ptms.setString(1, tx.getTenTuyen());
           ptms.setString(2, tx.getMaTuyen());
           int n = ptms.executeUpdate();
           if(n == 1){
               kq = true;
           }
           provider.close();
           JOptionPane.showMessageDialog(null, "Cập nhật thành công");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error"+ e);
       }
       return kq;
   }  
   public static ArrayList<TuyenXePoJo> timKiemTX(String maTX){
        ArrayList<TuyenXePoJo> dsTX= new ArrayList<>();
        try {
            String sql = "Select * from TUYENXE where MATUYEN = '"+maTX+"' ";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                TuyenXePoJo tx = new TuyenXePoJo();
                tx.setMaTuyen(rs.getString(1));
                tx.setTenTuyen(rs.getString(2));
                tx.setBenxeDi(rs.getString(3));
                tx.setBenxeDen(rs.getString(4));               
                dsTX.add(tx);                                 
            }
            provider.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return dsTX;
       
    }
}
