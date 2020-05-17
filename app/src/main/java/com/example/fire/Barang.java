package com.example.fire;

public class Barang {

    private String nama;
    private String merk;
    private String harga;
    private String key;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String toString(){
        return " "+nama+"\n"+
                " "+merk+"\n"+
                " "+harga;
    }
    public Barang(String nm, String mrk, String hrg){
        nama    = nm;
        merk    = mrk;
        harga   = hrg;
    }

}
