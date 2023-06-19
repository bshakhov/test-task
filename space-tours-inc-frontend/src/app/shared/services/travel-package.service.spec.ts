import {TestBed} from '@angular/core/testing';
import {TravelPackageService} from './travel-package.service';
import {MockingUtil} from '../../testing/mocking.util';
import {HttpClientService} from './http-client.service';

describe('TravelPackageService', () => {
  let service: TravelPackageService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        MockingUtil.createMockProvider(HttpClientService)
      ]
    });
    service = TestBed.inject(TravelPackageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
