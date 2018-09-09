import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-naseljena-mesta',
  templateUrl: './naseljena-mesta.component.html',
  styleUrls: ['./naseljena-mesta.component.scss']
})
export class NaseljenaMestaComponent implements OnInit {


  naseljenaMesta:FormGroup;
  drzave:any;

  constructor(public fb:FormBuilder,public http:HttpClient) { }

  ngOnInit() {
    this.naseljenaMesta = this.fb.group({

      sifra_mesta:["", Validators.required],
      naziv:["", Validators.required],
      ptt_oznaka:["", Validators.required],
      drzava:["", Validators.required]
    });

    this.http.get("http://localhost:8080/drzava/dobaviSve").subscribe(data=>{
      console.log(data);
      this.drzave = data;
  
    });
  }

  dodajMesto(){
    this.naseljenaMesta.value['drzava'] = this.drzave[this.naseljenaMesta.value['drzava']-1];
    this.http.post("http://localhost:8080/naseljenoMesto/sacuvaj",this.naseljenaMesta.value).subscribe(data=>{

      console.log(data);
    
    });

  }

}
