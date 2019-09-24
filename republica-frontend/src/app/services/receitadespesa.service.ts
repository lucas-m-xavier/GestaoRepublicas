import { Injectable } from '@angular/core';
import { ReceitaDespesa } from '../models/receita-despesa';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ReceitadespesaService {

  private receitaDespesaUrl: string;
  private receitaDespesa = new ReceitaDespesa();

  constructor(private http: HttpClient) {
    this.receitaDespesaUrl = 'http://localhost:8080/republica/receitasdespesas';
  }

  form: FormGroup = new FormGroup({
    $key: new FormControl(null),
    republica: new FormControl('', Validators.required),
    tipo: new FormControl('', Validators.required),
    descricao: new FormControl('', Validators.required),
    valor: new FormControl('', Validators.required),
    periodo: new FormControl('', Validators.required),
    divisao: new FormControl('', Validators.required),
    valorDividido: new FormControl('', Validators.required),
    dataLancamento: new FormControl('', Validators.required),
    dataVencimentoRecebimento: new FormControl('', Validators.required),
    efetivado: new FormControl('', Validators.required)
  });

  public findAll(): Observable<ReceitaDespesa[]> {
    return this.http.get<ReceitaDespesa[]>(this.receitaDespesaUrl);
  }

  public save(receitaDespesa: ReceitaDespesa) {
    return this.http.post<ReceitaDespesa>(this.receitaDespesaUrl, receitaDespesa);
  }

  public update(receitaDespesa: ReceitaDespesa) {
    return this.http.put<ReceitaDespesa>(`${this.receitaDespesaUrl}/${receitaDespesa.id}`, receitaDespesa);
  }

  public delete(id: number) {
    return this.http.delete<void>(`${this.receitaDespesaUrl}/${id}`);
  }

  public getReceitaDespesa() {
    return this.receitaDespesa;
  }

  public setReceitaDespesa(receitaDespesa: ReceitaDespesa) {
    this.receitaDespesa = receitaDespesa;
  }

}
