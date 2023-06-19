import {TestBed} from '@angular/core/testing';
import {of} from 'rxjs';
import {BookingService} from './booking.service';
import {Mock, MockingUtil} from '../../../testing/mocking.util';
import {HttpClientService} from '../http-client.service';

describe('BookingService', () => {
  let service: BookingService;
  let httpMock: Mock<HttpClientService>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        MockingUtil.createMockProvider(HttpClientService)
      ]
    });
    service = TestBed.inject(BookingService);
    httpMock = TestBed.inject(HttpClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('#fetchAll', () => {
    it('should call the correct endpoint', () => {
      httpMock.get.and.returnValue(of());
      service.fetchAll();
      expect(httpMock.get).toHaveBeenCalledWith('v1/bookings');
    });
  });

  describe('#fetch', () => {
    it('should call the correct endpoint', () => {
      httpMock.get.and.returnValue(of());
      service.fetch('test-id');
      expect(httpMock.get).toHaveBeenCalledWith('v1/bookings/test-id');
    });
  });
});
