import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  apiUrl: string = environment.apiUrl + "/clientes"

  constructor(private http: HttpClient) { }

  salvar (cliente: Cliente) : Observable<Cliente> {
      return this.http.post<Cliente>(`${this.apiUrl}`,cliente)
  }

  
  editar (cliente: Cliente) : Observable<Cliente> {
    return this.http.put<Cliente>(`${this.apiUrl}/${cliente.id}`,cliente)
}

deletar (cliente: Cliente) : Observable<Cliente> {
  return this.http.delete<Cliente>(`${this.apiUrl}/${cliente.id}`)
}

  getClientes(): Observable<Cliente[]>{
    return this.http.get<Cliente[]>(`${this.apiUrl}`)
  }

  getClientesbyId(id: any): Observable<Cliente>{
    return this.http.get<any>(`${this.apiUrl}/${id}`)
  }
  
}
