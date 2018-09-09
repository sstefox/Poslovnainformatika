package com.stefan.poslovnabanka.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MedjubankarskiTransfer {

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
	
	@Column(nullable = true)
	public Date datum;
	
	@ManyToOne
	public Banka bankaPrimalac;

	@ManyToOne
	public Banka bankaPosiljalac;

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

	public Banka getBankaPrimalac() {
		return bankaPrimalac;
	}

	public void setBankaPrimalac(Banka bankaPrimalac) {
		this.bankaPrimalac = bankaPrimalac;
	}

	public Banka getBankaPosiljalac() {
		return bankaPosiljalac;
	}

	public void setBankaPosiljalac(Banka bankaPosiljalac) {
		this.bankaPosiljalac = bankaPosiljalac;
	}

}
