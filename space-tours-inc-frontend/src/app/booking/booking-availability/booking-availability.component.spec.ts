import {ComponentFixture, TestBed} from '@angular/core/testing';
import {NO_ERRORS_SCHEMA} from '@angular/core';
import {BookingAvailabilityComponent} from './booking-availability.component';
import {MockingUtil} from '../../testing/mocking.util';
import {TravelPackageService} from '../../shared/services/travel-package.service';

describe('BookingAvailabilityComponent', () => {
  let component: BookingAvailabilityComponent;
  let fixture: ComponentFixture<BookingAvailabilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BookingAvailabilityComponent],
      providers: [
        MockingUtil.createMockProvider(TravelPackageService)
      ],
      schemas: [NO_ERRORS_SCHEMA]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingAvailabilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
