import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminReminderComponent } from './admin-reminder.component';

describe('AdminReminderComponent', () => {
  let component: AdminReminderComponent;
  let fixture: ComponentFixture<AdminReminderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminReminderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminReminderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
