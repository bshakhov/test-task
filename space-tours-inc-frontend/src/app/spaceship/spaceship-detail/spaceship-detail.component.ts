import { Component, Input, OnInit } from '@angular/core';
import { BookingService } from 'src/app/shared/services/booking/booking.service';
import { Booking } from 'src/app/shared/models/booking.model';
import { Orb } from 'src/app/shared/models/orb.model';
import * as moment from 'moment';
import { OrbsService } from 'src/app/shared/services/orbs/orbs.service';
import {Spaceship} from '../../shared/models/spaceship.model';
import { SpaceshipServicesService } from '../services/spaceship-services/spaceship-services.service';
import { forkJoin } from 'rxjs';
import { SpaceshipService } from 'src/app/shared/models/spaceship-service.model';
import { SpaceshipDetailService } from './services/spaceship-detail.service';


@Component({
    selector: 'app-spaceship-detail',
    templateUrl: './spaceship-detail.component.html',
    styleUrls: ['./spaceship-detail.component.scss']
})
export class SpaceshipDetailComponent implements OnInit {
    @Input() spaceShip: Spaceship;

    public orb: Orb;
    public datesOfNextFlights: moment.Moment[];
    isLoading: boolean;

    constructor(
        private spaceshipServicesService: SpaceshipServicesService, 
        private orbsService: OrbsService,
        private bookingService: BookingService,
        private spaceshipDetailService: SpaceshipDetailService) {}

    ngOnInit(): void {
        this.isLoading = true;
        forkJoin([
            this.bookingService.fetchAll(),
            this.spaceshipServicesService.fetch(this.spaceShip.service.id)
        ]).subscribe({
            next: (responses: any) => {
                const bookings: Booking[] = responses[0];
                const filteredBookings: Booking[] = bookings.filter(booking => booking.travelPackage.spaceship.id === this.spaceShip.id);
                this.datesOfNextFlights = this.spaceshipDetailService.retriveDateOfNextSpaceshipFlights(filteredBookings, 3);

                const spaceshipService: SpaceshipService = responses[1];
                this.orbsService.fetch(spaceshipService.orbId).subscribe(dataOrb =>{
                    this.orb = dataOrb;
                    this.isLoading = false;
                });
            }
        });
    }
}
