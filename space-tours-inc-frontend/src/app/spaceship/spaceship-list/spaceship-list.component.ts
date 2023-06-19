import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import {combineLatest} from 'rxjs';
import {map} from 'rxjs/operators';
import {SpaceshipService} from '../services/spaceship.service';
import {Spaceship} from '../../shared/models/spaceship.model';
import {PropellantService} from '../../shared/services/propellant.service';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-spaceship-list',
  templateUrl: './spaceship-list.component.html',
  styleUrls: ['./spaceship-list.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})
export class SpaceshipListComponent implements OnInit, AfterViewInit {

  displayedColumns: string[] = ['name', 'booster', 'service', 'seats', 'weight', 'maxCapacity', 'propellant', 'markup'];
  displayedColumnsWithExpand = [...this.displayedColumns, 'expand'];
  dataSource = new MatTableDataSource<Spaceship>([]);
  expandedElement: Spaceship | null;

  @ViewChild(MatSort) sort: MatSort;

  constructor(private spaceshipService: SpaceshipService,
              private propellantService: PropellantService) {
  }

  ngOnInit(): void {
    combineLatest([
      this.spaceshipService.fetchAll(),
      this.propellantService.fetchAll()
    ]).pipe(
      map(([spaceships, propellants]) => spaceships.map(s => {
        s.propellant = propellants.find(p => p.id === s.propellantId);
        return s;
      }))
    ).subscribe(data => this.dataSource.data = data);
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.filterPredicate = (data, filter: string) => data.name.toLowerCase().includes(filter);
  }

  applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
