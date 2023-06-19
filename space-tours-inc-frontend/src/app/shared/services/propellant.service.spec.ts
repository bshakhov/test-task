import {TestBed} from '@angular/core/testing';
import {Mock, MockingUtil} from '../../testing/mocking.util';
import {PropellantService} from './propellant.service';
import {HttpClientService} from './http-client.service';
import {of} from 'rxjs';

describe('PropellantService', () => {
  let service: PropellantService;
  let httpMock: Mock<HttpClientService>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        MockingUtil.createMockProvider(HttpClientService)
      ]
    });
    service = TestBed.inject(PropellantService);
    httpMock = TestBed.inject(HttpClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('#fetchAll', () => {
    it('should call the correct endpoint', () => {
      httpMock.get.and.returnValue(of());
      service.fetchAll();
      expect(httpMock.get).toHaveBeenCalledWith('v1/propellants');
    });
  });

  describe('#fetch', () => {
    it('should call the correct endpoint', () => {
      httpMock.get.and.returnValue(of());
      service.fetch(42);
      expect(httpMock.get).toHaveBeenCalledWith('v1/propellants/42');
    });
  });
});
