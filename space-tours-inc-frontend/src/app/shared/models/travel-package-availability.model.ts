import {TravelPackage} from './travel-package.model';

export class TravelPackageAvailability {

  constructor(public travelPackage: TravelPackage,
              public totalTicketsCount: number,
              public availableTicketsCount: number,
              public price: number) {
  }

}
