/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Enterprise JavaBeans/Session Bean

package warstwa_biznesowa;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import javax.ejb.Stateless;
import warstwa_biznesowa.entity.Produkt1;

/**
 *
 * @author Student
 */
@Stateless
public class Fasada_warstwy_biznesowej {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    static long klucz = 0;
    private LinkedList<Produkt1> produkty = new LinkedList();
    boolean stan = false;

    public LinkedList<Produkt1> getProdukty() {
        return produkty;
    }

    public void setProdukty(LinkedList<Produkt1> produkty) {
        this.produkty = produkty;
    }
    
    public void utworz_produkt(String dane[], Date data){
        Produkt1 produkt = new Produkt1();
	klucz++;
	produkt.setId(new Long(klucz));
        produkt.setNazwa(dane[0]);
        produkt.setCena(Float.parseFloat(dane[1]));
        produkt.setPromocja(Integer.parseInt(dane[2]));
	produkt.setProducent(dane[3]);
	produkt.setData_produkcji(data);
	dodaj_produkt(produkt);
    }

    protected void dodaj_produkt(Produkt1 produkt){
	if (!produkty.contains(produkt)){
	    produkty.add(produkt);
	    stan = true;
	}else{
	    stan = false;
	}
    }
     
    public String[] dane_produktu(){
	if (stan){
	    Produkt1 produkt = produkty.get(produkty.size()-1);
	    String nazwa = produkt.getNazwa();
	    String cena = "" + produkt.getCena();
	    String promocja = "" + produkt.getPromocja();
	    String producent = "" + produkt.getProducent();
	    String cena_brutto = "" + produkt.cena_brutto();
	    String data = "" + produkt.getData_produkcji().getTime();
	    String dane[] = {nazwa, cena, promocja, producent, cena_brutto, data};
	    return dane;
	}
	return null;
    }
    
    public ArrayList<ArrayList<String>> items(){
	ArrayList<ArrayList<String>> dane = new ArrayList();
        for(Produkt1 p : produkty){
	    ArrayList<String> wiersz = new ArrayList();
	    wiersz.add(p.getId().toString());
	    wiersz.add(p.getNazwa());
	    wiersz.add("" + p.getCena());
	    wiersz.add("" + p.getPromocja());
	    wiersz.add("" + p.getProducent());
	    wiersz.add("" + p.cena_brutto());
	    wiersz.add(p.getData_produkcji().toString());
	    dane.add(wiersz);
	}
	return dane;
    }
}
