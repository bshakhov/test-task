import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClientService} from '../http-client.service';
import {Booking} from '../../models/booking.model';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClientService) {
  }

  public fetchAll(): Observable<Booking[]> {
    return this.http.get('v1/bookings');
  }

  public fetch(id: string): Observable<Booking> {
    return this.http.get(`v1/bookings/${id}`);
  }
}
