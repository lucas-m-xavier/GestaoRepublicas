import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Republica } from '../models/republica';
import { RepublicadisponivelService } from '../services/republicadisponivel.service';

@Component({
  selector: 'app-republicadisponivel-list',
  templateUrl: './republicadisponivel-list.component.html',
  styleUrls: ['./republicadisponivel-list.component.css']
})
export class RepublicadisponivelListComponent implements OnInit {

  republicas: Republica[]
  displayedColumns: string[] = ['id', 'nome', 'endereco', 'numeroVagas', 'tipoLocacao', 'genero', /*'integrantes',*/ 'numeroComodos', 'utensilios', 'diferencial', 'numeroVagasDisponiveis', 'descricao', 'representante', 'link'/*, 'curso'*/];
  
  constructor(private route: ActivatedRoute, private router: Router, private republicaDisponivelService: RepublicadisponivelService) { }

  ngOnInit() {
    this.republicaDisponivelService.findAll().subscribe(data => {
      this.republicas = data
    })
  }

}
