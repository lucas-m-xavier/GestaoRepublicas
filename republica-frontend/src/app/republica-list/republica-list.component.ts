import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Republica } from '../models/republica';
import { RepublicaService } from '../services/republica.service'

@Component({
  selector: 'app-republica-list',
  templateUrl: './republica-list.component.html',
  styleUrls: ['./republica-list.component.css']
})
export class RepublicaListComponent implements OnInit {

  republicas: Republica[]
  displayedColumns: string[] = ['id', 'nome', 'endereco', 'numeroVagas', 'tipoLocacao', 'genero', /*'integrantes',*/ 'numeroComodos', 'utensilios', 'diferencial', 'numeroVagasDisponiveis', 'descricao', 'representante', 'link', 'curso', 'acoes'];

  constructor(private route: ActivatedRoute, private router: Router, private republicaService: RepublicaService) { }

  ngOnInit() {
    this.republicaService.findAll().subscribe(data => {
      this.republicas = data
    })
  }

  onUpdate(republica: Republica) {
    this.republicaService.setRepublica(republica);
    this.router.navigate(['/addrepublica']);
  }

  onDelete(id: number) {
    this.republicaService.delete(id).subscribe(result => {
      alert("República deletada!");
      this.ngOnInit();
    });
  }

  onCreate() {
    let republica = new Republica();
    this.republicaService.setRepublica(republica);
    this.router.navigate(['/addrepublica']);
  }

}
