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
public class Customer {
    private long idcust;
    private Person[] person;
    private int nPerson;
    
    public Customer(long idcust, int nPerson){
        this.idcust = idcust;
        person = new Person[nPerson];
    }
    
    public void addPerson(String nama, String kelamin, String alamat, String tgl_lahir){
        getPerson()[nPerson++]= new Person(nama,kelamin,alamat,tgl_lahir);
    }

   
    public long getIdcust() {
        return idcust;
    }

   
    public void setIdcust(long idcust) {
        this.idcust = idcust;
    }

   
    public Person[] getPerson() {
        return person;
    }
   
    public void setPerson(Person[] person) {
        this.person = person;
    }

   
    public int getnPerson() {
        return nPerson;
    }

   
    public void setnPerson(int nPerson) {
        this.nPerson = nPerson;
    }
    
    
}
