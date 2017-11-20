package com.doganoguz.stockbox;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class VeritabaniIsleme extends SQLiteOpenHelper {


	private static final int DATABASE_VERSIYON = 1;


	private static final String VERITABANI_ISMI = "DBRehber";


	private static final String TABLO_ISMI = "Kisiler";


	private static final String KISI_ID = "ID";
	private static final String KISI_ADISOYADI = "Adi_Soyadi";
	private static final String KISI_TELNO = "Tel_No";
	private static final String KISI_EMAIL ="EMail";

	public VeritabaniIsleme(Context context) {

		super(context, VERITABANI_ISMI, null, DATABASE_VERSIYON);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		String KISILER_TABLOSU_OLUSTUR = "CREATE TABLE " + TABLO_ISMI + "("
				+ KISI_ID + " INTEGER PRIMARY KEY," + KISI_ADISOYADI + " TEXT,"
				+ KISI_TELNO + " TEXT" + ","+ KISI_EMAIL +" TEXT" + ")";
		db.execSQL(KISILER_TABLOSU_OLUSTUR);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL("DROP TABLE IF EXISTS " + TABLO_ISMI);

		onCreate(db);
	}


	void kayitEkle(Kisiler _kisi) {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues kisi = new ContentValues();
		kisi.put(KISI_ADISOYADI, _kisi.getAdiSoyadi()); 
		kisi.put(KISI_TELNO, _kisi.getTelNo());  
		kisi.put(KISI_EMAIL, _kisi.getEmail()); 

		db.insert(TABLO_ISMI, null, kisi);

		db.close(); 
	}


	Kisiler kayitGetir(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLO_ISMI, new String[] { KISI_ID,
				KISI_ADISOYADI, KISI_TELNO,KISI_EMAIL }, KISI_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Kisiler kisiKayitlar = new Kisiler(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2),cursor.getString(3));
		return kisiKayitlar;
	}
	
	/*T�m kay�tlar� getir:*/
	public List<Kisiler> kayitlariGetir() {
		List<Kisiler> kisilerListesi = new ArrayList<Kisiler>();
		/*t�m kay�tlara sorgu olu�tur:*/
		String selectQuery = "SELECT  * FROM " + TABLO_ISMI;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {//ilk kay�t
			do {
				Kisiler kisi = new Kisiler();
				kisi.setID(Integer.parseInt(cursor.getString(0)));
				kisi.setAdiSoyadi(cursor.getString(1));
				kisi.setTelNo(cursor.getString(2));
				kisi.setEmail(cursor.getString(3));
				/*Ki�iler listesine ekle:*/
				kisilerListesi.add(kisi);
			} while (cursor.moveToNext());
		}
		return kisilerListesi;
	}

	/*Kayit g�ncelle:*/
	public int kayitGuncelle(Kisiler _kisi) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues kayit = new ContentValues();
		kayit.put(KISI_ADISOYADI, _kisi.getAdiSoyadi());
		kayit.put(KISI_TELNO, _kisi.getTelNo());
       int durum = db.update(TABLO_ISMI, kayit, KISI_ID + " = ?",
				new String[] { String.valueOf(_kisi.getID()) });
		return durum;
	}

	/*Kay�t sil:*/
	public void kayitSil(Kisiler _kisi) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLO_ISMI, KISI_ID + " = ?",
				new String[] { String.valueOf(_kisi.getID()) });
		db.close();
	}

	/*Kay�t say�s�n� getir:*/
	public int kayitSayisi() {
		String sorgu = "SELECT  * FROM " + TABLO_ISMI;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(sorgu, null);
		cursor.close();
		int sayi = cursor.getCount();
		return sayi;
	}

}
