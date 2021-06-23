import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, Validators } from "@angular/forms";
import { Item } from './models/item';
import { Usuario } from './models/usuario';
import { ProductoService } from './services/producto.service';
import { UsuarioService } from './services/usuario.service';
import { MatTable } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { DialogBoxComponent } from './components/dialog-box.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'NexosInventario';
  userList: Usuario[];
  userSelect : Usuario;
  itemList: Item[];
  nameColumns: string[] = ['_id', 'itemName', 'cuantity', 'dateAdd', 'userAdd', 'dateUpdate', 'userUpdate', 'action'];
  

  usuarioControl = new FormControl('', Validators.required);

  @ViewChild(MatTable, { static: true }) table: MatTable<any>;

  constructor(public _usuarioService: UsuarioService,
    public _productoService: ProductoService,
    public dialog: MatDialog) { }

  ngOnInit() {
    this._usuarioService.obtenerListaUsuario().subscribe(
      response => {
        this.userList = response;
      },
      error => {

      }
    );
    this.getAllItems();

  }

  private getAllItems(){
    this._productoService.obtenerProductos().subscribe(
      response => {
        this.itemList = response;
      },
      error => {

      }
    );
  }

  openDialog(action, obj) {
    obj.action = action;
    const dialogRef = this.dialog.open(DialogBoxComponent, {
      width: '365px',
      data: obj
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result.event == 'Agregar') {
        this.addRowData(result.data);
      } else if (result.event == 'Actualizar') {
        this.updateRowData(result.data);
      } else if (result.event == 'Eliminar') {
        this.deleteRowData(result.data);
      }
    });
  }

  addItem(row : Item) : Item{
    let rowDB : Item;
    rowDB = row;
    this._productoService.agregarProducto(row).subscribe(
      respose => {
        rowDB.id = respose.id;
        rowDB.fechaCreacion = respose.fechaCreacion;
      },
      error => {
        alert(error.error.message);
      }
    );
    return rowDB;
  }

  updateItem(row : Item){
    this._productoService.actualizarProducto(row).subscribe(
      response => {
        console.log(response);
      },
      error => {

      }
    );
  }

  addRowData(row_obj) {
    var itemAdd = new Item(null,row_obj.nombre,row_obj.cantidad,row_obj.fechaCreacion,this.userSelect,null,null);
    this.addItem(itemAdd);
    this.getAllItems();
    this.table.renderRows();
  }

  updateRowData(row_obj) {
    var itemUpdate = new Item(row_obj.id,row_obj.nombre,row_obj.cantidad,row_obj.fechaCreacion,row_obj.usuarioCreacion,this.userSelect,new Date());
    this.updateItem(itemUpdate);
    this.itemList = this.itemList.filter((value, key) => {
      if (value.id == row_obj.id) {
        value.cantidad = row_obj.cantidad;
        value.nombre = row_obj.nombre;
        value.usuarioModificacion = itemUpdate.usuarioModificacion,
        value.fechaModificacion = itemUpdate.fechaModificacion
      }
      return true;
    });
  }

  deleteRowData(row_obj) {
    this.itemList = this.itemList.filter((value, key) => {
      return value.id != row_obj.id;
    });
  }
}
