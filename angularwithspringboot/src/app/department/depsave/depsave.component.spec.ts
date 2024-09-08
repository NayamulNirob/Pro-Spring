import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DepsaveComponent } from './depsave.component';

describe('DepsaveComponent', () => {
  let component: DepsaveComponent;
  let fixture: ComponentFixture<DepsaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DepsaveComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DepsaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
