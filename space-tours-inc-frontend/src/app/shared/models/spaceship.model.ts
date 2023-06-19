import {SpaceshipBooster} from './spaceship-booster.model';
import {SpaceshipService} from './spaceship-service.model';
import {Propellant} from './propellant.model';

export class Spaceship {

  constructor(public id: string,
              public name: string,
              public seats: number,
              public booster: SpaceshipBooster,
              public service: SpaceshipService,
              public weightKg: number,
              public maxCapacityKg: number,
              public propellantId: number,
              public propellantMarkup: number,
              public propellant?: Propellant) {
  }

}
