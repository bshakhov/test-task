import {Injectable} from '@angular/core';
import { Booking } from 'src/app/shared/models/booking.model';
import * as moment from 'moment';


@Injectable({
  providedIn: 'root'
})
export class SpaceshipDetailService {

  constructor() {
  }

  public retriveDateOfNextSpaceshipFlights(bookings: Booking[], numberOfNextFlights?: number): moment.Moment[] {
    const totalFlightsToRetrieve: number = numberOfNextFlights ? numberOfNextFlights : 1;
    const sortedBookings = bookings.sort((a, b) => a.departureDate.unix() - b.departureDate.unix())
    
    let datesFlights: moment.Moment[] = [];
    for (let i = 0; i < bookings.length && i < totalFlightsToRetrieve; i++) {
        let booking: Booking = sortedBookings[i];
        let depatureDateString: moment.Moment = booking.departureDate;
        if (!datesFlights.includes(depatureDateString)) {
            datesFlights.push(depatureDateString);
        }
    }

    return datesFlights;
}
}
