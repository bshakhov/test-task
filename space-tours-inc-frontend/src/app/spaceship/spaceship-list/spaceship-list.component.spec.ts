import {NO_ERRORS_SCHEMA} from '@angular/core';
import {ComponentFixture, TestBed} from '@angular/core/testing';
import {Observable, of} from 'rxjs';
import {SpaceshipListComponent} from './spaceship-list.component';
import {Mock, MockingUtil} from '../../testing/mocking.util';
import {SpaceshipService} from '../services/spaceship.service';
import {PropellantService} from '../../shared/services/propellant.service';
import {Spaceship} from '../../shared/models/spaceship.model';
import {Propellant} from '../../shared/models/propellant.model';

describe('SpaceshipListComponent', () => {
  let component: SpaceshipListComponent;
  let fixture: ComponentFixture<SpaceshipListComponent>;

  let spaceshipServiceMock: Mock<SpaceshipService>;
  let propellantServiceMock: Mock<PropellantService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SpaceshipListComponent],
      providers: [
        MockingUtil.createMockProvider(SpaceshipService),
        MockingUtil.createMockProvider(PropellantService)
      ],
      schemas: [NO_ERRORS_SCHEMA]
    })
      .compileComponents();

    spaceshipServiceMock = TestBed.inject(SpaceshipService);
    propellantServiceMock = TestBed.inject(PropellantService);
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpaceshipListComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  describe('#ngOnInit', () => {
    beforeEach(() => {
      spaceshipServiceMock.fetchAll.and.returnValue(of(
        [
          {id: 'sc1', name: 'Spaceship 1', propellantId: 2},
          {id: 'sc2', name: 'Spaceship 2', propellantId: 1}
        ]
      ) as Observable<Spaceship[]>);

      propellantServiceMock.fetchAll.and.returnValue(of(
        [
          {id: 1, name: 'Propellant 1'},
          {id: 2, name: 'Propellant 2'}
        ]
      ) as Observable<Propellant[]>);
    });

    it('should combine spaceships with propellants', () => {
      component.dataSource.data = [];
      component.ngOnInit();
      expect(component.dataSource.data.length).toEqual(2);
      expect(component.dataSource.data[0].id).toEqual('sc1');
      expect(component.dataSource.data[0].propellant?.id).toEqual(2);
      expect(component.dataSource.data[1].id).toEqual('sc2');
      expect(component.dataSource.data[1].propellant?.id).toEqual(1);
    });
  });
});
