import { Component, Inject, Optional } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Item } from '../models/item';

@Component({
  selector: 'app-dialog-box',
  templateUrl: '../views/dialog-box.component.html',
  styleUrls: ['../views/dialog-box.component.scss']
})
export class DialogBoxComponent {

  action: string;
  local_data: any;
  maxDate: Date;

  constructor(
    public dialogRef: MatDialogRef<DialogBoxComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: Item) {
      this.local_data = { ...data };
      this.action = this.local_data.action;
      this.maxDate = new Date();
  }

  doAction() {
    this.dialogRef.close({ event: this.action, data: this.local_data });
  }

  closeDialog() {
    this.dialogRef.close({ event: 'Cancelar' });
  }

}