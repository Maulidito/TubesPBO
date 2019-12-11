/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Customer;
import MODEL.Pegawai;
import MODEL.TransaksiM;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Maulidito
 */
public class Database {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ArrayList<Customer> Customer = new ArrayList<>();
    private ArrayList<Pegawai> Pegawai = new ArrayList<>();
    private ArrayList<TransaksiM> Transaksi = new ArrayList<>();
    

    
    public Database() {
        loadPegawai();
        loadCustomer();       
        loadTransaksi();
    }
    
    
    public void connect(){
        try {
            
            String url = "jdbc:mysql://localhost/laundry";
            String user = "root";
            String pass = "";
            System.out.println("TULISAN INI ADA");
            conn = DriverManager.getConnection(url, user, pass); // buat melakukan koneksi ke database     
            System.out.println("TULISAN INI PASTI GAK ADA");
            stmt = conn.createStatement(); // buat melakukan sesuatu di ddl dan dml
           
        } catch (SQLException ex) {
            System.out.println("SALAH DI KONEK");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void disconnect(){
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
   
    public boolean manipulate(String query) {
        boolean cek = false;
        try {
            int rows = stmt.executeUpdate(query);
            if (rows > 0) cek = true; //JIKA ADD CUSTOMER HARUS ADA SATU?
        } catch (SQLException ex)  {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            cek = true;
        }
        return cek;
        
    }
    
    public void loadCustomer() { //mengambil data dari database ke sebuah array list
        connect();
        try {
            String query = "SELECT * FROM Customer";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                Customer C = new Customer(rs.getString("Nama_Customer"), rs.getString("JenisKelamin_Customer"), rs.getString("Tgl_Lahir_Customer"), rs.getString("Alamat_Customer"));
                C.setID(rs.getString("Id_Customer"));
                Customer.add(C);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

        disconnect();
    }
   }
    
   public Customer searchCustomer(String nama){
       for (Customer C : Customer){
           if (C.getNama().equals(nama)){
               return C;
           }
           
       }
       return null;
   
   }
   
      public Customer searchidCustomer(String id){
       for (Customer C : Customer){
           if (C.getIdcust().equals(id)){
               return C;
           }
           
       }
       return null;
   
   }

    public ArrayList<Customer> getCustomer() {
        return Customer;
    }
    
    public void addCustomer(Customer m) {
        connect();
        String query = "INSERT INTO customer VALUES (";
        query += "'" + m.getIdcust()+ "',";
        query += "'" + m.getNama()+ "',";
        query += "'" + m.getKelamin()+ "',";
        query += "'" + m.getTgl_lahir()+ "',";
        query += "'" + m.getAlamat()+"'";
        query += ")";
        System.out.println(m.getIdcust()+"asdfsdf");
        if (manipulate(query)) Customer.add(m);
        disconnect();
    }
     
    public boolean cekDuplikatIdcust(String Idcust){    
        boolean cek = false;
        for (Customer cus : Customer) {
            if (cus.getIdcust().equals(Idcust)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
        
    public boolean cekDuplikatnamaCustomer(String nama){    
        boolean cek = false;
        for (Customer cus : Customer) {        
            if (cus.getNama().equals(nama)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public String LastidCustomer(){
        try{
            return Customer.get(Customer.size()-1).getIdcust();
        }catch(ArrayIndexOutOfBoundsException e){
            return "";
        }
    }
    
    

    
    public void delCustomer(String Idcust) {
        connect();
        String query = "DELETE FROM Customer WHERE Id_Customer='" + Idcust + "'";
        if (manipulate(query)){
            for (Customer cus : Customer) {
                if (cus.getIdcust().equals(Idcust)){
                    Customer.remove(cus);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void updateCustomer(Customer m) {
        connect();
        String query = "UPDATE Customer SET";
        query += " Nama_Customer='" + m.getNama() + "',";
        query += " JenisKelamin_Customer='" + m.getKelamin()+ "',";
        query += " Tgl_Lahir_Customer='" + m.getTgl_lahir()+ "',";
        query += " Alamat_Customer='" + m.getAlamat()+ "'";
        query += " WHERE Id_Customer='" + m.getIdcust() + "'";
        if (manipulate(query)){
            for (Customer cus : Customer) {
                if (cus.getIdcust().equals(m.getIdcust())){
                    cus.setNama(m.getNama());
                    cus.setAlamat(m.getAlamat());
                    cus.setKelamin(m.getKelamin());
                    cus.setTgl_lahir(m.getTgl_lahir());
                    break;
                }
            }
        }
        disconnect();
    }
    
     public void loadPegawai() { //mengambil data dari database ke sebuah array list
        connect();
        try {
            String query = "SELECT * FROM Pegawai";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                Pegawai p = new Pegawai(rs.getString("Nama_Pegawai"), rs.getString("JenisKelamin_Pegawai"), rs.getString("Tgl_Lahir_Pegawai"),(""),(rs.getString("Password_Pegawai")));
                String a = rs.getString("Id_Pegawai");
                p.setIdpeg(a);
                Pegawai.add(p);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

        disconnect();
    }
   }

    public ArrayList<Pegawai> getPegawai() {
        return Pegawai;
    }
    
    public void addPegawai(Pegawai m) {
        connect();
        String query = "INSERT INTO Pegawai VALUES (";
        query += "'" + m.getIdpeg() + "',";
        query += "'" + m.getNama()+ "',";
        query += "'" + m.getKelamin()+ "',";
        query += "'" + m.getTgl_lahir()+ "',";
        query += "'" + m.getPassword()+ "'"; 
        query += ")";
        if (manipulate(query)) Pegawai.add(m);
        disconnect();
    }
     
    public boolean cekDuplikatidpeg(String idpeg){    
        boolean cek = false;
        for (Pegawai peg : Pegawai) {
            if (peg.getIdpeg().equals(idpeg)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public boolean cekDuplikatnamaPegawai(String nama){    
        boolean cek = false;
        for (Pegawai cus : Pegawai) {
            if (cus.getNama().equals(nama)){
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public String LastidPegawai(){
        try{
            return Pegawai.get(Pegawai.size()-1).getIdpeg();
        }catch(ArrayIndexOutOfBoundsException e){
            return "";
        }
    }
    
    public void delPegawai(String idpeg) {

        connect();
        String query = "DELETE FROM Pegawai WHERE id_Pegawai='" + idpeg + "'";
        if (manipulate(query)){
            for (Pegawai peg : Pegawai) {
                if (peg.getIdpeg().equals(idpeg)){                  
                    Pegawai.remove(peg);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void updatePegawai(Pegawai m) {
        connect();
        String query = "UPDATE Pegawai SET";
        query += " Nama_Pegawai='" + m.getNama() + "',";
        query += " JenisKelamin_Pegawai='" + m.getKelamin()+ "',";
        query += " Tgl_Lahir_Pegawai='" + m.getTgl_lahir()+ "',";
        query += "Password_Pegawai='" + m.getPassword()+ "'"; 
        query += " WHERE Id_Pegawai='" + m.getIdpeg()+ "'";
        if (manipulate(query)){
            for (Pegawai peg : Pegawai) {
                if (peg.getIdpeg().equals(m.getIdpeg())){
                    peg.setNama(m.getNama());
                    peg.setAlamat(m.getAlamat());
                    peg.setKelamin(m.getKelamin());
                    peg.setTgl_lahir(m.getTgl_lahir());
                    peg.setPassword(m.getPassword());
                    break;
                }
            }
        }
        disconnect();
    }
    
   public boolean LoginPegawai(String username, String pass){
       for (Pegawai P : this.Pegawai){
           if ((P.getNama().equals(username))&&(P.getPassword().equals(pass))){
               return true;
           }
           
       }
       return false;
   }
    
   public Pegawai searchPegawai(String nama){
       for (Pegawai P : this.Pegawai){
           if (P.getNama().equals(nama)){
               return P;
           }
           
       }
       return null;
   
   }
      public Pegawai searchidPegawai(String id){
       for (Pegawai P : this.Pegawai){
           System.out.println(P.getIdpeg()+id);
           System.out.println("II");
           if (P.getIdpeg().equals(id)){
               return P;
           }
           
       }
       return null;
   
   }
   
   
   
   
  public void loadTransaksi() { //mengambil data dari database ke sebuah array list
        connect();
        try {
            String query = "SELECT * FROM Transaksi";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                Pegawai pega =  searchidPegawai(rs.getString("id_Pegawai"));
                Customer cus = searchidCustomer(rs.getString("id_Customer"));
                TransaksiM T = new TransaksiM(pega, cus,rs.getInt("JmlPakaian"),rs.getInt("JmlSepatu"),rs.getInt("TotalHarga"));
                T.setTransaksiId(rs.getString("Id_Transaksi"));
                T.setStatus(rs.getString("Proses"));
                Transaksi.add(T);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

        disconnect();
    }
   }

    public ArrayList<TransaksiM> getTransaksi() {
        return Transaksi;
    }
    
    public void addTransaksi(TransaksiM m) {
        connect();
        String query = "INSERT INTO Transaksi VALUES (";
        query += "'" + m.getTransaksiId()+ "',";
        query += "'" + m.getPegTerima().getIdpeg()+ "',";
        query += "'" + m.getCustomer().getIdcust()+ "',";
        query += "'" + m.getTotalsatuTransaksi(0)/5000+ "',";
        query += "'" + m.getTotalsatuTransaksi(1)/25000+ "',";
        query += "'" + m.getTotalHarga(m)+ "',"; 
        query += "'" + m.getStatus()+ "'"; 
        query += ")";
        if (manipulate(query)) Transaksi.add(m);
        disconnect();
    }
     
//    public boolean cekDuplikatnamaTransaksi(String nama){    
//        boolean cek = false;
//        for (Transaksi cus : Transaksi) {
//            if (cus.getNama().equals(nama)){
//                cek = true;
//                break;
//            }
//        }
//        return cek;
//    }
    
    public void delTransaksi(String idTra) {
        connect();
        String query = "DELETE FROM Transaksi WHERE id_Transaksi='" + idTra + "'";
        if (manipulate(query)){
            for (TransaksiM Tra : Transaksi) {
                if (Tra.getTransaksiId().equals(idTra)){
                    Transaksi.remove(Tra);
                    break;
                }
            }
        }
        disconnect();
    }
    
    public void updateTransaksi(TransaksiM m) {
        connect();
        String query = "UPDATE Transaksi SET";
        query += " Id_Transaksi='" + m.getTransaksiId() + "',";
        query += " id_Pegawai='" + m.getPegTerima().getIdpeg()+ "',";
        query += " id_Customer='" + m.getCustomer().getIdcust()+ "',";
        query += " JmlPakaian ='" + m.getTotalsatuTransaksi(0)/5000+ "',";
        query += "JmlSepatu='" + m.getTotalsatuTransaksi(1)/25000+ "',";
        query += "TotalHarga='" + m.getTotalHarga(m)+ "',"; 
         query += "Proses='" + m.getStatus()+ " '"; 
        query += " WHERE id_Transaksi='" + m.getTransaksiId()+ "'";
        if (manipulate(query)){
            for (TransaksiM Tra : Transaksi) {
                if (Tra.getTransaksiId().equals(m.getTransaksiId())){
                    Tra.setPegTerima(m.getPegTerima());
                    Tra.setCustomer(m.getCustomer());
                    Tra.setCucian(m.getCucian());
                    break;
                }
            }
        }
        disconnect();
    }
    
    public TransaksiM searchidTransaksi(String id){
       for (TransaksiM P : this.Transaksi){
           if (P.getTransaksiId().equals(id)){
               return P;
           }
           
       }
       return null;
   
   }
   public String LastidTransaksi(){
       try{
        return Transaksi.get(Transaksi.size()-1).getTransaksiId();
       }catch(ArrayIndexOutOfBoundsException e){
        return "";
       }
    }
    
    

}