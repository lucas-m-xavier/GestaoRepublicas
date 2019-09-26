import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RepublicaListComponent } from './republica-list/republica-list.component';
import { RepublicaFormComponent } from './republica-form/republica-form.component';
import { RepublicadisponivelListComponent } from './republicadisponivel-list/republicadisponivel-list.component';
import { RepublicaReceitaDespesaFormComponent } from './republica-receita-despesa-form/republica-receita-despesa-form.component';
import { RepublicaReceitaDespesaListComponent } from './republica-receita-despesa-list/republica-receita-despesa-list.component';

const routes: Routes = [
  { path: 'republicas', component: RepublicaListComponent },
  { path: 'addrepublica', component: RepublicaFormComponent },
  { path: 'republicas/disponiveis', component: RepublicadisponivelListComponent },
  { path: 'republicas/addreceitasdespesas', component: RepublicaReceitaDespesaFormComponent },
  { path: 'republicas/receitasdespesas', component: RepublicaReceitaDespesaListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
