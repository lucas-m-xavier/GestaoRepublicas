import { Injectable } from '@angular/core';
import { Republica } from '../models/republica';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RepublicaService {

  private republicasUrl: string
  private republica = new Republica()

  constructor(private http: HttpClient) {
    this.republicasUrl = 'http://localhost:8080/republicas'
  }

  public findAll(): Observable<Republica[]> {
    return this.http.get<Republica[]>(this.republicasUrl)
  }

  public save(republica: Republica) {
    return this.http.post<Republica>(this.republicasUrl, republica)
  }

  public update(republica: Republica) {
    return this.http.put<Republica>(`${this.republicasUrl}/${republica.id}`, republica)
  }

  public delete(id: number) {
    return this.http.delete<void>(`${this.republicasUrl}/${id}`)
  }

  public getRepublica() {
    return this.republica
  }

  public setRepublica(republica: Republica) {
    this.republica = republica
  }

}
