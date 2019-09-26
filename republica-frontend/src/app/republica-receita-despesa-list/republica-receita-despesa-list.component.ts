import { Component, OnInit } from '@angular/core';
import { ReceitaDespesa } from '../models/receita-despesa';
import { ActivatedRoute, Router } from '@angular/router';
import { ReceitadespesaService } from '../services/receitadespesa.service';

@Component({
  selector: 'app-republica-receita-despesa-list',
  templateUrl: './republica-receita-despesa-list.component.html',
  styleUrls: ['./republica-receita-despesa-list.component.css']
})
export class RepublicaReceitaDespesaListComponent implements OnInit {

  receitaDespesa: ReceitaDespesa[];
  displayedColumns: string[] = ['tipo', 'descricao', 'valor', 'periodo', 'dataLancamento', 'dataVencimentoRecebimento', 'acoes'];

  constructor(private route: ActivatedRoute, private router: Router, private receitadespesaService: ReceitadespesaService) { }

  ngOnInit() {
    this.receitadespesaService.findAll().subscribe(data =>{
      this.receitaDespesa = data;
    });
  }

  onCreate() {
    let receitaDespesa = new ReceitaDespesa();
    this.receitadespesaService.setReceitaDespesa(receitaDespesa);
    this.router.navigate(['/republicas/addreceitasdespesas']);
  }

  onUpdate(recd: ReceitaDespesa) {
    this.receitadespesaService.setReceitaDespesa(recd);
    this.router.navigate(['/republicas/addreceitasdespesas']);
  }

  onDelete(id: number) {
    this.receitadespesaService.delete(id).subscribe(result => {
      alert('Receita/Despesa deletada!');
      this.ngOnInit();
    });
  }
}
