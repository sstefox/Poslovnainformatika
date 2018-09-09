package com.stefan.poslovnabanka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class VrstePlacanja {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Size(max = 3)
    @Column(name = "oznaka_vrste", unique = true, nullable = false)
    private int oznaka_vrste;

    @Size(max = 120)
    @Column(name = "naziv_vrste_placanja", unique = true, nullable = false)
    private String naziv_vrste_placanja;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOznaka_vrste() {
		return oznaka_vrste;
	}

	public void setOznaka_vrste(int oznaka_vrste) {
		this.oznaka_vrste = oznaka_vrste;
	}

	public String getNaziv_vrste_placanja() {
		return naziv_vrste_placanja;
	}

	public void setNaziv_vrste_placanja(String naziv_vrste_placanja) {
		this.naziv_vrste_placanja = naziv_vrste_placanja;
	}
    
    
}
