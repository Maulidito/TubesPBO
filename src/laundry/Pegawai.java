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
public class Pegawai {
    private long idpeg;
    private Person[] person;
    private int nPerson;

    public Pegawai(long idpeg, int nPerson) {
        this.idpeg = idpeg;
        person = new Person[nPerson];
    }
    
    public void addPerson(String nama, String kelamin, String alamat, String tgl_lahir){
            getPerson()[nPerson++] = new Person(nama,kelamin,alamat,tgl_lahir);
    }

    
    public long getIdpeg() {
        return idpeg;
    }

    
    public void setIdpeg(long idpeg) {
        this.idpeg = idpeg;
    }

    
    public Person[] getPerson() {
        return person;
    }

   
    public void setPerson(Person[] person) {
        this.person = person;
    }
    
    
    
    
}
