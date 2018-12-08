/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Persistence Entity Class

package warstwa_biznesowa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Student
 */
@Entity
public class Produkt1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazwa;
    private float cena;
    private int promocja;
    private String producent;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_produkcji;

    public Date getData_produkcji() {
	return data_produkcji;
    }

    public void setData_produkcji(Date data_produkcji) {
	this.data_produkcji = data_produkcji;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public float cena_brutto(){
        float cena_brutto = cena * (1-(float)promocja/100);
        return cena_brutto;
    }

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + Objects.hashCode(this.id);
		hash = 37 * hash + Objects.hashCode(this.nazwa);
		hash = 37 * hash + Float.floatToIntBits(this.cena);
		hash = 37 * hash + this.promocja;
		hash = 37 * hash + Objects.hashCode(this.producent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Produkt1 other = (Produkt1) obj;
		if (Float.floatToIntBits(this.cena) != Float.floatToIntBits(other.cena)) {
			return false;
		}
		if (this.promocja != other.promocja) {
			return false;
		}
		if (!Objects.equals(this.nazwa, other.nazwa)) {
			return false;
		}
		if (!Objects.equals(this.producent, other.producent)) {
			return false;
		}
		return true;
	}

    @Override
    public String toString() {
        return "warstwa_biznesowa.entity.Produkt1[ id=" + id + " ]";
    }
    
}
