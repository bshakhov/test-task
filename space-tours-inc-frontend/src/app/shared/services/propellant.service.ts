import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClientService} from './http-client.service';
import {Propellant} from '../models/propellant.model';

@Injectable({
  providedIn: 'root'
})
export class PropellantService {

  constructor(private http: HttpClientService) {
  }

  public fetchAll(): Observable<Propellant[]> {
    return this.http.get('v1/propellants');
  }

  public fetch(id: number): Observable<Propellant> {
    return this.http.get(`v1/propellants/${id}`);
  }

}
