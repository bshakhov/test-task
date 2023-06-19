import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SpaceshipRoutingModule} from './spaceship-routing.module';
import {SpaceshipListComponent} from './spaceship-list/spaceship-list.component';
import {SharedModule} from '../shared/shared.module';
import { SpaceshipDetailComponent } from './spaceship-detail/spaceship-detail.component';

@NgModule({
  declarations: [SpaceshipListComponent, SpaceshipDetailComponent],
  imports: [
    CommonModule,
    SpaceshipRoutingModule,
    SharedModule,
  ]
})
export class SpaceshipModule {
}
