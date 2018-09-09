import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedjubankarskiTransferiComponent } from './medjubankarski-transferi.component';

describe('MedjubankarskiTransferiComponent', () => {
  let component: MedjubankarskiTransferiComponent;
  let fixture: ComponentFixture<MedjubankarskiTransferiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedjubankarskiTransferiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedjubankarskiTransferiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
