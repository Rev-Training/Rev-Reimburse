import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewEmployeeRequestsComponent } from './view-employee-requests.component';

describe('ViewEmployeeRequestsComponent', () => {
  let component: ViewEmployeeRequestsComponent;
  let fixture: ComponentFixture<ViewEmployeeRequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewEmployeeRequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewEmployeeRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
