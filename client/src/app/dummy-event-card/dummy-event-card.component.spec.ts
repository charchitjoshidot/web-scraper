import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DummyEventCardComponent } from './dummy-event-card.component';

describe('DummyEventCardComponent', () => {
  let component: DummyEventCardComponent;
  let fixture: ComponentFixture<DummyEventCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DummyEventCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DummyEventCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
