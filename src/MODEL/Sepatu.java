/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author User
 */
public class Sepatu extends Cucian{
    private int pasang;
    private int hargasepatu;
    

    public Sepatu(int pasang) {
        super(pasang * 25000);
    }
    
    
    public int getPasang() {
        return pasang;
    }

    public void setPasang(int pasang) {
        this.pasang = pasang;
    }


   
    
    
}
