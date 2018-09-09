package com.stefan.poslovnabanka.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class RacuniPravnihLica {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Size(max = 18)
    @Column(name = "broj_racuna", unique = true, nullable = false)
    private String broj_racuna;

    @Column(name = "datum_otvaranja", unique = false, nullable = false)
    private Date datum_otvaranja;

    @Column(name = "vazeci", unique = false, nullable = false)
    private boolean vazeci;

    @ManyToOne
    @JoinColumn(name = "klijent_id", referencedColumnName = "id", nullable = false)
    private Klijent vlasnik_racuna;

    @ManyToOne
    @JoinColumn(name = "banka_id", referencedColumnName = "id", nullable = false)
    private Banka poslovna_banka;

    @ManyToOne
    @JoinColumn(name = "valuta", referencedColumnName = "id", nullable = false)
    private Valuta valuta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBroj_racuna() {
		return broj_racuna;
	}

	public void setBroj_racuna(String broj_racuna) {
		this.broj_racuna = broj_racuna;
	}

	public Date getDatum_otvaranja() {
		return datum_otvaranja;
	}

	public void setDatum_otvaranja(Date datum_otvaranja) {
		this.datum_otvaranja = datum_otvaranja;
	}

	public boolean isVazeci() {
		return vazeci;
	}

	public void setVazeci(boolean vazeci) {
		this.vazeci = vazeci;
	}

	public Klijent getVlasnik_racuna() {
		return vlasnik_racuna;
	}

	public void setVlasnik_racuna(Klijent vlasnik_racuna) {
		this.vlasnik_racuna = vlasnik_racuna;
	}

	public Banka getPoslovna_banka() {
		return poslovna_banka;
	}

	public void setPoslovna_banka(Banka poslovna_banka) {
		this.poslovna_banka = poslovna_banka;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}
    
    
}
