import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplierPanelComponent } from './supplier-panel.component';

describe('SupplierPanelComponent', () => {
  let component: SupplierPanelComponent;
  let fixture: ComponentFixture<SupplierPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SupplierPanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplierPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
