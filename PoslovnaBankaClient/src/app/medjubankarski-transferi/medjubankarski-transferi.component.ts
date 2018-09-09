import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-medjubankarski-transferi',
  templateUrl: './medjubankarski-transferi.component.html',
  styleUrls: ['./medjubankarski-transferi.component.css']
})
export class MedjubankarskiTransferiComponent implements OnInit {

  transferi:any;
  constructor(public http:HttpClient) { }

  ngOnInit() {
    this.http.get("http://localhost:8080/mbt/dobavi").subscribe(data=>{
      console.log(data);
      this.transferi = data;
    })
  }

  generisiXml(id){
    this.http.post("http://localhost:8080/mbt/generisi",this.transferi[id]).subscribe(data=>{
      console.log(data);
    })
  }

}
