import { Usuario } from "./usuario";

export class Item{
    constructor(
        public id: number,
        public nombre: string,
        public cantidad: number,
        public fechaCreacion: Date,
        public usuarioCreacion: Usuario,
        public usuarioModificacion: Usuario,
        public fechaModificacion: Date
    ){
    }
}