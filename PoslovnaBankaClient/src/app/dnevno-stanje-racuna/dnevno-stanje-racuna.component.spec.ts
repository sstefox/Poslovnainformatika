import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DnevnoStanjeRacunaComponent } from './dnevno-stanje-racuna.component';

describe('DnevnoStanjeRacunaComponent', () => {
  let component: DnevnoStanjeRacunaComponent;
  let fixture: ComponentFixture<DnevnoStanjeRacunaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DnevnoStanjeRacunaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DnevnoStanjeRacunaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
