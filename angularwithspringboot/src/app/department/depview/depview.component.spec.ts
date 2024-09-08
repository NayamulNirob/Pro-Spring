import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DepviewComponent } from './depview.component';

describe('DepviewComponent', () => {
  let component: DepviewComponent;
  let fixture: ComponentFixture<DepviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DepviewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DepviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
