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
  successMessage: string = '';
  maxPrice: number = 0;
  selectedCompany: string = 'All';
  uniqueCompanies: string[] = [];

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

      setTimeout(() => {
        this.successMessage = '';
      }, 3000);
    }
  }

  extractUniqueCompanies() {
    this.uniqueCompanies = Array.from(
      new Set(this.bikes.map((bike) => bike.company))
    );
  }
}
