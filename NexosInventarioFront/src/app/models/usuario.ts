import {Position} from './position';

export class Usuario{
    constructor(
        public id: number,
        public nombre: string,
        public fechaIngreso: Date,
        public fechaNacimiento: string,
        public cargo: Position
    ){
    }
}