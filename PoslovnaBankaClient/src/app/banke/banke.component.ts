import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-banke',
  templateUrl: './banke.component.html',
  styleUrls: ['./banke.component.scss']
})
export class BankeComponent implements OnInit {

  banke:FormGroup;
  banka:any;
  banks:any;

  constructor(public fb:FormBuilder,public http:HttpClient) { }

  ngOnInit() {
    this.banke = this.fb.group({

      sifra_banke:["", Validators.required],
      pib:["", Validators.required],
      naziv:["", Validators.required],
      adresa:["", Validators.required],
      email:["", Validators.required],
      web:["", Validators.required],
      telefon:["", Validators.required],
      fax:["", Validators.required]
    });

    this.http.get("http://localhost:8080/banka/dobaviSve").subscribe(data=>{
      this.banks= data;
      console.log(data);
    });
  }

  unesiBanku(){
    console.log(this.banke.value)
    this.http.post("http://localhost:8080/banka/sacuvaj",this.banke.value).subscribe(data=>{
      console.log(data);
    });
  }

  generisiXML(){
    this.http.get("http://localhost:8080/banka/generisiXML/"+this.banka).subscribe(data=>{
      console.log(data);
    });
  }

}
