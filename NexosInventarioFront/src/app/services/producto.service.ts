import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from '../models/item';
import { GLOBAL } from './global';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  public url: string;

  constructor(private _http: HttpClient) {
    this.url = GLOBAL.url;
  }

  obtenerProductos(): Observable<Item[]> {
    return this._http.get<Item[]>(this.url + 'productos');
  }

  agregarProducto(item: Item): Observable<Item> {
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    const body = JSON.stringify(item);
    return this._http.post<Item>(this.url + 'producto', body, { headers: headers });
  }

  actualizarProducto(item: Item): Observable<Item> {
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    const body = JSON.stringify(item);
    return this._http.put<Item>(this.url + 'producto', body, { headers: headers });
  }
}
