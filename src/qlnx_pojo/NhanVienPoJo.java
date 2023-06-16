/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_pojo;

/**
 *
 * @author phatnguyen
 */
public class NhanVienPoJo {
    private String maNV, maCV,tenDN,pass,sdt,diachi,anh,tennv;

    public NhanVienPoJo() {
    }

    public NhanVienPoJo(String maNV, String maCV, String tenDN, String pass, String sdt, String diachi, String anh, String tennv) {
        this.maNV = maNV;
        this.maCV = maCV;
        this.tenDN = tenDN;
        this.pass = pass;
        this.sdt = sdt;
        this.diachi = diachi;
        this.anh = anh;
        this.tennv = tennv;
    }
    
    

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    
    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    

   

  
    
    
}
