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

  constructor(private http: HttpClient) { }

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
  }

  aggiorna() { }

  svuota() { }

  cancella(inx: number) { }
}
