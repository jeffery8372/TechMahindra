import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Accessory } from '../model/accessory.model';

@Injectable({
  providedIn: 'root',
})
export class AccessoryService {
  private jsonUrl = 'assets/accessories.json';

  constructor(private http: HttpClient) {}

  getAccessories(): Observable<Accessory[]> {
    return this.http.get<Accessory[]>(this.jsonUrl);
  }
}
