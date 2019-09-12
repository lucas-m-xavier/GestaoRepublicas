import { Injectable } from '@angular/core';
import { Republica } from '../models/republica';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class RepublicaService {

  private republicasUrl: string
  private republica = new Republica()

  constructor(private http: HttpClient) {
    this.republicasUrl = 'http://localhost:8080/republicas'
  }

  form: FormGroup = new FormGroup({
    $key: new FormControl(null),
    nome: new FormControl('', Validators.required),
    endereco: new FormControl('', Validators.required),
    numeroVagas: new FormControl('', Validators.required),
    tipoLocacao: new FormControl('', Validators.required),
    genero: new FormControl('', Validators.required),
    integrantes: new FormControl('', Validators.required),
    numeroComodos: new FormControl('', Validators.required),
    utensilios: new FormControl('', Validators.required),
    diferencial: new FormControl('', Validators.required),
    numeroVagasDisponiveis: new FormControl('', Validators.required),
    descricao: new FormControl('', Validators.required),
    representante: new FormControl('', Validators.required),
    link: new FormControl('', Validators.required),
    curso: new FormControl('', Validators.required)
  });

  /*
  initializeFormGroup() {
    this.form.setValue({
      $key: null,
      nome: '',
      endereco: '',
      numeroVagas: '',
      tipoLocacao: '',
      genero: '1',
      integrantes: '',
      numeroComodos: '',
      utensilios: '',
      diferencial: '',
      numeroVagasDisponiveis: '',
      descricao: '',
      representante: '',
      link: '',
      curso: ''
    });
  }*/

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
