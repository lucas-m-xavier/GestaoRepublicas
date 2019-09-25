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

  recdes: ReceitaDespesa[]
  displayedColumns: string[] = [];

  constructor(private route: ActivatedRoute, private router: Router, private receitadespesaService: ReceitadespesaService) { }

  ngOnInit() {
    this.receitadespesaService.findAll().subscribe(data =>{
      this.recdes = data
    });
  }

  onCreate() {
    let rd = new ReceitaDespesa();
    this.receitadespesaService.setReceitaDespesa(rd);
    this.router.navigate(['/republicas/registrarreceitasdespesas']);
  }

  onUpdate(recd: ReceitaDespesa) {
    this.receitadespesaService.setReceitaDespesa(recd);
    this.router.navigate(['/republicas/registrarreceitasdespesas']);
  }

  onDelete(id: number) {
    this.receitadespesaService.delete(id).subscribe(result => {
      alert('Receita/Despesa deletada!');
      this.ngOnInit();
    });
  }
}
