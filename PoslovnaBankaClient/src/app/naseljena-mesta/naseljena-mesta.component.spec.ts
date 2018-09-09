import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NaseljenaMestaComponent } from './naseljena-mesta.component';

describe('NaseljenaMestaComponent', () => {
  let component: NaseljenaMestaComponent;
  let fixture: ComponentFixture<NaseljenaMestaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NaseljenaMestaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NaseljenaMestaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
