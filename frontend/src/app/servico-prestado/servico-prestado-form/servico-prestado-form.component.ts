import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ServicoPrestadoService } from '../../servico-prestado.service';
import { ClientesService } from '../../clientes.service';
import { Cliente } from '../../clientes/cliente';
import { ServicoPrestado } from '../ServicoPrestado';
import {  DateValidator } from 'src/app/date.validator';

@Component({
  selector: 'app-servico-prestado-form',
  templateUrl: './servico-prestado-form.component.html',
  styleUrls: ['./servico-prestado-form.component.css']
})
export class ServicoPrestadoFormComponent implements OnInit {


  clientes: Cliente[]=[]
  servicoPrestado: ServicoPrestado
  sucess: boolean = false
  erros: String[]; 
  dataValida: any=false


  onSubmit (){
    console.log(this.servicoPrestado)
   this.servico.salvar(this.servicoPrestado).subscribe (
        response => {this.sucess=true, this.erros=[]},
        errorResponse =>   {this.sucess=false,this.erros = errorResponse.error.errors}
        ) 
 
  }

  validarData (e){
    this.dataValida = DateValidator.dateVaidator(e)
  }

  constructor( private clienteService: ClientesService,
               private servico : ServicoPrestadoService
    ) { 
    this.servicoPrestado = new ServicoPrestado()
    }

  ngOnInit(): void {
    this.clienteService.getClientes().subscribe(response => {this.clientes=response})
  
  }

}
