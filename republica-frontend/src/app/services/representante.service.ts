import { Injectable } from '@angular/core';
import { Representante } from '../models/representante';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RepresentanteService {

  private representantesUrl: string
  private representante = new Representante()

  constructor(private http: HttpClient) {
    this.representantesUrl = 'http://localhost:8080/representantes'
  }

  public findAll(): Observable<Representante[]> {
    return this.http.get<Representante[]>(this.representantesUrl)
  }

}
