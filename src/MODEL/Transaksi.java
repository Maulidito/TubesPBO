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
public class Transaksi {
    private Pegawai pegTerima;
    private Customer customer;
    private ArrayList<Cucian> cucian  = new ArrayList<Cucian>();

    public Transaksi(Pegawai pegTerima, Customer customer) {
        this.pegTerima = pegTerima;
        this.customer = customer;
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
    
    public int getTotalHarga(Transaksi T){
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

    public void setCucian(ArrayList <Cucian> cucian) {
        this.cucian = cucian;
    }
    
        
    

}
