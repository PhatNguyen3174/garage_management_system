/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_pojo;

/**
 *
 * @author phatnguyen
 */
public class VeXePoJoRePort {
     private String MAVE, TENKH,TENNV,TENCHUYEN,NGAYDI,VITRI, THANG;
     private double GIAVE, TONGVE;

    public VeXePoJoRePort() {
    }

    public VeXePoJoRePort(String MAVE, String TENKH, String TENNV, String TENCHUYEN, String NGAYDI, String VITRI, double GIAVE, double TONGVE, String THANG) {
        this.MAVE = MAVE;
        this.TENKH = TENKH;
        this.TENNV = TENNV;
        this.TENCHUYEN = TENCHUYEN;
        this.NGAYDI = NGAYDI;
        this.VITRI = VITRI;
        this.GIAVE = GIAVE;
        this.TONGVE= TONGVE;
        this.THANG = THANG;
    }

    public double getTONGVE() {
        return TONGVE;
    }

    public void setTONGVE(double TONGVE) {
        this.TONGVE = TONGVE;
    }

    public String getTHANG() {
        return THANG;
    }

    public void setTHANG(String THANG) {
        this.THANG = THANG;
    }

   
    

    

    public String getMAVE() {
        return MAVE;
    }

    public void setMAVE(String MAVE) {
        this.MAVE = MAVE;
    }

    public String getTENKH() {
        return TENKH;
    }

    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }

    public String getTENNV() {
        return TENNV;
    }

    public void setTENNV(String TENNV) {
        this.TENNV = TENNV;
    }

    public String getTENCHUYEN() {
        return TENCHUYEN;
    }

    public void setTENCHUYEN(String TENCHUYEN) {
        this.TENCHUYEN = TENCHUYEN;
    }

    public String getNGAYDI() {
        return NGAYDI;
    }

    public void setNGAYDI(String NGAYDI) {
        this.NGAYDI = NGAYDI;
    }

    public String getVITRI() {
        return VITRI;
    }

    public void setVITRI(String VITRI) {
        this.VITRI = VITRI;
    }

    public double getGIAVE() {
        return GIAVE;
    }

    public void setGIAVE(double GIAVE) {
        this.GIAVE = GIAVE;
    }
}
