/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

/**
 *
 * @author User
 */
public class Person {
    private String nama;
    private String kelamin;
    private String alamat ;
    private String tgl_lahir;
    
    public Person(String nama, String alamat, String kelamin, String tgl_lahir){
        this.nama = nama;
        this.alamat = alamat;
        this.kelamin = kelamin;
    }

   
    public String getNama() {
        return nama;
    }

   
    public void setNama(String nama) {
        this.nama = nama;
    }

   
    public String getKelamin() {
        return kelamin;
    }

    
    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

  
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    
    public String getTgl_lahir() {
        return tgl_lahir;
    }

   
    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }
    
    
    
}
