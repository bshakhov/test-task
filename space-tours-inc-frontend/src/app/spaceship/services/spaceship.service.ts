import {Injectable} from '@angular/core';
import {HttpClientService} from '../../shared/services/http-client.service';
import {Observable} from 'rxjs';
import {Spaceship} from '../../shared/models/spaceship.model';

@Injectable({
  providedIn: 'root'
})
export class SpaceshipService {

  constructor(private http: HttpClientService) {
  }

  public fetchAll(): Observable<Spaceship[]> {
    return this.http.get('v1/spaceships');
  }

  public fetch(id: string): Observable<Spaceship> {
    return this.http.get(`v1/spaceships/${id}`);
  }

}
