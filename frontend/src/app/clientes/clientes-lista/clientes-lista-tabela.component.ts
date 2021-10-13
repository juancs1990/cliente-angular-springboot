import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from '../cliente'; 
declare var $: any;

@Component({
  selector: 'app-clientes-lista-tabela',
  templateUrl: './clientes-lista-tabela.component.html'
})
export class ClientesListaTabelaComponent implements OnInit {

  clientes : Cliente[] = []
  clienteSelecionado: Cliente 
  mensagemSucesso: String = ''
  mensagemErro: String = ''
 
   

  alertFadeOut(){
    $(".alert").fadeOut(2000);

  }



   refresh() {
     this.ngOnInit();
}
 
 
  
alertFadein(){
  $(".alert-excluir").fadeIn(1);

  }

  constructor(private service: ClientesService,
              private router : Router) { 
   }
 

    
preparaDelecao(cliente: Cliente){
  this.clienteSelecionado=cliente
}



deletarCliente (){
  this.service.deletar(this.clienteSelecionado)
  .subscribe(response => {this.mensagemSucesso = 'Cliente deletado com sucesso!', this.alertFadein(), this.ngOnInit()},
             erro => {this.mensagemErro = 'Ocorreu um erro ao deletar o cliente.'})
}

iniciarTabela(){

  $(document).ready( function () { 
    if ( $.fn.dataTable.isDataTable( '#table_id' ) ) {
      var table = $('#example').DataTable();
  }
  else {
   var table = $('#table_id').DataTable({"language": {
      "lengthMenu": "Exibir _MENU_ registros por página",
       "search":  "Pesquisar: ",
      "zeroRecords": "Não existem registros",
      "info": "Mostrando _PAGE_ de _PAGES_",
      "infoEmpty": "Não existem registros",
      "infoFiltered": "(Total de _MAX_ registros)",
      "paginate": {
        first:      "Primeiro",
        previous:   "Anterior",
        next:       "Próximo",
        last:       "Último"
    }
  }
})
  };

} );
}

  ngOnInit(): void {
    this.service
    .getClientes()
    .subscribe(resposta => {this.clientes = resposta,this.alertFadeOut(),
      this.iniciarTabela();
    })
  }

  
}
