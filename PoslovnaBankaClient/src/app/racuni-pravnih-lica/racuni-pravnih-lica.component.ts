import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-racuni-pravnih-lica',
  templateUrl: './racuni-pravnih-lica.component.html',
  styleUrls: ['./racuni-pravnih-lica.component.scss']
})
export class RacuniPravnihLicaComponent implements OnInit {

  valute:any;
  banke:any;
  klijenti:any;
  vazeci:boolean = false;
  racunPravnihLica:FormGroup;
  datumod:any;
  datumdo:any;
  racuni:any;
  odabraniKlijent:any;

  constructor(public fb:FormBuilder,public http:HttpClient) { }

  ngOnInit() {

    this.racunPravnihLica = this.fb.group({

      broj_racuna:["", Validators.required],
      datum_otvaranja:["", Validators.required],
      vlasnik_racuna:["", Validators.required],
      naseljeno_mesto:["", Validators.required],
      poslovna_banka:["", Validators.required],
      valuta:["", Validators.required]
    });

    this.http.get("http://localhost:8080/valuta/dobaviSve").subscribe(data=>{
      console.log(data);
      this.valute = data;
  
    });

    this.http.get("http://localhost:8080/banka/dobaviSve").subscribe(data=>{
      console.log(data);
      this.banke = data;
  
    });

    this.http.get("http://localhost:8080/racuniPravnihLica/dobaviSve").subscribe(data=>{
      console.log(data);
      this.racuni = data;
  
    });

    this.http.get("http://localhost:8080/korisnik/dobaviSve").subscribe(data=>{
      console.log(data);
      this.klijenti = data;
  
    });
  }

  dodaj()
  {
    this.valute.forEach(element => {
      if(element['id'] == this.racunPravnihLica.value.valuta){
        this.racunPravnihLica.value.valuta = element;
      }
    });
    this.banke.forEach(element => {
      if(element['id'] == this.racunPravnihLica.value.poslovna_banka){
        this.racunPravnihLica.value.poslovna_banka = element;
      }
    });
    this.klijenti.forEach(element => {
      if(element['id'] == this.racunPravnihLica.value.vlasnik_racuna){
        this.racunPravnihLica.value.vlasnik_racuna = element;
      }
    });
    console.log(this.racunPravnihLica.value);
    this.http.post("http://localhost:8080/racuniPravnihLica/sacuvaj",this.racunPravnihLica.value).subscribe(data=>{

      console.log(data);
    
    });
  }

  generisiPDF(){
    this.racuni.forEach(element => {
      if(element['id'] == this.odabraniKlijent){
        this.odabraniKlijent = element;
      }
    });
    console.log(this.odabraniKlijent);
    this.http.post("http://localhost:8080/korisnik/generisi/"+this.datumod+"/"+this.datumdo,this.odabraniKlijent).subscribe(data=>{
      console.log(data)
    })
  }

}
