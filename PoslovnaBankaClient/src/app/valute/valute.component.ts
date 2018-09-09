import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-valute',
  templateUrl: './valute.component.html',
  styleUrls: ['./valute.component.scss']
})
export class ValuteComponent implements OnInit {

  valute:FormGroup;
  drzave:any;

  constructor(public fb:FormBuilder,public http:HttpClient) { }

  ngOnInit() {
    this.valute = this.fb.group({

      zvanicna_sifra:["", Validators.required],
      naziv:["", Validators.required],
      domicilna:["", Validators.required],
      drzava:["", Validators.required]
    });

    this.http.get("http://localhost:8080/drzava/dobaviSve").subscribe(data=>{
      console.log(data);
      this.drzave = data;
  
    });
  }

  sacuvajValutu(){
    this.valute.value['drzava'] = this.drzave[this.valute.value['drzava']-1];
    this.http.post("http://localhost:8080/valuta/sacuvaj",this.valute.value).subscribe(data=>{

      console.log(data);
    
    });
  }

}
