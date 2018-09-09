import { Component, OnInit } from '@angular/core';
import { fail } from 'assert';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  user:boolean;

  constructor() { }

  ngOnInit() {
    console.log(localStorage.getItem("user"))
    this.user = localStorage.getItem("user") == null ? false : true;
  }

}
