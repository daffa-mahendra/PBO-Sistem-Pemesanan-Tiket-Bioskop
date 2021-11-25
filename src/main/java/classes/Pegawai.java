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
public class Pegawai {
    String  id_pegawai, nama, alamat;
    private final JENIS_KELAMIN jenis_kelamin;
    
     public enum JENIS_KELAMIN {
        L, 
        P
    }
    
    public Pegawai (String id_pegawai, String nama, String alamat, JENIS_KELAMIN jenis_kelamin)
        
    {
        this.id_pegawai = id_pegawai;
        this.nama = nama;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
    }
     public String getId () {
        return id_pegawai;
    }
    
    public String getNama () {
        return nama;
    }
      public String getAlamat () {
        return alamat;
    }
    public JENIS_KELAMIN getJenisKelamin () {
        return jenis_kelamin;
    }
}

