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
public class TiketPengunjung {
    // Property
    private Tiket tiket;
    private int jumlah_tiket;
    
    // Constructor    
    public TiketPengunjung (Tiket tiket, int jumlah_tiket) {
        this.tiket = tiket;
        this.jumlah_tiket = jumlah_tiket;
    }
    
    public Tiket getTiket () {
        return this.tiket;
    }
    
    public int getJumlahTiket () {
        return this.jumlah_tiket;
    }
}
