import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'spaceships', loadChildren: () => import('./spaceship/spaceship.module').then(mod => mod.SpaceshipModule)},
  {path: 'booking', loadChildren: () => import('./booking/booking.module').then(mod => mod.BookingModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
