import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { usuario } from '../model/usuario.model';

@Injectable({
  providedIn: 'root'
})


export class UsuarioService {
  
  URL = 'http://localhost:8080/usuario';

  constructor(private http: HttpClient) { }

  
  public getUsuario(): Observable<usuario>{
  
    return this.http.get<usuario>(this.URL+'/id/1');
   // return this.http.get<usuario>(this.URL+'/id/'+usuario(idUsuario));

  }
}
