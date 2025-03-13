import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Bike } from '../model/bike.model';
import { Accessory } from '../model/accessory.model';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  private cart: (Bike | Accessory)[] = [];
  private cartSubject = new BehaviorSubject<(Bike | Accessory)[]>(this.cart);

  constructor() {}

  getCart() {
    return this.cartSubject.asObservable();
  }

  getCartItems(): (Bike | Accessory)[] {
    return this.cart;
  }
  addToCart(item: Bike | Accessory) {
    this.cart.push(item);
    this.cartSubject.next([...this.cart]);
    console.log('Cart Updated:', this.cart);
  }

  removeFromCart(item: Bike | Accessory) {
    this.cart = this.cart.filter((cartItem) => cartItem.id !== item.id);
    this.cartSubject.next([...this.cart]);
  }

  clearCart() {
    this.cart = [];
    this.cartSubject.next([]);
  }
}
