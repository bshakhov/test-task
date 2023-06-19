import {TestBed} from '@angular/core/testing';
import {HttpClient} from '@angular/common/http';
import {noop, of, throwError} from 'rxjs';
import {HttpClientService} from './http-client.service';
import {Mock, MockingUtil} from '../../testing/mocking.util';
import {ConfigService} from './config.service';
import {HttpExceptionHandlerService} from './http-exception-handler.service';

describe('HttpClientService', () => {
  let service: HttpClientService;
  let httpClientMock: Mock<HttpClient>;
  let configMock: Mock<ConfigService>;
  let httpErrorServiceMock: Mock<HttpExceptionHandlerService>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        HttpClientService,
        MockingUtil.createMockProvider(HttpClient),
        MockingUtil.createMockProvider(ConfigService),
        MockingUtil.createMockProvider(HttpExceptionHandlerService)
      ]
    });

    service = TestBed.inject(HttpClientService);
    httpClientMock = TestBed.inject(HttpClient);
    configMock = TestBed.inject(ConfigService);
    httpErrorServiceMock = TestBed.inject(HttpExceptionHandlerService);

    httpClientMock.request.and.returnValue(of());
    configMock.apiUrl = 'http://localhost:8080/api/';
  });

  describe('#get', () => {
    it('should do an http request without http params', () => {
      service.get('v1/test-endpoint');
      expect(httpClientMock.request).toHaveBeenCalled();
    });

    it('should do an http request with http params', () => {
      service.get('v1/test-endpoint', {});
      expect(httpClientMock.request).toHaveBeenCalled();
    });

    it('should handle exceptions', (done) => {
      const mockHandledError = of('A test error');
      httpClientMock.request.and.returnValue(throwError('A test error'));
      httpErrorServiceMock.handleError.and.returnValue(mockHandledError);
      service.get('route').subscribe(noop, (error: any) => {
        expect(httpErrorServiceMock.handleError).toHaveBeenCalledWith('A test error');
        expect(error).toEqual(mockHandledError);
        done();
      });
    });
  });

  it('#post should do an http request', () => {
    service.post('v1/test-endpoint', {});
    expect(httpClientMock.request).toHaveBeenCalled();
  });

  it('#put should do an http request', () => {
    service.put('v1/test-endpoint', {});
    expect(httpClientMock.request).toHaveBeenCalled();
  });

  it('#delete should do an http request', () => {
    service.delete('v1/test-endpoint');
    expect(httpClientMock.request).toHaveBeenCalled();
  });
});
