/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_dao;
import java.io.InputStream;
import java.util.ArrayList;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import qlnx_pojo.*;
import java.util.Date;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author phatnguyen
 */
public class VeXeDAO {
    public static ArrayList<VeXePoJo> layDanhSachVX(){
        ArrayList<VeXePoJo> dsVX = new ArrayList<VeXePoJo>();
        try {
            String sql = """
                         SELECT VX.MAVE,KH.TENKH, NV.TENNV, CX.TENCHUYEN, VX.NGAYDI, VX.VITRI,VX.GIAVE
                         FROM VEXE VX
                         INNER JOIN NHANVIEN NV ON VX.MANV = NV.MANV
                         INNER JOIN CHUYENXE CX ON VX.MACHUYEN = CX.MACHUYEN
                         INNER JOIN KHACHHANG KH ON VX.MAKH = KH.MAKH
                         """;
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                VeXePoJo vx = new VeXePoJo();
                vx.setMaVe(rs.getString(1));
                vx.setMaKH(rs.getString(2));
                vx.setMaNV(rs.getString(3));
                vx.setMaChuyen(rs.getString(4));
                vx.setNgayDi(rs.getString(5));
                vx.setViTri(rs.getString(6));
                vx.setGiaVe(rs.getDouble(7));
                dsVX.add(vx);                            
            }            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }    
        return dsVX;
    }
    public static ArrayList<VeXePoJoRePort> layDanhSachVX1(){
        ArrayList<VeXePoJoRePort> dsVX = new ArrayList<VeXePoJoRePort>();
        try {
            String sql = """
                         SELECT VX.MAVE,KH.TENKH, NV.TENNV, CX.TENCHUYEN, TO_CHAR(VX.NGAYDI,'DD-MM-YYYY'), VX.VITRI,VX.GIAVE,SUM(VX.GIAVE) OVER() AS TONGVE
                         FROM VEXE VX
                         INNER JOIN NHANVIEN NV ON VX.MANV = NV.MANV
                         INNER JOIN CHUYENXE CX ON VX.MACHUYEN = CX.MACHUYEN
                         INNER JOIN KHACHHANG KH ON VX.MAKH = KH.MAKH
                         """;
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                VeXePoJoRePort vx = new VeXePoJoRePort();
                vx.setMAVE(rs.getString(1));
                vx.setTENKH(rs.getString(2));
                vx.setTENNV(rs.getString(3));
                vx.setTENCHUYEN(rs.getString(4));
                vx.setNGAYDI(rs.getString(5));
                vx.setVITRI(rs.getString(6));
                vx.setGIAVE(rs.getDouble(7));
                vx.setTONGVE(rs.getDouble("TONGVE"));
                dsVX.add(vx);                            
            }            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }    
        return dsVX;
    }
    
    public static ArrayList<VeXePoJoRePort> DoanhThuThang(){
        ArrayList<VeXePoJoRePort> dsVX = new ArrayList<VeXePoJoRePort>();
        try {
            String sql = "SELECT TO_CHAR(VX.NGAYDI, 'MM-YYYY') AS THANG, SUM(VX.GIAVE) AS TONGVE FROM VEXE VX GROUP BY TO_CHAR(VX.NGAYDI, 'MM-YYYY')";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                VeXePoJoRePort vx = new VeXePoJoRePort();
                vx.setTHANG(rs.getString("THANG"));
                vx.setTONGVE(rs.getDouble("TONGVE"));
                dsVX.add(vx);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        return dsVX;
    }
 
    public void InDoanhThu(ArrayList<VeXePoJoRePort> listVeXe) {
    try {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listVeXe);
        InputStream inputStream = getClass().getResourceAsStream("/report/VeXe.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error"+ e);
        }
    }
    
    public void InDoanhThuThang(ArrayList<VeXePoJoRePort> listVeXe) {
    try {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listVeXe);
        InputStream inputStream = getClass().getResourceAsStream("/report/DoanhThuThang.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error"+ e);
        }
    }
    public static boolean datVe(VeXePoJo vx){
        boolean kq = false;
        try {
            String sql = "INSERT INTO VEXE(MAKH, MANV, MACHUYEN, NGAYDI, VITRI, GIAVE)" +
                         "VALUES((SELECT makh FROM khachhang WHERE tenkh = N'"+vx.getMaKH()+"')," +
                        " (SELECT manv FROM nhanvien WHERE tendn = ?)," +
                        " (SELECT machuyen FROM chuyenxe WHERE tenchuyen = N'"+vx.getMaChuyen()+"')," +
                        "  TO_DATE(?, 'DD-MM-YYYY'), ?, ?)";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            PreparedStatement ptms = provider.getPre(sql);
            ptms.setString(1,vx.getMaNV());
            ptms.setString(2, vx.getNgayDi());
            ptms.setString(3, vx.getViTri());
            ptms.setDouble(4, vx.getGiaVe());      
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
    public static boolean xoaVe(String maVe){
        boolean kq = false;
        try {
            String sql = "DELETE FROM VEXE WHERE MAVE = '"+maVe+"'";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            int n = provider.excuteUpdate(sql);
            if(n == 1){
                kq = true;
            }
            provider.close();
            JOptionPane.showMessageDialog(null, "Đã Xóa Vé");       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;
    }
    public static boolean suaVe(VeXePoJo vx){
        boolean kq = false;
        try {
            String sql = "UPDATE VEXE SET MAKH = (SELECT makh FROM khachhang WHERE tenkh = N'"+vx.getMaKH()+"')"
                    + ", MANV = (SELECT manv FROM nhanvien WHERE tendn = ?)"
                    + ", MACHUYEN = (SELECT machuyen FROM chuyenxe WHERE tenchuyen = N'"+vx.getMaChuyen()+"')"
                    + ", NGAYDI = TO_DATE(?, 'DD-MM-YYYY')"
                    + ", VITRI =?, GIAVE=? WHERE MAVE = ? ";
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            PreparedStatement ptms = provider.getPre(sql);
            ptms.setString(1,vx.getMaNV());
            ptms.setString(2, vx.getNgayDi());
            ptms.setString(3, vx.getViTri());
            ptms.setDouble(4, vx.getGiaVe());      
            ptms.setString(5, vx.getMaVe());
            int n = ptms.executeUpdate();
            if(n ==1){
                kq = true;
            }   
            JOptionPane.showMessageDialog(null, "Sửa Thành Công");       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }
        return kq;        
    }
    public static ArrayList<VeXePoJo> timVe(String maVe){
        ArrayList<VeXePoJo> dsVX = new ArrayList<VeXePoJo>();
        try {
            String sql = "SELECT VX.MAVE,KH.TENKH, NV.TENNV, CX.TENCHUYEN, VX.NGAYDI, VX.VITRI,VX.GIAVE" +
"                         FROM VEXE VX" +
"                         INNER JOIN NHANVIEN NV ON VX.MANV = NV.MANV" +
"                         INNER JOIN CHUYENXE CX ON VX.MACHUYEN = CX.MACHUYEN" +
"                         INNER JOIN KHACHHANG KH ON VX.MAKH = KH.MAKH WHERE MAVE = '"+maVe+"'";                        
            OracleSeverProvider provider = new OracleSeverProvider();
            provider.open();
            ResultSet rs = provider.excuteQuery(sql);
            while(rs.next()){
                VeXePoJo vx = new VeXePoJo();
                vx.setMaVe(rs.getString(1));
                vx.setMaKH(rs.getString(2));
                vx.setMaNV(rs.getString(3));
                vx.setMaChuyen(rs.getString(4));
                vx.setNgayDi(rs.getString(5));
                vx.setViTri(rs.getString(6));
                vx.setGiaVe(rs.getFloat(7));
                dsVX.add(vx);                            
            }            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error"+ e);
        }    
        return dsVX;
    }
    

    
}
