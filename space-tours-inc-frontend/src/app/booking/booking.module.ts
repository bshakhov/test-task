import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BookingRoutingModule} from './booking-routing.module';
import {SharedModule} from '../shared/shared.module';
import {BookingListComponent} from './booking-list/booking-list.component';
import {BookingAvailabilityComponent} from './booking-availability/booking-availability.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [BookingListComponent, BookingAvailabilityComponent],
  imports: [
    CommonModule,
    BookingRoutingModule,
    SharedModule,
    FormsModule
  ]
})
export class BookingModule {
}
