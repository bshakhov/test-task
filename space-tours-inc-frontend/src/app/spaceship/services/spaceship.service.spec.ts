import {TestBed} from '@angular/core/testing';
import {SpaceshipService} from './spaceship.service';
import {Mock, MockingUtil} from '../../testing/mocking.util';
import {HttpClientService} from '../../shared/services/http-client.service';
import {of} from 'rxjs';

describe('SpaceshipService', () => {
  let service: SpaceshipService;
  let httpMock: Mock<HttpClientService>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        MockingUtil.createMockProvider(HttpClientService)
      ]
    });
    service = TestBed.inject(SpaceshipService);
    httpMock = TestBed.inject(HttpClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('#fetchAll', () => {
    it('should call the correct endpoint', () => {
      httpMock.get.and.returnValue(of());
      service.fetchAll();
      expect(httpMock.get).toHaveBeenCalledWith('v1/spaceships');
    });
  });

  describe('#fetch', () => {
    it('should call the correct endpoint', () => {
      httpMock.get.and.returnValue(of());
      service.fetch('test-id');
      expect(httpMock.get).toHaveBeenCalledWith('v1/spaceships/test-id');
    });
  });
});
