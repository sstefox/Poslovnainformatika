import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm:FormGroup;

  constructor(public fb:FormBuilder,public http:HttpClient,public router:Router) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      naziv:["", Validators.required],
      email:["", Validators.required],
      username:["", Validators.required],
      password:["", Validators.required],
    });
  }

  register(){
    this.http.post("http://localhost:8080/korisnik/register",this.registerForm.value).subscribe(data=>{
      console.log(data)
    })
  }

}
