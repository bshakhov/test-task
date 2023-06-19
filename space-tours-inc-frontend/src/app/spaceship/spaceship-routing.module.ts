import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {SpaceshipListComponent} from './spaceship-list/spaceship-list.component';

const routes: Routes = [
  {path: '', component: SpaceshipListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SpaceshipRoutingModule {
}
