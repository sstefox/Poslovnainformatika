import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BankeComponent } from './banke.component';

describe('BankeComponent', () => {
  let component: BankeComponent;
  let fixture: ComponentFixture<BankeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BankeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BankeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
