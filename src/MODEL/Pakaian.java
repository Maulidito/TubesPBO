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
public class Pakaian extends Cucian{
    private int berat;
    
    public Pakaian(int berat) {
        super(berat * 5000);
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }


    
}
