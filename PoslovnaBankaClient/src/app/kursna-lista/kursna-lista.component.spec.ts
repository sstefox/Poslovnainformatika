import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KursnaListaComponent } from './kursna-lista.component';

describe('KursnaListaComponent', () => {
  let component: KursnaListaComponent;
  let fixture: ComponentFixture<KursnaListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KursnaListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KursnaListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
