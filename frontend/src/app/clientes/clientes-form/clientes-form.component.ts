import { Component, OnInit ,ViewChild, AfterViewInit} from '@angular/core';
import {Cliente} from '../cliente'
import {ClientesService} from '../../clientes.service'
import { Router ,ActivatedRoute} from '@angular/router'; 
import { Observable } from 'rxjs';
import { ClientesListaTabelaComponent } from '../clientes-lista/clientes-lista-tabela.component';
 

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit, AfterViewInit  {

  sucess: boolean = false
  erros: String[];
  id: String; 
  @ViewChild(ClientesListaTabelaComponent) child: ClientesListaTabelaComponent;


cliente: Cliente
  constructor(private service : ClientesService,
              private router : Router,
              private activetedRoute: ActivatedRoute) {  
    this.cliente = new Cliente () 
  }

 
  btnVoltarCliente(){
    this.router.navigate(['clientes-form'])
  }

  alertFadein(){
    $(".alert-salvar").fadeIn(1);
  
    }

 
  onSubmit(){

    if (this.cliente.id)
    {
      this.service.editar(this.cliente).subscribe (
        response => {this.sucess=true, this.erros=[],this.cliente=response,this.btnVoltarCliente()},
        errorResponse =>   {this.sucess=false,this.erros = errorResponse.error.errors  }
        )
    }
    else{
      this.service.salvar(this.cliente).subscribe (
        response => {this.sucess=true, this.erros=[], this.alertFadein(), this.child.refresh()
        },
        errorResponse =>   {this.sucess=false,this.erros = errorResponse.error.errors ;
          console.log(errorResponse.error.errors[0])
        ;
        }
        ) 
    } 
   
     }

  ngOnInit(): void { 
    if (this.activetedRoute.snapshot.paramMap.get('id'))
    {
   this.id = this.activetedRoute.snapshot.paramMap.get('id'); 
   this.service.getClientesbyId(this.id).subscribe (
    response => {this.erros=[],this.cliente=response}
    ) 
    
    }
  }

  ngAfterViewInit() {


  }

}
