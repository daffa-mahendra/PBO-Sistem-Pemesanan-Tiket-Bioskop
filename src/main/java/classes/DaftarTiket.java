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
public class DaftarTiket {
    // Property   
    private ArrayList<Tiket> daftarTiket;
    
    // Constructor
    public DaftarTiket () {
        daftarTiket = new ArrayList<Tiket>();
    }
    
    // Method
    public void tambahTiket (Tiket tiket) {
        daftarTiket.add(tiket);
    }
    
    public void tampilDaftarTiket () {
        System.out.println("======== MTIX 21 ========");
        
        for (int i = 0; i < daftarTiket.size(); i++) {
            Tiket t = daftarTiket.get(i);
            System.out.println((i + 1) + ". " + t.getKodeTiket() + "\t" + t.getNamaFilm() + "\t" + t.getHargaTiket());
        }
    }
    
     public Tiket pilihTiket(){
        try{
            Scanner input = new Scanner(System.in);
            
            System.out.println("Kode Tiket yang dipilih : ");
            int kode_tiket = input.nextInt();
            
            // Get tiket berdasarkan kode_tiket, di -1 karena arrayList mulai dari 0
            Tiket t = daftarTiket.get(kode_tiket - 1);
            return t;
        } catch(IndexOutOfBoundsException err) {
            // Jika kode_tiket tidak ada, maka akan menuju sini
            System.out.println("[Netnot] Tiket tidak tersedia");
            return pilihTiket();
        } catch(InputMismatchException err) {
            // Jika input bukan berupa angka akan masuk kesini
            System.out.println("[Netnot] Mohon masukkan nomor tiket");
            return pilihTiket();
        }        
    }

  
}
