/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author DMA
 */
public class DaftarPegawai {
    // Property   
    private ArrayList<Pegawai> daftarPegawai;
    private int id_pegawai;
    private Pegawai pegawai;
    
    // Constructor
    public DaftarPegawai () {
        daftarPegawai = new ArrayList<Pegawai>();
    }
    
    // Method  
    
     public void tambahPegawai (Tiket tiket) {
        daftarPegawai.add(pegawai);
    }
    public void tampilDaftarPegawai () {
        System.out.println("======== MTIX 21 ========");
        
        for (int i = 0; i < daftarPegawai.size(); i++) {
            Pegawai p = daftarPegawai.get(i);
            System.out.println((i + 1) + ". " + p.getId() + "\t" + p.getNama());
        }
    }
    
     public Pegawai pilihPegawai(){
        try{
            Scanner input = new Scanner(System.in);
            
            System.out.println("Pegawai yang di pilih ");
            int id_pegawai = input.nextInt();
            
            // Get tiket berdasarkan kode_tiket, di -1 karena arrayList mulai dari 0
            Pegawai p = daftarPegawai.get(id_pegawai - 1);
            return p;
        } catch(IndexOutOfBoundsException err) {
            // Jika id_pegawai tidak ada, maka akan menuju sini
            System.out.println("[Netnot] Pegawai yang di pilih sedang libur");
            return pilihPegawai();
        } catch(InputMismatchException err) {
            // Jika input bukan berupa angka akan masuk kesini
            System.out.println("[Netnot] Mohon masukkan nomor id");
            return pilihPegawai();
        }        
    }
}
