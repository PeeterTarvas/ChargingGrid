import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LaadimispunktComponent } from './laadimispunkt.component';

describe('LaadimispunktComponent', () => {
  let component: LaadimispunktComponent;
  let fixture: ComponentFixture<LaadimispunktComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LaadimispunktComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LaadimispunktComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
