import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { appRoutes } from '../router';
import { NavigationComponent } from './navigation/navigation.component';
import { HomeNavigationComponent } from './home-navigation/home-navigation.component';
import { AnalitikeIzvodaComponent } from './analitike-izvoda/analitike-izvoda.component';
import { BankeComponent } from 'src/app/banke/banke.component';
import { DnevnoStanjeRacunaComponent } from './dnevno-stanje-racuna/dnevno-stanje-racuna.component';
import { DrzavaComponent } from './drzava/drzava.component';
import { KursnaListaComponent } from './kursna-lista/kursna-lista.component';
import { NaseljenaMestaComponent } from './naseljena-mesta/naseljena-mesta.component';
import { UkidanjaComponent } from './ukidanja/ukidanja.component';
import { ValuteComponent } from './valute/valute.component';
import { RacuniPravnihLicaComponent } from './racuni-pravnih-lica/racuni-pravnih-lica.component';
import { KlijentiComponent } from './klijenti/klijenti.component';
import { MedjubankarskiTransferiComponent } from './medjubankarski-transferi/medjubankarski-transferi.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    NavigationComponent,
    BankeComponent,
    HomeNavigationComponent,
    AnalitikeIzvodaComponent,
    DnevnoStanjeRacunaComponent,
    DrzavaComponent,
    KursnaListaComponent,
    NaseljenaMestaComponent,
    UkidanjaComponent,
    ValuteComponent,
    RacuniPravnihLicaComponent,
    KlijentiComponent,
    MedjubankarskiTransferiComponent
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
