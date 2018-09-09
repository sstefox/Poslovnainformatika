package com.stefan.poslovnabanka.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Valuta {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Size(max = 3)
    @Column(name = "zvanicna_sifra", unique = true, nullable = false)
    private String zvanicna_sifra;

    @Size(max = 30)
    @Column(name = "naziv", unique = true, nullable = false)
    private String naziv;

    @Column(name = "domicilna", nullable = false)
    private boolean domicilna;

    @ManyToOne
    @JoinColumn(name = "drzava_id", referencedColumnName = "id", nullable = false)
    private Drzava drzava;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZvanicna_sifra() {
		return zvanicna_sifra;
	}

	public void setZvanicna_sifra(String zvanicna_sifra) {
		this.zvanicna_sifra = zvanicna_sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public boolean isDomicilna() {
		return domicilna;
	}

	public void setDomicilna(boolean domicilna) {
		this.domicilna = domicilna;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
    
    

}
