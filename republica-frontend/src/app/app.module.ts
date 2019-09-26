import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';

import { AppComponent } from './app.component';
import { RepublicaListComponent, RepublicaListDialogComponent } from './republica-list/republica-list.component';
import { RepublicaFormComponent } from './republica-form/republica-form.component';

import { RepublicaService } from './services/republica.service';
import { MainNavComponent } from './main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RepublicadisponivelListComponent } from './republicadisponivel-list/republicadisponivel-list.component';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { RepublicaReceitaDespesaFormComponent } from './republica-receita-despesa-form/republica-receita-despesa-form.component';
import { MatRadioModule } from '@angular/material/radio';
import { RepublicaReceitaDespesaListComponent } from './republica-receita-despesa-list/republica-receita-despesa-list.component';

@NgModule({
  declarations: [
    AppComponent,
    RepublicaListComponent,
    RepublicaFormComponent,
    RepublicadisponivelListComponent,
    MainNavComponent,
    RepublicaListDialogComponent,
    RepublicaReceitaDespesaFormComponent,
    RepublicaReceitaDespesaListComponent
  ],
  entryComponents: [
    RepublicaListDialogComponent
  ],
  imports: [
    MatSidenavModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
    MatMenuModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    LayoutModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatPaginatorModule,
    MatSortModule,
    MatCardModule,
    MatDialogModule,
    MatRadioModule
  ],
  providers: [
    RepublicaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
