package com.stefan.poslovnabanka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Drzava {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Range(min=1, max=999)
    @Column(name = "sifra_drzave", unique = true, nullable = false)
    private int sifra_drzave;

    @Size(max = 40)
    @Column(name = "naziv_drzave", unique = true, nullable = false)
    private String naziv_drzave;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSifra_drzave() {
		return sifra_drzave;
	}

	public void setSifra_drzave(int sifra_drzave) {
		this.sifra_drzave = sifra_drzave;
	}

	public String getNaziv_drzave() {
		return naziv_drzave;
	}

	public void setNaziv_drzave(String naziv_drzave) {
		this.naziv_drzave = naziv_drzave;
	}
    
    
}

