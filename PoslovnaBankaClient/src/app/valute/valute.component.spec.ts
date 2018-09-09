import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ValuteComponent } from './valute.component';

describe('ValuteComponent', () => {
  let component: ValuteComponent;
  let fixture: ComponentFixture<ValuteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ValuteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValuteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
