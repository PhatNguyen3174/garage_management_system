/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_pojo;
import java.util.Date;
/**
 *
 * @author phatnguyen
 */
public class VeXePoJo {
    private String maVe, maKH,maChuyen, viTri, maNV, ngayDi;
    private double giaVe;

    public VeXePoJo() {
    }

    public VeXePoJo(String maVe, String maKH, String maChuyen, String viTri, String maNV, String ngayDi, Date checkNgay, double giaVe) {
        this.maVe = maVe;
        this.maKH = maKH;
        this.maChuyen = maChuyen;
        this.viTri = viTri;
        this.maNV = maNV;
        this.ngayDi = ngayDi;
        this.giaVe = giaVe;
    }   

  
    
    public String getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }
   
    
   

    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaChuyen() {
        return maChuyen;
    }

    public void setMaChuyen(String maChuyen) {
        this.maChuyen = maChuyen;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    //

    
    
}
