package com.stefan.poslovnabanka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Klijent {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Size(max = 120)
    @Column(name = "naziv_klijenta", unique = false, nullable = false)
    private String naziv_klijenta;

    @Column(name = "username", unique = false, nullable = false)
    private String username;
    
    @Column(name = "adresa", unique = false, nullable = false)
    private String adresa;
    
    @Column(name = "telefon", unique = false, nullable = false)
    private String telefon;
    
    @Column(name = "maticni_broj", unique = true, nullable = false)
    private String maticni_broj;
    
    @Column(name = "pib", unique = true, nullable = false)
    private String pib;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", unique = false, nullable = false)
    private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv_klijenta() {
		return naziv_klijenta;
	}

	public void setNaziv_klijenta(String naziv_klijenta) {
		this.naziv_klijenta = naziv_klijenta;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getMaticni_broj() {
		return maticni_broj;
	}

	public void setMaticni_broj(String maticni_broj) {
		this.maticni_broj = maticni_broj;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    
}
