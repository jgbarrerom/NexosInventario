import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario';
import { map } from 'rxjs/operators';
import { Position } from '../models/position';
import { GLOBAL } from './global';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  public url : string;

  constructor(private _http: HttpClient) {
    this.url = GLOBAL.url;
  }

  obtenerListaUsuario() : Observable<Usuario[]>{
    return this._http.get(this.url + 'usuarios').pipe(
      map((data: any[]) =>
        data.map(
          (item: any) => new Usuario(item.id, item.nombre, item.fechaIngreso, item.fechaNacimiento, new Position(item.cargo.id,item.cargo.cargo))
        )
      ));
  }
}
