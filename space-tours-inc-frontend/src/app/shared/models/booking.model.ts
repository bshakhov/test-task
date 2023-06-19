import * as moment from 'moment';
import {TravelPackage} from './travel-package.model';

export class Booking {

  constructor(public id: string,
              public departureDate: moment.Moment,
              public passengers: number,
              public travelPackage: TravelPackage) {
  }

}
