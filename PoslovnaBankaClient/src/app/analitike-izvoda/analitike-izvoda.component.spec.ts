import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalitikeIzvodaComponent } from './analitike-izvoda.component';

describe('AnalitikeIzvodaComponent', () => {
  let component: AnalitikeIzvodaComponent;
  let fixture: ComponentFixture<AnalitikeIzvodaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnalitikeIzvodaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnalitikeIzvodaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
