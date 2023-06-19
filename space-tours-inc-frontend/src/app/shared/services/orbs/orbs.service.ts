import {Injectable} from '@angular/core';
import {HttpClientService} from '../http-client.service';
import {Observable} from 'rxjs';
import { Orb } from '../../models/orb.model';

@Injectable({
  providedIn: 'root'
})
export class OrbsService {

  constructor(private http: HttpClientService) {
  }

  public fetchAll(): Observable<Orb[]> {
    return this.http.get('v1/orbs');
  }

  public fetch(id: string): Observable<Orb> {
    return this.http.get(`v1/orbs/${id}`);
  }

}
