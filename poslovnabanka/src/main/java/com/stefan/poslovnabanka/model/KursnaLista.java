package com.stefan.poslovnabanka.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class KursnaLista {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "datum", unique = true, nullable = false)
    private Date datum;

    @Size(max = 3)
    @Column(name = "broj_kursne_liste", unique = true, nullable = false)
    private int broj_kursne_liste;

    @Column(name = "primenjuje_se_od", unique = true, nullable = false)
    private Date primenjuje_se_od;

    @ManyToOne
    @JoinColumn(name = "banka_id", referencedColumnName = "id", nullable = false)
    private Banka banka;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getBroj_kursne_liste() {
		return broj_kursne_liste;
	}

	public void setBroj_kursne_liste(int broj_kursne_liste) {
		this.broj_kursne_liste = broj_kursne_liste;
	}

	public Date getPrimenjuje_se_od() {
		return primenjuje_se_od;
	}

	public void setPrimenjuje_se_od(Date primenjuje_se_od) {
		this.primenjuje_se_od = primenjuje_se_od;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}
    
    
}
