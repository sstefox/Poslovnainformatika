package com.stefan.poslovnabanka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class DnevnoStanjeRacuna {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "broj_izvoda", unique = false, nullable = false)
    private int broj_izvoda;

    @Column(name = "datum_prometa", unique = false, nullable = false)
    private Date datum_prometa;

    
    @Column(precision = 2,name = "prethodno_stanje", unique = false, nullable = false)
    private Double prethodno_stanje;

    
    @Column(precision = 2,name = "promet_u_korist", unique = false, nullable = false)
    private Double promet_u_korist;

    
    @Column(precision = 2,name = "promet_na_teret", unique = false, nullable = false)
    private Double promet_na_teret;

    
    @Column(precision = 2,name = "novo_stanje", unique = false, nullable = false)
    private Double novo_stanje;
    
    @ManyToOne
    @JoinColumn(name = "racuniPravnihLica", referencedColumnName = "id", nullable = false)
    private RacuniPravnihLica racuniPravnihLica;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBroj_izvoda() {
		return broj_izvoda;
	}

	public void setBroj_izvoda(int broj_izvoda) {
		this.broj_izvoda = broj_izvoda;
	}

	public RacuniPravnihLica getRacuniPravnihLica() {
		return racuniPravnihLica;
	}

	public void setRacuniPravnihLica(RacuniPravnihLica racuniPravnihLica) {
		this.racuniPravnihLica = racuniPravnihLica;
	}

	public Date getDatum_prometa() {
		return datum_prometa;
	}

	public void setDatum_prometa(Date datum_prometa) {
		this.datum_prometa = datum_prometa;
	}

	public Double getPrethodno_stanje() {
		return prethodno_stanje;
	}

	public void setPrethodno_stanje(Double prethodno_stanje) {
		this.prethodno_stanje = prethodno_stanje;
	}

	public Double getPromet_u_korist() {
		return promet_u_korist;
	}

	public void setPromet_u_korist(Double promet_u_korist) {
		this.promet_u_korist = promet_u_korist;
	}

	public Double getPromet_na_teret() {
		return promet_na_teret;
	}

	public void setPromet_na_teret(Double promet_na_teret) {
		this.promet_na_teret = promet_na_teret;
	}

	public Double getNovo_stanje() {
		return novo_stanje;
	}

	public void setNovo_stanje(Double novo_stanje) {
		this.novo_stanje = novo_stanje;
	}

}
