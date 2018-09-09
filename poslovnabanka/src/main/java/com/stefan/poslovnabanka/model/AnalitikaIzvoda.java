package com.stefan.poslovnabanka.model;

import com.stefan.poslovnabanka.enums.TipGreske;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Range;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class AnalitikaIzvoda {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "broj_stavke", unique = false, nullable = false)
    private int broj_stavke;

    @Size(max = 256)
    @Column(name = "duznik", unique = false, nullable = false)
    private String duznik;

    @Size(max = 256)
    @Column(name = "svrha_placanja", unique = false, nullable = false)
    private String svrha_placanja;

    @Size(max = 256)
    @Column(name = "poverilac", unique = false, nullable = false)
    private String poverilac;

    @Column(name = "datum_prijema", unique = false, nullable = false)
    private Date datum_prijema;

    @Column(name = "datum_valute", unique = false, nullable = false)
    private Date datum_valute;

    @Size(max = 18)
    @Column(name = "racun_duznika", unique = false, nullable = false)
    private String racun_duznika;

    @Range(min=1,max=99)
    @Column(name = "model_zaduzenja", unique = false, nullable = false)
    private int model_zaduzenja;

    @Size(max = 20)
    @Column(name = "poziv_na_broj_zaduzenja", unique = false, nullable = false)
    private String poziv_na_broj_zaduzenja;

    @Size(max = 18)
    @Column(name = "racun_poverioca", unique = false, nullable = false)
    private String racun_poverioca;

    @Range(min=1,max=99)
    @Column(name = "model_odobrenja", unique = false, nullable = false)
    private int model_odobrenja;

    @Size(max = 20)
    @Column(name = "poziv_na_broj_odobrenja", unique = false, nullable = false)
    private String poziv_na_broj_odobrenja;

    @Column(name = "hitno", unique = false, nullable = false)
    private boolean hitno;

    @Range(min=1,max=999999999)
    @Column(precision = 2, name = "iznos", unique = false, nullable = false)
    private Double iznos;

    @Column(name = "tip_greske", unique = false, nullable = true)
    private TipGreske tip_greske;

    @Column(name = "status", unique = false, nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "valuta_id", referencedColumnName = "id", nullable = false)
    private Valuta valuta;
    
    @ManyToOne
    @JoinColumn(name = "transfer_id", referencedColumnName = "id", nullable = false)
    private MedjubankarskiTransfer medjubankarskiTransfer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBroj_stavke() {
		return broj_stavke;
	}

	public void setBroj_stavke(int broj_stavke) {
		this.broj_stavke = broj_stavke;
	}

	public String getDuznik() {
		return duznik;
	}

	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}

	public String getSvrha_placanja() {
		return svrha_placanja;
	}

	public void setSvrha_placanja(String svrha_placanja) {
		this.svrha_placanja = svrha_placanja;
	}

	public String getPoverilac() {
		return poverilac;
	}

	public void setPoverilac(String poverilac) {
		this.poverilac = poverilac;
	}

	public Date getDatum_prijema() {
		return datum_prijema;
	}

	public void setDatum_prijema(Date datum_prijema) {
		this.datum_prijema = datum_prijema;
	}

	public Date getDatum_valute() {
		return datum_valute;
	}

	public void setDatum_valute(Date datum_valute) {
		this.datum_valute = datum_valute;
	}

	public String getRacun_duznika() {
		return racun_duznika;
	}

	public void setRacun_duznika(String racun_duznika) {
		this.racun_duznika = racun_duznika;
	}

	public int getModel_zaduzenja() {
		return model_zaduzenja;
	}

	public void setModel_zaduzenja(int model_zaduzenja) {
		this.model_zaduzenja = model_zaduzenja;
	}

	public String getPoziv_na_broj_zaduzenja() {
		return poziv_na_broj_zaduzenja;
	}

	public void setPoziv_na_broj_zaduzenja(String poziv_na_broj_zaduzenja) {
		this.poziv_na_broj_zaduzenja = poziv_na_broj_zaduzenja;
	}

	public String getRacun_poverioca() {
		return racun_poverioca;
	}

	public void setRacun_poverioca(String racun_poverioca) {
		this.racun_poverioca = racun_poverioca;
	}

	public int getModel_odobrenja() {
		return model_odobrenja;
	}

	public void setModel_odobrenja(int model_odobrenja) {
		this.model_odobrenja = model_odobrenja;
	}

	public String getPoziv_na_broj_odobrenja() {
		return poziv_na_broj_odobrenja;
	}

	public void setPoziv_na_broj_odobrenja(String poziv_na_broj_odobrenja) {
		this.poziv_na_broj_odobrenja = poziv_na_broj_odobrenja;
	}

	public boolean isHitno() {
		return hitno;
	}

	public void setHitno(boolean hitno) {
		this.hitno = hitno;
	}

	public Double getIznos() {
		return iznos;
	}

	public void setIznos(Double iznos) {
		this.iznos = iznos;
	}

	public TipGreske getTip_greske() {
		return tip_greske;
	}

	public void setTip_greske(TipGreske tip_greske) {
		this.tip_greske = tip_greske;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public MedjubankarskiTransfer getMedjubankarskiTransfer() {
		return medjubankarskiTransfer;
	}

	public void setMedjubankarskiTransfer(MedjubankarskiTransfer medjubankarskiTransfer) {
		this.medjubankarskiTransfer = medjubankarskiTransfer;
	}
    
    

}
