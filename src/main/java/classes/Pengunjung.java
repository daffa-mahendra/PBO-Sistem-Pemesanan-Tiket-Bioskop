/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author DMA
 */
public class Pengunjung {
    //property
    String  nama, alamat, no_telepon;
    
    public Pengunjung (String nama, String alamat, String no_telepon)
        
    {
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
    }
    
      // Method
    public String getNama () {
        return nama;
    }
    
    public String getAlamat () {
        return alamat;
    }
    
    public String getNoTelepon () {
        return no_telepon;
    }
        
}

