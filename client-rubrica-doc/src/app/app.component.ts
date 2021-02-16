import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Contatto } from './contatto';
import { RichiestaAServerDto } from './richiesta-a-server-dto';
import { RispostaDaServerDto } from './risposta-da-server-dto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  contatto = new Contatto();
  contatti: Contatto[] = [];
  url = "http://localhost:8080/";
  criterioRicerca = "";

  constructor(private http: HttpClient) {
    // carica i dati della rubrica all'avvio
    this.aggiorna();
  }

  aggiungi() {
    // metto il contatto da inserire nel DTO
    let req = new RichiestaAServerDto();
    req.contatto = this.contatto;

    // preparo la richiesta POST verso il server
    let ox: Observable<RispostaDaServerDto> = this.http
      .post<RispostaDaServerDto>(this.url + "inserisci", req);
    // invio la richiesta, avendole dato la callback
    ox.subscribe(r => {
      this.contatti = r.listaContatti;
    });
    // resetto l'oggetto associato al campo di input
    this.contatto = new Contatto();
  }

  aggiorna() {
    // preparo la richiesta GET verso il server
    let ox: Observable<RispostaDaServerDto> = this.http
      .get<RispostaDaServerDto>(this.url + "leggi-rubrica");
    // invio la richiesta, avendole dato la callback
    ox.subscribe(r => {
      this.contatti = r.listaContatti;
    });
  }

  svuota() {
    // preparo la richiesta GET verso il server
    let ox: Observable<RispostaDaServerDto> = this.http
      .get<RispostaDaServerDto>(this.url + "svuota");
    // invio la richiesta, avendole dato la callback
    ox.subscribe(r => {
      this.contatti = r.listaContatti;
    });
  }

  cancella(c: Contatto) {
    // metto il contatto da cancellare nel DTO
    let req = new RichiestaAServerDto();
    req.contatto = c;

    // preparo la richiesta POST verso il server
    let ox: Observable<RispostaDaServerDto> = this.http
      .post<RispostaDaServerDto>(this.url + "cancella", req);
    // invio la richiesta, avendole dato la callback
    ox.subscribe(r => {
      this.contatti = r.listaContatti;
    });
  }

  cerca() {
    // metto il contatto da cancellare nel DTO
    let req = new RichiestaAServerDto();
    req.contatto = new Contatto();
    req.contatto.nome = this.criterioRicerca;

    // preparo la richiesta POST verso il server
    let ox: Observable<RispostaDaServerDto> = this.http
      .post<RispostaDaServerDto>(this.url + "cerca-nome", req);
    // invio la richiesta, avendole dato la callback
    ox.subscribe(r => {
      this.contatti = r.listaContatti;
    });
  }
}

