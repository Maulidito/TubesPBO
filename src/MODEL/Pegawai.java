/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Pegawai extends Person{
    private String idpeg;
    private ArrayList<Transaksi> transaksi  = new ArrayList<>(); 

    public Pegawai(String nama, String kelamin, String tgl_lahir, String alamat) {
        super(nama,kelamin, tgl_lahir, alamat);
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi.add(transaksi);
    }

    public String getIdpeg() {
        return idpeg;
    }

    
    public void setIdpeg(String idpeg) {
        this.idpeg = idpeg;
    }


    public ArrayList<Transaksi> getTransaksi() {
        return transaksi;
    }

   
    
    
    
    
    
}
