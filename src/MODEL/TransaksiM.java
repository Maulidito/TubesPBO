/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author User
 */
public class TransaksiM {
    private String TransaksiId; 
    private Pegawai pegTerima;
    private Customer customer;
    private ArrayList<Integer> TotalHarga = new ArrayList<>();
    private ArrayList<Cucian> cucian = new ArrayList<>();
    
    public TransaksiM(Pegawai pegTerima, Customer customer, int pakaian, int sepatu, int harga) {
        this.pegTerima = pegTerima;
        this.customer = customer;
        this.cucian.add(new Pakaian(pakaian));
        this.cucian.add(new Sepatu(sepatu));
        TotalHarga.add(harga);
    }

    public String getTransaksiId() {
        return TransaksiId;
    }

    public void setTransaksiId(String TransaksiId) {
        this.TransaksiId = TransaksiId;
    }

    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    public void  createCucianPakaian(int berat) {
        cucian.add(new Pakaian(berat));
    }

    public void createCucianSepatu(int pasang) {
        cucian.add(new Sepatu(pasang));
    }
    
    public int getTotalHarga(TransaksiM T){
        int retur = 0;
        for (Cucian X : T.getCucian()) {
            retur = retur + X.getTotalHarga();
        }
        return retur;
    }
    
    

    public Pegawai getPegTerima() {
        return pegTerima;
    }

    public void setPegTerima(Pegawai pegTerima) {
        this.pegTerima = pegTerima;
    }

    public ArrayList<Cucian> getCucian() {
        return cucian;
    }

    public void setCucian(ArrayList<Cucian> cucian) {
        this.cucian = cucian;
    }

    public int getTotalsatuTransaksi(int idx){
        return cucian.get(idx).getTotalHarga();
    }
    
    public void setID(String idT){
       if (idT.equals("")){
            this.TransaksiId = "T001";
       }else{
           int id= Integer.valueOf(idT.substring(1));
           id++;
           if (id<10){
               this.TransaksiId = "T00";
           }else if (id<100){
               this.TransaksiId = "T0";
           }else{
               this.TransaksiId = "T";
           }
           this.TransaksiId = this.TransaksiId + String.valueOf(id);
            
        }
    
    }
        
    

}
