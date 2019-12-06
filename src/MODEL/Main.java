/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Maulidito
 */
public class Main {
    public static void main(String[] args) {
        Customer a = new Customer("bambank", "rumah", "laki laki", "02");
        Pegawai peg = new Pegawai("mamank", "telu", "ganda", "08");
        Pegawai pe = new Pegawai("mamank", "telu", "ganda", "08");
        Transaksi T = new Transaksi(peg, a);
        T.createCucianPakaian(3);
        T.createCucianSepatu(3);
        peg.setTransaksi(T);
        System.out.println(peg.getTransaksi().get(0).getTotalHarga(T));
        System.out.println(T.getCucian().get(0));
        
    
}
}
