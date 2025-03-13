import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bike } from '../model/bike.model';

@Injectable({
  providedIn: 'root',
})
export class BikeService {
  private jsonUrl = 'assets/bikes.json';

  constructor(private http: HttpClient) {}

  getBikes(): Observable<Bike[]> {
    return this.http.get<Bike[]>(this.jsonUrl);
  }
}
