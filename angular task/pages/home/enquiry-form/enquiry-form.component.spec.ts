import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnquiryFormComponent } from './enquiry-form.component';

describe('EnqiryFormComponent', () => {
  let component: EnquiryFormComponent;
  let fixture: ComponentFixture<EnquiryFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EnquiryFormComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(EnquiryFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
