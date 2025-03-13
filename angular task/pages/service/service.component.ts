import { Component, OnInit } from '@angular/core';
import { AccessoryService } from '../../services/accessory.service';
import { Accessory } from '../../model/accessory.model';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css'],
})
export class ServiceComponent implements OnInit {
  accessories: Accessory[] = [];
  successMessage: string = ''; // Success message for added to cart
  selectedCategory: string = 'All'; // Filter for category
  uniqueCategories: string[] = []; // List of unique categories

  constructor(
    private accessoryService: AccessoryService,
    private cartService: CartService
  ) {}

  ngOnInit(): void {
    this.accessoryService.getAccessories().subscribe((data) => {
      this.accessories = data;
      this.extractUniqueCategories();
    });
  }

  addToCart(accessory: Accessory) {
    const confirmAdd = window.confirm(
      `Are you sure you want to add ${accessory.name} to the cart?`
    );

    if (confirmAdd) {
      this.cartService.addToCart(accessory);
      this.successMessage = `${accessory.name} added to cart successfully!`;

      // Hide message after 3 seconds
      setTimeout(() => {
        this.successMessage = '';
      }, 3000);
    }
  }

  // Extract unique categories from the accessories list
  private extractUniqueCategories() {
    const categories = this.accessories.map((acc) => acc.category);
    this.uniqueCategories = ['All', ...new Set(categories)];
  }
}
