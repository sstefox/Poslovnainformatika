import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-home-navigation',
  templateUrl: './home-navigation.component.html',
  styleUrls: ['./home-navigation.component.css']
})
export class HomeNavigationComponent implements OnInit {

  constructor(public router:Router,public fb:FormBuilder,public http:HttpClient) { }

  ngOnInit() {
  }

  logout()
  {
    localStorage.clear();
    location.reload();
  }

}
