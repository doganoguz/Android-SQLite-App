package com.doganoguz.stockbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Doğan Oğuz on 8.02.2016.
 */
public class listele extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listele);
        //
        TextView text = (TextView)findViewById(com.doganoguz.stockbox.R.id.textView1);
        //
        /*t�m kay�tlar� oku:*/
        VeritabaniIsleme veritabani = new VeritabaniIsleme(this);
        List<Kisiler> kisilerListesi = veritabani.kayitlariGetir();
        StringBuilder str = new StringBuilder();
        for (Kisiler kisi : kisilerListesi) {
            String kayit = "Ürün Id: "+kisi.getID()+"\nÜrün Adı: " + kisi.getAdiSoyadi() + "\nÜrün Adeti: " + kisi.getTelNo() + "\nKategori: "+kisi.getEmail();
            str.append(kayit+"\n------------------------------------------------------------\n");
        }//for
        text.setText(str);
    }//onCreate

}
