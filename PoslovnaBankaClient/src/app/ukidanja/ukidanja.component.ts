import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-ukidanja',
  templateUrl: './ukidanja.component.html',
  styleUrls: ['./ukidanja.component.scss']
})
export class UkidanjaComponent implements OnInit {

  ukidanja:FormGroup;
  racuni:any;

  constructor(public fb:FormBuilder,public http:HttpClient) { }

  ngOnInit() {
    this.ukidanja = this.fb.group({

      datum_ukidanja:["", Validators.required],
      sredstva_se_prenose_na_racun:["", Validators.required],
      ukidanjeRacuna:["", Validators.required]
    });

    this.http.get("http://localhost:8080/racuniPravnihLica/dobaviSve").subscribe(data=>{
      console.log(data);
      this.racuni = data;
  
    });
  }

  potvrdiUkidanje(){
    this.racuni.forEach(element => {
      if(element['broj_racuna'] == this.ukidanja.value.ukidanjeRacuna){
        this.ukidanja.value.ukidanjeRacuna = element;
      }
    });
    console.log(this.ukidanja.value);
    this.http.post("http://localhost:8080/ukidanje/izvrsi",this.ukidanja.value).subscribe(data=>{
      console.log(data);
  
    });
  }

}
