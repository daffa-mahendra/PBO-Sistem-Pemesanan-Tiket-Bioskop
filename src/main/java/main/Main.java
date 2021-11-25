/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import java.util.InputMismatchException;

import classes.Pengunjung;
import classes.Pegawai;
import classes.Transaksi;
import classes.DaftarTiket;
import classes.DaftarPegawai;
import static classes.Pegawai.JENIS_KELAMIN;
import classes.Tiket;
import classes.Tiket.JENIS_TIKET;
import classes.TiketPengunjung;

/**
 *
 * @author DMA
 */
public class Main {
    public DaftarTiket daftarTiket;
    
       public static void main (String[] args) {
 
        Scanner input = new Scanner(System.in);
        
        // Pengunjung 
        Pengunjung pengunjung;
        String nama, alamat, no_telepon;
        
        // Penjaga Loket
        
        // Transaksi
        String id_transaksi, tanggal_transaksi;
        String transaksi_lagi = "", pesan_lagi = "";
        
        Main app = new Main();
        
        // Ambil data pelanggan
        System.out.println("Nama Pengunjung : ");
        nama = input.nextLine();
        System.out.println("Alamat : ");
        alamat = input.nextLine();
        System.out.println("Nomor Telepon :");//Jenis Kelamin : [L/P]
        no_telepon = input.next();
        
        pengunjung = new Pengunjung(nama, alamat, no_telepon);// jenis_kelamin.equalsIgnoreCase("L") ? JENIS_KELAMIN.L : JENIS_KELAMIN.P);
        
        // Tampilkan daftar tiket
        app.generateDaftarTiket();
        
        
        // Mulai transaksi
        System.out.println("======== TRANSAKSI ========");
        
        do{
            // Ambil data transaksi
            System.out.println("Id Transaksi : ");
            id_transaksi = input.next();
            System.out.println("Tanggal : [dd-mm-yyyy] ");
            tanggal_transaksi= input.next();

            // Buat transaksi baru
            Transaksi transaksi = new Transaksi(id_transaksi, pengunjung, tanggal_transaksi);
            System.out.println("======== TRANSAKSI ========");
            do {
                // Ambil tiket berdasarkan nomor urut yang dipilih
                Tiket tiket_yang_dipilih = app.daftarTiket.pilihTiket();
                int jumlah_tiket = (int) app.cekInputNumber("Jumlah : ");
                
                // Buat pesanan
                TiketPengunjung tiketpengunjung = new TiketPengunjung(tiket_yang_dipilih, jumlah_tiket);
                transaksi.tambahTiketPengunjung(tiketpengunjung);

                // Konfirmasi, mau tambah tiket atau tidak
                System.out.println("Pesan tiket lagi? [Y/N] ");
                pesan_lagi = input.next();
            } while (pesan_lagi.equalsIgnoreCase("Y"));

            // Cetak struk
            transaksi.cetakStruk();

            // Hitung total harga
            double total_tiket_pesanan = transaksi.hitungTotalTiketPengunjung();
            System.out.println("============================");
            System.out.println("Total Harga : \t\t\t" + total_tiket_pesanan);

            // Cek uang bayar, apakah > total bayar atau tidak
            double kembalian = 0;
            do{
                // Ambil input uang bayar
                double uang_bayar = app.cekInputNumber("Bayar : \t\t\t");
                kembalian = transaksi.hitungKembalian(uang_bayar);
                    
                if(kembalian < 0){
                    System.out.println("[NetNot] Uang anda kurang");
                } else{
                    System.out.println("Kembalian \t\t\t" + kembalian);
                }
            } while(kembalian < 0);

            System.out.println("Mau Beli Lagi? [Y/N] ");
            transaksi_lagi = input.next();
        } while(transaksi_lagi.equalsIgnoreCase("Y"));
        
        System.out.println("======= TERIMA KASIH ========");
    }
    
    public void generateDaftarTiket () {
        // this.kode_tiket = kode_tiket;  
        // thus.nama_film =  anama_film;
        // this.jenis_tiket = jenis_tiket;
        // this.harga_tiket = harga_tiket;

        daftarTiket = new DaftarTiket();
        daftarTiket.tambahTiket(new Tiket("Gold Tiket","The Conjuring",JENIS_TIKET.Gold, 500000));
        daftarTiket.tambahTiket(new Tiket("Silver Tiket","The Conjuring",JENIS_TIKET.Silver, 300000));
        daftarTiket.tambahTiket(new Tiket("Bronze Tiket","The Conjuring",JENIS_TIKET.Bronze, 150000));
        daftarTiket.tambahTiket(new Tiket("Gold Tiket","Black Panther",JENIS_TIKET.Gold, 500000));
        daftarTiket.tambahTiket(new Tiket("Silver Tiket","Black Panther",JENIS_TIKET.Silver, 300000));
        daftarTiket.tambahTiket(new Tiket("Bronze Tiket","Black Panther",JENIS_TIKET.Bronze, 150000));
        daftarTiket.tambahTiket(new Tiket("Gold Tiket","Thor Ragnarok",JENIS_TIKET.Gold, 500000));
        daftarTiket.tambahTiket(new Tiket("Silver Tiket","Thor Ragnarok",JENIS_TIKET.Silver, 300000));
        daftarTiket.tambahTiket(new Tiket("Bronze Tiket","Thor Ragnarok",JENIS_TIKET.Bronze, 150000));
    
        
        daftarTiket.tampilDaftarTiket();
    }
    
    public double cekInputNumber(String label){
       try {
           Scanner get_input = new Scanner(System.in);
           System.out.println(label);
           double nilai = get_input.nextDouble();
           
           return nilai;
       } catch(InputMismatchException ex) {
            System.out.println("Harap masukkan angka");
            return cekInputNumber(label);
        }
    }
    
}
