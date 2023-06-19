import { Booking } from "src/app/shared/models/booking.model";
import { TravelPackage } from "src/app/shared/models/travel-package.model";

const BOOKINGS: Booking[] = [{
    id: "fake id",
    departureDate: "2021-01-01",
    passengers: 2,
    travelPackage: {
      id: "fake id",
      name: "fake name",
      spaceship: {
        id: "fake spaceship id",
        name: "fake name",
        seats: 200,
        booster: {
          id: "fake id",
          name: "fake name"
        },
        service: {
          id: "fake id",
          name: "fake name",
          orbId: "fake id"
        },
        weightKg: 549045,
        maxCapacityKg: 22800,
        propellantId: 1,
        propellantMarkup: 3,
        carriedWeight: 571845
      },
      departureOrbId: "fakeId",
      lunarCyclerHotelRoomNights: 0,
      orbHotelRoomNights: 0,
      totalTicketsCount: 200,
      totalHotelRoomNights: 0
    } as TravelPackage,
},
{
    id: "fake id",
    departureDate: "2021-01-02",
    passengers: 2,
    travelPackage: {
      id: "fake id",
      name: "fake name",
      spaceship: {
        id: "fake spaceship id",
        name: "fake name",
        seats: 200,
        booster: {
          id: "fake id",
          name: "fake name"
        },
        service: {
          id: "fake id",
          name: "fake name",
          orbId: "fake id"
        },
        weightKg: 549045,
        maxCapacityKg: 22800,
        propellantId: 1,
        propellantMarkup: 3,
        carriedWeight: 571845
      },
      departureOrbId: "fakeId",
      lunarCyclerHotelRoomNights: 0,
      orbHotelRoomNights: 0,
      totalTicketsCount: 200,
      totalHotelRoomNights: 0
    } as TravelPackage,
},
{
    id: "fake id",
    departureDate: "2021-01-06",
    passengers: 2,
    travelPackage: {
      id: "fake id",
      name: "fake name",
      spaceship: {
        id: "fake spaceship id",
        name: "fake name",
        seats: 200,
        booster: {
          id: "fake id",
          name: "fake name"
        },
        service: {
          id: "fake id",
          name: "fake name",
          orbId: "fake id"
        },
        weightKg: 549045,
        maxCapacityKg: 22800,
        propellantId: 1,
        propellantMarkup: 3,
        carriedWeight: 571845
      },
      departureOrbId: "fakeId",
      lunarCyclerHotelRoomNights: 0,
      orbHotelRoomNights: 0,
      totalTicketsCount: 200,
      totalHotelRoomNights: 0
    } as TravelPackage,
    
},
{
    id: "fake id",
    departureDate: "2021-01-01",
    passengers: 2,
    travelPackage: {
      id: "fake id",
      name: "fake name",
      spaceship: {
        id: "fake spaceship id",
        name: "fake name",
        seats: 200,
        booster: {
          id: "fake id",
          name: "fake name"
        },
        service: {
          id: "fake id",
          name: "fake name",
          orbId: "fake id"
        },
        weightKg: 549045,
        maxCapacityKg: 22800,
        propellantId: 1,
        propellantMarkup: 3,
        carriedWeight: 571845
      },
      departureOrbId: "fakeId",
      lunarCyclerHotelRoomNights: 0,
      orbHotelRoomNights: 0,
      totalTicketsCount: 200,
      totalHotelRoomNights: 0
    } as TravelPackage,
}];

export class SpaceshipDetailDataConfigurationStub {
    static get GET_BOOKINGS(): Booking[] {
        return BOOKINGS;
    }
}
