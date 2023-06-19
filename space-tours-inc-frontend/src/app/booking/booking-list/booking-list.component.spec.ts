import {ComponentFixture, TestBed} from '@angular/core/testing';
import {NO_ERRORS_SCHEMA} from '@angular/core';
import {of} from 'rxjs';
import {BookingListComponent} from './booking-list.component';
import {Mock, MockingUtil} from '../../testing/mocking.util';
import {BookingService} from '../../shared/services/booking/booking.service';

describe('BookingListComponent', () => {
  let component: BookingListComponent;
  let fixture: ComponentFixture<BookingListComponent>;
  let bookingServiceMock: Mock<BookingService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BookingListComponent],
      providers: [
        MockingUtil.createMockProvider(BookingService)
      ],
      schemas: [NO_ERRORS_SCHEMA]
    })
      .compileComponents();

    bookingServiceMock = TestBed.inject(BookingService);
    bookingServiceMock.fetchAll.and.returnValue(of());
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
