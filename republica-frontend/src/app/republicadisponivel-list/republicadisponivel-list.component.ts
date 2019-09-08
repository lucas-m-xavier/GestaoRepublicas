import { Component, OnInit } from '@angular/core';
import { Republica } from '../models/republica';
import { ActivatedRoute, Router } from '@angular/router';
import { RepublicadisponivelService } from '../services/republicadisponivel.service';

@Component({
  selector: 'app-republicadisponivel-list',
  templateUrl: './republicadisponivel-list.component.html',
  styleUrls: ['./republicadisponivel-list.component.css']
})
export class RepublicadisponivelListComponent implements OnInit {
  republicas: Republica[]
  displayedColumns: string[] = ['id', 'nome', 'endereco', 'numeroVagas', 'tipoLocacao', 'genero', /*'integrantes',*/ 'numeroComodos', 'utensilios', 'diferencial', 'numeroVagasDisponiveis', 'descricao', 'representante', 'link', 'curso', 'acoes'];
  
  constructor(private route: ActivatedRoute, private router: Router, private republicaService: RepublicadisponivelService) { }

  ngOnInit() {
    this.republicaService.findAll().subscribe(data => {
      this.republicas = data
    })
  }

}
