import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-klijenti',
  templateUrl: './klijenti.component.html',
  styleUrls: ['./klijenti.component.css']
})
export class KlijentiComponent implements OnInit {

  registerForm:FormGroup;
  korisnici:any;

  constructor(public fb:FormBuilder,public http:HttpClient,public router:Router) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      naziv_klijenta:["", Validators.required],
      email:["", Validators.required],
      adresa:["", Validators.required],
      telefon:["", Validators.required],
      maticni_broj:["", Validators.required],
      pib:["", Validators.required],
      username:["", Validators.required],
      password:["", Validators.required],
    });

    this.http.get("http://localhost:8080/korisnik/dobaviSve").subscribe(data=>{
      this.korisnici = data;
      console.log(data)
    })
  }

  register(){
    this.http.post("http://localhost:8080/korisnik/register",this.registerForm.value).subscribe(data=>{
      console.log(data)
    })
  }

}
