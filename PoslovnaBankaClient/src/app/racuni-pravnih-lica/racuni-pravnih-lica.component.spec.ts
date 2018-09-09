import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RacuniPravnihLicaComponent } from './racuni-pravnih-lica.component';

describe('RacuniPravnihLicaComponent', () => {
  let component: RacuniPravnihLicaComponent;
  let fixture: ComponentFixture<RacuniPravnihLicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RacuniPravnihLicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RacuniPravnihLicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
