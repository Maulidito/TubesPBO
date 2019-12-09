/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Pegawai extends Person{
    private String idpeg,password;
    private ArrayList<TransaksiM> transaksi  = new ArrayList<>(); 
    int id;
    
    public Pegawai(String nama, String kelamin, String tgl_lahir, String alamat, String pass) {
        super(nama,kelamin, tgl_lahir, alamat);
        password = pass;
        this.idpeg = "00"+String.valueOf(++id); //-------------------------------------MASIH BELUM------------------------------
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTransaksi(TransaksiM transaksi) {
        this.transaksi.add(transaksi);
    }

    public String getIdpeg() {
        return idpeg;
    }

    
    public void setIdpeg(String idpeg) {
        this.idpeg = idpeg;
    }


    public ArrayList<TransaksiM> getTransaksi() {
        return transaksi;
    }
    
    public void setID(String idpega){
        if (idpega.equals("")){
            this.idpeg = "P001";
        }else{
            int id= Integer.valueOf(idpega.substring(1));
            id++;
            if (id<10){
                this.idpeg = "P00";
            }else if (id<100){
                this.idpeg = "P0";
            }else{
                this.idpeg = "P";
            }
            this.idpeg = this.idpeg + String.valueOf(id);
            
        }
    
    }

   
    
    
    
    
    
}
