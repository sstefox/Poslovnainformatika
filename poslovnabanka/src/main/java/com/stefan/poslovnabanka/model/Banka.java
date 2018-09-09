package com.stefan.poslovnabanka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Banka {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Size(max = 3)
    @Column(name = "sifra_banke", unique = true, nullable = false)
    private String sifra_banke;

    @Size(max = 10)
    @Column(name = "pib", unique = true, nullable = false)
    private String pib;

    @Size(max = 120)
    @Column(name = "naziv", unique = true, nullable = false)
    private String naziv;

    @Size(max = 120)
    @Column(name = "adresa", unique = true, nullable = false)
    private String adresa;

    @Size(max = 128)
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Size(max = 128)
    @Column(name = "web", unique = true, nullable = false)
    private String web;

    @Size(max = 20)
    @Column(name = "telefon", unique = true, nullable = false)
    private String telefon;

    @Size(max = 20)
    @Column(name = "fax", unique = true, nullable = false)
    private String fax;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSifra_banke() {
		return sifra_banke;
	}

	public void setSifra_banke(String sifra_banke) {
		this.sifra_banke = sifra_banke;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

    
    
}
