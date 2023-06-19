import {TestBed} from '@angular/core/testing';
import { SpaceshipDetailService } from './spaceship-detail.service';
import { Booking } from 'src/app/shared/models/booking.model';
import { SpaceshipDetailDataConfigurationStub } from './spaceship-detail-data.fake';
import * as moment from 'moment';

describe('SpaceshipDetailService', () => {
  const bookingsStub: Booking[] = SpaceshipDetailDataConfigurationStub.GET_BOOKINGS;

  let service: SpaceshipDetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        SpaceshipDetailService
      ]
    });
    service = TestBed.inject(SpaceshipDetailService);
  });

  describe('Instance Service', () => {
    it('should be created', () => {
        expect(service).toBeTruthy();
    });
  });

  describe('retriveDateOfNextSpaceshipFlights', () => {
    it('should retrieve N flights', () => {
      const expectedFlightNumber: number = 3;
      const actual: moment.Moment[] = service.retriveDateOfNextSpaceshipFlights(bookingsStub, expectedFlightNumber);
      expect(actual).toBeDefined();
      expect(actual.length).toEqual(expectedFlightNumber);
    });
  });
});
