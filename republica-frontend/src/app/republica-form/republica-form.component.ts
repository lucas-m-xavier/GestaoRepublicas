import { Component, OnInit } from '@angular/core';
import { Republica } from '../models/republica';
import { ActivatedRoute, Router } from '@angular/router';
import { RepublicaService } from '../services/republica.service';
import { Representante } from '../models/representante';
import { RepresentanteService } from '../services/representante.service';

@Component({
  selector: 'app-republica-form',
  templateUrl: './republica-form.component.html',
  styleUrls: ['./republica-form.component.css']
})
export class RepublicaFormComponent implements OnInit {

  republica: Republica
  representantes: Representante[]

  constructor(private route: ActivatedRoute, private router: Router, private republicaService: RepublicaService, private representanteService: RepresentanteService) {
    this.republica = new Republica()
  }

  ngOnInit() {
    this.republica = this.republicaService.getRepublica()
    this.representanteService.findAll().subscribe(data => {
      this.representantes = data
    })
  }

  onSubmit() {
    if (this.republica.id == undefined) {
      console.log(this.republica)
      this.republicaService.save(this.republica).subscribe(result => {
        this.router.navigate(['/republicas']);
        alert("República adicionada com sucesso!");
      });
    } else {
      this.republicaService.update(this.republica).subscribe(result => {
        this.router.navigate(['/republicas']);
        alert("República editada com sucesso!");
      });
    }
  }

}
