import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {BookingListComponent} from './booking-list/booking-list.component';
import {BookingAvailabilityComponent} from './booking-availability/booking-availability.component';

const routes: Routes = [
  {path: '', component: BookingListComponent},
  {path: 'availability', component: BookingAvailabilityComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookingRoutingModule {
}
