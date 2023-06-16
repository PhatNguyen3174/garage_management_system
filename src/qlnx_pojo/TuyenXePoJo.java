/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnx_pojo;

/**
 *
 * @author phatnguyen
 */
public class TuyenXePoJo {
    private String maTuyen;
    private String tenTuyen;
    private String benxeDi;
    private String benxeDen;

    public TuyenXePoJo() {
    }

    public String getBenxeDi() {
        return benxeDi;
    }

    public void setBenxeDi(String benxeDi) {
        this.benxeDi = benxeDi;
    }

    public String getBenxeDen() {
        return benxeDen;
    }

    public void setBenxeDen(String benxeDen) {
        this.benxeDen = benxeDen;
    }

    public TuyenXePoJo(String maTuyen, String tenTuyen, String benxeDi, String benxeDen) {
        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;
        this.benxeDi = benxeDi;
        this.benxeDen = benxeDen;
    }

    

    

    public String getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public String getTenTuyen() {
        return tenTuyen;
    }

    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
    }

    public TuyenXePoJo(String maTuyen, String tenTuyen) {
        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;
    }

   
    
    
}
