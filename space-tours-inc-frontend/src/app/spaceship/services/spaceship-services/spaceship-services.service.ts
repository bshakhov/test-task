import {Injectable} from '@angular/core';
import {HttpClientService} from '../../../shared/services/http-client.service';
import {Observable} from 'rxjs';
import { SpaceshipService } from '../spaceship.service';

@Injectable({
  providedIn: 'root'
})
export class SpaceshipServicesService {

  constructor(private http: HttpClientService) {
  }

  public fetchAll(): Observable<SpaceshipService[]> {
    return this.http.get('v1/spaceship_services');
  }

  public fetch(id: string): Observable<SpaceshipService> {
    return this.http.get(`v1/spaceship_services/${id}`);
  }

}
