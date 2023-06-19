import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import * as moment from 'moment';
import {TravelPackageService} from '../../shared/services/travel-package.service';
import {TravelPackageAvailability} from '../../shared/models/travel-package-availability.model';

@Component({
  selector: 'app-booking-availability',
  templateUrl: './booking-availability.component.html',
  styleUrls: ['./booking-availability.component.scss']
})
export class BookingAvailabilityComponent implements OnInit {

  isLoading: boolean;
  date: string;

  displayedColumns: string[] = ['travelPackage', 'totalTickets', 'isAvailable', 'availableTicketsCount', 'price'];
  dataSource = new MatTableDataSource<TravelPackageAvailability>([]);

  constructor(private travelPackageService: TravelPackageService) {
  }

  ngOnInit(): void {
  }

  onCheckAvailability(): void {
    this.isLoading = true;
    this.travelPackageService.checkAvailability(moment(this.date)).subscribe(data => {
      this.dataSource.data = data;
      this.isLoading = false;
    });
  }

}
