import { Component, OnInit } from '@angular/core';
import { CartService } from '../../services/cart.service';
import { Bike } from '../../model/bike.model';
import { Accessory } from '../../model/accessory.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  cartItems: (Bike | Accessory)[] = []; // Now supports both types
  totalAmount: number = 0;
  showOrderForm: boolean = false;
  selectedItems: { [id: number]: boolean } = {}; // Track selected items

  orderDetails = {
    name: '',
    phone: '',
    email: '',
    address: '',
    items: [] as (Bike | Accessory)[], // Store selected items
  };

  constructor(private cartService: CartService, private http: HttpClient) {}

  ngOnInit(): void {
    this.cartService.getCart().subscribe((items) => {
      this.cartItems = items;
      this.initializeSelection();
    });
  }

  initializeSelection() {
    // Initialize all checkboxes as unchecked
    this.cartItems.forEach((item) => {
      this.selectedItems[item.id] = false;
    });
    this.calculateTotal();
  }

  toggleSelection(item: Bike | Accessory, event: Event) {
    const isChecked = (event.target as HTMLInputElement).checked;
    this.selectedItems[item.id] = isChecked;
    this.calculateTotal();
  }

  calculateTotal() {
    this.totalAmount = this.cartItems
      .filter((item) => this.selectedItems[item.id]) // Only include selected items
      .reduce((sum, item) => sum + item.price, 0);
  }

  openOrderForm() {
    if (this.totalAmount === 0) {
      alert('Please select at least one item.');
      return;
    }
    this.showOrderForm = true;
  }

  submitOrder() {
    if (
      !this.orderDetails.name ||
      !this.orderDetails.phone ||
      !this.orderDetails.email ||
      !this.orderDetails.address
    ) {
      alert('Please fill in all fields.');
      return;
    }

    this.orderDetails.items = this.cartItems.filter(
      (item) => this.selectedItems[item.id]
    );

    this.http.post('http://localhost:3000/orders', this.orderDetails).subscribe(
      () => {
        alert('Order placed successfully!');
        this.cartService.clearCart();
        this.cartItems = [];
        this.totalAmount = 0;
        this.showOrderForm = false;
      },
      (error) => {
        console.error('Error storing order:', error);
      }
    );
  }
}
