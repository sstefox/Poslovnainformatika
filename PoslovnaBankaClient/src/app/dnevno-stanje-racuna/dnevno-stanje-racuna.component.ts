import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-dnevno-stanje-racuna',
  templateUrl: './dnevno-stanje-racuna.component.html',
  styleUrls: ['./dnevno-stanje-racuna.component.scss']
})
export class DnevnoStanjeRacunaComponent implements OnInit {


  dnevnoStanje:FormGroup;
  stanja:any;

  constructor(public fb:FormBuilder,public http:HttpClient) { }

  ngOnInit() {

    this.http.get("http://localhost:8080/dnevnoStanje/dobaviSve").subscribe(data=>{
      console.log(data);
      this.stanja = data;
  
    });
  }

  
}
