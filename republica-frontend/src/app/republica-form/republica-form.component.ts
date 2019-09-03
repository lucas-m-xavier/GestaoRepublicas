import { Component, OnInit } from '@angular/core';
import { Republica } from '../models/republica';
import { ActivatedRoute, Router } from '@angular/router';
import { RepublicaService } from '../services/republica.service';

@Component({
  selector: 'app-republica-form',
  templateUrl: './republica-form.component.html',
  styleUrls: ['./republica-form.component.css']
})
export class RepublicaFormComponent implements OnInit {

  republica: Republica

  constructor(private route: ActivatedRoute, private router: Router, private republicaService: RepublicaService) {
    this.republica = new Republica()
  }

  ngOnInit() {
    this.republica = this.republicaService.getRepublica()
  }

  onSubmit() {
    if (this.republica.id == undefined) {
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
