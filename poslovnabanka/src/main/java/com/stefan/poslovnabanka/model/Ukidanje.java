package com.stefan.poslovnabanka.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Ukidanje {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "datum_ukidanja", unique = true, nullable = false)
    private Date datum_ukidanja;

    @Size(max = 20)
    @Column(name = "sredstva_se_prenose_na_racun", unique = true, nullable = false)
    private String sredstva_se_prenose_na_racun;

    @ManyToOne
    @JoinColumn(name = "racuni_id", referencedColumnName = "id", nullable = false)
    private RacuniPravnihLica ukidanjeRacuna;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum_ukidanja() {
		return datum_ukidanja;
	}

	public void setDatum_ukidanja(Date datum_ukidanja) {
		this.datum_ukidanja = datum_ukidanja;
	}

	public String getSredstva_se_prenose_na_racun() {
		return sredstva_se_prenose_na_racun;
	}

	public void setSredstva_se_prenose_na_racun(String sredstva_se_prenose_na_racun) {
		this.sredstva_se_prenose_na_racun = sredstva_se_prenose_na_racun;
	}

	public RacuniPravnihLica getUkidanjeRacuna() {
		return ukidanjeRacuna;
	}

	public void setUkidanjeRacuna(RacuniPravnihLica ukidanjeRacuna) {
		this.ukidanjeRacuna = ukidanjeRacuna;
	}
    
    
}
