package com.example.fire;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahData extends AppCompatActivity {

    private DatabaseReference database;
    private Button simpan;
    private EditText nama_barang, merk_barang,harga_barang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        simpan= (Button) findViewById(R.id.simpandata);
        nama_barang= (EditText) findViewById(R.id.namaBarang);
        merk_barang= (EditText) findViewById(R.id.merkbarang);
        harga_barang=(EditText) findViewById(R.id.hargabarang);

        database = FirebaseDatabase.getInstance().getReference();

        final Barang barang = (Barang) getIntent().getSerializableExtra("data");




        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!IsEmpty(nama_barang.getText().toString())&&(!IsEmpty(merk_barang.getText().toString()))&&(!IsEmpty(harga_barang.getText().toString()))){
                    SimpanData(new Barang(nama_barang.getText().toString(),merk_barang.getText().toString(),harga_barang.getText().toString()));
                }else {
                    Toast.makeText(TambahData.this,"Maaf Inputan Anda Kosong",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public static Intent getActiveIntent(Activity activity){
        return new Intent(activity,TambahData.class);
    }
    private static boolean IsEmpty(String s){
        return TextUtils.isEmpty(s);

    }

    private void SimpanData (Barang barang){
        database.child("Barang").push().setValue(barang).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                nama_barang.setText(null);
                merk_barang.setText(null);
                harga_barang.setText(null);

                Toast.makeText(TambahData.this,"Inputan Berhasil",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void UpdateBarang(Barang barang) {
        database.child("Barang") //akses parent index, ibaratnya seperti nama tabel
                .child(barang.getKey()) //select barang berdasarkan key
                .setValue(barang) //set value barang yang baru
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        /**
                         * Baris kode yang akan dipanggil apabila proses update barang sukses
                         */
                        Snackbar.make(findViewById(R.id.simpandata), "Data berhasil diupdatekan", Snackbar.LENGTH_LONG).setAction("Oke", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        }).show();
                    }
                });
    }





}
