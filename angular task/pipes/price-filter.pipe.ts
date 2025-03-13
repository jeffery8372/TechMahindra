import { Pipe, PipeTransform } from '@angular/core';
import { Bike } from '../model/bike.model';

@Pipe({
  name: 'priceFilter',
  pure: false, // Ensures real-time filtering
})
export class PriceFilterPipe implements PipeTransform {
  transform(bikes: Bike[], maxPrice: number | null): Bike[] {
    if (maxPrice === null || maxPrice === undefined) return bikes; // If no max price, return all bikes
    return bikes.filter((bike) => bike.price <= maxPrice);
  }
}
