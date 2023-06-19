import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import * as _ from 'lodash';
import {BookingService} from '../../shared/services/booking/booking.service';
import {Booking} from '../../shared/models/booking.model';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.scss']
})
export class BookingListComponent implements OnInit {

  displayedColumns: string[] = ['departureDate', 'passengers', 'travelPackage', 'lunarCyclerHotelRoom', 'lunarCyclerHotelNights', 'orbHotelRoom', 'orbHotelNights'];
  dataSource = new MatTableDataSource<Booking>([]);

  constructor(private bookingService: BookingService) {
  }

  ngOnInit(): void {
    this.bookingService.fetchAll().subscribe(data => this.dataSource.data = _.sortBy(data, d => d.departureDate).reverse());
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
