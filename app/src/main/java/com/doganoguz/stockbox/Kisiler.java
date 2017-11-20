package com.doganoguz.stockbox;

public class Kisiler {

	int ID;
	String ADI_SOYADI;
	String TEL_NO;
	String E_MAIL;
	
	/*Constructor(Yap�land�r�c�):1*/
	public Kisiler(){
		//varsay�lan...
	}
	/*Constructor(Yap�land�r�c�):2*/
	public Kisiler(int _ID, String _adisoyadi, String _telno,String _email){
		this.ID = _ID;
		this.ADI_SOYADI = _adisoyadi;
		this.TEL_NO = _telno;
		this.E_MAIL = _email;
	}
	
	/*Constructor(Yap�land�r�c�):3*/
	public Kisiler(String _adisoyadi, String _telno,String _email){
		this.ADI_SOYADI = _adisoyadi;
		this.TEL_NO = _telno;
		this.E_MAIL = _email;
	}
	
	/*ID ayarla:*/
	public void setID(int _ID){
		this.ID = _ID;
    }
		
	/*ID bilgisini �a��r:*/
	public int getID(){
		return this.ID;
	}
	
	/*Ad� soyad� ayarla:*/
	public void setAdiSoyadi(String _adisoyadi){
		this.ADI_SOYADI = _adisoyadi;
	}
	/*Ad� soyad� bilgisini �a��r:*/
	public String getAdiSoyadi(){
		return this.ADI_SOYADI;
	}	
	
	/*Telefon numaras� ayarla:*/
	public void setTelNo(String _telno){
			this.TEL_NO = _telno;
	}
	/*Telefon numaras� bilgisini �a��r:*/
	public String getTelNo(){
		return this.TEL_NO;
	}
	
	/*Email bilgisi ayarla:*/
	public void setEmail(String _email){
		this.E_MAIL = _email;
	}
	/*Email bilgisini �a��r:*/
	public String getEmail(){
		return this.E_MAIL;
	}
}
