import java.sql.Date;

public class Bilet {
int bilet_id;
int bilet_sayısı;
int bilet_fiyatı;
Date tarih;
public Bilet(int bilet_id, int bilet_sayısı, int bilet_fiyatı, Date tarih) {
	super();
	this.bilet_id = bilet_id;
	this.bilet_sayısı = bilet_sayısı;
	this.bilet_fiyatı = bilet_fiyatı;
	this.tarih = tarih;
}


}
