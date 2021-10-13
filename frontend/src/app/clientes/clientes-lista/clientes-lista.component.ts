import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clientes-lista',
  templateUrl: './clientes-lista.component.html'
})
export class ClientesListaComponent implements OnInit {

  constructor(private router : Router) { 
   }

   btnClienteNovo() {
       this.router.navigate(['clientes-form'])
   }

  ngOnInit(): void { 
  }

  
}
