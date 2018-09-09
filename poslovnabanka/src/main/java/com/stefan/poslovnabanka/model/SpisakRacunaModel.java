package com.stefan.poslovnabanka.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SpisakRacunaModel {

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
	private String ime_banke;
	private String broj_racuna;
	private String novo_stanje;
	private String datum;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme_banke() {
		return ime_banke;
	}
	public void setIme_banke(String ime_banke) {
		this.ime_banke = ime_banke;
	}
	public String getBroj_racuna() {
		return broj_racuna;
	}
	public void setBroj_racuna(String broj_racuna) {
		this.broj_racuna = broj_racuna;
	}
	public String getNovo_stanje() {
		return novo_stanje;
	}
	public void setNovo_stanje(String novo_stanje) {
		this.novo_stanje = novo_stanje;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
}
