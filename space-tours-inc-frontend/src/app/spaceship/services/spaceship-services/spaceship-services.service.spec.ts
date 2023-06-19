import {TestBed} from '@angular/core/testing';
import {of} from 'rxjs';
import { SpaceshipServicesService } from './spaceship-services.service';
import { HttpClientService } from 'src/app/shared/services/http-client.service';
import { Mock, MockingUtil } from 'src/app/testing/mocking.util';

describe('SpaceshipServicesService', () => {
  let service: SpaceshipServicesService;
  let httpMock: Mock<HttpClientService>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        MockingUtil.createMockProvider(HttpClientService)
      ]
    });
    service = TestBed.inject(SpaceshipServicesService);
    httpMock = TestBed.inject(HttpClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('#fetchAll', () => {
    it('should call the correct endpoint', () => {
      httpMock.get.and.returnValue(of());
      service.fetchAll();
      expect(httpMock.get).toHaveBeenCalledWith('v1/spaceship_services');
    });
  });

  describe('#fetch', () => {
    it('should call the correct endpoint', () => {
      httpMock.get.and.returnValue(of());
      service.fetch('test-id');
      expect(httpMock.get).toHaveBeenCalledWith('v1/spaceship_services/test-id');
    });
  });
});
