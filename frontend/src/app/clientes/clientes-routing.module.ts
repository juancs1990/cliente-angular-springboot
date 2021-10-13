import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ClientesFormComponent} from './clientes-form/clientes-form.component'
import {  ClientesListaComponent} from './clientes-lista/clientes-lista.component';
import {  ClientesListaTabelaComponent} from './clientes-lista/clientes-lista-tabela.component';
const routes: Routes = [
{path:'clientes-lista', component:ClientesListaComponent,
children : [
  {path:'clientes-lista-tabela', component:ClientesListaTabelaComponent}
]},
{ path: 'clientes-form', component:ClientesFormComponent },
{ path: 'clientes-form/:id', component:ClientesFormComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }
