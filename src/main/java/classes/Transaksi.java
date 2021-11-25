/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author DMA
 */
public class Transaksi {
    //property
    private String id_transaksi;
    private Pengunjung pengunjung;
    private Pegawai pegawai;
    private String tanggal_transaksi;
    private ArrayList<TiketPengunjung> tiketPengunjung;
    private double total_bayar;
    
  public Transaksi(String id_transaksi, Pengunjung pengunjung, String tanggal_transaksi)
    {
        this.id_transaksi = id_transaksi;
        this.pengunjung = pengunjung;
        this.tanggal_transaksi = tanggal_transaksi;
        
        tiketPengunjung = new ArrayList<>();
    }
  
   // Method
    public void tambahTiketPengunjung (TiketPengunjung tiketPengunjung) {
        this.tiketPengunjung.add(tiketPengunjung);
    }
    
    public ArrayList<TiketPengunjung> getSemuaTiketPengunjung () {
        return this.tiketPengunjung;
    }
    
      public void cetakStruk () {
        System.out.println("\n======== MTIX 21 ========");
        System.out.println("Id Transaksi : " + id_transaksi);
        System.out.println("Pemesan : " + pengunjung.getNama());
        System.out.println("Nomor Telepon : " + pengunjung.getNoTelepon());
        System.out.println("Tanggal : " + tanggal_transaksi);
        
        System.out.println("=========------=========");
        
        for (int i = 0; i < tiketPengunjung.size(); i++) {
            TiketPengunjung tp = tiketPengunjung.get(i);
            Tiket t = tp.getTiket();
            String struk = tp.getJumlahTiket() + " " + t.getKodeTiket() + " (" + t.getJenisTiket() +")" + "\t" + (t.getHargaTiket() * tp.getJumlahTiket());
            
            // Tampilkan Struk
            System.out.println(struk);
        }
    }
    
    public double hitungTotalTiketPengunjung(){
        for (int i = 0; i < tiketPengunjung.size(); i++) {
            TiketPengunjung tp = tiketPengunjung.get(i);
            double hargaTiket = tp.getTiket().getHargaTiket();
            this.total_bayar += (hargaTiket * tp.getJumlahTiket());
        }
        
        return this.total_bayar;
    }
    
    public double hitungKembalian (double uang_bayar) {
        return uang_bayar - this.total_bayar;
    }
}
    
     
         
        

