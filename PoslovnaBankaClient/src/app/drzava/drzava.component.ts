import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-drzava',
  templateUrl: './drzava.component.html',
  styleUrls: ['./drzava.component.scss']
})
export class DrzavaComponent implements OnInit {

  drzava:FormGroup;
  drzave:any;

  constructor(public fb:FormBuilder,public http:HttpClient) { }

  ngOnInit() {
    this.drzava = this.fb.group({

      sifra_drzave:["", Validators.required],
      naziv_drzave:["", Validators.required]
    });

    this.http.get("http://localhost:8080/drzava/dobaviSve").subscribe(data=>{
      console.log(data);
      this.drzave = data;
    });
  }

  unesiDrzavu()
  {
    this.http.post("http://localhost:8080/drzava/sacuvaj",this.drzava.value).subscribe(data=>{
      console.log(data);
    });
  }

}
