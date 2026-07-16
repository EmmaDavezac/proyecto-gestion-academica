import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfesoresComponent } from './profesores.component';

describe('ProfesoresComponent', () => {
  let component: ProfesoresComponent;
  let fixture: ComponentFixture<ProfesoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProfesoresComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ProfesoresComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
