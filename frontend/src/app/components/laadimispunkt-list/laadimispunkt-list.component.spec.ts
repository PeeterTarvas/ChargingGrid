import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LaadimispunktListComponent } from './laadimispunkt-list.component';

describe('LaadimispunktListComponent', () => {
  let component: LaadimispunktListComponent;
  let fixture: ComponentFixture<LaadimispunktListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LaadimispunktListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LaadimispunktListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
