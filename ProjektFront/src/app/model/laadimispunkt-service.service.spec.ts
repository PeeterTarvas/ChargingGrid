import { TestBed } from '@angular/core/testing';

import { LaadimispunktServiceService } from './laadimispunkt-service.service';

describe('LaadimispunktServiceService', () => {
  let service: LaadimispunktServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LaadimispunktServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
