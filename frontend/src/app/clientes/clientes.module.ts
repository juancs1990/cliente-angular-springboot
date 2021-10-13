import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientesRoutingModule } from './clientes-routing.module';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import {FormsModule} from '@angular/forms';
import {  ClientesListaComponent } from './clientes-lista/clientes-lista.component'
import {  ClientesListaTabelaComponent } from './clientes-lista/clientes-lista-tabela.component'

@NgModule({
  declarations: [
    ClientesFormComponent,
    ClientesListaComponent,
    ClientesListaTabelaComponent
  ],
  imports: [
    CommonModule,
    ClientesRoutingModule,
    FormsModule 
  ],
  exports:[
    ClientesFormComponent 
  ]
})
export class ClientesModule { }
