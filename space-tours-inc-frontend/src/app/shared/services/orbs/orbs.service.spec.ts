import {TestBed} from '@angular/core/testing';
import {of} from 'rxjs';
import { OrbsService } from './orbs.service';
import { Mock, MockingUtil } from 'src/app/testing/mocking.util';
import { HttpClientService } from '../http-client.service';

describe('OrbsService', () => {
  let service: OrbsService;
  let httpMock: Mock<HttpClientService>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        MockingUtil.createMockProvider(HttpClientService)
      ]
    });
    service = TestBed.inject(OrbsService);
    httpMock = TestBed.inject(HttpClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('#fetchAll', () => {
    it('should call the correct endpoint', () => {
      httpMock.get.and.returnValue(of());
      service.fetchAll();
      expect(httpMock.get).toHaveBeenCalledWith('v1/orbs');
    });
  });

  describe('#fetch', () => {
    it('should call the correct endpoint', () => {
      httpMock.get.and.returnValue(of());
      service.fetch('test-id');
      expect(httpMock.get).toHaveBeenCalledWith('v1/orbs/test-id');
    });
  });
});
