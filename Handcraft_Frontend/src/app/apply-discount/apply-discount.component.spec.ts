import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplyDiscountComponent } from './apply-discount.component';

describe('ApplyDiscountComponent', () => {
  let component: ApplyDiscountComponent;
  let fixture: ComponentFixture<ApplyDiscountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApplyDiscountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplyDiscountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
