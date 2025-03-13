import { Component, OnInit } from '@angular/core';
import { BikeService } from '../../services/bike.service';
import { Bike } from '../../model/bike.model';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css'],
})
export class BuyComponent implements OnInit {
  bikes: Bike[] = [];
  successMessage: string = ''; // Success message for added to cart
  maxPrice: number | null = null; // Filter for max price
  selectedCompany: string = 'All'; // Filter for company
  uniqueCompanies: string[] = []; // List of unique companies

  constructor(
    private bikeService: BikeService,
    private cartService: CartService
  ) {}

  ngOnInit(): void {
    this.bikeService.getBikes().subscribe((data) => {
      this.bikes = data;
      this.extractUniqueCompanies();
    });
  }

  addToCart(bike: Bike) {
    const confirmAdd = window.confirm(
      `Are you sure you want to add ${bike.name} to the cart?`
    );

    if (confirmAdd) {
      this.cartService.addToCart(bike);
      this.successMessage = `${bike.name} added to cart successfully!`;

      // Hide message after 3 seconds
      setTimeout(() => {
        this.successMessage = '';
      }, 3000);
    }
  }

  // Extract unique company names from the bike list
  private extractUniqueCompanies() {
    const companies = this.bikes.map((bike) => bike.company);
    this.uniqueCompanies = ['All', ...new Set(companies)];
  }
}
