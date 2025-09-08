import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-inventory-form',
  templateUrl: './inventory-form.component.html'
})
export class InventoryFormComponent {
  itemName = '';
  itemNumber: number | null = null;
  id: number | null = null;

  constructor(private http: HttpClient) {}

  create() {
    this.http.post('/api/inventory', {
      itemName: this.itemName,
      itemNumber: this.itemNumber
    }).subscribe();
  }

  update() {
    if (this.id != null) {
      this.http.put(`/api/inventory/${this.id}`, {
        itemName: this.itemName,
        itemNumber: this.itemNumber
      }).subscribe();
    }
  }

  delete() {
    if (this.id != null) {
      this.http.delete(`/api/inventory/${this.id}`).subscribe();
    }
  }
}