package com.stefan.poslovnabanka.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class KursUValuti {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Size(max = 9)
    @Column(precision = 4,name = "kupovni", unique = true, nullable = false)
    private Double kupovni;

    @Size(max = 9)
    @Column(precision = 4,name = "srednji", unique = true, nullable = false)
    private Double srednji;

    @Size(max = 9)
    @Column(precision = 4,name = "prodajni", unique = true, nullable = false)
    private Double prodajni;

    @ManyToOne
    @JoinColumn(name = "kursna_lista_id", referencedColumnName = "id", nullable = false)
    private KursnaLista kursnaLista;

    @ManyToOne
    @JoinColumn(name = "valuta_id", referencedColumnName = "id", nullable = false)
    private Valuta valuta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getKupovni() {
		return kupovni;
	}

	public void setKupovni(Double kupovni) {
		this.kupovni = kupovni;
	}

	public Double getSrednji() {
		return srednji;
	}

	public void setSrednji(Double srednji) {
		this.srednji = srednji;
	}

	public Double getProdajni() {
		return prodajni;
	}

	public void setProdajni(Double prodajni) {
		this.prodajni = prodajni;
	}

	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}

	public void setKursnaLista(KursnaLista kursnaLista) {
		this.kursnaLista = kursnaLista;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}
    
    
}
