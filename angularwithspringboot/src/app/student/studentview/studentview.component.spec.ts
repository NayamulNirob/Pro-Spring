import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentviewComponent } from './studentview.component';

describe('StudentviewComponent', () => {
  let component: StudentviewComponent;
  let fixture: ComponentFixture<StudentviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StudentviewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
