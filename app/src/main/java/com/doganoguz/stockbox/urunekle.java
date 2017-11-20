package com.doganoguz.stockbox;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Doğan Oğuz on 8.02.2016.
 */
public class urunekle  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.urunekle);
        //
        final EditText edit_adisoyadi = (EditText)findViewById(com.doganoguz.stockbox.R.id.edit_adiSoyadi);
        final EditText edit_telno = (EditText)findViewById(com.doganoguz.stockbox.R.id.edit_telno);
        final EditText edit_email = (EditText)findViewById(com.doganoguz.stockbox.R.id.edit_email);
        Button btn_yeni = (Button)findViewById(com.doganoguz.stockbox.R.id.button_yeni);
        Button btn_ekle = (Button)findViewById(com.doganoguz.stockbox.R.id.button_ekle);
        Button btn_liste = (Button)findViewById(com.doganoguz.stockbox.R.id.button_liste);
        Button btn_sil = (Button)findViewById(com.doganoguz.stockbox.R.id.button_sil);
        Button btn_guncel = (Button)findViewById(R.id.button_guncel);



        btn_yeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_adisoyadi.setText("");
                edit_telno.setText("");
                edit_email.setText("");


            }
        });
        btn_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adi_soyadi = edit_adisoyadi.getText().toString();
                String tel_no = edit_telno.getText().toString();
                String email = edit_email.getText().toString();

                VeritabaniIsleme veritabani = new VeritabaniIsleme(getApplicationContext());
	   /*kay�t ekle:*/
                veritabani.kayitEkle(new Kisiler(adi_soyadi, tel_no, email));

                Toast.makeText(getApplicationContext(), "Ürün Başarıyla Eklendi.", Toast.LENGTH_LONG).show();

            }
        });

        btn_liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),listele.class);
                startActivity(intent);
            }
        });

        btn_sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String adi_soyadi = edit_adisoyadi.getText().toString();
                String tel_no = edit_telno.getText().toString();
                String email = edit_email.getText().toString();

                VeritabaniIsleme veritabani = new VeritabaniIsleme(getApplicationContext());

                veritabani.kayitSil(new Kisiler(adi_soyadi, tel_no, email));

                Toast.makeText(getApplicationContext(), "Ürün Başarıyla Silindi.", Toast.LENGTH_LONG).show();

            }
        });
        btn_guncel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String adi_soyadi = edit_adisoyadi.getText().toString();
                String tel_no = edit_telno.getText().toString();
                String email = edit_email.getText().toString();

                VeritabaniIsleme veritabani = new VeritabaniIsleme(getApplicationContext());

                veritabani.kayitGuncelle(new Kisiler(adi_soyadi, tel_no, email));

                Toast.makeText(getApplicationContext(), "Ürün Başarıyla Güncellendi.", Toast.LENGTH_LONG).show();

            }
        });

    }//onCreate


}

