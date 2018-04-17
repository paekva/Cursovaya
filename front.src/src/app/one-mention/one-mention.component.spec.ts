import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OneMentionComponent } from './one-mention.component';

describe('OneMentionComponent', () => {
  let component: OneMentionComponent;
  let fixture: ComponentFixture<OneMentionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OneMentionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OneMentionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
