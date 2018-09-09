import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from 'src/app/register/register.component';
import { LoginComponent } from 'src/app/login/login.component';
import { HomeNavigationComponent } from 'src/app/home-navigation/home-navigation.component';
import { NavigationComponent } from 'src/app/navigation/navigation.component';
import { BankeComponent } from 'src/app/banke/banke.component';
import { AnalitikeIzvodaComponent } from 'src/app/analitike-izvoda/analitike-izvoda.component';
import { DnevnoStanjeRacunaComponent } from 'src/app/dnevno-stanje-racuna/dnevno-stanje-racuna.component';
import { DrzavaComponent } from 'src/app/drzava/drzava.component';
import { KursnaListaComponent } from 'src/app/kursna-lista/kursna-lista.component';
import { NaseljenaMestaComponent } from 'src/app/naseljena-mesta/naseljena-mesta.component';
import { UkidanjaComponent } from 'src/app/ukidanja/ukidanja.component';
import { ValuteComponent } from 'src/app/valute/valute.component';
import { RacuniPravnihLicaComponent } from 'src/app/racuni-pravnih-lica/racuni-pravnih-lica.component';
import { KlijentiComponent } from 'src/app/klijenti/klijenti.component';
import { MedjubankarskiTransferiComponent } from 'src/app/medjubankarski-transferi/medjubankarski-transferi.component';

export const appRoutes: Routes = [
    { path: 'navigation', component: NavigationComponent , pathMatch: 'full'},
    { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
    { path: 'banke', component: BankeComponent },
    { path: 'analitike-izvoda', component: AnalitikeIzvodaComponent },
    { path: 'dnevno-stanje-racuna', component: DnevnoStanjeRacunaComponent },
    { path: 'drzava', component: DrzavaComponent },
    { path: 'kursna-lista', component: KursnaListaComponent },
    { path: 'naseljena-mesta', component: NaseljenaMestaComponent },
    { path: 'ukidanja', component: UkidanjaComponent },
    { path: 'valute', component: ValuteComponent },
    { path: 'racuniPravnihLica', component: RacuniPravnihLicaComponent },
    { path: 'klijenti', component: KlijentiComponent },
    { path: 'transferi', component: MedjubankarskiTransferiComponent },
]