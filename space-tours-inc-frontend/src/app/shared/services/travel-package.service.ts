import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import * as moment from 'moment';
import {HttpClientService} from './http-client.service';
import {TravelPackageAvailability} from '../models/travel-package-availability.model';

@Injectable({
  providedIn: 'root'
})
export class TravelPackageService {

  constructor(private http: HttpClientService) {
  }

  public checkAvailability(date: moment.Moment): Observable<TravelPackageAvailability[]> {
    return this.http.get(`v1/travel_packages/availability/${date.format('YYYY-MM-DD')}`);
  }
}
