import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Validators } from '@angular/forms';
import { PapaParseService } from 'ngx-papaparse';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-analitike-izvoda',
  templateUrl: './analitike-izvoda.component.html',
  styleUrls: ['./analitike-izvoda.component.scss']
})
export class AnalitikeIzvodaComponent implements OnInit {

  analitikeIzvoda:FormGroup;
  valute:any;
  mesta:any;
  racuni:any;
  xmlFile:any;
  xml:any;
  analitike:any;

  constructor(public fb:FormBuilder,public http:HttpClient) { }

  ngOnInit() {
    this.analitikeIzvoda = this.fb.group({

      broj_stavke:["", Validators.required],
      duznik:["", Validators.required],
      svrha_placanja:["", Validators.required],
      poverilac:["", Validators.required],
      datum_prijema:["", Validators.required],
      datum_valute:["", Validators.required],
      racun_duznika:["", Validators.required],
      model_zaduzenja:["", Validators.required],
      poziv_na_broj_zaduzenja:["", Validators.required],
      racun_poverioca:["", Validators.required],
      model_odobrenja:["", Validators.required],
      poziv_na_broj_odobrenja:["", Validators.required],
      hitno:["", Validators.required],
      iznos:["", Validators.required],
      vrste_placanja:["", Validators.required],
      naseljeno_mesto:["", Validators.required],
      valuta:["", Validators.required]
    });

    this.http.get("http://localhost:8080/valuta/dobaviSve").subscribe(data=>{
      console.log(data);
      this.valute = data;
  
    });

    this.http.get("http://localhost:8080/racuniPravnihLica/dobaviSve").subscribe(data=>{
      console.log(data);
      this.racuni = data;
  
    });

    this.http.get("http://localhost:8080/naseljenoMesto/dobaviSve").subscribe(data=>{
      console.log(data);
      this.mesta = data;
  
    });
    this.http.get("http://localhost:8080/analitika/dobaviSve").subscribe(data=>{
      console.log(data);
      this.analitike = data;
  
    });
  }

  izvrsiTransfer(){
    console.log(this.valute);
    this.valute.forEach(element => {
      if(element['id'] == this.analitikeIzvoda.value.valuta){
        this.analitikeIzvoda.value.valuta = element;
      }
    });
    console.log(this.analitikeIzvoda.value);
    this.http.post("http://localhost:8080/analitika/uplata",this.analitikeIzvoda.value).subscribe(data=>{

      console.log(data);
    
    });
  }

  izvrsiKliring(){
    this.http.post("http://localhost:8080/analitika/izvrsiKliring",this.analitikeIzvoda.value).subscribe(data=>{

      console.log(data);
    
    });
  }

  public fileChangeEvent(files: any){
    this.xml = files.item(0);
    console.log(this.xml);
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'undefined'
      })
    };

    const formdata: FormData = new FormData();
 
    formdata.append('file', this.xml);
    this.http.post("http://localhost:8080/analitika/uploadXML",formdata).subscribe(data=>{

      console.log(data);
    
    });
  }
}
