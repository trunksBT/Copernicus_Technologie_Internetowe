/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// JavaServerFaces/JSF Managed Bean

package warstwa_internetowa;

import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.NumberConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import warstwa_biznesowa.Fasada_warstwy_biznesowej;

/**
 *
 * @author Student
 */
@Named(value = "managed_produkt")
@RequestScoped
public class Managed_produkt {
   
    @EJB
    private Fasada_warstwy_biznesowej fasada;
    private String nazwa;
    private float cena;
    private int promocja;
    private String producent;
    private float cena_brutto;
    private DataModel items;
    private int stan = 1;
    private Date data_produkcji;
    private NumberConverter number_convert=new NumberConverter();
    
    public Managed_produkt() {
    }
    
    public Fasada_warstwy_biznesowej getFasada(){
        return fasada;
    }

    public void setFasada(Fasada_warstwy_biznesowej fasada){
        this.fasada = fasada;
    }
    
    public NumberConverter getNumber_convert(){
	this.number_convert.setPattern("######.##zł");
	return number_convert;
    }
    
    public void setNumber_convert(NumberConverter Number_convert){
	this.number_convert = Number_convert;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
    
    public int getPromocja() {
        return promocja;
    }

    public void setPromocja(int promocja) {
        this.promocja = promocja;
    }
    
    public float getCena_brutto() {
        return cena_brutto;
    }

    public void setCena_brutto(float cena_brutto) {
        this.cena_brutto = cena_brutto;
    }
    
    public Date getData_produkcji() {
 	return data_produkcji;
    }

    public void setData_produkcji(Date data_produkcji) {
	this.data_produkcji = data_produkcji;
    }

    public DataModel utworz_DataModel(){
	return new ListDataModel(fasada.items());
    }
    
    public DataModel getItems(){
	if (items == null){
	    items = utworz_DataModel();
	}
	return items;
    }
    
    public void setItems(DataModel items){
	this.items = items;
    }
    
    public int getStan(){
	return stan;
    }
    
    public void setStan(int stan){
	this.stan = stan;
    }
    
    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String dodaj_produkt(){
        String dane[] = {nazwa, ""+cena, ""+promocja, producent};
        fasada.utworz_produkt(dane, data_produkcji);
        dane_produktu();
        return "rezultat2";
    }

    public void dane_produktu(){
	stan = 1;
        String[] dane = fasada.dane_produktu();
	if (dane == null){
	    stan = 0;
	} else {
            nazwa=dane[0];
            cena=Float.parseFloat(dane[1]);
            promocja=Integer.parseInt(dane[2]);
	    producent=dane[3];
            data_produkcji.setTime(Long.parseLong(dane[4]));
	    cena_brutto=Float.parseFloat(dane[5]);
	}
    }
}
