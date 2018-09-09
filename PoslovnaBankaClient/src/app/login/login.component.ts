import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  LoginForm:FormGroup;

  constructor(public fb:FormBuilder,public http:HttpClient,public router:Router) { }

  ngOnInit() {
    this.LoginForm = this.fb.group({

      email:["", Validators.required],
      password:["", Validators.required]
    });
  }


  login(){
    this.http.post("http://localhost:8080/korisnik/login",this.LoginForm.value).subscribe(data=>{
      console.log(data);
      if(data != null){
        localStorage.setItem("user",JSON.stringify(data));
        location.reload();
      }
      
    })
  }

  registerNav(){
    this.router.navigate(["/register"]);
  }

}
