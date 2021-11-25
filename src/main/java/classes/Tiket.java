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
public class Tiket {
    private String kode_tiket, nama_film;
    private double harga_tiket;
    private JENIS_TIKET  jenis_tiket;
    String getJenisTiket;
    
     public enum JENIS_TIKET {
        Gold, 
        Silver, 
        Bronze
    }
     
    public Tiket (String kode_tiket, String nama_film, JENIS_TIKET jenis_tiket, double harga_tiket)
        
    {
        this.kode_tiket = kode_tiket;
        this.nama_film = nama_film;
        this.jenis_tiket = jenis_tiket;
        this.harga_tiket = harga_tiket;
        
       
    }
    
    //method
      public String getKodeTiket () {
        return kode_tiket;
    }
      public String getNamaFilm () {
        return nama_film;
    }
    
      public String getJenisTiket () {
        return jenis_tiket == JENIS_TIKET.Gold ? "Gold" : jenis_tiket == JENIS_TIKET.Silver ? "Silver" : "Bronze";
    }
        
       public double getHargaTiket () {
        return harga_tiket;
    }
       
}

