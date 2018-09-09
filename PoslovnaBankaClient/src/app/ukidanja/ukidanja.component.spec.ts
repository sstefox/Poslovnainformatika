import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UkidanjaComponent } from './ukidanja.component';

describe('UkidanjaComponent', () => {
  let component: UkidanjaComponent;
  let fixture: ComponentFixture<UkidanjaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UkidanjaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UkidanjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
