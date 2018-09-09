package com.stefan.poslovnabanka.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class NaseljenoMesto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "sifra_mesta", unique = true, nullable = false)
    private int sifra_mesta;

    @Size(max = 60)
    @Column(name = "naziv", unique = true, nullable = false)
    private String naziv;

    @Size(max = 12)
    @Column(name = "ptt_oznaka", unique = true, nullable = false)
    private String ptt_oznaka;

    @ManyToOne
    @JoinColumn(name = "drzava_id", referencedColumnName = "id", nullable = false)
    private Drzava drzava;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSifra_mesta() {
		return sifra_mesta;
	}

	public void setSifra_mesta(int sifra_mesta) {
		this.sifra_mesta = sifra_mesta;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPtt_oznaka() {
		return ptt_oznaka;
	}

	public void setPtt_oznaka(String ptt_oznaka) {
		this.ptt_oznaka = ptt_oznaka;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
    
    
}
