import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReceitaDespesa } from '../models/receita-despesa';
import { Republica } from '../models/republica';
import { RepublicaService} from '../services/republica.service';
import { ReceitadespesaService } from '../services/receitadespesa.service';

@Component({
  selector: 'app-republica-receita-despesa-form',
  templateUrl: './republica-receita-despesa-form.component.html',
  styleUrls: ['./republica-receita-despesa-form.component.css']
})
export class RepublicaReceitaDespesaFormComponent implements OnInit {

  receitaDespesa: ReceitaDespesa;
  republicas: Republica[];

  constructor(private route: ActivatedRoute, private router: Router, private receitaDespesaService: ReceitadespesaService, private republicaService: RepublicaService) {
    this.receitaDespesa = new ReceitaDespesa();
  }

  ngOnInit() {
    this.receitaDespesa = this.receitaDespesaService.getReceitaDespesa();
    this.republicaService.findAll().subscribe(data => {
      this.republicas = data;
    });
  }

  onSubmit() {
    if (this.receitaDespesa.id === undefined) {
      console.log(this.receitaDespesa);
      this.receitaDespesaService.save(this.receitaDespesa).subscribe(result => {
        this.router.navigate(['/republicas/']);
        alert('Receita / Despesa adicionada com sucesso!');
      });
    } else {
      this.receitaDespesaService.update(this.receitaDespesa).subscribe(result => {
        this.router.navigate(['/republicas']);
        alert('Receita / Despesa editada com sucesso!');
      });
    }
  }

}
