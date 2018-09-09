package com.stefan.poslovnabanka.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


import com.stefan.poslovnabanka.enums.TipGreske;

@XmlRootElement(name="nalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnalitikaIzvodaImport {

    private int broj_stavke;

    private String duznik;

    private String svrha_placanja;

    private String poverilac;

    private Date datum_prijema;

    private Date datum_valute;

    private String racun_duznika;

    private int model_zaduzenja;

    private String poziv_na_broj_zaduzenja;

    private String racun_poverioca;

    private int model_odobrenja;

    private String poziv_na_broj_odobrenja;

    private boolean hitno;

    private Double iznos;

    private TipGreske tip_greske;

    private boolean status;
    
    private String naziv_valute;
    
	public String getNaziv_valute() {
		return naziv_valute;
	}

	public void setNaziv_valute(String naziv_valute) {
		this.naziv_valute = naziv_valute;
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
    

}
