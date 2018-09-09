import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-kursna-lista',
  templateUrl: './kursna-lista.component.html',
  styleUrls: ['./kursna-lista.component.scss']
})
export class KursnaListaComponent implements OnInit {

  kursnaLista:FormGroup;

  constructor(public fb:FormBuilder,public http:HttpClient) { }

  ngOnInit() {
    this.kursnaLista = this.fb.group({

      datum:["", Validators.required],
      broj_kursne_liste:["", Validators.required],
      primenjuje_se_od:["", Validators.required],
      banka:["", Validators.required]
    });
  }

}
