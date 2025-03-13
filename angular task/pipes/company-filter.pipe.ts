import { Pipe, PipeTransform } from '@angular/core';
import { Bike } from '../model/bike.model';

@Pipe({
  name: 'companyFilter',
})
export class CompanyFilterPipe implements PipeTransform {
  transform(bikes: Bike[], selectedCompany: string): Bike[] {
    if (!bikes || !selectedCompany || selectedCompany === 'All') {
      return bikes;
    }
    return bikes.filter((bike) => bike.company === selectedCompany);
  }
}
