import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSaleComponent } from './user-sale.component';

describe('UserSaleComponent', () => {
  let component: UserSaleComponent;
  let fixture: ComponentFixture<UserSaleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserSaleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserSaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
