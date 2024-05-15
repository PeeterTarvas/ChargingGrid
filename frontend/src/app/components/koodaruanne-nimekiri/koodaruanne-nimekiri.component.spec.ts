import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KoodaruanneNimekiriComponent } from './koodaruanne-nimekiri.component';

describe('KoodaruanneNimekiriComponent', () => {
  let component: KoodaruanneNimekiriComponent;
  let fixture: ComponentFixture<KoodaruanneNimekiriComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KoodaruanneNimekiriComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KoodaruanneNimekiriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
