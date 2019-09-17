import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RepublicaListComponent } from './republica-list/republica-list.component';
import { RepublicaFormComponent } from './republica-form/republica-form.component';
import { RepublicadisponivelListComponent } from './republicadisponivel-list/republicadisponivel-list.component';
import { RepublicaReceitaDespesaFormComponent } from './republica-receita-despesa-form/republica-receita-despesa-form.component';

const routes: Routes = [
  { path: 'republicas', component: RepublicaListComponent },
  { path: 'addrepublica', component: RepublicaFormComponent },
  { path: 'republicas/disponiveis', component: RepublicadisponivelListComponent },
  { path: 'republicas/receitasdespesas', component: RepublicaReceitaDespesaFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
