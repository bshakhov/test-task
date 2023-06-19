import {Spaceship} from './spaceship.model';
import {HotelRoom} from './hotel-room.model';

export class TravelPackage {

  constructor(public id: string,
              public name: string,
              public spaceship: Spaceship,
              public departureOrbId: string,
              public lunarCyclerHotelRoomNights: number,
              public orbHotelRoomNights: number,
              public lunarCyclerHotelRoom?: HotelRoom,
              public orbHotelRoom?: HotelRoom) {
  }

}
