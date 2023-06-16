/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_pojo;

/**
 *
 * @author phatnguyen
 */
public class ChuyenXePoJo {
    private String maChuyen, tenChuyen, maTuyen,maXe,gioXP;

    public ChuyenXePoJo() {
    }

    public ChuyenXePoJo(String maChuyen, String tenChuyen, String maTuyen, String maXe, String gioXP) {
        this.maChuyen = maChuyen;
        this.tenChuyen = tenChuyen;
        this.maTuyen = maTuyen;
        this.maXe = maXe;
        this.gioXP = gioXP;
    }

    

    public String getMaChuyen() {
        return maChuyen;
    }

    public void setMaChuyen(String maChuyen) {
        this.maChuyen = maChuyen;
    }

    public String getTenChuyen() {
        return tenChuyen;
    }

    public void setTenChuyen(String tenChuyen) {
        this.tenChuyen = tenChuyen;
    }

    public String getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getGioXP() {
        return gioXP;
    }

    public void setGioXP(String gioXP) {
        this.gioXP = gioXP;
    }
    
}
